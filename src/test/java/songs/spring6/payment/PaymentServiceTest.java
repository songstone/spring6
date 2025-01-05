package songs.spring6.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import songs.spring6.exrate.ExRateProviderStub;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {
    Clock clock;

    @BeforeEach
    void beforeEach() {
        clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @Test
    void convertedAmount() throws Exception {
        testAmount(valueOf(100), valueOf(1_000), clock);
        testAmount(valueOf(1000), valueOf(10_000), clock);
        testAmount(valueOf(2000), valueOf(20_000), clock);
    }

    @Test
    void validUntil() throws Exception {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(valueOf(1_000)), clock);

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime expected = LocalDateTime.now(clock).plusMinutes(30);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expected);
    }

    private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) throws Exception {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);

    }

}
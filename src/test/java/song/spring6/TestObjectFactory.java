package song.spring6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import song.spring6.exrate.CachedExRateProvider;
import song.spring6.exrate.WebApiExRateProvider;
import song.spring6.payment.ExRateProvider;
import song.spring6.payment.ExRateProviderStub;
import song.spring6.payment.PaymentService;

import java.math.BigDecimal;

@Configuration
public class TestObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }
}

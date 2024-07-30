package song.spring6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import song.spring6.exrate.WebApiExRateProvider;
import song.spring6.payment.ExRateProvider;
import song.spring6.payment.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}

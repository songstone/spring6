package songs.spring6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import songs.spring6.api.ApiTemplate;
import songs.spring6.api.ErApiExRateExtractor;
import songs.spring6.api.HttpClientApiExecutor;
import songs.spring6.exrate.CachedExRateProvider;
import songs.spring6.payment.ExRateProvider;
import songs.spring6.exrate.WebApiExRateProvider;
import songs.spring6.payment.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider(apiTemplate());
    }

    @Bean
    public ApiTemplate apiTemplate() {
        return new ApiTemplate(new HttpClientApiExecutor(), new ErApiExRateExtractor());
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}

package song.spring6.exrate;

import song.spring6.api.ApiTemplate;
import song.spring6.api.ExApiExRateExtractor;
import song.spring6.api.HttpClientApiExecutor;
import song.spring6.payment.ExRateProvider;

import java.math.BigDecimal;

public class WebApiExRateProvider implements ExRateProvider {
    ApiTemplate apiTemplate = new ApiTemplate();

    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        return apiTemplate.getExRate(url, new HttpClientApiExecutor(), new ExApiExRateExtractor());
    }

}

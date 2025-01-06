package songs.spring6.exrate;

import songs.spring6.payment.ExRateProvider;

import java.math.BigDecimal;

public class ExRateProviderStub implements ExRateProvider {
    private BigDecimal exRate;

    public void setExRate(BigDecimal exRate) {
        this.exRate = exRate;
    }

    public ExRateProviderStub(BigDecimal exRate) {
        this.exRate = exRate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        return exRate;
    }
}

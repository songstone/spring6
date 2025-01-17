package songs.spring6.exrate;

import songs.spring6.payment.ExRateProvider;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CachedExRateProvider implements ExRateProvider {

    private final ExRateProvider target;

    private BigDecimal cachedExRate;
    private LocalDateTime cachedExpiryTime;

    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        if(cachedExRate == null || cachedExpiryTime.isBefore(LocalDateTime.now())) {
            cachedExRate = target.getExRate(currency);
            cachedExpiryTime = LocalDateTime.now().plusSeconds(3);
        }
        return cachedExRate;
    }
}

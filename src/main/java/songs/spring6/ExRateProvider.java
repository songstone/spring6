package songs.spring6;

import java.math.BigDecimal;

public interface ExRateProvider {
    BigDecimal getExRate(String currency) throws Exception;
}

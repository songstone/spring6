package song.spring6.learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockTest {

    @DisplayName("Clock 을 통한 LocalDateTime.now() 호출")
    @Test
    void clock() {
        Clock clock = Clock.systemDefaultZone();

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        assertThat(Duration.between(dt1, dt2).toMillis()).isLessThanOrEqualTo(1);
    }

    @DisplayName("fixed Clock 을 통한 LocalDateTime.now() 호출")
    @Test
    void fixedClock() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        LocalDateTime dt3 = LocalDateTime.now(clock).plusHours(1);

        assertThat(dt2).isEqualTo(dt1);
        assertThat(dt3).isEqualTo(dt1.plusHours(1));
    }
}

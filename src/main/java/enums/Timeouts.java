package enums;

import lombok.Getter;

import java.time.Duration;

@Getter
public enum Timeouts {
    SHORT(5),
    STANDARD(10),
    MID(15),
    LONG(20);

    private int timeout;
    private Duration durationOfSeconds;

    Timeouts(int timeout) {
        this.timeout = timeout;
        durationOfSeconds = Duration.ofSeconds(timeout);
    }
}

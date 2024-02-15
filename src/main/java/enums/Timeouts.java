package enums;

import lombok.Getter;

import java.time.Duration;

public enum Timeouts {
    SHORT(Duration.ofSeconds(5)),
    STANDARD(Duration.ofSeconds(10)),
    MID(Duration.ofSeconds(15)),
    LONG(Duration.ofSeconds(20));

    @Getter
    private Duration timeout;

    Timeouts(Duration timeout) {
        this.timeout = timeout;
    }
}

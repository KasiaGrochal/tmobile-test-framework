package enums;

import lombok.Getter;

public enum Timeouts {
    SHORT(5),
    STANDARD(10),
    MID(15),
    LONG(30);

    @Getter
    private int timeout;

    Timeouts(int timeout) {
        this.timeout = timeout;
    }
}

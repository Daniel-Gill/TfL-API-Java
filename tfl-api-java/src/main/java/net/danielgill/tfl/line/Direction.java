package net.danielgill.tfl.line;

import javax.annotation.Nullable;

public enum Direction {
    INBOUND, OUTBOUND;

    @Nullable
    public static Direction getFromString(String name) {
        switch (name) {
            case "inbound":
                return INBOUND;
            case "outbound":
                return OUTBOUND;
            default:
                break;
        }
        return null;
    }
}

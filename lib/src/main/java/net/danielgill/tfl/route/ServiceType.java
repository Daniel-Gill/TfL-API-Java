package net.danielgill.tfl.route;

import javax.annotation.Nullable;

public enum ServiceType {
    REGULAR, NIGHT;

    @Nullable
    public static ServiceType getFromString(String name) {
        switch (name) {
            case "regular":
                return REGULAR;
            case "night":
                return NIGHT;
            default:
                break;
        }
        return null;
    }
}

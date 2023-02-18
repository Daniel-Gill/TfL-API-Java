package net.danielgill.tfl.route;

import javax.annotation.Nullable;

/**
 * The type of service.
 */
public enum ServiceType {
    REGULAR, NIGHT;

    /**
     * Get a ServiceType from a string.
     * @param name The name of the service type.
     * @return The ServiceType, or null if the string is not a valid service type.
     */
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

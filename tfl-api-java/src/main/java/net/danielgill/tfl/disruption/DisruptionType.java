package net.danielgill.tfl.disruption;

import javax.annotation.Nullable;

/**
 * The type of disruption.
 */
public enum DisruptionType {
    LINEINFO ("lineInfo"),
    ROUTEINFO ("routeInfo");

    /**
     * The name of the disruption type.
     */
    public final String name;

    private DisruptionType(String name) {
        this.name = name;
    }

    /**
     * Get a DisruptionType from a string.
     * @param name The name of the disruption type.
     * @return The DisruptionType, or null if the string is not a valid disruption type.
     */
    @Nullable
    public static DisruptionType getFromString(String name) {
        switch (name) {
            case "lineInfo":
                return LINEINFO;
            case "routeInfo":
                return ROUTEINFO;
            default:
                break;
        }
        return null;
    }
}

package net.danielgill.tfl.disruption;

import javax.annotation.Nullable;

public enum DisruptionCategory {
    UNDEFINED ("Undefined"),
    REALTIME ("RealTime"),
    PLANNEDWORK ("PlannedWork"),
    INFORMATION ("Information"),
    EVENT ("Event"),
    CROWDING ("Crowding"),
    STATUSALERT ("StatusAlert");

    public final String name;
    
    private DisruptionCategory(String name) {
        this.name = name;
    }

    @Nullable
    public static DisruptionCategory getFromString(String name) {
        switch (name) {
            case "Undefined":
                return UNDEFINED;
            case "RealTime":
                return REALTIME;
            case "PlannedWork":
                return PLANNEDWORK;
            case "Information":
                return INFORMATION;
            case "Event":
                return EVENT;
            case "Crowding":
                return CROWDING;
            case "StatusAlert":
                return STATUSALERT;
            default:
                break;
        }
        return null;
    }
}

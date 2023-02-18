package net.danielgill.tfl.line;

import javax.annotation.Nullable;

public enum Mode {
    BUS ("bus"), 
    TUBE ("tube"), 
    RIVERBUS ("river-bus"), 
    OVERGROUND ("overground"), 
    ELIZABETHLINE ("elizabeth-line"), 
    CABLECAR ("cable-car"), 
    DLR ("dlr"), 
    NATIONALRAIL ("national-rail"), 
    TRAM ("tram");

    public final String name;

    private Mode(String name) {
        this.name = name;
    }

    @Nullable
    public static Mode getFromString(String name) {
        switch (name) {
            case "bus":
                return BUS;
            case "tube":
                return TUBE;
            case "river-bus":
                return RIVERBUS;
            case "overground":
                return OVERGROUND;
            case "elizabeth-line":
                return ELIZABETHLINE;
            case "cable-car":
                return CABLECAR;
            case "dlr":
                return DLR;
            case "national-rail":
                return NATIONALRAIL;
            case "tram":
                return TRAM;
            default:
                break;
        }
        return null;
    }
}

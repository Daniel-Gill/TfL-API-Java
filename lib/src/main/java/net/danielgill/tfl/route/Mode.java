package net.danielgill.tfl.route;

import javax.annotation.Nullable;

public enum Mode {
    BUS, TUBE, RIVERBUS, OVERGROUND, ELIZABETHLINE, CABLECAR, DLR, NATIONALRAIL, TRAM;

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

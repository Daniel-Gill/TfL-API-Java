package net.danielgill.tfl.station;

public class Station {
    public final String naptan;
    public final String name;

    private Station(String naptan, String name) {
        this.naptan = naptan;
        this.name = name;
    }

    public static Station fromBasic(String naptan, String name) {
        return new Station(
            naptan, 
            name
        );
    }
}

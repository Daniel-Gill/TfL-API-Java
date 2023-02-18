package net.danielgill.tfl.route;

import com.google.gson.JsonObject;

import net.danielgill.tfl.line.Direction;
import net.danielgill.tfl.line.Line;
import net.danielgill.tfl.station.Station;

/**
 * A single route on a {@link Line Line}. Consists of a name, direction and origin and destination stations.
 */
public class Route {
    public final String name;
    public final Direction direction;
    public final Station origin;
    public final Station destination;
    public final ServiceType serviceType;

    private Route(String name, Direction direction, Station origin, Station destination, ServiceType serviceType) {
        this.name = name;
        this.direction = direction;
        this.origin = origin;
        this.destination = destination;
        this.serviceType = serviceType;
    }

    public static Route fromJson(JsonObject object) {
        Station origin = Station.fromBasic(object.get("originator").getAsString(), object.get("originationName").getAsString());
        Station destination = Station.fromBasic(object.get("destination").getAsString(), object.get("destinationName").getAsString());
        return new Route(
            object.get("name").getAsString(),
            Direction.getFromString(object.get("direction").getAsString()),
            origin,
            destination,
            ServiceType.getFromString(object.get("serviceType").getAsString())
        );
    }

    @Override
    public String toString() {
        return this.name;
    }
}

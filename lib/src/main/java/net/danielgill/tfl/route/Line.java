package net.danielgill.tfl.route;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Represents a single line. A line consists of an id and name, as well as multiple {@link Route routes}.
 * 
 * @author Daniel Gill
 * @see net.danielgill.tfl.LineAPI LineAPI
 */
public class Line {
    public final String id;
    public final String name;
    public final Mode mode;
    public final List<Route> routes;

    private Line(String id, String name, String mode, List<Route> routes) {
        this.id = id;
        this.name = name;
        this.mode = Mode.getFromString(mode);
        this.routes = routes;
    }

    public static Line fromJson(JsonObject object) {
        List<Route> routes = new ArrayList<>();
        for(JsonElement je : object.get("routeSections").getAsJsonArray()) {
            JsonObject route = je.getAsJsonObject();
            routes.add(Route.fromJson(route));
        }

        Line line = new Line(
            object.get("id").getAsString(),
            object.get("name").getAsString(),
            object.get("modeName").getAsString(),
            routes
        );
        return line;
    }

    @Override
    public String toString() {
        return "Route: " + id;
    }
}

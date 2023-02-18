package net.danielgill.tfl.line;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.danielgill.tfl.route.Route;

/**
 * Represents a single line. A line consists of an id and name, as well as multiple {@link Route routes}.
 * 
 * @author Daniel Gill
 * @see net.danielgill.tfl.LineAPI LineAPI
 */
public class Line {
    /**
     * The id of the line.
     */
    public final String id;
    /**
     * The name of the line.
     */
    public final String name;
    /**
     * The mode of the line.
     */
    public final Mode mode;
    /**
     * The routes of the line. If the data that this was created from has no data for routes, this will be null.
     */
    @Nullable
    public final List<Route> routes;
    /**
     * The statuses of the line. If the data that this was created from has no data for statuses, this will be null.
     */
    @Nullable
    public final List<Status> statuses;

    private Line(String id, String name, String mode, List<Route> routes, List<Status> statuses) {
        this.id = id;
        this.name = name;
        this.mode = Mode.getFromString(mode);
        this.routes = routes;
        this.statuses = statuses;
    }

    /**
     * Create a Line from a JsonObject.
     * @param object The JsonObject to create the Line from.
     * @return The Line.
     */
    public static Line fromJson(JsonObject object) {
        List<Route> routes = new ArrayList<Route>();
        List<Status> statuses = new ArrayList<Status>();

        for (JsonElement route : object.get("routes").getAsJsonArray()) {
            routes.add(Route.fromJson(route.getAsJsonObject()));
        }
        if(routes.size() == 0) routes = null;

        for (JsonElement status : object.get("lineStatuses").getAsJsonArray()) {
            statuses.add(Status.fromJson(status.getAsJsonObject()));
        }
        if(statuses.size() == 0) statuses = null;

        return new Line(
            object.get("id").getAsString(),
            object.get("name").getAsString(),
            object.get("modeName").getAsString(),
            routes,
            statuses
        );
    }

    @Override
    public String toString() {
        return "Route: " + id;
    }
}

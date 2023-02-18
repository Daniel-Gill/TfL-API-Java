package net.danielgill.tfl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.danielgill.tfl.route.Line;

public class LineAPI {
    protected LineAPI() {
    }

    /**
     * Gets a list of valid routes for all lines, including the name and id of the originating and terminating stops for each route.
     * @return A list of {@link net.danielgill.tfl.route.Line Line} objects containing the valid route data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Line> getRoutes() throws APIException {
        List<Line> routeList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/Route");
            JsonArray routes = je.getAsJsonArray();
            for(JsonElement route : routes) {
                JsonObject routeObject = route.getAsJsonObject();
                routeList.add(Line.fromJson(routeObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/Route");
        }
        return routeList;
    }
}

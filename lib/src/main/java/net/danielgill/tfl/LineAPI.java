package net.danielgill.tfl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.danielgill.tfl.disruption.Disruption;
import net.danielgill.tfl.line.Line;
import net.danielgill.tfl.line.Mode;
import net.danielgill.tfl.route.ServiceType;

/**
 * Represents the Line API. This API provides information about the lines and routes of the transport network.
 * 
 * @author Daniel Gill
 * @see net.danielgill.tfl.TfLAPI TfLAPI
 */
public class LineAPI {
    protected LineAPI() {
    }

    /**
     * Gets a list of valid routes for all lines, including the name and id of the originating and terminating stops for each route.
     * @return A list of {@link net.danielgill.tfl.line.Line Line} objects containing the valid route data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Line> route() throws APIException {
        List<Line> lineList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/Route");
            JsonArray routes = je.getAsJsonArray();
            for(JsonElement route : routes) {
                JsonObject routeObject = route.getAsJsonObject();
                lineList.add(Line.fromJson(routeObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/Route");
        }
        return lineList;
    }

    /**
     * Gets a list of valid routes of a given {@code ServiceType}, including the name and id of the originating and terminating stops for each route.
     * {@code ServiceType.NIGHT} will give night tube services only.
     * @param type The service type of routes that are given. 
     * @return A list of {@link net.danielgill.tfl.line.Line Line} objects containing the valid route data.
     * @throws APIException Thrown if the API cannot be accessed.
     * @see net.danielgill.tfl.route.ServiceType
     */
    public List<Line> route(ServiceType type) throws APIException {
        List<Line> lineList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/Route?serviceTypes=" + type.toString());
            JsonArray routes = je.getAsJsonArray();
            for(JsonElement route : routes) {
                JsonObject routeObject = route.getAsJsonObject();
                lineList.add(Line.fromJson(routeObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/Route?serviceTypes=" + type.toString());
        }
        return lineList;
    }

    /**
     * Gets all valid routes for a given line ID, including the name and id of the originating and terminating stops for each route.
     * @param id The ID of the line to get the routes.
     * @return A single {@link net.danielgill.tfl.line.Line Line} object containing the valid route data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public Line route(String id) throws APIException {
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/"+ id +"/Route");
            JsonObject routeObject = je.getAsJsonObject();
            return Line.fromJson(routeObject);
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/"+ id +"/Route");
        }
    }

    /**
     * Get all valid routes for given line IDs, including the name and id of the originating and terminating stops for each route.
     * @param ids A list of IDs of lines to get route data for. Maximum approx 20.
     * @return A list of {@link net.danielgill.tfl.line.Line Line} objects containing the valid route data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Line> route(List<String> ids) throws APIException {
        String idstr = "";
        for(String id : ids) {
            idstr += id + ",";
        }
        List<Line> lineList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/" + idstr + "/Route");
            JsonArray routes = je.getAsJsonArray();
            for(JsonElement route : routes) {
                JsonObject routeObject = route.getAsJsonObject();
                lineList.add(Line.fromJson(routeObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/" + idstr + "/Route");
        }
        return lineList;
    }

    /**
     * Get disruptions for all lines of the given mode.
     * @return A list of {@link net.danielgill.tfl.disruption.Disruption Disruption} objects containing the disruption data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Disruption> disruption(Mode mode) throws APIException {
        List<Disruption> disruptionList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/Mode/" + mode.toString() + "/Disruption");
            JsonArray disruptions = je.getAsJsonArray();
            for(JsonElement disruption : disruptions) {
                JsonObject disruptionObject = disruption.getAsJsonObject();
                disruptionList.add(Disruption.fromJson(disruptionObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/Mode/" + mode.toString() + "/Disruption");
        }
        return disruptionList;
    }

    /**
     * Get disruptions for all lines of the given modes.
     * @param modes A set of modes to get disruption data for. Maximum approx 20.
     * @return A list of {@link net.danielgill.tfl.disruption.Disruption Disruption} objects containing the disruption data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Disruption> disruption(Set<Mode> modes) throws APIException {
        String modestr = "";
        for(Mode mode : modes) {
            modestr += mode.toString() + ",";
        }
        List<Disruption> disruptionList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/Mode/" + modestr + "/Disruption");
            JsonArray disruptions = je.getAsJsonArray();
            for(JsonElement disruption : disruptions) {
                JsonObject disruptionObject = disruption.getAsJsonObject();
                disruptionList.add(Disruption.fromJson(disruptionObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/Mode/" + modestr + "/Disruption");
        }
        return disruptionList;
    }

    /**
     * Get disruptions for a given line ID.
     * @param id The ID of the line to get disruption data for.
     * @return A list of {@link net.danielgill.tfl.disruption.Disruption Disruption} objects containing the disruption data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Disruption> disruption(String id) throws APIException {
        List<Disruption> disruptionList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/" + id + "/Disruption");
            JsonArray disruptions = je.getAsJsonArray();
            for(JsonElement disruption : disruptions) {
                JsonObject disruptionObject = disruption.getAsJsonObject();
                disruptionList.add(Disruption.fromJson(disruptionObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/" + id + "/Disruption");
        }
        return disruptionList;
    }

    /**
     * Get disruptions for given line IDs.
     * @param ids A list of IDs of lines to get disruption data for. Maximum approx 20.
     * @return A list of {@link net.danielgill.tfl.disruption.Disruption Disruption} objects containing the disruption data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Disruption> disruption(List<String> ids) throws APIException {
        String idstr = "";
        for(String id : ids) {
            idstr += id + ",";
        }
        List<Disruption> disruptionList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/" + idstr + "/Disruption");
            JsonArray disruptions = je.getAsJsonArray();
            for(JsonElement disruption : disruptions) {
                JsonObject disruptionObject = disruption.getAsJsonObject();
                disruptionList.add(Disruption.fromJson(disruptionObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/" + idstr + "/Disruption");
        }
        return disruptionList;
    }

    /**
     * Get status for all lines of the given mode.
     * @return A list of {@link net.danielgill.tfl.line.Line Line} objects containing the status data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Line> status(Mode mode) throws APIException {
        List<Line> lineList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/Mode/" + mode.toString() + "/Status");
            JsonArray lines = je.getAsJsonArray();
            for(JsonElement line : lines) {
                JsonObject lineObject = line.getAsJsonObject();
                lineList.add(Line.fromJson(lineObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/Mode/" + mode.toString() + "/Status");
        }
        return lineList;
    }

    /**
     * Get status for all lines of the given modes.
     * @param modes A set of modes to get status data for. Maximum approx 20.
     * @return A list of {@link net.danielgill.tfl.line.Line Line} objects containing the status data.
     * @throws APIException Thrown if the API cannot be accessed.
     */
    public List<Line> status(Set<Mode> modes) throws APIException {
        String modestr = "";
        for(Mode mode : modes) {
            modestr += mode.toString() + ",";
        }
        List<Line> lineList = new ArrayList<>();
        try {
            JsonElement je = TfLAPI.call("https://api.tfl.gov.uk/Line/Mode/" + modestr + "/Status");
            JsonArray lines = je.getAsJsonArray();
            for(JsonElement line : lines) {
                JsonObject lineObject = line.getAsJsonObject();
                lineList.add(Line.fromJson(lineObject));
            }
        } catch (IOException e) {
            throw new APIException("https://api.tfl.gov.uk/Line/Mode/" + modestr + "/Status");
        }
        return lineList;
    }
}

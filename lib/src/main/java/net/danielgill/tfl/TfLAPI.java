package net.danielgill.tfl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * The TfL API. This class is used to access parts of the TfL API.
 */
public class TfLAPI {
    /**
     * TfL's Line API, which provides information about lines, routes, departures, and statuses.
     */
    public static final LineAPI line = new LineAPI();

    /**
     * Call the TfL API.
     * @param endPoint The endpoint to call.
     * @return The JsonElement returned by the API.
     * @throws IOException If the API call fails.
     */
    protected static final JsonElement call(String endPoint) throws IOException {
        URL url = new URL(endPoint);
        URLConnection request = url.openConnection();
        request.connect();

        JsonElement el = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        return el;
    }
}
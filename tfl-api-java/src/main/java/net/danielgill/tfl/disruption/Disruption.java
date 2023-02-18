package net.danielgill.tfl.disruption;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

/**
 * A disruption to a line.
 */
public class Disruption {
    /**
     * The category of disruption.
     */
    public final DisruptionCategory category;
    /**
     * The type of disruption.
     */
    public final DisruptionType type;
    /**
     * The text describing the disruption.
     */
    public final String description;
    /**
     * The text describing the closure, if no closure text is provided, this will be null.
     */
    @Nullable
    public final String closureText;

    private Disruption(DisruptionCategory category, DisruptionType type, String description, String closureText) {
        this.category = category;
        this.type = type;
        this.description = description;
        this.closureText = closureText;
    }

    /**
     * Create a Disruption from a JsonObject.
     * @param jo The JsonObject to create the Disruption from.
     * @return The Disruption.
     */
    public static Disruption fromJson(JsonObject jo) {
        String closureText = jo.get("closureText") == null ? null : jo.get("closureText").getAsString();

        return new Disruption(
            DisruptionCategory.getFromString(jo.get("categoryDescription").getAsString()),
            DisruptionType.getFromString(jo.get("type").getAsString()),
            jo.get("description").getAsString(),
            closureText
        );
    }
}

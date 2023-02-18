package net.danielgill.tfl.line;

import com.google.gson.JsonObject;

import net.danielgill.tfl.disruption.Disruption;

/**
 * Represents the status of a line.
 */
public class Status {
    /**
     * The id of the status.
     */
    public final int id;
    /**
     * The id of the line that the status pertains to.
     */
    public final String lineId;
    /**
     * The severity of the status.
     */
    public final int severity;
    /**
     * The description of the severity of the status.
     */
    public final String severityDescription;
    /**
     * The reason for the status.
     */
    public final String reason;
    /**
     * The disruption that the status pertains to.
     */
    public final Disruption disruption;

    private Status(int id, String lineId, int severity, String severityDescription, String reason, Disruption disruption) {
        this.id = id;
        this.lineId = lineId;
        this.severity = severity;
        this.severityDescription = severityDescription;
        this.reason = reason;
        this.disruption = disruption;
    }

    /**
     * Create a Status from a JsonObject.
     * @param jo The JsonObject to create the status from.
     * @return The status.
     */
    public static Status fromJson(JsonObject jo) {
        return new Status(
            jo.get("id").getAsInt(),
            jo.get("lineId").getAsString(),
            jo.get("statusSeverity").getAsInt(),
            jo.get("statusSeverityDescription").getAsString(),
            jo.get("reason").getAsString(),
            Disruption.fromJson(jo.get("disruption").getAsJsonObject())
        );
    }
}

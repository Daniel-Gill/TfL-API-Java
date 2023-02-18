package net.danielgill.tfl;

public class APIException extends Exception {
    public APIException(String endpoint) {
        super("A call to " + endpoint + " did not succeed.");
    }
}

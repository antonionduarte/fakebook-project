package enums;

public enum Stance {

    /* Truthfulness (posts) */
    HONEST("honest"),
    FAKE("fake"),

    /* Stance (comments) */
    POSITIVE("positive"),
    NEGATIVE("negative");

    /* Variables */
    private final String message;

    /**
     * Constructor.
     * @param message The string of the characteristic.
     */
    Stance(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
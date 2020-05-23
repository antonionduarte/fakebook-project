package enums;

public enum View {

    /* Truthfulness */
    HONEST("honest"),
    FAKE("fake"),

    /* Stance */
    POSITIVE("positive"),
    NEGATIVE("negative");

    /* Variables */
    private final String message;

    /**
     * Constructor.
     * @param message The string of the characteristic.
     */
    View(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
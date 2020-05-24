package enums;

public enum Stance {

    /* Truthfulness (posts) */
    HONEST("honest", true),
    FAKE("fake", false),

    /* Stance (comments) */
    POSITIVE("positive", true),
    NEGATIVE("negative", false);

    /* Variables */
    private final String message;
    private final boolean value;

    /**
     * Constructor.
     * @param message The string of the characteristic.
     */
    Stance(String message, boolean value) {
        this.message = message;
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public boolean getValue() {
        return value;
    }
} 
package enums;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * All post, comment and fanaticism stances.
 */

public enum Stance {

    /* Truthfulness (posts) */
    HONEST("honest", true),
    FAKE("fake", false),

    /* Stance (comments) */
    POSITIVE("positive", true),
    NEGATIVE("negative", false),
    
    /* Stance (fanaticisms) */
    LOVES("loves", true),
    HATES("hates", false);

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
    
    /**
     * @return The stances' string.
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * @return The stances' boolean value.
     */
    public boolean getValue() {
        return value;
    }
    
} 
package exceptions;

public class NoLiesException extends Exception {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -3368150928696255511L;

    /* Exception message */
    private static final String MESSAGE = "Social distancing has reached facebook. Post a lie and become the kind of liars.";

    /* Constructor */
    public NoLiesException() {
        super(MESSAGE);
    }
}
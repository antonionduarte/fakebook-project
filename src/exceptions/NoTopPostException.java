package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class NoTopPostException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 1L;

    /* Exception message */
    private static final String MESSAGE = "Social distancing has reached fakebook. Please post something.";

    /* Constructor */
    public NoTopPostException() {
        super(MESSAGE);
    }
    
}

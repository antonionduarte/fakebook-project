package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class NoTopResponsiveException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = -7260620685022633278L;

    /* Exception message */
    private static final String MESSAGE = "Social distancing has reached fakebook. Post something and then comment your own post to become the king of responsiveness.";

    /* Constructor */
    public NoTopResponsiveException() {
        super(MESSAGE);
    }
    
}

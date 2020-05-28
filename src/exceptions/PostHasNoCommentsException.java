package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class PostHasNoCommentsException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 2725549232612704858L;

    /* Exception message */
    private static final String MESSAGE = "No comments!";
    
    /* Constructor */
    public PostHasNoCommentsException() {
        super(MESSAGE);
    }
}
    

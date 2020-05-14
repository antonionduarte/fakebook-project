package exceptions;

public class PostHasNoCommentsException extends Exception {
    
    /* Serial version UID */
    private static final long serialVersionUID = 2725549232612704858L;

    /* Exception message */
    private static final String MESSAGE = "No comments!";
    
    /* Constructor */
    public PostHasNoCommentsException() {
        super(MESSAGE);
    }
    
}

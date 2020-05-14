package exceptions;

public class PostHasNoCommentsException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "No comments!";
    
    /* Constructor */
    public PostHasNoCommentsException() {
        super(MESSAGE);
    }
    
}

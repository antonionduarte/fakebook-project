package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class InvalidNumberOfPostsException extends RuntimeException {
    
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 970572607340229809L;

    /* Exception message */
    private static final String MESSAGE = "Invalid number of posts to present!";
    
    public InvalidNumberOfPostsException() {
        super(MESSAGE);
    }
    
}

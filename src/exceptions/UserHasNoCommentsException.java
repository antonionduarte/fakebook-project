package exceptions;

public class UserHasNoCommentsException extends Exception {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;
    
    /* Exception message */
    private static final String MESSAGE = "No comments!";

    /* Constructor */
    public UserHasNoCommentsException() {
        super(MESSAGE);
    }
    
}
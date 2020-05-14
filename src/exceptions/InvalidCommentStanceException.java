package exceptions;

public class InvalidCommentStanceException extends Exception {
    
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1548829716255641287L;
    
    /* Exception message */
    private static final String MESSAGE = "Invalid comment stance!";
    
    /* Constructor */
    public InvalidCommentStanceException() {
        super(MESSAGE);
    }
    
}

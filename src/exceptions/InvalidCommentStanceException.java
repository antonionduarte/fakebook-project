package exceptions;

public class InvalidCommentStanceException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "Invalid comment stance!";
    
    /* Constructor */
    public InvalidCommentStanceException() {
        super(MESSAGE);
    }
    
}

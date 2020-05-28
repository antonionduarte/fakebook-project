package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class InvalidCommentStanceException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 1548829716255641287L;
    
    /* Exception message */
    private static final String MESSAGE = "Invalid comment stance!";
    
    /* Constructor */
    public InvalidCommentStanceException() {
        super(MESSAGE);
    } 
}

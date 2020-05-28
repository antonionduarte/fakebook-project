package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class InvalidHashtagListException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 6959377380529681823L;

    /* Exception message */
    private static final String MESSAGE = "Invalid hashtags list!";
    
    /* Constructor */
    public InvalidHashtagListException() {
        super(MESSAGE);
    }
    
}

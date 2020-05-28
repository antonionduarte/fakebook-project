package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class InvalidStanceException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 413239227084256764L;

    /* Exception message */
    private static final String MESSAGE = "Inadequate stance!";
    
    public InvalidStanceException() {
        super(MESSAGE);
    }
    
}

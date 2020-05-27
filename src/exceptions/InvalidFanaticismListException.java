package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class InvalidFanaticismListException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 4730950725835496032L;

    /* Exception message */
    private static final String MESSAGE = "Invalid fanaticism list!";
    
    public InvalidFanaticismListException() {
        super(MESSAGE);
    }
    
}

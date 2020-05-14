package exceptions;

public class InvalidFanaticismListException extends Exception {
    
    /* Serial version UID */
    private static final long serialVersionUID = 4730950725835496032L;

    /* Exception message */
    private static final String MESSAGE = "Invalid fanaticism list!";
    
    public InvalidFanaticismListException() {
        super(MESSAGE);
    }
    
}

package exceptions;

public class InvalidFanaticismListException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "Invalid fanaticism list!";
    
    public InvalidFanaticismListException() {
        super(MESSAGE);
    }
    
}

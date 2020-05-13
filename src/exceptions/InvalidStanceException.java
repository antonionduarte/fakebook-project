package exceptions;

public class InvalidStanceException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "Inadequate stance!";
    
    public InvalidStanceException() {
        super(MESSAGE);
    }
    
}

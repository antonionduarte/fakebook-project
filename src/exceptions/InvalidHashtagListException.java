package exceptions;

public class InvalidHashtagListException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "Invalid hashtags list!";
    
    public InvalidHashtagListException() {
        super(MESSAGE);
    }
    
}

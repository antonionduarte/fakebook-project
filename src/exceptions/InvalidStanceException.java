package exceptions;

public class InvalidStanceException extends Exception {
    
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 413239227084256764L;

    /* Exception message */
    private static final String MESSAGE = "Inadequate stance!";
    
    public InvalidStanceException() {
        super(MESSAGE);
    }
    
}

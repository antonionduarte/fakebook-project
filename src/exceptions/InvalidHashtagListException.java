package exceptions;

public class InvalidHashtagListException extends Exception {
    
    /* Serial version UID */
    private static final long serialVersionUID = 6959377380529681823L;

    /* Exception message */
    private static final String MESSAGE = "Invalid hashtags list!";
    
    public InvalidHashtagListException() {
        super(MESSAGE);
    }
    
}

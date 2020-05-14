package exceptions;

public class InvalidFanaticismException extends Exception {
    
    /**
     *
     */
    private static final long serialVersionUID = 8486642903904460641L;

    /* Exception message */
    private static final String MESSAGE = "Oh please, who would be a fanatic of <%s>?\n";

    /* Constructor */
    public InvalidFanaticismException() {
        super(MESSAGE);
    }
    
}
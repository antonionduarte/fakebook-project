package exceptions;

public class InvalidFanaticismException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 8486642903904460641L;

    /* Exception message */
    private static final String MESSAGE = "Oh please, who would be a fanatic of %s?";

    /* Constructor */
    public InvalidFanaticismException(String hashtag) {
        super(String.format(MESSAGE, hashtag));
    }
    
}
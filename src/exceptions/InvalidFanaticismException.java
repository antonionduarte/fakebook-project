package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class InvalidFanaticismException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 8486642903904460641L;

    /* Exception message */
    private static final String MESSAGE = "Oh please, who would be a fanatic of %s?";
    
    /**
     * Constructor.
     * @param hashtag The invalid fanaticism hashtag.
     */
    public InvalidFanaticismException(String hashtag) {
        super(String.format(MESSAGE, hashtag));
    }
    
}

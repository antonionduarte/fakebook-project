package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class InvalidHashtagException extends RuntimeException {
    
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 5278952031591834601L;

    /* Exception message */
    private static final String MESSAGE = "Oh please, who would write about %s?";
    
    /**
     * Constructor.
     * @param hashtag Invalid hashtag.
     */
    public InvalidHashtagException(String hashtag) {
        super(String.format(MESSAGE, hashtag));
    }
    
}

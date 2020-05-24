package exceptions;

public class InvalidHashtagException extends RuntimeException {
    
    /* Exception message */
    private static final String MESSAGE = "Oh please, who would write about %s";
    
    /**
     * Constructor.
     * @param hashtag Invalid hashtag.
     */
    public InvalidHashtagException(String hashtag) {
        super(String.format(MESSAGE, hashtag));
    }
    
}

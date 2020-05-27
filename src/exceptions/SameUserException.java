package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class SameUserException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 781512738771612364L;

    /* Exception message */
    private static final String MESSAGE = "%s cannot be the same as %s!";
    
    /**
     * Constructor.
     * @param userId The repeated users' ID.
     */
    public SameUserException(String userId) {
        super(String.format(MESSAGE, userId, userId));
    }
    
}

package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class UserCannotCommentOnPostException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = -7746132248927028171L;

    /* Exception message */
    private static final String MESSAGE = "%s cannot comment on this post!";
    
    /**
     * Constructor.
     * @param userId The users' ID.
     */
    public UserCannotCommentOnPostException(String userId) {
        super(String.format(MESSAGE, userId));
    }
    
}

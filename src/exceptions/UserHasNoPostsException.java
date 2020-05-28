package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class UserHasNoPostsException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = -4767632046512590820L;

    /* Exception message */
    private static final String MESSAGE = "%s has no posts!";
    
    /**
     * Constructor.
     * @param userId The user that has no posts.
     */
    public UserHasNoPostsException(String userId) {
        super(String.format(MESSAGE, userId));
    }
    
}

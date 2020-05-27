package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class UserDoesNotHavePostException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = -4955497150450307646L;

    /* Exception message */
    private static final String MESSAGE = "%s has no post %d!";
    
    /**
     * Constructor.
     * @param userId The users' ID.
     * @param postId The posts' ID.
     */
    public UserDoesNotHavePostException(String userId, int postId) {
        super(String.format(MESSAGE, userId, postId));
    }
    
}

package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class UserHasNoFriendsException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 6289365015163704640L;

    /* Exception message */
    private static final String MESSAGE = "%s has no friends!";
    
    /**
     * Constructor.
     * @param userId The user that has no friends.
     */
    public UserHasNoFriendsException(String userId) {
        super(String.format(MESSAGE, userId));
    }
}
    

package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class UsersAlreadyFriendsException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = -4561608868886859692L;

    /* Exception message */
    private static final String MESSAGE = "%s must really admire %s!";
    
    /**
     * Constructor.
     * @param userId1 The first user.
     * @param userId2 The second user.
     */
    public UsersAlreadyFriendsException(String userId1, String userId2) {
        super(String.format(MESSAGE, userId1, userId2));
    }
    
}

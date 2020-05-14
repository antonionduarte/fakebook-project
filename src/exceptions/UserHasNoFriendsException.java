package exceptions;

public class UserHasNoFriendsException extends Exception {
    
    /**
     * Serial version UID.
     */
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

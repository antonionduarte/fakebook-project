package exceptions;

public class UserHasNoFriendsException extends Exception {
    
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

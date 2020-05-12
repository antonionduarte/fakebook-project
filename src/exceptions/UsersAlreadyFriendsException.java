package exceptions;

public class UsersAlreadyFriendsException extends Exception {
    
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

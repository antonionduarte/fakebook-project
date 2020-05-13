package exceptions;

public class UserCannotCommentOnPostException extends Exception {
    
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

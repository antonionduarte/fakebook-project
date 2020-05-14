package exceptions;

public class UserDoesNotHaveAccessToPostException extends Exception {
    
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 9185586726477864031L;

    /* Exception message */
    private static final String MESSAGE = "%s has no access to post %d by user %s!";
    
    
    public UserDoesNotHaveAccessToPostException(String userIdComment, int postId, String userIdAuthor) {
        super(String.format(MESSAGE, userIdComment, postId, userIdAuthor));
    }
    
}

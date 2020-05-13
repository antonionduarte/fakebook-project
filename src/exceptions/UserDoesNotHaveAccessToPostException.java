package exceptions;

public class UserDoesNotHaveAccessToPostException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "%s has no access to post %d by user %s!";
    
    
    public UserDoesNotHaveAccessToPostException(String userIdComment, int postId, String userIdAuthor) {
        super(String.format(MESSAGE, userIdComment, postId, userIdAuthor));
    }
    
}

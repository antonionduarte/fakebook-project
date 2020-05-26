package exceptions;

public class UserDoesNotHaveAccessToPostException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 9185586726477864031L;

    /* Exception message */
    private static final String MESSAGE = "%s has no access to post %d by %s!";
    
    /**
     * Constructor.
     * @param userIdComment ID of the user that wants to comment on the post.
     * @param postId The posts' ID.
     * @param userIdAuthor The posts authors' ID.
     */
    public UserDoesNotHaveAccessToPostException(String userIdComment, int postId, String userIdAuthor) {
        super(String.format(MESSAGE, userIdComment, postId, userIdAuthor));
    }
    
}

package exceptions;

public class PostDoesNotExistException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "%s has no post %d!";
    
    /**
     * Constructor.
     * @param userId The users' ID.
     * @param postId ID of the post that doesn't exist.
     */
    public PostDoesNotExistException(String userId, int postId) {
        super(String.format(MESSAGE, userId, postId));
    }
    
}

package exceptions;

public class InvalidNumberOfPostsException extends RuntimeException {
    
    /* Exception message */
    private static final String MESSAGE = "Invalid number of posts to present!";
    
    public InvalidNumberOfPostsException() {
        super(MESSAGE);
    }
    
}

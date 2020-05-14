package exceptions;

public class NoPostsException extends Exception {
    
    /* Serial version UID */
    private static final long serialVersionUID = 1L;

    /* Exception message */
    private static final String MESSAGE = "Social distancing has reached fakebook. Please post something to become the kind of posters.";

    /* Constructor */
    public NoPostsException() {
        super(MESSAGE);
    }
}
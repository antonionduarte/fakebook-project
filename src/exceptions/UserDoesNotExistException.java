package exceptions;

public class UserDoesNotExistException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = -6368849754665328060L;

    /* Exception message */
    private static final String MESSAGE = "%s does not exist!";
    
    /**
     * Constructor.
     * @param userId The user that doesn't exist.
     */
    public UserDoesNotExistException(String userId) {
        super(String.format(MESSAGE, userId));
    }
    
}

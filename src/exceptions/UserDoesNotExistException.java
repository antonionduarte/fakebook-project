package exceptions;

public class UserDoesNotExistException extends Exception {
    
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

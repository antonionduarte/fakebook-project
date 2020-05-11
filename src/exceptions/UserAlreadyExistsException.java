package exceptions;

public class UserAlreadyExistsException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "%s already exists!";
    
    /**
     * Constructor.
     * @param userId User ID that already exists.
     */
    public UserAlreadyExistsException(String userId) {
        super(String.format(MESSAGE, userId));
    }
}

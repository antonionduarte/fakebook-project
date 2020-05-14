package exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = 7146754211447615073L;

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

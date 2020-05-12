package exceptions;

public class SameUserException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "%s cannot be the same as %s!";
    
    /**
     * Constructor.
     * @param userId The repeated users' ID.
     */
    public SameUserException(String userId) {
        super(String.format(MESSAGE, userId, userId));
    }
    
}

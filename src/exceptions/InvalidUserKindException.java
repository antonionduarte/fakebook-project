package exceptions;

public class InvalidUserKindException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "%s is an invalid user kind!";
    
    /**
     * Constructor.
     * @param userKind Invalid user kind.
     */
    public InvalidUserKindException(String userKind) {
        super(String.format(MESSAGE, userKind));
    }
    
}

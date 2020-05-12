package exceptions;

public class InvalidUserKindException extends Exception {
    
    /* Serial version UID */
    private static final long serialVersionUID = 2247045929902441380L;

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

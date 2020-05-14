package exceptions;

public class NoUsersException extends Exception {
    
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 2124299706527122145L;

    /* Exception message */
    private static final String MESSAGE = "There are no users!";
    
    /* Constructor */
    public NoUsersException() {
        super(MESSAGE);
    }
    
}

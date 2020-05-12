package exceptions;

public class NoUsersException extends Exception {
    
    /* Exception message */
    private static final String MESSAGE = "There are no users!";
    
    /* Constructor */
    public NoUsersException() {
        super(MESSAGE);
    }
    
}

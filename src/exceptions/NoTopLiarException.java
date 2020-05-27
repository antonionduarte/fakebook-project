package exceptions;

public class NoTopLiarException extends RuntimeException {
    
    /* Serial version UID */
    private static final long serialVersionUID = -3368150928696255511L;

    /* Exception message */
    private static final String MESSAGE = "Social distancing has reached fakebook. Post a lie and become the king of liars.";

    /* Constructor */
    public NoTopLiarException() {
        super(MESSAGE);
    }
}
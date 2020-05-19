package exceptions;

public class NoTopPosterException extends RuntimeException {
    
    
    /* Serial version UID */
    private static final long serialVersionUID = 7109479092766658286L;
    
    /* Exception message */
    private static final String MESSAGE = "Social distancing has reached fakebook. Post something to become the king of posters";

    /* Constructor */
    public NoTopPosterException() {
        super(MESSAGE);
    }
    
}
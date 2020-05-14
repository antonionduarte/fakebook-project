package exceptions;

public class NoResponsiveException extends Exception {

    /**
    * Serial version UID.
    */
    private static final long serialVersionUID = -7260620685022633278L;

    /* Exception message */
        private static final String MESSAGE = "Social distancing has reached fakebook. Please post something and then comment your own post to become the king of responsiveness.";

        /* Constructor */
        public NoResponsiveException() {
            super(MESSAGE);
        }
}
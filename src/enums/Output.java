package enums;

public enum Output {
	
	/* Outputs */
	USER_REGISTERED("%s registered.\n"),
	MESSAGE_SENT("%s sent a %s post to %d friends. Post id = %d.\n"),
	USER_POSTS("%s posts:\n"),
	COMMENT_ADDED("Comment added!"),
	UNKNOWN_COMMAND("Unknown command. Type help to see available commands."),
	INVALID_NUMBER_POSTS("Invalid number of posts to present!"), /* Might be useless */
	EXIT("Bye!");
	
	/* Variables */
	private final String message;
	
	/**
	 * Constructor.
	 * @param message The outputs' message.
	 */
	Output(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}

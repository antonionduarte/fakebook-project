package enums;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public enum Output {
	
	/* Outputs */
	USER_REGISTERED("%s registered.\n"),
	LIST_USER("%s [%s] %d %d %d\n"),
	FRIEND_ADDED("%s is friend of %s.\n"),
	POST_SENT("%s sent a %s post to %d friends. Post id = %d.\n"),
	USER_POSTS("%s posts:\n"),
	LIST_POST("%d. [%s] %s [%d comments]\n"),
	COMMENT_ADDED("Comment added!"),
	READ_POST("[%s %s] %s\n"),
	LIST_COMMENT("[%s %s %d %s] %s\n"),
	LIST_TOPIC_POST("%s %d %d: %s\n"),
	TOP_POST("%s %d %d: %s\n"),
	TOP_POSTER("%s %d %d.\n"),
	TOP_RESPONSIVE("%s %d %d.\n"),
	TOP_LIAR("%s %d.\n"),
	UNKNOWN_COMMAND("Unknown command. Type help to see available commands."),
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

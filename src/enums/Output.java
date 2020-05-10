package enums;

public enum Output {
	
	/* Outputs */
	UNKNOWN_COMMAND("Unknown command. Type help to see available commands."),
	EXIT("Bye!");
	
	/**/
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

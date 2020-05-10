package enums;

public enum Command {
	
	/* Commands */
	EXIT("terminates the execution of the program."),
	HELP("shows the available commands.");
	
	/* Variables */
	private final String description;
	
	/**
	 * Constructor.
	 * @param description The commands' description.
	 */
	Command(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}

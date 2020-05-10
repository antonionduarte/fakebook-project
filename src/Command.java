public enum Command {
	
	/* Commands */
	
	
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

package enums;

public enum Command {
	
	/* Commands */
	REGISTER("registers a new user"),
	USERS("lists all users"),
	ADDFRIEND("adds a new friend"),
	FRIENDS("lists the user friends"),
	POST("posts a new message"),
	USERPOSTS("lists all posts by a user"),
	COMMENT("user comments on a post"),
	READPOST("prints detailed info on a post"),
	COMMENTSBYUSER("shows all the comments by a user on a given post"),
	TOPICFANATICS("shows a list of fanatic users on a topic"),
	TOPICPOSTS("shows a list of posts on a given topic"),
	POPULARPOST("shows the most commented post"),
	TOPPOSTER("shows the user with more posts"),
	RESPONSIVE("shows the user with a higher percentage of commented posts"),
	SHAMELESS("shows the top liars"),
	HELP("shows the available commands"),
	EXIT("terminates the execution of the program"),
	UNKNOWN("unknown command");
	
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

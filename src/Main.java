import exceptions.*;
import fakebook.*;
import enums.*;
import fanaticisms.Fanaticism;
import fanaticisms.FanaticismClass;
import posts.*;
import users.*;
import comments.*;
import java.util.*;


public class Main {
	
	/**
	 * Reads and executes input commands repeatedly until the EXIT command is introduced.
	 * @param args Arguments used for the execution of the program (not used).
	 */
	public static void main(String[] args) {
		Fakebook fakebook = new FakebookClass();
		Scanner in = new Scanner(System.in);
		Command command;
		
		do {
			command = readCommand(in);
			executeCommand(command, in, fakebook);
		} while (command != Command.EXIT);
		
		in.close();
	}
	
	/**
	 * Interprets an inserted command.
	 * @param in Input scanner.
	 * @return The desired command || Unknown command.
	 */
	private static Command readCommand(Scanner in) {
		try {
			return Command.valueOf(in.next().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}
	
	/**
	 * Executes a given command.
	 * @param command Command to execute.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void executeCommand(Command command, Scanner in, Fakebook fakebook) {
		switch (command) {
			case EXIT:
				exit();
				break;
			case HELP:
				help();
				break;
			case REGISTER:
				registerUser(in, fakebook);
				break;
			case USERS:
				listUsers(in, fakebook);
				break;
			case ADDFRIEND:
				addFriend(in, fakebook);
				break;
			case FRIENDS:
				listUserFriends(in, fakebook);
				break;
			case POST:
				post(in, fakebook);
				break;
			case USERPOSTS:
				listUserPosts(in, fakebook);
				break;
			case COMMENT:
				commentPost(in, fakebook);
				break;
			case READPOST:
				readPost(in, fakebook);
				break;
			case COMMENTSBYUSER:
				listUserComments(in, fakebook);
				break;
			case TOPICFANATICS:
				listTopicFanatics(in, fakebook);
				break;
			case TOPICPOSTS:
				listTopicPosts(in, fakebook);
				break;
			case POPULARPOST:
				topPost(fakebook);
				break;
			case TOPPOSTER:
				topPoster(fakebook);
				break;
			case RESPONSIVE:
				topResponsive(fakebook);
				break;
			case SHAMELESS:
				topLiar(fakebook);
				break;
			default:
				unknownCommand(in);
				break;
		}
	}
	
	/**
	 * Prints out the unknown command message.
	 */
	private static void unknownCommand(Scanner in) {
		System.out.println(Output.UNKNOWN_COMMAND.getMessage());
		in.nextLine();
	}
	
	/**
	 * Prints out the exit message.
	 */
	private static void exit() {
		System.out.println(Output.EXIT.getMessage());
	}
	
	/**
	 * Prints out all existing commands and their corresponding descriptions.
	 */
	private static void help() {
		for (Command command: Command.values()) {
			if (command != Command.UNKNOWN) {
				System.out.println(command.toString().toLowerCase() + " - " + command.getDescription());
			}
		}
	}
	
	/**
	 * Registers a new user.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void registerUser(Scanner in, Fakebook fakebook) {
		String userKind = in.next();
		String userId = in.next() + in.nextLine();
		
		try {
			if (fakebook.userKindIsFanatic(userKind)) {
				int numFanaticisms = in.nextInt();
				Map<String, String> fanaticismsChecker = new HashMap<>();
				List<Fanaticism> fanaticisms = new ArrayList<>();
				
				for (int i = 0; i < numFanaticisms; i++) {
					String stance = in.next();
					String hashtag = in.next();
					
					if (!fanaticismsChecker.containsKey(hashtag)) {
						fanaticismsChecker.put(hashtag, stance);
						fanaticisms.add(new FanaticismClass(hashtag, stance));
					}
					else {
						throw new InvalidFanaticismListException();
					}
				}
				in.nextLine();
				
				fakebook.registerFanatic(userId, fanaticisms);
			}
			else {
				fakebook.registerUser(userKind, userId);
			}
		}
		catch (InvalidUserKindException e) {
			System.out.println(e.getMessage());
		}
		catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidFanaticismListException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Lists all registered users.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listUsers(Scanner in, Fakebook fakebook) {
		try {
			in.nextLine();
			Iterator<User> users = fakebook.newUsersIterator();
			
			while (users.hasNext()) {
				User user = users.next();
				System.out.printf("%s [%s] %d %d %d\n", user.getId(), user.getKind(), user.getNumFriends(),
					user.getNumPosts(), user.getNumComments());
			}
		}
		catch (NoUsersException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Creates a bidirectional friend relationship between 2 users.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void addFriend(Scanner in, Fakebook fakebook) {
		try {
			String userId1 = in.next() + in.nextLine();
			String userId2 = in.nextLine();
			
			fakebook.addFriend(userId1, userId2);
			System.out.printf("%s is friend of %s.\n", userId1, userId2);
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (SameUserException e) {
			System.out.println(e.getMessage());
		}
		catch (UsersAlreadyFriendsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Lists a users' friend list.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listUserFriends(Scanner in, Fakebook fakebook) {
		try {
			String userId = in.next() + in.nextLine();
			
			Iterator<User> friends = fakebook.newUserFriendsIterator(userId);
			
			while (friends.hasNext()) {
				User friend = friends.next();
				
				System.out.print(friend.getId());
				
				if (friends.hasNext()) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (UserHasNoFriendsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Allows a user to make a new post (visible to his friends).
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void post(Scanner in, Fakebook fakebook) {
		try {
			String userId = in.next() + in.nextLine();
			int numHashtags = in.nextInt();
			
			/**
			 * DataStructure hashtags = new DataStructureClass();
			 */
			
			for (int i = 0; i < numHashtags; i++) {
				/**
				 * (Code to be added here)
				 * (Awaiting for master Goulao's tips on what data structure to use for saving a posts' hashtags)
				 */
			}
			
			String postTruthfulness = in.next();
			String postMessage = in.next() + in.nextLine();
			
			fakebook.post(userId, hashtags, postTruthfulness, postMessage);
			System.out.printf(Output.MESSAGE_SENT.getMessage(), userId, postTruthfulness,
				fakebook.getUserNumFriends(userId), fakebook.getUserNumPosts(userId));
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidHashtagListException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidStanceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Lists a users' posts.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listUserPosts(Scanner in, Fakebook fakebook) {
		try {
			String userId = in.next() + in.nextLine();
			
			Iterator<Post> posts = fakebook.newUserPostsIterator(userId);
			
			System.out.printf(Output.USER_POSTS.getMessage(), userId);
			
			while (posts.hasNext()) {
				Post post = posts.next();
				
				System.out.printf("%d. [%s] %s [%d comments]\n", post.getId(), post.getTruthfulness(),
					post.getMessage(), post.getNumComments());
			}
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (UserHasNoPostsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Allows a user to comment another users' (or his own) post.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void commentPost(Scanner in, Fakebook fakebook) {
		try {
			String userIdComment = in.next() + in.nextLine();
			String userIdPost = in.next() + in.nextLine();
			int postId = in.nextInt();
			String commentStance = in.next();
			String commentMessage = in.next() + in.nextLine();
			
			fakebook.commentPost(userIdComment, userIdPost, postId, commentStance, commentMessage);
			System.out.println(Output.COMMENT_ADDED.getMessage());
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (PostDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (UserDoesNotHaveAccessToPostException e) {
			System.out.println(e.getMessage());
		}
		catch (UserCannotCommentOnPostException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidCommentStanceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Prints out detailed information on a users' post.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void readPost(Scanner in, Fakebook fakebook) {
		try {
			String userId = in.next() + in.nextLine();
			int postId = in.nextInt();
			in.nextLine();
			
			Post post = fakebook.getUserPost(userId, postId);
			
			System.out.printf("[%s %s] %s\n", post.getAuthorId(), post.getTruthfulness(), post.getMessage());
			
			Iterator<Comment> comments = post.newCommentsIterator();
			
			while (comments.hasNext()) {
				Comment comment = comments.next();
				
				System.out.printf("[%s %s] %s\n", comment.getAuthorId(), comment.getStance(), comment.getMessage());
			}
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (UserDoesNotHavePostException e) {
			System.out.println(e.getMessage());
		}
		catch (PostHasNoCommentsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lists the comments made by a user about a certain hashtag.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listUserComments(Scanner in, Fakebook fakebook) {
		try {
			String userId = in.nextLine();
			String hashtag = in.nextLine();

			Iterator<Comment> comments  = fakebook.newUserCommentsIterator(userId, hashtag);

			while (comments.hasNext()) {
				Comment comment = comments.next();
				System.out.printf("[%s %s %d %s] %s\n", comment.getPostAuthorId(), comment.getPostTruthfulness(),
					comment.getPostId(), comment.getStance(), comment.getMessage());
			}
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (UserHasNoCommentsException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lists a given topics' fanatic users in alphabetic order of their ID.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listTopicFanatics(Scanner in, Fakebook fakebook) {
		try {
			String hashtag = in.nextLine();
			
			Iterator<User> fanatics = fakebook.newTopicFanaticsIterator(hashtag);

			while (fanatics.hasNext()) {
				User fanatic = fanatics.next();
				
				System.out.printf("%s", fanatic.getId());
				
				if (fanatics.hasNext()) {
					System.out.print(", ");
				}
			}
			System.out.println(".");
		}
		catch (InvalidFanaticismException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lists a specified number of posts of a given topic.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listTopicPosts(Scanner in, Fakebook fakebook) {
		String topic = in.next();
		int amount = in.nextInt(); in.nextLine();
		/**
		 * TODO Awaiting Goulao's orders on if we do a counter in Main
		 * or we do it in the fakebook class.
		 */
	}

	/**
	 * Prints out information about the most commented post.
	 * @param fakebook Fakebook manager.
	 */
	private static void topPost(Fakebook fakebook) {
		try {
			Post post = fakebook.getTopPost();
			
			System.out.printf("%s %d %d: %s\n", post.getAuthorId(), post.getId(),
				post.getNumComments(), post.getMessage());
		}
		catch (NoTopPostException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Prints out information about the user with the most posts.
	 * @param fakebook Fakebook manager.
	 */
	private static void topPoster(Fakebook fakebook) {
		try {
			User topPoster = fakebook.getTopPoster();
			
			System.out.printf("%s %d %d.\n", topPoster.getId(), topPoster.getNumPosts(), topPoster.getNumComments());
		}
		catch (NoTopPosterException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Prints out information about the user with most comments.
	 * @param fakebook Fakebook manager.
	 */
	private static void topResponsive(Fakebook fakebook) {
		try {
			User responsive = fakebook.getTopResponsive();
			
			System.out.printf("%s %d %d.\n", responsive.getId(), responsive.getNumComments(), responsive.getNumPosts());
		}
		catch (NoTopResponsiveException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Prints out information about the users with the most lies.
	 * @param fakebook Fakebook manager.
	 */
	private static void topLiar(Fakebook fakebook) {
		try {
			LiarUserClass liar = fakebook.getTopLiar();
			
			System.out.printf("%s %d.\n", liar.getId(), liar.getNumLies());
		}
		catch (NoTopLiarException e) {
			System.out.println(e.getMessage());
		}
	}

}

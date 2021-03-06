import exceptions.*;
import fakebook.*;
import enums.*;
import fanaticisms.Fanaticism;
import fanaticisms.FanaticismClass;
import posts.*;
import users.*;
import comments.*;
import java.util.*;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * This program simulates a simple social network in which users are separated into various categories (naive,
 * liar, fanatic and selfcentered), with each their own unique atributes.
 * Users can make posts and comment on others' (or their own) posts, with either a positive or negative stance.
 */

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
	private static void registerUser(Scanner in, Fakebook fakebook) throws InvalidFanaticismListException {
		String userKind = in.next();
		String userId = in.next() + in.nextLine();
		
		try {
			if (fakebook.userKindIsFanatic(userKind)) {
				fakebook.registerFanatic(userId, readFanaticisms(in));
			}
			else {
				fakebook.registerUser(userKind, userId);
			}
			
			System.out.printf(Output.USER_REGISTERED.getMessage(), userId);
		}
		catch (InvalidUserKindException e) {
			System.out.println(e.getMessage());
		}
		catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidFanaticismListException e) {
			System.out.println(e.getMessage());
			in.nextLine();
		}
	}

	/**
	 * Reads a list of fanaticisms.
	 * @param in Input scanner.
	 * @return List of fanaticisms.
	 */
	private static List<Fanaticism> readFanaticisms(Scanner in) {
		int numFanaticisms = in.nextInt();
		Set<String> fanaticismsChecker = new HashSet<>();
		List<Fanaticism> fanaticisms = new ArrayList<>();
		
		for (int i = 0; i < numFanaticisms; i++) {
			String stance = in.next();
			String hashtag = in.next();
			
			if (!fanaticismsChecker.contains(hashtag)) {
				fanaticismsChecker.add(hashtag);
				fanaticisms.add(new FanaticismClass(hashtag, stance));
			}
			else {
				throw new InvalidFanaticismListException();
			}
		}
		in.nextLine();
		
		return fanaticisms;
	}
	
	/**
	 * Lists all registered users.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listUsers(Scanner in, Fakebook fakebook) {
		in.nextLine();
		
		try {
			Iterator<User> users = fakebook.newUsersIterator();
			
			while (users.hasNext()) {
				User user = users.next();
				System.out.printf(Output.LIST_USER.getMessage(), user.getId(), user.getKind(), user.getNumFriends(),
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
		String userId1 = in.next() + in.nextLine();
		String userId2 = in.nextLine();
		
		try {
			fakebook.addFriend(userId1, userId2);
			System.out.printf(Output.FRIEND_ADDED.getMessage(), userId1, userId2);
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
		String userId = in.next() + in.nextLine();
		
		try {
			Iterator<User> friends = fakebook.newUserFriendsIterator(userId);
			
			while (friends.hasNext()) {
				User friend = friends.next();
				
				System.out.print(friend.getId());
				
				if (friends.hasNext()) {
					System.out.print(", ");
				}
			}
			System.out.println(".");
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
	private static void post(Scanner in, Fakebook fakebook) throws InvalidHashtagListException {
		String userId = in.next() + in.nextLine();
		int numHashtags = in.nextInt();
		
		try {
			Set<String> postHashtags = readPostHashtags(numHashtags, in);
			String postTruthfulness = in.next();
			String postMessage = in.next() + in.nextLine();
			
			fakebook.post(userId, postHashtags, postTruthfulness, postMessage);
			System.out.printf(Output.POST_SENT.getMessage(), userId, postTruthfulness,
				fakebook.getUser(userId).getNumFriends(), fakebook.getUser(userId).getNumPosts());
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidHashtagListException e) {
			System.out.println(e.getMessage());
			in.nextLine();
			in.nextLine();
		}
		catch (InvalidStanceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Reads a list of post hashtags.
	 * @param numHashtags Number of hashtags to read.
	 * @param in Input scanner.
	 * @return Set of valid hashtags.
	 */
	private static Set<String> readPostHashtags(int numHashtags, Scanner in) {
		if (numHashtags < 0) {
			throw new InvalidHashtagListException();
		}
		
		Set<String> postHashtags = new HashSet<>();
		
		for (int i = 0; i < numHashtags; i++) {
			String hashtag = in.next();
			
			if (!postHashtags.contains(hashtag)) {
				postHashtags.add(hashtag);
			}
			else {
				throw new InvalidHashtagListException();
			}
		}
		in.nextLine();
		
		return postHashtags;
	}
	
	/**
	 * Lists a users' posts.
	 * @param in Input scanner.
	 * @param fakebook Fakebook manager.
	 */
	private static void listUserPosts(Scanner in, Fakebook fakebook) {
		String userId = in.next() + in.nextLine();
		
		try {
			Iterator<Post> posts = fakebook.newUserPostsIterator(userId);
			System.out.printf(Output.USER_POSTS.getMessage(), userId);
			
			while (posts.hasNext()) {
				Post post = posts.next();
				
				System.out.printf(Output.LIST_POST.getMessage(), post.getId(),
					post.getTruthfulness().toString().toLowerCase(), post.getMessage(), post.getNumComments());
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
		String userIdComment = in.next() + in.nextLine();
		String userIdPost = in.next() + in.nextLine();
		int postId = in.nextInt();
		String commentStance = in.next();
		String commentMessage = in.next() + in.nextLine();
		
		try {
			fakebook.commentPost(userIdComment, userIdPost, postId, commentStance, commentMessage);
			System.out.println(Output.COMMENT_ADDED.getMessage());
		}
		catch (UserDoesNotExistException e) {
			System.out.println(e.getMessage());
		}
		catch (UserDoesNotHavePostException e) {
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
		String userId = in.next() + in.nextLine();
		int postId = in.nextInt();
		in.nextLine();
		
		try {
			Post post = fakebook.getUserPost(userId, postId);
			System.out.printf(Output.READ_POST.getMessage(), post.getAuthorId(), post.getTruthfulness().toString().toLowerCase(), post.getMessage());
			
			Iterator<Comment> comments = post.newCommentsIterator();
			
			while (comments.hasNext()) {
				Comment comment = comments.next();
				System.out.printf(Output.READ_POST.getMessage(), comment.getAuthorId(), comment.getStance().toString().toLowerCase(), comment.getMessage());
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
		String userId = in.next() + in.nextLine();
		String hashtag = in.nextLine();
		
		try {
			Iterator<Comment> comments = fakebook.newUserCommentsIterator(userId, hashtag);

			while (comments.hasNext()) {
				Comment comment = comments.next();
				System.out.printf(Output.LIST_COMMENT.getMessage(), comment.getPostAuthorId(), comment.getPostTruthfulness(),
					comment.getPostId(), comment.getStance().toString().toLowerCase(), comment.getMessage());
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
		String hashtag = in.next();
		in.nextLine();
		
		try {
			Iterator<FanaticUser> fanatics = fakebook.newTopicFanaticsIterator(hashtag);

			while (fanatics.hasNext()) {
				User fanatic = fanatics.next();
				System.out.print(fanatic.getId());
				
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
		String hashtag = in.next();
		int amount = in.nextInt();
		in.nextLine();
		
		try {
			Iterator<Post> posts = fakebook.newTopicPostsIterator(hashtag, amount);
			
			while (posts.hasNext()) {
				Post post = posts.next();
				System.out.printf(Output.LIST_TOPIC_POST.getMessage(), post.getAuthorId(), post.getId(), post.getNumComments(), post.getMessage());
			}
		}
		catch (InvalidNumberOfPostsException e) {
			System.out.println(e.getMessage());
		}
		catch (InvalidHashtagException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Prints out information about the most commented post.
	 * @param fakebook Fakebook manager.
	 */
	private static void topPost(Fakebook fakebook) {
		try {
			Post post = fakebook.getTopPost();
			System.out.printf(Output.TOP_POST.getMessage(), post.getAuthorId(), post.getId(), post.getNumComments(), post.getMessage());
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
			System.out.printf(Output.TOP_POSTER.getMessage(), topPoster.getId(), topPoster.getNumPosts(), topPoster.getNumComments());
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
			System.out.printf(Output.TOP_RESPONSIVE.getMessage(), responsive.getId(), responsive.getNumComments(), responsive.getNumAvailablePosts());
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
			User liar = fakebook.getTopLiar();
			System.out.printf(Output.TOP_LIAR.getMessage(), liar.getId(), liar.getNumLies());
		}
		catch (NoTopLiarException e) {
			System.out.println(e.getMessage());
		}
	}
}

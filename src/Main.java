
import exceptions.*;
import fakebook.*;
import enums.Command;
import enums.Output;
import users.User;

import java.util.*;

public class Main {
	
	/**
	 * Reads and executes input commands repeatedly until the EXIT command is introduced.
	 * @param args Arguments used for the execution of the program (not used).
	 */
	public static void main(String[] args) {
		Fakebook fakebook = new FakebookClass();
		Scanner in = new Scanner(System.in);
		Command command = null;
		
		while (command != Command.EXIT) {
			command = readCommand(in);
			executeCommand(command, in, fakebook);
		}
		
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
			default:
				unknownCommand();
				break;
		}
	}
	
	/**
	 * Prints out the unknown command message.
	 */
	private static void unknownCommand() {
		System.out.println(Output.UNKNOWN_COMMAND.getMessage());
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
		try {
			String userKind = in.next();
			String userId = in.nextLine();
			
			if (fakebook.userKindIsFanatic(userKind)) {
				int numFanaticisms = in.nextInt();
				
				for (int i = 0; i < numFanaticisms; i++) {
					/**
					 * (Code to be added here)
					 * (Awaiting master Goulao's orders)
					 */
				}
				
				in.nextLine();
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
				System.out.printf("%s [%s] %d %d %d\n", user.getName(), user.getKind(), user.getNumFriends(),
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
			String userId1 = in.nextLine();
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
			String userId = in.nextLine();
			
			Iterator<User> friends = fakebook.newUserFriendsIterator(userId);
			
			while (friends.hasNext()) {
				User friend = friends.next();
				
				System.out.print(friend.getName());
				
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
	
}

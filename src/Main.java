
import exceptions.InvalidUserKindException;
import exceptions.UserAlreadyExistsException;
import fakebook.Fakebook;
import fakebook.FakebookClass;
import enums.Command;
import enums.Output;

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
				register(in, fakebook);
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
	private static void register(Scanner in, Fakebook fakebook) {
		try {
			String userKind = in.next();
			String userId = in.nextLine();
			
			if (fakebook.userKindIsFanatic(userKind)) {
				int numFanaticisms = in.nextInt();
				
				for (int i = 0; i < numFanaticisms; i++) {
					
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
	}
	
}

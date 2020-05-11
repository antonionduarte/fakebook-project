
import fakebook.Fakebook;
import fakebook.FakebookClass;
import enums.Command;
import enums.Output;

import java.util.Scanner;

public class Main {
	
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
	
	private static Command readCommand(Scanner in) {
		try {
			return Command.valueOf(in.nextLine().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}
	
	private static void executeCommand(Command command, Scanner in, Fakebook fakebook) {
		switch (command) {
			case EXIT:
				exit();
				break;
			case HELP:
				help();
				break;
			default:
				unknownCommand();
				break;
		}
	}
	
	private static void unknownCommand() {
		System.out.println(Output.UNKNOWN_COMMAND);
	}
	
	private static void exit() {
		System.out.println(Output.EXIT);
	}
	
	private static void help() {
		for (Command command: Command.values()) {
			System.out.println(command.toString().toLowerCase() + " - " + command.getDescription());
		}
	}
	
}

package ss.week3.hotel;

import ss.utils.TextIO;
import ss.week3.bill.SysoutPrinter;

/**
 * A simple interactive Hotel TUI
 *
 * @author Tom van Dijk
 */
public class HotelTUI {
	// User commands (constants)
	static final String IN = "i";
	static final String OUT = "o";
	static final String ROOM = "r";
	static final String PRINT = "p";
	static final String NIGHTS = "b";
	static final String SAFE = "a";
	static final String HELP = "h";
	static final String EXIT = "x"; // a command for activate save room ophalen activeren
	private Hotel hotel;

	public HotelTUI(String hotelName) {
		hotel = new Hotel(hotelName);
	}

	public static void main(String[] args) {
		new HotelTUI("U_Parkhotel").start();
	}


	public void start() {
		printHelpMenu();
		// Now until we are done, ask for user input
		boolean exit = false;
		while (!exit) {
			// First get a line of text from the user
			String input = TextIO.getlnString();

			// We want to extract the command (first word) so we split on (repeated) whitespace
			// the "\\s" means whitespace, the "+" means 1-or-more whitespace
			String[] splittedCommand = input.split("\\s+");

			// By the way, we know that input != null so split will go fine, and split always
			// returns an array of length at least 1, so we can access split[0] without checking bounds

			String command = splittedCommand[0];
			String guestName = null;
			String passWord = null;
			String nights = null;

			if (splittedCommand.length == 2) {
				guestName = splittedCommand[1];
			}

			if (splittedCommand.length == 3) {
				guestName = splittedCommand[1];
				if (command.contains("a")) {
					passWord = splittedCommand[2];
				}
				else if (command.contains("b")) {
					nights = splittedCommand[2];
				}
				else {
					System.out.println("Wrong parameters");
				}
			}

			// To make our code not to complicated, we do all the actual commands
			// in separate methods, so it is easier to read here

			switch(command) {
				case IN:
					if (splittedCommand.length != 2) {
						System.out.println("Wrong parameters at check in");
					} else {
						hotel.checkIn(guestName);
					}
					break;
				case OUT:
					if (splittedCommand.length != 2) {
						System.out.println("Wrong parameter at check out");
					} else {
						hotel.checkOut(guestName);
					}
					break;
				case ROOM:
					if (splittedCommand.length != 2) {
						System.out.println("Wrong parameter at get room");
					} else {
						hotel.getRoom(guestName);
					}
					break;
				case SAFE:
					if (splittedCommand.length == 1 || splittedCommand.length > 3) {
						System.out.println("Wrong parameter for safe activation");
					} else if (splittedCommand.length == 2) {
						hotel.getRoom(guestName).getSafe().activate();
						} else {
						if (hotel.getRoom(guestName) instanceof PricedRoom) {
							((PricedSafe) hotel.getRoom(guestName).getSafe()).activate(passWord);
						}
						else {
							System.out.println("error");
						}
					}
					break;
				case NIGHTS:
					if (splittedCommand.length != 3) {
						System.out.println("Wrong parameter for safe activation");
					} else {
						hotel.getBill(guestName,Integer.parseInt(nights),new SysoutPrinter());
					}
					break;
				case PRINT:
					System.out.println(hotel.toString());
					break;
				case HELP:
					// Just print the help menu...
					printHelpMenu();
					break;
				case EXIT:
					// Set exit to true so we can leave the while loop
					// If we just "return" here, we don't get the nice goodbye message!
					exit = true;
					break;
				default:
					System.out.println("Unknown command: " + command);
					printHelpMenu();
			}
		}

		System.out.println("Goodbye! We hope to see you again at " + hotel.name);
	}

	public void printHelpMenu() {
		// Let's prepare a little help Menu
		final String helpMenu =
				String.format("Commands:%n") +
						String.format("- %s name ........... check in guest with name%n", IN) +
						String.format("- %s name ........... check out guest with name%n", OUT) +
						String.format("- %s name ........... request room of guest%n", ROOM) +
						String.format("- %s ................ help (this menu)%n", HELP) +
						String.format("- %s name password .. activate safe, password required for PricedSafe%n",SAFE) +
						String.format("- %s name nights .... print bill for guest (name) and number of nights%n",NIGHTS) +
						String.format("- %s ................ print state%n", PRINT) +
						String.format("- %s ................ exit%n", EXIT);

		// Let's start with a friendly welcoming message and show the help menu
		System.out.println("Welcome to the Hotel booking system of " + hotel.name);
		System.out.println(helpMenu);
	}
}
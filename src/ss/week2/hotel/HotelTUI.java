package ss.week2.hotel;

import ss.utils.TextIO;

public class HotelTUI {

	private Hotel hotel;
	static String hotelName;

	//constructor
	public HotelTUI(String name) {
		hotelName = name;
		hotel = new Hotel(name);
	}

	private void printHelpMenu() {

		System.out.println("Welcome to the Hotel booking system of the " + hotelName);
		System.out.println("Commands:");
		System.out.println("i name ............... check in guest with name");
		System.out.println("o name ............... check out guest with name");
		System.out.println("r name ............... request room of guest");
		System.out.println("h .................... help (this menu)");
		System.out.println("p .................... print state ");
		System.out.println("x .................... exit");
	}

	public void start() {
		String value;
		String param;
		int exit = 0;
		String input;

		printHelpMenu();

		while (exit == 0) {

			input = TextIO.getlnString();
			String[] split = input.split("\\W+");
			value = split[0];
			param = null;

			if (split.length > 1) {
				param = split[1];
			}

			switch (value) {
				case "i":
					if (param == null) {
						System.out.println("ERROR");
					}
					hotel.checkIn(param);
					break;

				case "o":
					if (param == null) {
						System.out.println("ERROR");
					}
					hotel.checkOut(param);
					break;

				case "r":
					if (param == null) {
						System.out.println("ERROR");
					}
					System.out.println(hotel.getRoom(param));
					break;
				case "h":
					printHelpMenu();
					break;

				case "p":
					System.out.println(hotelName);
					break;

				case "x":
					System.out.println("Goodbye! We hope to see you again at " + hotelName);
					exit = 1;
					break;

			}

		}

	}

	public static void main(String[] args) {
		(new HotelTUI("U Parkhotel")).start();
	}
}
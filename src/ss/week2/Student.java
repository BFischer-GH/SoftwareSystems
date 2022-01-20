package ss.week2;

import ss.utils.TextIO;

/**
 * Student class, which will contain a method <b>passed</b> 
 * which will return whether a student has passed or not. 
 * @author Wim Kamerman
 *
 * 1. Added First added public static void main (Strink[] arg) {}
 *
 */
public class Student {

	private static final int CRITERION = 70;
	public static int score;
	public static void main(String[] arg) {

		System.out.println("What is the score of the student?.");
		score = TextIO.getlnInt();
	passed();

	}
	public static void passed() {
		boolean result = score > CRITERION;
		System.out.println("Passed: "+result);

	}

}

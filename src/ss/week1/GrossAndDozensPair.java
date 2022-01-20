package ss.week1;
import ss.utils.TextIO; //the location folder of TextIO.

/*
WARNING: Change the location of TextIO if needed.
*/


public class GrossAndDozensPair {

    public static void main(String[] args){

        int userInput; //The number of eggs.

        System.out.println("How many eggs do you have?");

        userInput = TextIO.getlnInt(); //Use this to get # of eggs

        int leftOver = userInput % 12;

        int gross = userInput/144;

        int dozen = (userInput%144)/12; // If you don't calculate the modulus this way you'll calculate the amount of dozen in total!

        System.out.println("Your number of eggs is " + gross + " gross, " +
                dozen + " dozen, and " + leftOver + " remaining.");
    }
}

package ss.week1.EXTRA;

import ss.utils.TextIO;

public class DollarCounter {
    public static void main(String[] args) {
        int quarters; // 25ct
        int dimes; // 10ct
        int nickels; // 5ct
        int pennies; // 1ct
        double dollars;

        System.out.println("How many QUARTERS do you have?");
        quarters = TextIO.getlnInt();

        System.out.println("How many DIMES do you have?");
        dimes = TextIO.getlnInt();

        System.out.println("How many NICKLES do you have?");
        nickels = TextIO.getlnInt();

        System.out.println("How many PENNIES do you have?");
        pennies = TextIO.getlnInt();

        dollars = (0.25*quarters)+(0.10*dimes)+(0.05*nickels)+(0.01*pennies);
        System.out.print("You have a total of $");
        System.out.printf("%1.2f", dollars); // Format output
    }
}

package ss.week2.EXTRA;

import java.util.Scanner;

public class SimpleCalc {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StatCalc calc; //Computes stats for numbers enterend by users.
        calc = new StatCalc();
        double item;


        System.out.println("Enter the numbers to be processed, te end enter a ZERO!");
        System.out.println();

        do {
            System.out.print("? ");
            item = input.nextDouble();
            if (item != 0)
                calc.enter(item);
        } while (item != 0);

        System.out.println("\nStatistics about your data:");
        System.out.println("Count:            "+calc.getCount());
        System.out.println("Sum:              "+calc.getSum());
        System.out.println("Minimum:          "+calc.getMin());
        System.out.println("Maximum:          "+calc.getMax());
        System.out.println("Average:          "+calc.getMean());
        System.out.println("Standard Dev.:    "+calc.getStandardDeviation());

    }
}

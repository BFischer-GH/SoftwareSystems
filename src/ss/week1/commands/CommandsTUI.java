package ss.week1.commands;

import ss.utils.TextIO;
import ss.week1.FibonacciPair;
import ss.week1.BabylonianAlgorithm;

import java.util.Arrays;

public class CommandsTUI {

    public static int findMaximum(String[] values) {
        Integer maxInt = null;
        for (String value : values) {
            int val = Integer.parseInt(value);
            if (maxInt == null || val > maxInt) {
                maxInt = val;
            }
        }
        return maxInt;
    }

    public static void main(String[] args) {
        System.out.println("Greetings Human!\nThrough this application you have access to the following commands:");
        System.out.println("Fibonacci number: `FIB <int>`");
        System.out.println("Babylonian Algorithm: `BABY <double>`");
        System.out.println("Maximum number: `MAX <list of ints>`");
        System.out.println("Context menu: `HELP`\nExit program: `EXIT`");

        String input = "";
        while (!input.equals("EXIT")) {
            System.out.println("Enter a command, for help enter `HELP`:");
            input = TextIO.getlnString();
            String[] inputSplit = input.split(" ");
            String command = inputSplit[0];
            String parm = null;
            if (inputSplit.length > 1) {
                parm = inputSplit[1];
            }
            switch (command) {
                case "FIB":
                    if (parm == null) {
                        System.err.println("Please give the command " + command + " an argument");
                    } else {
                        long result = FibonacciPair.fibonacciWithArray(Integer.parseInt(parm));
                        System.out.println(result);
                    }
                    break;
                case "BABY":
                    if (parm == null) {
                        System.err.println("Please give the command " + command + " an argument");
                    } else {
                        double result = BabylonianAlgorithm.babylonianAlgorithm(Double.parseDouble(parm));
                        System.out.println(result);
                    }
                    break;
                case "MAX":
                    if (parm == null) {
                        System.err.println("Please give the command " + command + " an argument");
                    } else {
                        int result = findMaximum(Arrays.copyOfRange(inputSplit, 1, inputSplit.length));
                        System.out.println(result);
                    }
                    break;
                case "HELP":
                    System.out.println("The menu is:");
                    System.out.println("1. FIB integer:");
                    System.out.println("2. BABY double");
                    System.out.println("3. MAX integer");
                    System.out.println("4. HELP");
                    System.out.println("5. EXIT");
                    break;
                default:
                    break;
            }
        }
    }
}
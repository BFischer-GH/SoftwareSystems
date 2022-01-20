package ss.week1;
import ss.utils.TextIO; //the location folder of TextIO.

public class FibonacciPair {

    public static long fibonacciRecursive(int index){

        long number; //the requested Fibonacci number (fibonacciRecursive(index))

        long number0 = 0; //Fibonacci value 0.
        long number1 = 1; // Fibonacci value 1.

        if (index == 0){
            return number0;
        }
        if (index == 1){
            return number1;
        }
        number = fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2); // As index is the provided parameter you get the index:index here
        return number;
    }

    public static long fibonacciWithArray(int index){

        long number0 = 0;
        long number1 = 1;
        int counter;
        long[] fibonacciNumbers = new long[index +1];
        long number = 0;

        fibonacciNumbers[0] = 0;
        if (fibonacciNumbers.length > 1) {
            fibonacciNumbers[1] = 1;
        }
        if (index == 0){
            return number0;
        }
        if (index == 1){
            return number1;
        }

        for (counter = 2 ; counter <= index ; counter++){

            number = number0 + number1;
            fibonacciNumbers[counter] = number;
            number0 = number1;
            number1 = number;
        }
       return fibonacciNumbers[index];
    }

    public static void main(String[] args){
        int index;

        while(true) {
            System.out.println("What index do you want to use?");
            index = TextIO.getlnInt();
            if (index > 0)
                break;
            System.out.println("Please enter a positive interger!");
        }

        System.out.println(fibonacciWithArray (index));
        System.out.println(fibonacciRecursive (index));
    }
}

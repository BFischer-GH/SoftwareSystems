package ss.week1.EXTRA;

import ss.utils.TextIO;

public class SimpleCalc {

    public static void main(String[] args) {

    double firstValue, secondValue, output;
    char operator;

    System.out.println("This is a simple calculator, to add, substract, multiply and divide 2 values");
    System.out.println("To end give 0 as the first value.");

    while(true) {
        firstValue = TextIO.getDouble();
        if (firstValue==0) {
            System.out.println("First value is Zero, exiting calculator");
            break;
        }
        System.out.println("First value is "+firstValue);
        operator = TextIO.getChar();
        secondValue = TextIO.getDouble();

        switch (operator) {
            case '+':
                output = firstValue + secondValue;
                break;
            case '-':
                output = firstValue - secondValue;
                break;
            case '*':
                output = firstValue * secondValue;
                break;
            case '/':
                output = firstValue / secondValue;
                break;
            default:
                System.out.println("Incorrect operator, " + operator + " is not accepted!");
                continue;
        }// end of the switch
        // Display result
        System.out.println("Result is " + output);
        }
    }
}

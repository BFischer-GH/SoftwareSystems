package ss.week1;
import ss.utils.TextIO; //the location folder of TextIO.

public class BabylonianAlgorithm {
    public static double babylonianAlgorithm(double nValue){
        //System.out.println("Give me a f*%#ning number and I'll give you the square root!");
        //nValue = TextIO.getDouble(); // Get the initial  nValue from user
        double intialGues = nValue/2 ; // Calculate initial Guess  STEP 1
        double rValue = nValue/intialGues; // RValue is STEP 2
        double guess = (intialGues + rValue) /2; // Guess = (Guess + rVal) /2 STEP 3

        while(guess/intialGues < 0.99 || 1.01 < guess/intialGues){
            rValue = nValue/guess;
            intialGues = guess;
            guess = (intialGues + rValue) /2;

        }
        return (guess);

    }

    public static void main (String[] args){
        System.out.println("Give me a f*%#ning number and I'll give you the square root!");
        double nValue = TextIO.getDouble(); // Get the initial  nValue from user
            System.out.println(babylonianAlgorithm(nValue));

    }

}

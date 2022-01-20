package ss.week4.EXTRA;

import ss.utils.TextIO;

public class ECK7_3 {
    /* This is actually assignment 7.5!
    Create a sorting where all numbers are stored in an Array and sorted by your own method.
    The user will input a zero to mark the end of the input. Assume that at most 100 positive numbers will be entered.
    Do not use any built-in function such as Arrays.sort(). Do the sorting yourself.
     */
    public static void main(String[] args) {
        double[] numbers; //The array in which all input values are stored
        int numCT; // The amount of values inside array numbers
        double num; // One of the numbers input

        numbers = new double[100]; // Max of 100 numbers can be stored
        numCT = 0; // In the beginning no numbers are stored

        System.out.println("Enter the  numbers you want to sort. Enter 0 the end input");

        while(true) {
        System.out.print("? ");
        num = TextIO.getlnDouble();
        if (num <= 0)
            break;
        numbers[numCT] = num;
        numCT++;
        }

        selectSort(numbers,numCT);

        System.out.println("\nYour numbers in sorted order are:\n");

        for (int i = 0; i < numCT; i++) {
            System.out.println(numbers[i]);

        }
    } // end main

    // Create the selectsort method

    static void selectSort(double[] A, int count){
        for (int lastPlace = count -1; lastPlace >0; lastPlace--){
            int maxLoc = 0;
            for (int i = 0; i <= lastPlace; i++) {
                if (A[i]> A[maxLoc])
                    maxLoc=i;

            }
            double temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }
}

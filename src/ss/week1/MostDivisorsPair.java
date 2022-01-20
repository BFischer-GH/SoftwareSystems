package ss.week1;

public class MostDivisorsPair {

    public static void main(String[] args){


        int testDivisor; // A number between 1 and N that is a
// possible divisor of N.
        int divisorCount; // Number of divisors of N that have been found.

// reaches 10000000, a period is output and
// the value of numberTested is reset to zero.
        int counter; //a counter for the numbers between 0 and 10000.
        int maxDivs = 1; //the largest number of divs.
        int maxNumber = 1; //the number that has the largest number of divs.

        /* Count the divisors, printing a "." after every 10000000 tests. */


        for (counter = 0; counter <= 10001; counter++) {
            divisorCount = 0;

            for (testDivisor = 1; testDivisor <= counter; testDivisor++) {
                if (counter % testDivisor == 0) {
                    divisorCount++;

                    if (maxDivs < divisorCount) {
                        maxDivs = divisorCount;
                        maxNumber = counter;
                    }

                }
            }
        }
        /* Display the result. */

        System.out.println("The number " + maxNumber +
                " has the most divisors which are " + maxDivs);

    }
}

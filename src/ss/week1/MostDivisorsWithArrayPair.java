package ss.week1;

public class MostDivisorsWithArrayPair {

    public static void main(String[] args) {

        int testDivisor; // A number between 1 and N that is a
// possible divisor of N.
        int divisorCount; // Number of divisors of N that have been found.

// reaches 10000000, a period is output and
// the value of numberTested is reset to zero.
        int counter; //a counter for the numbers between 0 and 10000.
        int maxDivs = 1; //the largest number of divs.
        //int maxNumber = 1; //the number that has the largest number of divs.
        int[] maxArray = new int[10001]; //we create an array of integers with a length of 10001

        int counter1; //another counter.


        for (counter = 0; counter <= 10000; counter++) {
            divisorCount = 0;

            for (testDivisor = 1; testDivisor <= counter; testDivisor++) {
                if (counter % testDivisor == 0) {
                    divisorCount++;

                    if (maxDivs < divisorCount) {
                        maxDivs = divisorCount;
                        //maxNumber = counter;
                        }

                    }
             }

            maxArray[counter] = divisorCount;
            }



        System.out.println("Among integers between 1 and 10000,");
        System.out.println("The maximum number of divisors was " + maxDivs);
        System.out.println("Numbers with that many divisors include:");


        for (counter1 = 0; counter1 <= 10000; counter1++){
            if (maxArray[counter1] == maxDivs){
                System.out.println(counter1);
            }

        }

        }


    }


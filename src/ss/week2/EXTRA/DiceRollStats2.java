package ss.week2.EXTRA;

public class DiceRollStats2 {

 static final int NUMBER = 10000;

 //Constructor for the dice to be used
    private static PairOfDice dice = new PairOfDice();

  // Roll the dice

    static int rollFor (int N){
        int rollCT = 0; // Numbers of times dice rolled
        do {
            dice.roll();
            rollCT++;
        } while (dice.getTotal() != N);
            return rollCT;
    }// End of rollFor

    public static void main(String[] args) {
        System.out.println("Dice Total  Avg # of Rolls  Stand.Dev.  Max# of Rolls");
        System.out.println("----------  --------------  ----------  -------------");

        for (int sumDice = 2; sumDice <=12; sumDice++){
            StatCalc stats;
            stats = new StatCalc();

            for (int i = 0; i < NUMBER; i++) {
                stats.enter(rollFor(sumDice));

            }
            System.out.printf("%6d", sumDice);
            System.out.printf("%15.2f", stats.getMean());
            System.out.printf("%15.2f", stats.getStandardDeviation());
            System.out.printf("%12.0f", stats.getMax());
            System.out.println(); // Needed to get new sumDice line

        }

    } // End of Main
} // End of Class




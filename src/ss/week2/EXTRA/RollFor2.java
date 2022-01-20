package ss.week2.EXTRA;

public class RollFor2 {

    public static void main(String[] args) {
        PairOfDice dice; // A variable that will refer to the dice
        int rollCount = 0; // Number of times the dice have been rolled, set at 0

        dice = new PairOfDice(); // Create a dice object from PairOfDice

        while (dice.getTotal() != 2){
            dice.roll();
            System.out.println("The dice come up "+ dice);
            rollCount++;

        }

        System.out.println("\nIt took "+ rollCount +" roll to get SnakeEyes.");
    }
}

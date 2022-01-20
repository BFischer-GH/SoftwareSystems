package ss.week2.EXTRA;

public class PairOfDice {

    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.

    /**
     * Constructor creates a pair of dice and rolls them so that
     * they initially show some random value.
     */
    public PairOfDice() {

        roll();  // Call the roll() method to roll the dice.
    }

    /**
     * Roll the dice by setting each die to be a random number between 1 and 6.
     */
    public void roll() {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;

    }
    // Return Die 1
    public int getDie1(){
        return die1;
    }
// Set the value of first die, if value is not between 1-6 it throws an IllegalArgumentException
    public void setDie1 (int value) {
       if (value <1 || value > 6)
            throw new IllegalArgumentException("Illegal dice value " + value);
    die1 = value;
    }
// Return Die 2
    public int getDie2(){
        return die2;
    }
    public void setDie2 (int value) {
        if (value <1 || value > 6)
            throw new IllegalArgumentException("Illegal dice value " + value);
        die2 = value;
    }

    public int getTotal(){
        return die1 + die2;
    }

// Create String representation, with double value giving a different result
    public String toString() {
        if (die1 == die2)
            return "double " + die1;
        else
            return die1 + " and " + die2;
    }

}


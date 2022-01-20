package ss.week1;

public class RollTheDicePair {

    public static void main(String[] args){

        int die1 = (int)(Math.random ()*6) + 1;
        int die2 = (int)(Math.random ()*6) + 1;
        int totalDie = die1 + die2;

        System.out.println("The first die comes up " + die1);
        System.out.println("The second die comes up " + die2);
        System.out.println("Your final result is " + totalDie);

    }

}

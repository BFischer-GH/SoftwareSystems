package ss.week2.EXTRA;

public class Exercise5_3 {
    public static void main(String[] args) {
        StatCalc statCalc = new StatCalc();
        PairOfDice dices = new PairOfDice();

        while(!(dices.getDie1() == dices.getDie2() && dices.getDie1() == 2)) {
            dices.roll();
            statCalc.enter(dices.getDie1());
            statCalc.enter(dices.getDie2());
        }


        System.out.format("count: %s, max: %s, min: %s, mean: %s, sum: %s, SD: %s %n",statCalc.getCount()/2,statCalc.getMax(),statCalc.getMin(),statCalc.getMean(),statCalc.getSum(),statCalc.getStandardDeviation());
        System.out.println(dices.toString());

    }

}

package ss.week5.tictactoe;


import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;

public class NaiveStrategy implements Strategy{
    @Override
    public String getName() {
        return "Naive AI";
        }

    @Override
    public int determineMove(Board board, Mark mark) {
        // construct a new array list of empty integers
        ArrayList<Integer> naiveList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if(board.isEmptyField(i)){
                naiveList.add(i);
            }

        }
        // Select random integers for the naiveList array
        int randomValue = (int) (Math.random() * naiveList.size());
        return naiveList.get(randomValue);
    }

}

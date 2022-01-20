package ss.week5.tictactoe;


import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;

public class SmartStrategy implements Strategy {
    @Override
    public String getName() {
        return "Smart AI";
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        // Construct an array to scan through of all empty values

        ArrayList<Integer> smartList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board.isEmptyField(i)) {
                smartList.add(i);
            }
        }

    int winner = -1; // Set as -1 otherwise 0 is set
    int blocker = -1;

        for (int i = 0; i < smartList.size(); i++) { // create a copy of the board and see if there's an empty field that leads to a winner
            Board testBoard = board.deepCopy();
            testBoard.setField(smartList.get(i),mark);
            if(testBoard.isWinner(mark)) {
                winner = smartList.get(i);
                break;
            }
            mark = mark.other(); // switch the mark to see if opponent has a potential winning next step to block
            testBoard.setField(smartList.get(i),mark);
            if(testBoard.isWinner(mark)) {
                blocker = smartList.get(i);
                break;
            }
            mark = mark.other();
        }


    if(board.isEmptyField(4)) { // If the middle field is empty, this field is chosen
        return 4;
    } else if (winner >= 0) { //If there's a guaranteed direct win, selct this filed
        return  winner;
    } else if (blocker >= 0){ //If there's field to block the opponent to win, select this field
        return blocker;
    } else { //If above is not applicable select random => Naive startege
            int randomValue = (int) (Math.random() * smartList.size());
            return smartList.get(randomValue);
    }

    } // End of determineMove
}

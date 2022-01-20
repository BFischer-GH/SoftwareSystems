package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {
    /**
    @return name of the strategy
     */

    public String getName();

    /**
    *@param board current state of the board
    * @param mark mark of the player
    * @return next legal move given parameter

     */

    public int determineMove (Board board, Mark mark);


}

package ss.week5.tictactoe;

import ss.week4.tictactoe.*;

public class ComputerPlayer extends Player{
   public Mark mark;
   public Strategy strategy;

   // Create 2 constructors

   // Constructor 1 , a computer player using the given mark and strategy

    /**
     *
     * @param mark
     * @param strategy
     */

    public ComputerPlayer(Mark mark, Strategy strategy) {
      super(strategy.getName()+"-"+mark.toString(), mark);
      this.mark = mark;
      this.strategy = strategy;
    }
   // Constructor 2,
    public ComputerPlayer(Mark mark){
        super("NaiveStrategy-" + mark.toString(), mark);
        this.mark = mark;
        this.strategy = new NaiveStrategy();
    }
   // determineMove from strategy
   public int determineMove(Board board) {
       return strategy.determineMove(board, this.mark);
   }

   // Create getter
    public Strategy getStrategy() {
        return this.strategy;
    }

    // Create setter

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
        }
    }

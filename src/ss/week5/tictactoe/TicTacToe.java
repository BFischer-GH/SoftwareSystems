
package ss.week5.tictactoe;

import ss.week4.tictactoe.Game;
import ss.week4.tictactoe.HumanPlayer;
import ss.week4.tictactoe.Mark;
import ss.week4.tictactoe.Player;

import java.util.Scanner;

import static ss.week4.tictactoe.Mark.OO;
import static ss.week4.tictactoe.Mark.XX;



public class TicTacToe {

    public static void main(String[] args) {
        // create new game-object and call method start
        // enable user to provide command-line parameters for the names
        String[] input = inputNames(args);
        Player[] players = new Player[2];
        Mark[] marks = {XX,OO};

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("-N")) {
                players[i] = new ComputerPlayer(marks[i], new NaiveStrategy());

            }else if (input[i].equals("-C")) {
                players[i] = new ComputerPlayer(marks[i], new SmartStrategy());

            } else {
                players[i] = new HumanPlayer(input[i], marks[i]);

            }
        }
        Game game = new Game(players[0], players[1]);
        game.start();
    }

    public static String [] inputNames (String[] args){
        String[] names = new String[2];
        if (args.length ==2){
            return args;
        } else {
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Hi, who is player 1?");
            names[0] = scanner1.next();
            System.out.println("Who is player 2?");
            names[1] = scanner2.next();
            return names;
        }
    }

}
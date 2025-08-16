package TicTacToe;

import java.util.*;
public class Game {

    Board gameBoard;
    List<Player> gamePlayers;
    Player winner;
    GameStatus gameStatus;
    Player currentPlayer;
    public Game()
    {
        gameBoard = initializeBoard();
        gamePlayers = initPlayerAndSymbol();
        winner = null;
        gameStatus = GameStatus.RUNNING;
        currentPlayer = gamePlayers.get(0);

        System.out.println(gamePlayers.get(0).name + " and " + gamePlayers.get(1).name + " are the Players...");

        System.out.println("Game logistics initialized ");

    }

    public static Board initializeBoard()
    {
        Board thisGameBoard = new Board(3, 3);
        System.out.println("Board initialized ");

        return thisGameBoard;

    }

    public static List<Player> initPlayerAndSymbol()
    {

        Player player1 = new Player("Yukti", Symbol.X);
        Player player2 = new Player("Shreyas", Symbol.O);

        List<Player> gamePlayers = new ArrayList<>();

        gamePlayers.add(player1);
        gamePlayers.add(player2);


        return gamePlayers;

    }

}

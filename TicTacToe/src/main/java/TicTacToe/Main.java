package TicTacToe;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // System.out.println("Hello world!");

        startGame();

    }

    public static void startGame()
    {
        Game game = new Game();

        Game finalRes = game.playGame(game);
        System.out.println("Game Over...");

    }




}
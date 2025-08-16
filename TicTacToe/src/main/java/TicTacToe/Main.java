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

        Game finalRes = playGame(game);
        System.out.println("Game Over...");

    }



    public static Game playGame(Game game)
    {

        // select a cell to play this turn by this player
        // place the symbol there
        // check if anyone player won after this turn
        // if won, return player name who won
        // else if no one has won till now - 1. check if all cells are filled, if yes return draw, else
        // switch player and resume game

//        System.out.println("Current status of board");
//        for(int i=0;i<game.gameBoard.numRows;i++)
//        {
//            for(int j=0;j<game.gameBoard.numCols;j++)
//            {
//                System.out.print(game.gameBoard.cells[i][j].symbol + " ");
//            }
//            System.out.println();
//        }

        System.out.println(" Turn of Player "+game.currentPlayer.name);
        int playingRow, playingCol;

        do {
            playingRow = (int)(Math.random() * game.gameBoard.numRows);
            playingCol = (int)(Math.random() * game.gameBoard.numCols);

        }while(game.gameBoard.cells[playingRow][playingCol].checkEmpty());

        System.out.println(" cell being played now "+playingRow + " " + playingCol);


        Cell playingCell = game.gameBoard.cells[playingRow][playingCol]; // this playingCell is pointing to the same location as gameBoard cell
        Symbol playerSymbol = game.currentPlayer.symbol;

        playingCell.symbol = playerSymbol;

//        for(int i=0;i<game.gameBoard.numRows;i++)
//        {
//            for(int j=0;j<game.gameBoard.numCols;j++)
//            {
//                System.out.print(game.gameBoard.cells[i][j].symbol + " ");
//            }
//            System.out.println();
//        }

        Game thisGame = checkGameStatus(game, playingRow,  playingCol,playerSymbol);

        System.out.println("After this turn Game status is "+thisGame.gameStatus);

        if(thisGame.gameStatus == GameStatus.COMPLETE)
        {
            System.out.println("Winner is " + thisGame.winner.name);
        }

        else if(thisGame.gameStatus == GameStatus.DRAW)
        {
            System.out.println("Game Drawn " );
        }

        else
        {
            playGame(thisGame);
        }

        return thisGame;

    }

    public static Game checkGameStatus(Game game, int playingRow,int playingCol, Symbol playerSymbol)
    {
        boolean continuePlay = false;

        boolean vert = checkVertical(game.gameBoard,playingCol,playerSymbol);
        boolean horiz = checkHoriz(game.gameBoard,playingRow,playerSymbol);
        boolean leftDiag = checkLeftDiag(game.gameBoard,playerSymbol);
        boolean rightDiag = checkRightDiag(game.gameBoard,playerSymbol);

        System.out.println("vertical "+vert);
        System.out.println("horiz "+horiz);
        System.out.println("leftDiag "+leftDiag);
        System.out.println("rightDiag "+rightDiag);


        for(int i=0;i<game.gameBoard.numRows;i++)
        {
            for(int j=0;j<game.gameBoard.numCols;j++)
            {
                System.out.print(game.gameBoard.cells[i][j].symbol + " ");
            }
            System.out.println();
        }

        if(vert || horiz || leftDiag || rightDiag)
        {
            game.gameStatus = GameStatus.COMPLETE;
            game.winner = game.currentPlayer;

        }

        else
        {
            // first check if no one has won after this last play, is the game drawn now
            for(int i=0;i<game.gameBoard.numRows;i++)
            {
                for (int j = 0; j < game.gameBoard.numCols; j++)
                {
                    if (game.gameBoard.cells[i][j].symbol == null)
                    {
                        continuePlay = true;
                    }
                }
            }

            System.out.println(" should we continuePlay "+continuePlay);

            // if continuePlay == false till now -> means all cells are filled . so match draw
            if(!continuePlay)
             {
                 game.gameStatus = GameStatus.DRAW;
             }
            else // if not draw and still cell is empty then switch player and continue playing
            {
                game.currentPlayer = (game.currentPlayer == game.gamePlayers.get(0)) ? game.gamePlayers.get(1) : game.gamePlayers.get(0);
            }

        }
        return game;

    }

    public static boolean checkVertical(Board gameBoard, int playingCol, Symbol playerSymbol)
    {
        for(int row=0;row<gameBoard.numRows;row++)
        {
            if(gameBoard.cells[row][playingCol].symbol != playerSymbol)
                return false;
        }
        return true;
    }
    public static boolean checkHoriz(Board gameBoard, int playingRow, Symbol playerSymbol)
    {
        for(int col=0;col<gameBoard.numCols;col++)
        {
            if(gameBoard.cells[playingRow][col].symbol != playerSymbol)
                return false;
        }
        return true;
    }

    public static boolean checkLeftDiag(Board gameBoard, Symbol playerSymbol)
    {
        if (playerSymbol == null)
            return false;
        for (int i = 0; i < gameBoard.numRows; i++)
        {
            if (gameBoard.cells[i][i].symbol != playerSymbol)
                return false;
        }
        return true;
    }

    public static boolean checkRightDiag(Board gameBoard, Symbol playerSymbol)
    {
        if (playerSymbol == null)
            return false;
        int n = gameBoard.numCols;
        for (int i = 0; i < gameBoard.numRows; i++)
        {
            if (gameBoard.cells[i][n - 1 - i].symbol != playerSymbol)
                return false;
        }
        return true;
    }


}

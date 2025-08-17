package TicTacToe;

import java.util.*;
public class Game {

    Board gameBoard;
    List<Player> gamePlayers;
    Player winner;
    GameStatus gameStatus;
    Player currentPlayer;
    int lastRow, lastCol;

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

    public  Board initializeBoard()
    {
        Board thisGameBoard = new Board(3, 3);
        System.out.println("Board initialized ");

        return thisGameBoard;

    }

    public  List<Player> initPlayerAndSymbol()
    {

        Player player1 = new Player("Yukti", Symbol.X);
        Player player2 = new Player("Shreyas", Symbol.O);

        List<Player> gamePlayers = new ArrayList<>();

        gamePlayers.add(player1);
        gamePlayers.add(player2);


        return gamePlayers;

    }


    public  Game playGame(Game game)
    {
        System.out.println(" Turn of Player "+game.currentPlayer.name);

       // Cell playingCell = chooseCell();


        //Cell playingCell = game.gameBoard.cells[playingRow][playingCol]; // this playingCell is pointing to the same location as gameBoard cell
        //Symbol playerSymbol = game.currentPlayer.symbol;

       // playingCell.symbol = playerSymbol;

        Game updatedGame = makeMove(game);

        //Game thisGame = checkGameStatus(updatedGame, playingRow,  playingCol,playerSymbol);

        Game thisGame = checkGameStatus(updatedGame);

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

    public Game makeMove(Game game)
    {
        int playingRow, playingCol;

      //  Scanner sc = new Scanner(System.in);

//        do {
//            System.out.println("Select a row and col to make a move");
//
//            System.out.print("Enter row: ");
//            playingRow = sc.nextInt();
//
//            System.out.print("Enter col: ");
//            playingCol = sc.nextInt();
//
//        }while(game.gameBoard.cells[playingRow][playingCol].checkEmpty());

        Scanner sc = new Scanner(System.in);

        do {

//            playingRow = (int)(Math.random() * game.gameBoard.numRows);
//            playingCol = (int)(Math.random() * game.gameBoard.numCols);

            System.out.println("Select a row and col to make a move");

            System.out.print("Enter row: ");
            playingRow = sc.nextInt();

            System.out.print("Enter col: ");
            playingCol = sc.nextInt();


        }while(!game.gameBoard.cells[playingRow][playingCol].checkEmpty());

        Cell chosen = game.gameBoard.cells[playingRow][playingCol];

        System.out.println(" cell being played now "+playingRow + " " + playingCol);
        chosen.markCell(game.currentPlayer.symbol);

        game.lastRow = playingRow;
        game.lastCol = playingCol;

        return game;
    }
    public  Game checkGameStatus(Game game)
    {
        boolean continuePlay = false;

        int playingRow = game.lastRow;
        int playingCol = game.lastCol;

        Symbol playerSymbol = game.currentPlayer.symbol;

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

    public  boolean checkVertical(Board gameBoard, int playingCol, Symbol playerSymbol)
    {
        for(int row=0;row<gameBoard.numRows;row++)
        {
            if(gameBoard.cells[row][playingCol].symbol != playerSymbol)
                return false;
        }
        return true;
    }
    public  boolean checkHoriz(Board gameBoard, int playingRow, Symbol playerSymbol)
    {
        for(int col=0;col<gameBoard.numCols;col++)
        {
            if(gameBoard.cells[playingRow][col].symbol != playerSymbol)
                return false;
        }
        return true;
    }

    public  boolean checkLeftDiag(Board gameBoard, Symbol playerSymbol)
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

    public  boolean checkRightDiag(Board gameBoard, Symbol playerSymbol)
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
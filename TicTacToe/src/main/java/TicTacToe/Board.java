package TicTacToe;

public class Board {
    int numRows;
    int numCols;
    Cell[][] cells;

    public Board(int rows, int cols)
    {
        this.numRows = rows;
        this.numCols = cols;

        this.cells = new Cell[rows][cols];

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                cells[i][j] = new Cell();
            }
        }

        System.out.println("New board created with cell rows = " + this.numRows + " and cell cols = " + this.numCols);
    }


}

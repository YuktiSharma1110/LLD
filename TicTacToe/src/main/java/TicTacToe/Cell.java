package TicTacToe;

public class Cell {

    Symbol  symbol;

    public Cell()
    {
        this.symbol = null;
    }

    public boolean checkEmpty()
    {
        if(this.symbol == null)
            return true;

        return false;
    }

    public boolean markCell(Symbol symb) {
        if (!checkEmpty())
            return false;
        this.symbol = symb;

        return true;
    }



}

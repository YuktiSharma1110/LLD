package TicTacToe;

public class Cell {

    Symbol  symbol;

    public boolean checkEmpty()
    {
        if(this.symbol == null)
            return false;

        return true;
    }

//    public boolean markCell(Symbol symbol)
//    {
//        if(!checkEmpty())
//        {
//            System.out.println("Cannot put new symbol here. Cell is already filled with "+this.symbol);
//            return false;
//        }
//
//        this.symbol = symbol;
//        System.out.println("Cell is now filled with "+this.symbol);
//        return true;
//
//    }

    public Cell()
    {
        this.symbol = null;
        //markCell(player.symbol);
    }

}

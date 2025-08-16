package TicTacToe;

public class Player {

    String name;
    Symbol symbol;

    public Player(String name, Symbol symb) {
        this.name = name;
        this.symbol = symb;

        System.out.println("Player " + this.name  + " has chosen symbol " + this.symbol);
    }
}

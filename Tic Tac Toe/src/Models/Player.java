package Models;

import java.util.Scanner;

public class Player {
    private String Name;
    private Symbol symbol;
    private PlayerType playerType;
    private static final Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        Name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){

        System.out.println("Please enter the row number where you want to make a move ? ");
        int row = scanner.nextInt();
        System.out.println("Please enter the col number where you want to make a move ? ");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }
}

package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for (int i = 0; i < size; i++){
            board.add(new ArrayList<>());
            for (int j = 0; j < size; j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getCells() {
        return board;
    }

    public void setCells(List<List<Cell>> cells) {
        this.board = cells;
    }

    public void printBoard() {
        for (List<Cell> row : board){
            for (Cell cell : row){
                if (cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print("| -- |");
                }
                else{
                    System.out.print("| " + cell.getPlayer().getSymbol().getChar() + " |");
                }
            }
            System.out.println();
        }
    }
}

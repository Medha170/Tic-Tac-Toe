package Stratergies;

import Models.Board;
import Models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    HashMap<Character, Integer> leftDiag = new HashMap<>();
    HashMap<Character, Integer> rightDiag = new HashMap<>();

    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getChar();

        //row
        if (!rowMaps.containsKey(row)){
            rowMaps.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> currRowMaps = rowMaps.get(row);

        if (!currRowMaps.containsKey(character)){
            currRowMaps.put(character, 1);
        }
        else{
            currRowMaps.put(character, currRowMaps.get(character) + 1);
        }

        if (currRowMaps.get(character) == board.getSize()){
            return true;
        }

        //col
        if (!colMaps.containsKey(col)){
            colMaps.put(col, new HashMap<>());
        }

        HashMap<Character, Integer> currColMaps = colMaps.get(col);

        if (!currColMaps.containsKey(character)){
            currColMaps.put(character, 1);
        }
        else{
            currColMaps.put(character, currColMaps.get(character) + 1);
        }

        if (currColMaps.get(character) == board.getSize()){
            return true;
        }

        //left diagonal
        if (row == col){
            if (!leftDiag.containsKey(character)){
                leftDiag.put(character, 1);
            }
            else{
                leftDiag.put(character, leftDiag.get(character) + 1);
            }

            if (leftDiag.get(character) == board.getSize()) return true;
        }

        //right diagonal
        if ((row + col) == board.getSize() - 1){
            if (!rightDiag.containsKey(character)){
                rightDiag.put(character, 1);
            }
            else{
                rightDiag.put(character, rightDiag.get(character) + 1);
            }

            if (rightDiag.get(character) == board.getSize()) return true;
        }

        return false;
    }
}

package Controller;

import Exceptions.InvalidMoveException;
import Exceptions.TwoSymbolSameException;
import Models.Game;
import Models.GameState;
import Models.Player;
import Models.Symbol;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {
    public Game startGame(int dimension, List<Player> players) throws TwoSymbolSameException{
        Set<Symbol> symbols = new HashSet<>();
        for (Player player : players){
            symbols.add(player.getSymbol());
        }
        if (symbols.size() != players.size()) {
            throw new TwoSymbolSameException("Two or more players have the same symbol please choose a different symbol");
        }
        return new Game(dimension,players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){
        game.printBoard();
    }
}

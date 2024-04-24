import Controller.GameController;
import Exceptions.InvalidMoveException;
import Exceptions.TwoSymbolSameException;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws TwoSymbolSameException, InvalidMoveException {

        System.out.println("Hello world!");
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimensions = 3;
        List<Player> players = List.of(
                new Player("Medha", new Symbol('X'), PlayerType.HUMAN),
                new Bot("ABC", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        Game game = gameController.startGame(dimensions, players);
        gameController.printBoard(game);
        while (game.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.ENDED)){
            game.setGameState(GameState.DRAW);
            System.out.println("Game DRAW");
        }
        else {
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }
    }
}
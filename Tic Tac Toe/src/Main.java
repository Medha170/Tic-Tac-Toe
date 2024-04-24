import Controller.GameController;
import Exceptions.TwoSymbolSameException;
import Models.Game;
import Models.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TwoSymbolSameException {

        System.out.println("Hello world!");
        GameController gameController = new GameController();

        int dimensions = 3;
        List<Player> players = new ArrayList<>();
        Game game = gameController.startGame(dimensions, players);



    }
}
import controller.Controller;
import view.GameView;


/**
 * @author Viktoras Sfakianakis
 */
public class Main {
    public static Controller controller;
    public static GameView game;

    public static void main(String[] args) {
        controller = new Controller();
        game = new GameView(controller);
    }


}
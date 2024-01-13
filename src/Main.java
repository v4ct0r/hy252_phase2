import controller.Controller;
import view.GameView;

/**
 * @author Viktoras Sfakianakis
 */
public class Main {
    public static void main(String[] args) {
        GameView game = new GameView(new Controller());
    }
}
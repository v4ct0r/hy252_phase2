import controller.Controller;
import view.GameView;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        GameView game = new GameView(controller);
    }
}
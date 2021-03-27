import controller.Controller;
import models.Game;
import view.*;

import java.util.concurrent.TimeUnit;

public class SpaceInvaders {
    public static void main(String[] args) {
        Game game = new Game();
        boolean isOver = false;
        Controller controller = new Controller(game);

        Tui tui = new Tui(controller);
        Gui gui = new Gui(controller);
        controller.addObserver(tui);
        controller.addObserver(gui);


        controller.run(isOver);
    }
}
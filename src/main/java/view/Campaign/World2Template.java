package view.Campaign;

import control.MainProgram;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polyline;
import model.Maps.Sprite;
import model.World;
import model.time.TimeThread;
import view.AudioPlayer;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;

/**
 * @author Sebastian Helin & Filip Örnling
 */


public class World2Template extends World1Template {

    private final int squareSize;

    public World2Template(Sprite[][] level, int currentLevel, int heartCrystals, RightPanel rightPanel, World world) throws FileNotFoundException {
        super(level, currentLevel, heartCrystals, rightPanel, world, 35);
        squareSize = (int) MainProgram.HEIGHT / (level.length + 2);
        rightPanel.changeHeartCounter(heartCrystals);
        if (6 == currentLevel) {
            initialize();
        }
        new TimeThread(35, rightPanel);
        rightPanel.resetTimerLabel();
    }

    /**
     * Metoden initialize instansierar olika antal ImageView objekt beroende på vilken bana som spelas
     * Metoden initialize instansierar även olika antal rectanglar i olika former beroende på bana
     * Metoden kopplar sedan samman ImageView objekt och rectanglar för att skapa animationer
     * Animationerna kan gå i olika hastigheter
     */

    private void initialize() {
        Image ghost = new Image("file:files/ghost.png", squareSize, squareSize, false, false);

        ImageView ghost1V = createImageView(ghost, 10, 0);
        ImageView ghost2V = createImageView(ghost, 9, 0);
        ImageView ghost3V = createImageView(ghost, 8, 0);
        ImageView ghost4V = createImageView(ghost, 1, 0);
        ImageView ghost5V = createImageView(ghost, 2, 0);
        ImageView ghost6V = createImageView(ghost, 3, 0);

        Polyline line1 = new Polyline();
        Polyline line2 = new Polyline();
        Polyline line3 = new Polyline();

        line1.getPoints().addAll(16.0, -10.5, 10.5, 650.0);
        line2.getPoints().addAll(15.0, -10.5, 10.5, 650.0);
        line3.getPoints().addAll(14.0, -10.5, 10.5, 650.0);

        createPathTransition(ghost1V, 3.5, -1, line1, false).play();
        createPathTransition(ghost2V, 3.0, -1, line2, false).play();
        createPathTransition(ghost3V, 4.0, -1, line3, false).play();
        createPathTransition(ghost4V, 3.5, -1, line1, false).play();
        createPathTransition(ghost5V, 3.0, -1, line2, false).play();
        createPathTransition(ghost6V, 4.0, -1, line3, false).play();

        ghost1V.setOnMouseEntered(e -> enteredGhost(e));
        ghost2V.setOnMouseEntered(e -> enteredGhost(e));
        ghost3V.setOnMouseEntered(e -> enteredGhost(e));
        ghost4V.setOnMouseEntered(e -> enteredGhost(e));
        ghost5V.setOnMouseEntered(e -> enteredGhost(e));
        ghost6V.setOnMouseEntered(e -> enteredGhost(e));
    }
}

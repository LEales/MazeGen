package view.Campaign;

import control.MainProgram;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import model.Maps.Sprite;
import model.World;
import view.AudioPlayer;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;

/**
 * @author Filip Örnling
 */

public class World5Template extends World1Template {

    private final int squareSize;
    private final int currentLevel;


    public World5Template(Sprite[][] level, int currentLevel, int heartCrystals, RightPanel rightPanel, World world) throws FileNotFoundException {
        super(level, currentLevel, heartCrystals, rightPanel, world, 90);
        squareSize = (int) MainProgram.HEIGHT / (level.length + 2);
        this.currentLevel = currentLevel;
        rightPanel.changeHeartCounter(heartCrystals);
        rightPanel.resetTimerLabel();
        initialize();
    }


    /**
     * Metoden initialize instansierar olika antal ImageView objekt beroende på vilken bana som spelas
     * Metoden initialize instansierar även olika antal rectanglar i olika former beroende på bana
     * Metoden kopplar sedan samman ImageView objekt och rectanglar för att skapa animationer
     * Animationerna kan gå i olika hastigheter
     */

    private void initialize() {
        Image ghost = new Image("file:files/mob_egypt.png", squareSize, squareSize, false, false);
        switch (currentLevel) {
            case 2 -> {
                ImageView ghost1V = createImageView(ghost, 20, 5);
                ImageView ghost2V = createImageView(ghost, 10, 10);

                Rectangle rectangle = createRectangle(300.0, 150.0, 65.0, -150.0);
                Rectangle rectangle1 = createRectangle(97.0, 280.0, 65.0, -150.0);

                createPathTransition(ghost1V, 4.0, -1, rectangle1, false).play();
                createPathTransition(ghost2V, 4.0, -1, rectangle, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 3 -> {
                ImageView ghost1V = createImageView(ghost, 6,3);
                ImageView ghost2V = createImageView(ghost, 20, 5);

                Rectangle rectangle = createRectangle(270.0, 100.0, 50.0, -150.0);
                Rectangle rectangle1 = createRectangle(100.0, 100.0, 80.0, -150.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle, false).play();
                createPathTransition(ghost2V, 2.0, -1, rectangle1, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 4 -> {
                ImageView ghost1V = createImageView(ghost, 13, 3);
                ImageView ghost2V = createImageView(ghost,12, 10);

                Rectangle rectangle = createRectangle(132.0, 100.0, 50.0, -150.0);
                Rectangle rectangle1 = createRectangle(100.0, 100.0, 80.0, -150.0);

                createPathTransition(ghost1V, 1.5, -1, rectangle, false).play();
                createPathTransition(ghost2V, 1.5, -1, rectangle1, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 5 -> {
                ImageView ghost1V = createImageView(ghost, 12, 8);
                ImageView ghost2V = createImageView(ghost, 14, 0);
                ImageView ghost3V = createImageView(ghost,8, 12);

                Rectangle rectangle = createRectangle(132.0, 200.0, 80.0, -150.0);
                Rectangle rectangle1 = createRectangle(0.0, 135.0, 80.0, -150.0);
                Rectangle rectangle2 = createRectangle(400.0, 0.0, 20.0, -150.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle, false).play();
                createPathTransition(ghost2V, 3.0, -1, rectangle1, true).play();
                createPathTransition(ghost3V, 2.5, -1, rectangle2, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 6 -> {
                ImageView ghost1V = createImageView(ghost, 7, 6);
                ImageView ghost2V = createImageView(ghost, 6, 3);
                ImageView ghost3V = createImageView(ghost, 16, 0);
                ImageView ghost4V = createImageView(ghost, 17, 10);

                Rectangle rectangle = createRectangle(100.0, 100.0, 80.0, -150.0);
                Rectangle rectangle1 = createRectangle(100.0, 0.0, 80.0, -150.0);
                Rectangle rectangle2 = createRectangle(0.0, 450.0, 80.0, 17);
                Rectangle rectangle3 = createRectangle(70.0, 130.0, 80.0, -150.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle, false).play();
                createPathTransition(ghost2V, 2.5, -1, rectangle1, true).play();
                createPathTransition(ghost3V, 2.0, -1, rectangle2, true).play();
                createPathTransition(ghost4V, 3.0, -1, rectangle3, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
            }
        }
    }
}

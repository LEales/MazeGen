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

public class World3Template extends World1Template {
    private final int squareSize;
    private final int currentLevel;
    public World3Template(Sprite[][] level, int currentLevel, int heartCrystals, RightPanel rightPanel, World world) throws FileNotFoundException {
        super(level, currentLevel, heartCrystals, rightPanel, world, 60);
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
        Image ghost = new Image("file:files/ghost.png", squareSize, squareSize, false, false);
        switch (currentLevel) {
            case 2 -> {
                ImageView ghost1V = createImageView(ghost, 14, 5);
                ImageView ghost2V = createImageView(ghost, 5, 5);

                Rectangle rectangle = createRectangle(125.0, 251.0, 65.0, -147.0);
                Rectangle rectangle1 = createRectangle(84.0, 123.0, 65.0, -147.0);

                createPathTransition(ghost2V, 4.0, -1, rectangle, false).play();
                createPathTransition(ghost1V, 4.0, -1, rectangle1, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 3 -> {
                ImageView ghost1V = createImageView(ghost, 5, 8);
                ImageView ghost2V = createImageView(ghost, 9, 3);

                Rectangle rectangle = createRectangle(125.0, 120.0, 65.0, -147.0);
                Rectangle rectangle1 = createRectangle(210.0, 125.0, 190.0, -231.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle, false).play();
                createPathTransition(ghost2V, 2.0, -1, rectangle1, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 4 -> {
                ImageView ghost1V = createImageView(ghost, 10, 1);
                ImageView ghost2V = createImageView(ghost, 15, 4);
                ImageView ghost3V = createImageView(ghost, 15, 1);
                ImageView ghost4V = createImageView(ghost, 10, 4);
                ImageView ghost5V = createImageView(ghost, 12, 1);

                Rectangle rectangle = createRectangle(125.0, 83.0, 190.0, -230.0);
                Rectangle rectangle1 = createRectangle(0.0, 83.0, 105.0, -232.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle1, true).play();
                createPathTransition(ghost2V, 3.0, -1, rectangle, true).play();
                createPathTransition(ghost3V, 2.0, -1, rectangle1, true).play();
                createPathTransition(ghost4V, 2.0, -1, rectangle, true).play();
                createPathTransition(ghost5V, 2.0, -1, rectangle1, true).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
                ghost5V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 5 -> {
                ImageView ghost1V = createImageView(ghost, 8, 3);
                ImageView ghost2V = createImageView(ghost, 8, 8);
                ImageView ghost3V = createImageView(ghost, 8, 12);
                ImageView ghost4V = createImageView(ghost, 8, 11);

                Rectangle rectangle = createRectangle(83.0, 125.0, 65.0, -150.0);
                Rectangle rectangle1 = createRectangle(0.0, 125.0, 65.0, -150.0);
                Rectangle rectangle2 = createRectangle(400.0, 0.0, 20.0, -150.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle, true).play();
                createPathTransition(ghost2V, 1.5, -1, rectangle1, true).play();
                createPathTransition(ghost3V, 2.5, -1, rectangle2, true).play();
                createPathTransition(ghost4V, 3.0, -1, rectangle2, true).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 6 -> {
                ImageView ghost1V = createImageView(ghost, 7, 6);
                ImageView ghost2V = createImageView(ghost, 8, 2);
                ImageView ghost3V = createImageView(ghost, 8, 6);
                ImageView ghost4V = createImageView(ghost, 8, 10);

                Rectangle rectangle = createRectangle(83.0, 125.0, 65.0, -150.0);
                Rectangle rectangle1 = createRectangle(0.0, 40.0, 65.0, -150.0);
                Rectangle rectangle2 = createRectangle(170.0, 87.0, 20.0, 20.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle, false).play();
                createPathTransition(ghost2V, 1.5, -1, rectangle1, true).play();
                createPathTransition(ghost3V, 2.5, -1, rectangle2, true).play();
                createPathTransition(ghost4V, 3.0, -1, rectangle2, true).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
            }
        }
    }
}

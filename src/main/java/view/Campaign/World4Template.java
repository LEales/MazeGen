package view.Campaign;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import model.Maps.Maps;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;

/**
 * @author Filip Örnling
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables methods and dependencies
 */

public class World4Template extends World1Template {

    public World4Template(Maps map, RightPanel rightPanel) throws FileNotFoundException {
        super(map, rightPanel);
        initialize(map.getNextLevel());
    }

    /**
     * Metoden initialize instansierar olika antal ImageView objekt beroende på vilken bana som spelas
     * Metoden initialize instansierar även olika antal rectanglar i olika former beroende på bana
     * Metoden kopplar sedan samman ImageView objekt och rectanglar för att skapa animationer
     * Animationerna kan gå i olika hastigheter
     */

    private void initialize(int currentLevel) {
        Image ghost = new Image("file:files/god_mob2.png", squareSize, squareSize, false, false);
        switch (currentLevel) {
            case 2 -> {
                ImageView ghost1V = createImageView(ghost, 14, 5);
                ImageView ghost2V = createImageView(ghost, 0, 10);
                ImageView ghost3V = createImageView(ghost, 15, 9);

                Rectangle rectangle = createRectangle(110.0, 150.0, 57.0, -130.0);
                Rectangle rectangle1 = createRectangle(75.0, 75.0, 57.0, -130.0);
                Rectangle rectangle2 = createRectangle(110.0, 75.0, 57.0, -130.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle2, false).play();
                createPathTransition(ghost2V, 2.5, -1, rectangle1, true).play();
                createPathTransition(ghost3V, 3.5, -1, rectangle, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 3 -> {
                ImageView ghost1V = createImageView(ghost, 1, 4);
                ImageView ghost2V = createImageView(ghost, 5, 9);

                Rectangle rectangle = createRectangle(115.0, 115.0, 18.0, 18.0);
                Rectangle rectangle1 = createRectangle(190.0, 190.0, 18.0, 18.0);

                createPathTransition(ghost1V, 2.0, -1, rectangle, true).play();
                createPathTransition(ghost2V, 2.0, -1, rectangle1, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 4 -> {
                ImageView ghost1V = createImageView(ghost, 0, 6);
                ImageView ghost2V = createImageView(ghost, 0, 2);
                ImageView ghost3V = createImageView(ghost, 0, 8);
                ImageView ghost4V = createImageView(ghost, 0, 4);
                ImageView ghost5V = createImageView(ghost, 0, 10);
                ImageView ghost6V = createImageView(ghost, 0, 12);
                ImageView ghost7V = createImageView(ghost, 0, 14);

                Rectangle rectangle = createRectangle(570.0, 0.0, 20.0, 20.0);

                createPathTransition(ghost1V, 4.0, -1, rectangle, true).play();
                createPathTransition(ghost2V, 4.0, -1, rectangle, true).play();
                createPathTransition(ghost3V, 4.0, -1, rectangle, true).play();
                createPathTransition(ghost4V, 4.0, -1, rectangle, true).play();
                createPathTransition(ghost5V, 4.0, -1, rectangle, true).play();
                createPathTransition(ghost6V, 4.0, -1, rectangle, true).play();
                createPathTransition(ghost7V, 4.0, -1, rectangle, true).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
                ghost5V.setOnMouseEntered(e -> enteredGhost(e));
                ghost6V.setOnMouseEntered(e -> enteredGhost(e));
                ghost7V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 5 -> {
                ImageView ghost1V = createImageView(ghost, 8, 3);
                ImageView ghost2V = createImageView(ghost, 8, 8);
                ImageView ghost3V = createImageView(ghost, 8, 12);
                ImageView ghost4V = createImageView(ghost, 8, 11);

                Rectangle rectangle = createRectangle(83.0, 125.0, 65.0, -150.0);
                Rectangle rectangle1 = createRectangle(0.0, 125.0, 65.0, -150.0);
                Rectangle rectangle2 = createRectangle(400.0, 0.0, 20.0, -150.0);

                createPathTransition(ghost4V, 3.0, -1, rectangle2, true).play();
                createPathTransition(ghost3V, 2.5, -1, rectangle2, true).play();
                createPathTransition(ghost2V, 1.5, -1, rectangle1, true).play();
                createPathTransition(ghost1V, 2.0, -1, rectangle, true).play();

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

                createPathTransition(ghost4V, 3.0, -1, rectangle2, true).play();
                createPathTransition(ghost3V, 2.5, -1, rectangle2, true).play();
                createPathTransition(ghost2V, 1.5, -1, rectangle1, true).play();
                createPathTransition(ghost1V, 2.0, -1, rectangle, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
            }
        }
    }
}

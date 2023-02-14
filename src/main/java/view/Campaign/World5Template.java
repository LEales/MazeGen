package view.Campaign;

import control.MainProgram;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
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



    public World5Template(Sprite[][] level, int currentLevel, int heartCrystals, RightPanel rightPanel, World world, AudioPlayer audioPlayer) throws FileNotFoundException {

        super(level, currentLevel, heartCrystals, rightPanel, world, audioPlayer, 90);

        squareSize = (int) MainProgram.HEIGHT/(level.length+2);
        this.currentLevel = currentLevel;

        rightPanel.changeHeartCounter(String.valueOf(heartCrystals));
        rightPanel.resetTimerLabel();
        initialize();
    }


    /**
     * Metoden initialize instansierar olika antal ImageView objekt beroende på vilken bana som spelas
     * Metoden initialize instansierar även olika antal rectanglar i olika former beroende på bana
     * Metoden kopplar sedan samman ImageView objekt och rectanglar för att skapa animationer
     * Animationerna kan gå i olika hastigheter
     */

    public void initialize() {

        Image ghost = new Image("file:files/mob_egypt.png", squareSize, squareSize, false, false);


        switch (currentLevel) {
            case 2 -> {
                ImageView ghost3V = new ImageView();
                ImageView ghost1V = new ImageView();

                ghost3V.setImage(ghost);
                ghost1V.setImage(ghost);

                add(ghost3V, 10, 10);
                add(ghost1V, 20, 5);

                Rectangle rectangle = createRectangle(300.0, 150.0, 65.0, -150.0);
                Rectangle rectangle2 = createRectangle(97.0, 280.0, 65.0, -150.0);

                createPathTransition(ghost3V, 4.0, rectangle, false).play();

                createPathTransition(ghost1V, 4.0, rectangle2, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 3 -> {
                ImageView ghost1V = new ImageView();
                ImageView ghost2V = new ImageView();

                ghost1V.setImage(ghost);
                ghost2V.setImage(ghost);

                add(ghost1V, 6, 3);
                add(ghost2V, 20, 5);



                Rectangle rectangle = createRectangle(270.0, 100.0, 50.0, -150.0);
                Rectangle rectangle1 = createRectangle(100.0, 100.0, 80.0, -150.0);

                createPathTransition(ghost1V, 2.0, rectangle, false).play();
                createPathTransition(ghost2V, 2.0, rectangle1, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 4 -> {

                ImageView ghost1V = new ImageView();
                ImageView ghost2V = new ImageView();

                ghost1V.setImage(ghost);
                ghost2V.setImage(ghost);

                add(ghost1V, 13, 3);
                add(ghost2V, 12, 10);

                Rectangle rectangle = createRectangle(132.0, 100.0, 50.0, -150.0);

                Rectangle rectangle1 = createRectangle(100.0, 100.0, 80.0, -150.0);

                createPathTransition(ghost1V, 1.5, rectangle, false).play();
                createPathTransition(ghost2V, 1.5, rectangle1, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));

            }
            case 5 -> {
                ImageView ghost1V = new ImageView();
                ImageView ghost2V = new ImageView();
                ImageView ghost3V = new ImageView();

                ghost3V.setImage(ghost);
                ghost2V.setImage(ghost);
                ghost1V.setImage(ghost);

                add(ghost1V, 12, 8);
                add(ghost2V, 14, 0);
                //add(ghost3V, 8, 12);

                Rectangle rectangle = createRectangle(132.0, 200.0, 80.0, -150.0);

                Rectangle rectangle1 = createRectangle(0.0, 135.0, 80.0, -150.0);

                Rectangle rectangle2 = createRectangle(400.0, 0.0, 20.0, -150.0);

                createPathTransition(ghost1V, 2.0, rectangle, false).play();
                createPathTransition(ghost2V, 3.0, rectangle1, true).play();
                createPathTransition(ghost3V, 2.5, rectangle2, false).play();
            }
            case 6 -> {
                ImageView ghost1V = new ImageView();
                ImageView ghost2V = new ImageView();
                ImageView ghost3V = new ImageView();
                ImageView ghost4V = new ImageView();

                ghost4V.setImage(ghost);
                ghost3V.setImage(ghost);
                ghost2V.setImage(ghost);
                ghost1V.setImage(ghost);

                add(ghost1V, 7, 6);
                add(ghost2V, 6, 3);
                add(ghost3V, 16, 0);
                add(ghost4V, 17, 10);

                Rectangle rectangle = createRectangle(100.0, 100.0, 80.0, -150.0);

                Rectangle rectangle1 = createRectangle(100.0, 0.0, 80.0, -150.0);

                Rectangle rectangle2 = createRectangle(0.0, 450.0, 80.0, 17);

                Rectangle rectangle3 = createRectangle(70.0, 130.0, 80.0, -150.0);

                createPathTransition(ghost1V, 2.0, rectangle, false).play();
                createPathTransition(ghost2V, 2.5, rectangle1, true).play();
                createPathTransition(ghost3V, 2.0, rectangle2, true).play();

                createPathTransition(ghost4V, 3.0, rectangle3, false).play();
            }
        }
    }

    private PathTransition createPathTransition(Node node, double duration, Rectangle path, boolean autoReverse) {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(node);
        pathTransition.setAutoReverse(autoReverse);
        pathTransition.setDuration(Duration.seconds(duration));
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setPath(path);
        return pathTransition;
    }

    private Rectangle createRectangle(double v, double v1, double y, double x) {
        Rectangle rectangle = new Rectangle(v, v1);
        rectangle.setY(y);
        rectangle.setX(x);
        return rectangle;
    }
}

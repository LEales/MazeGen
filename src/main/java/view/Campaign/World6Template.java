package view.Campaign;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import model.Maps.Maps;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;

/**
 * @author Filip Örnling
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables methods and dependencies
 */

public class World6Template extends World1Template {
    public World6Template(Maps map, RightPanel rightPanel) throws FileNotFoundException {
        super(map, rightPanel);
        initialize(map.getNextLevel());
    }

    /**
     * Updates the ghost animation
     * @param animation The animation to be updated
     * @param duration The length in seconds of the animation
     * @param cycleCount How many cycles the animation will run (-1 equals indefinitely)
     * @param autoReverse If the animation returns to the starting point, following the same path
     */
    private void ghostCycleEnded(PathTransition animation, double duration,  int cycleCount, boolean autoReverse) {
        validateDurationAndCycle(duration, cycleCount);
        animation.setCycleCount(cycleCount);
        animation.setDuration(Duration.seconds(duration));
        animation.setAutoReverse(autoReverse);
        animation.play();
    }

    /**
     * Updates the ghost animation and prepares a second update
     * @param animation The animation to be updated
     * @param duration The length in seconds of the first animation
     * @param nextDuration The length in seconds of the updated animation
     * @param cycleCount How many cycles the animation will run (-1 equals indefinitely)
     * @param nextCycleCount How many cycles the next animation will run
     * @param autoReverse If the animation returns to the starting point, following the same path
     * @param path The path of the animation
     * @param nextPath The path of the next animation
     */
    private void ghostCycleEnded(PathTransition animation, double duration, double nextDuration, int cycleCount, int nextCycleCount, boolean autoReverse, Shape path, Shape nextPath) {
        validateDurationAndCycle(duration, cycleCount);
        animation.setDuration(Duration.seconds(duration));
        animation.setCycleCount(cycleCount);
        animation.setPath(path);
        animation.setAutoReverse(autoReverse);
        animation.play();
        animation.setOnFinished(e -> ghostCycleEnded(animation, nextDuration, nextCycleCount, autoReverse, path));
    }
    /**
     * Updates the ghost animation
     * @param animation The animation to be updated
     * @param duration The length in seconds of the animation
     * @param cycleCount How many cycles the animation will run (-1 equals indefinitely)
     * @param autoReverse If the animation returns to the starting point, following the same path
     * @param path The path of the animation
     */
    private void ghostCycleEnded(PathTransition animation, double duration, int cycleCount, boolean autoReverse, Shape path) {
        validateDurationAndCycle(duration, cycleCount);
        animation.setDuration(Duration.seconds(duration));
        animation.setCycleCount(cycleCount);
        animation.setAutoReverse(autoReverse);
        animation.setPath(path);
        animation.play();
    }

    /**
     * Validates that the duration and cycleCount are in bounds
     * @param duration The duration of an animation
     * @param cycleCount How many cycles an animation will run
     * @return true or throws an exception
     */
    private boolean validateDurationAndCycle(double duration, int cycleCount) {
        if (0.0 >= duration) {
            throw new IllegalArgumentException("Duration cannot be bellow 0");
        }
        if (-1 > cycleCount) {
            throw new IllegalArgumentException("Cycle count cannot be bellow -1");
        }
        return true;
    }

    /**
     * Metoden initialize instansierar olika antal ImageView objekt beroende på vilken bana som spelas
     * Metoden initialize instansierar även olika antal rectanglar i olika former beroende på bana
     * Metoden kopplar sedan samman ImageView objekt och rectanglar för att skapa animationer
     * Animationerna kan gå i olika hastigheter
     */


    private void initialize(int currentLevel) {
        Image ghost = new Image("file:files/space_mob3.png", squareSize, squareSize, false, false);
        switch (currentLevel) {
            case 2 -> {
                ImageView ghost1V = createImageView(ghost,5,10);
                ImageView ghost2V = createImageView(ghost,4,5);
                ImageView ghost3V = createImageView(ghost,9,4);
                ImageView ghost4V = createImageView(ghost,10,13);
                ImageView ghost5V = createImageView(ghost,16,4);

                Rectangle rectangle = createRectangle(120.0, 93.0, 72.0, -45.0);

                createPathTransition(ghost1V, 4.0, -1, rectangle, false).play();
                createPathTransition(ghost2V, 4.0, -1, rectangle, false).play();
                createPathTransition(ghost3V, 4.0, -1, rectangle, false).play();
                createPathTransition(ghost4V, 4.0, -1, rectangle, false).play();
                createPathTransition(ghost5V, 4.0, -1, rectangle, false).play();

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
                ghost5V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 3 -> {
                ImageView ghost1V = createImageView(ghost, 5,10);
                ImageView ghost2V = createImageView(ghost, 4,5);
                ImageView ghost3V = createImageView(ghost, 9, 4);
                ImageView ghost4V = createImageView(ghost,10, 13);
                ImageView ghost5V = createImageView(ghost, 16,4);


                Rectangle rectangle = createRectangle(120.0, 93.0, 72.0, -45.0);

                PathTransition animation = createPathTransition(ghost1V, 5.0, 1, rectangle, false);
                animation.play();
                animation.setOnFinished(e -> ghostCycleEnded(animation, 2.0, -1, true));

                PathTransition animation2 = createPathTransition(ghost2V, 5.0, 1, rectangle, false);
                animation2.play();
                animation2.setOnFinished(e -> ghostCycleEnded(animation2, 2.0, -1, true));

                PathTransition animation3 = createPathTransition(ghost3V, 5.0, 1, rectangle, false);
                animation3.play();
                animation3.setOnFinished(e -> ghostCycleEnded(animation3, 2.0, -1, true));

                PathTransition animation4 = createPathTransition(ghost4V, 5.0, 1, rectangle, false);
                animation4.play();
                animation4.setOnFinished(e -> ghostCycleEnded(animation3, 2.0, -1, true));

                PathTransition animation5 = createPathTransition(ghost5V, 5.0, 1, rectangle, false);
                animation5.play();
                animation5.setOnFinished(e -> ghostCycleEnded(animation5, 2.0, -1, true));

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
                ghost5V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 4 -> {
                ImageView ghost1V = createImageView(ghost, 3, 5);
                ImageView ghost2V = createImageView(ghost, 3, 7);
                ImageView ghost3V = createImageView(ghost, 3, 3);
                ImageView ghost4V = createImageView(ghost, 3, 9);
                ImageView ghost5V = createImageView(ghost, 3, 1);
                ImageView ghost6V = createImageView(ghost, 3, 11);
                ImageView ghost7V = createImageView(ghost, 3, 13);
                ImageView ghost8V = createImageView(ghost, 3, 15);
                ImageView ghost9V = createImageView(ghost, 3, 17);

                Rectangle rectangle = createRectangle(525.0, 0.0, 72.0, -45.0);
                Rectangle rectangle1 = createRectangle(525.0, 0.0, 105.0, -45.0);

                PathTransition animation = createPathTransition(ghost3V, 5.0, 3, rectangle, false);
                animation.play();
                animation.setOnFinished(e -> ghostCycleEnded(animation, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation2 = createPathTransition(ghost1V, 5.0, 3, rectangle, false);
                animation2.play();
                animation2.setOnFinished(e -> ghostCycleEnded(animation2, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation3 = createPathTransition(ghost2V, 5.0, 3, rectangle, false);
                animation3.play();
                animation3.setOnFinished(e -> ghostCycleEnded(animation3, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation4 = createPathTransition(ghost4V, 5.0, 3, rectangle, false);
                animation4.play();
                animation4.setOnFinished(e -> ghostCycleEnded(animation4, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation5 = createPathTransition(ghost5V, 5.0, 3, rectangle, false);
                animation5.play();
                animation5.setOnFinished(e -> ghostCycleEnded(animation5, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation6 = createPathTransition(ghost6V, 5.0, 3, rectangle, false);
                animation6.play();
                animation6.setOnFinished(e -> ghostCycleEnded(animation6, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation7 = createPathTransition(ghost7V, 5.0, 3, rectangle, false);
                animation7.play();
                animation7.setOnFinished(e -> ghostCycleEnded(animation7, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation8 = createPathTransition(ghost8V, 5.0, 3, rectangle, false);
                animation8.play();
                animation8.setOnFinished(e -> ghostCycleEnded(animation8, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                PathTransition animation9 = createPathTransition(ghost9V, 5.0, 3, rectangle, false);
                animation9.play();
                animation9.setOnFinished(e -> ghostCycleEnded(animation9, 5.0, 5.0, 1, -1, true, rectangle1, rectangle));

                ghost1V.setOnMouseEntered(e -> enteredGhost(e));
                ghost2V.setOnMouseEntered(e -> enteredGhost(e));
                ghost3V.setOnMouseEntered(e -> enteredGhost(e));
                ghost4V.setOnMouseEntered(e -> enteredGhost(e));
                ghost5V.setOnMouseEntered(e -> enteredGhost(e));
                ghost6V.setOnMouseEntered(e -> enteredGhost(e));
                ghost7V.setOnMouseEntered(e -> enteredGhost(e));
                ghost8V.setOnMouseEntered(e -> enteredGhost(e));
                ghost9V.setOnMouseEntered(e -> enteredGhost(e));
            }
            case 5 -> {
                ImageView ghost1V = createImageView(ghost,12, 8);
                ImageView ghost2V = createImageView(ghost, 14,0);
                ImageView ghost3V = createImageView(ghost, 8,12);

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
                ImageView ghost1V = createImageView(ghost, 7,6);
                ImageView ghost2V = createImageView(ghost,6,3);
                ImageView ghost3V = createImageView(ghost, 16, 0);
                ImageView ghost4V = createImageView(ghost, 17, 10);

                Rectangle rectangle = createRectangle(100.0, 100.0, 80.0, -150.0);
                Rectangle rectangle1 = createRectangle(100.0, 0.0, 80.0, -150.0);
                Rectangle rectangle2 = createRectangle(0.0, 450.0, 80.0, 17.0);
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

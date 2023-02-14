package view.Campaign;

import control.MainProgram;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
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

public class World6Template extends World1Template {

    private final int squareSize;
    private final int currentLevel;

    public World6Template(Sprite[][] level, int currentLevel, int heartCrystals, RightPanel rightPanel, World world, AudioPlayer audioPlayer) throws FileNotFoundException {
        super(level, currentLevel, heartCrystals, rightPanel, world, audioPlayer, 99);
        squareSize = (int) MainProgram.HEIGHT / (level.length + 2);
        this.currentLevel = currentLevel;
        rightPanel.changeHeartCounter(String.valueOf(heartCrystals));
        rightPanel.resetTimerLabel();
        initialize();

    }

    private void ghostCycleEnded(PathTransition animation, double duration, int cycleCount, boolean autoReverse) {
        if (0 >= duration) {
            throw new IllegalArgumentException("Duration cannot be bellow 0");
        }
        if (-1 > cycleCount) {
            throw new IllegalArgumentException("Cycle count cannot be bellow -1");
        }
        animation.setCycleCount(cycleCount);
        animation.setDuration(Duration.seconds(duration));
        animation.setAutoReverse(autoReverse);
        animation.play();
    }

    /**
     * Metoden initialize instansierar olika antal ImageView objekt beroende på vilken bana som spelas
     * Metoden initialize instansierar även olika antal rectanglar i olika former beroende på bana
     * Metoden kopplar sedan samman ImageView objekt och rectanglar för att skapa animationer
     * Animationerna kan gå i olika hastigheter
     */


    private void initialize() {
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
                animation.setOnFinished(actionEvent -> {
                    animation.setCycleCount(1);
                    animation.setAutoReverse(true);
                    animation.setPath(rectangle1);
                    animation.play();
                    animation.setOnFinished(actionEvent1 -> {
                        animation.setCycleCount(Animation.INDEFINITE);
                        animation.setAutoReverse(true);
                        animation.setPath(rectangle);
                        animation.play();
                    });
                });

                PathTransition animation2 = createPathTransition(ghost1V, 5.0, 3, rectangle, false);
                animation2.play();
                animation2.setOnFinished(actionEvent -> {
                    animation2.setCycleCount(1);
                    animation2.setAutoReverse(true);
                    animation2.setPath(rectangle1);
                    animation2.play();
                    animation2.setOnFinished(actionEvent1 -> {
                        animation2.setCycleCount(Animation.INDEFINITE);
                        animation2.setAutoReverse(true);
                        animation2.setPath(rectangle);
                        animation2.play();
                    });
                });

                PathTransition animation3 = createPathTransition(ghost2V, 5.0, 3, rectangle, false);
                animation3.play();
                animation3.setOnFinished(actionEvent -> {
                    animation3.setPath(rectangle1);
                    animation3.setCycleCount(1);
                    animation3.setAutoReverse(true);
                    animation3.play();
                    animation3.setOnFinished(actionEvent1 -> {
                        animation3.setCycleCount(Animation.INDEFINITE);
                        animation3.setPath(rectangle);
                        animation3.play();
                    });
                });


                PathTransition animation4 = createPathTransition(ghost4V, 5.0, 3, rectangle, false);
                animation4.play();
                animation4.setOnFinished(actionEvent -> {
                    animation4.setPath(rectangle1);
                    animation4.setCycleCount(1);
                    animation4.setAutoReverse(true);
                    animation4.play();
                    animation4.setOnFinished(actionEvent1 -> {
                        animation4.setCycleCount(Animation.INDEFINITE);
                        animation4.setPath(rectangle);
                        animation4.play();
                    });
                });

                PathTransition animation5 = createPathTransition(ghost5V, 5.0, 3, rectangle, false);
                animation5.play();
                animation5.setOnFinished(actionEvent -> {
                    animation5.setPath(rectangle1);
                    animation5.setCycleCount(1);
                    animation5.setAutoReverse(true);
                    animation5.play();
                    animation5.setOnFinished(actionEvent1 -> {
                        animation5.setCycleCount(Animation.INDEFINITE);
                        animation5.setPath(rectangle);
                        animation5.play();
                    });
                });
                PathTransition animation6 = createPathTransition(ghost6V, 5.0, 3, rectangle, false);
                animation6.play();
                animation6.setOnFinished(actionEvent -> {
                    animation6.setPath(rectangle1);
                    animation6.setCycleCount(1);
                    animation6.setAutoReverse(true);
                    animation6.play();
                    animation6.setOnFinished(actionEvent1 -> {
                        animation6.setCycleCount(Animation.INDEFINITE);
                        animation6.setPath(rectangle);
                        animation6.play();
                    });
                });

                PathTransition animation7 = createPathTransition(ghost7V, 5.0, 3, rectangle, false);
                animation7.play();
                animation7.setOnFinished(actionEvent -> {
                    animation7.setPath(rectangle1);
                    animation7.setCycleCount(1);
                    animation7.setAutoReverse(true);
                    animation7.play();
                    animation7.setOnFinished(actionEvent1 -> {
                        animation7.setCycleCount(Animation.INDEFINITE);
                        animation7.setPath(rectangle);
                        animation7.play();
                    });
                });

                PathTransition animation8 = createPathTransition(ghost8V, 5.0, 3, rectangle, false);
                animation8.play();
                animation8.setOnFinished(actionEvent -> {
                    animation8.setPath(rectangle1);
                    animation8.setCycleCount(1);
                    animation8.setAutoReverse(true);
                    animation8.play();
                    animation8.setOnFinished(actionEvent1 -> {
                        animation8.setCycleCount(Animation.INDEFINITE);
                        animation8.setPath(rectangle);
                        animation8.play();
                    });
                });


                PathTransition animation9 = createPathTransition(ghost9V, 5.0, 3, rectangle, false);
                animation9.play();
                animation9.setOnFinished(actionEvent -> {
                    animation9.setPath(rectangle1);
                    animation9.setCycleCount(1);
                    animation9.setAutoReverse(true);
                    animation9.play();
                    animation9.setOnFinished(actionEvent1 -> {
                        animation9.setCycleCount(Animation.INDEFINITE);
                        animation9.setPath(rectangle);
                        animation9.play();
                    });
                });

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

package view.Menu;

import control.MainProgram;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import control.AudioPlayer;

/**
 * @author Viktor Näslund
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables methods and dependencies
 */

public class Intro extends Pane {

    private final MainProgram mainProgram;

    /**
     * Konstruktor som tar emot mainProgram och audioPlayer
     * Kör sedan metoder för bakgrundsbild, bilder i övrigt och listener
     */
    public Intro() {
        mainProgram = MainProgram.getMainProgram();
        setBackground();
        addListener();
        introAnimation();

    }

    /**
     * Metod som sätter bakgrundsbilden
     */
    private void setBackground() {
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:files/intropics/1.png", MainProgram.WIDTH, MainProgram.HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
    }

    /**
     * Lägger till listener för att stänga av ljudet och byta scen
     */
    private void addListener() {
        setOnMouseClicked(mouseEvent -> {
            AudioPlayer.stopMusic();
            AudioPlayer.playButtonSound();
            mainProgram.changeToMenu();
        });
    }


    /**
     * Metod som animerar in bilder med olika delays och durations
     * med FadeTransitions
     */
    private void introAnimation() {
        Image spaceImage = new Image("file:files/intropics/2.png", MainProgram.WIDTH, MainProgram.HEIGHT, false, false);
        ImageView introView = new ImageView(spaceImage);
        introView.setStyle("fx-background-color: transparent;");
        FadeTransition ft = new FadeTransition(Duration.millis(3000), introView);
        getChildren().add(introView);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();

        Image mazeGen = new Image("file:files/intropics/3.png", MainProgram.WIDTH, MainProgram.HEIGHT, false, false);
        ImageView mazeGenView = new ImageView(mazeGen);
        mazeGenView.setStyle("fx-background-color: transparent;");
        mazeGenView.toFront();
        FadeTransition ft2 = new FadeTransition(Duration.millis(2000), mazeGenView);
        mazeGenView.setOpacity(0);
        getChildren().add(mazeGenView);
        ft2.setDelay(Duration.millis(2000));
        ft2.setFromValue(0);
        ft2.setToValue(1);
        ft2.play();

        Image mazeGenGlow = new Image("file:files/intropics/4.png", MainProgram.WIDTH, MainProgram.HEIGHT, false, false);
        ImageView mazeGenGlowView = new ImageView(mazeGenGlow);
        mazeGenGlowView.setStyle("fx-background-color: transparent;");
        mazeGenGlowView.toFront();
        FadeTransition ft3 = new FadeTransition(Duration.millis(1500), mazeGenGlowView);
        mazeGenGlowView.setOpacity(0);
        getChildren().add(mazeGenGlowView);
        ft3.setDelay(Duration.millis(3500));
        ft3.setFromValue(0);
        ft3.setToValue(1);
        ft3.play();

        Image pressMouse = new Image("file:files/intropics/5.png", MainProgram.WIDTH, MainProgram.HEIGHT, false, false);
        ImageView pressMouseView = new ImageView(pressMouse);
        pressMouseView.setStyle("fx-background-color: transparent;");
        pressMouseView.toFront();
        FadeTransition ft4 = new FadeTransition(Duration.millis(1500), pressMouseView);
        ft4.setCycleCount(Transition.INDEFINITE);
        pressMouseView.setOpacity(0);
        getChildren().add(pressMouseView);
        ft4.setDelay(Duration.millis(5500));
        ft4.setFromValue(0);
        ft4.setToValue(1);
        ft4.play();
    }
}

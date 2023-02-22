package view.menu;

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

public class Help extends VBox {

    private final MainProgram mainProgram;

    /**
     * Konstruktor som skapar pressMouse-objektet för animation och tar emot mainProgram och audioPlayer
     */
    public Help() {
        mainProgram = MainProgram.getMainProgram();
        setBackground();
        pressMouseAnimation();
        addListener();
    }

    /**
     * Metod som sätter bakgrundsbilden
     */
    private void setBackground() {
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:files/menuImages/helppicnew.png", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
    }

    /**
     * Metod som får pressMouseView-objektet att blinka genom en FadeTransition
     */
    private void pressMouseAnimation() {
        Image pressMouse = new Image("file:files/menuImages/helppicmouse.png");
        ImageView pressMouseView = new ImageView(pressMouse);
        pressMouseView.setStyle("fx-background-color: transparent;");
        pressMouseView.toFront();
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500.0), pressMouseView);
        fadeTransition.setCycleCount(Transition.INDEFINITE);
        pressMouseView.setOpacity(0.0);
        getChildren().add(pressMouseView);

        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }


    /**
     * Lägger till listener för knapptryck och skiftar scen till menyn
     */
    private void addListener() {
        setOnMouseClicked(mouseEvent -> {
            mainProgram.changeToMenu();
            AudioPlayer.playButtonSound();
        });
    }

}

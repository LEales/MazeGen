package view.Menu;

import control.MainProgram;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import view.AudioPlayer;

/**
 * @author Viktor Näslund
 */

public class Help extends VBox {

    private MainProgram mainProgram;
    private Image pressMouse;

    /**
     * Konstruktor som skapar pressMouse-objektet för animation och tar emot mainProgram och audioPlayer
     */
    public Help(){
        pressMouse = new Image("file:files/menuImages/helppicmouse.png");
        this.mainProgram = MainProgram.getMainProgram();
        setBackground();
        pressMouseAnimation();
        addListener();
    }

    /**
     * Metod som sätter bakgrundsbilden
     */
    public void setBackground(){
        BackgroundImage backgroundImage = new BackgroundImage(new Image("file:files/menuImages/helppicnew.png",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));
    }

    /**
     * Metod som får pressMouseView-objektet att blinka genom en FadeTransition
     */
    public void pressMouseAnimation(){
        ImageView pressMouseView = new ImageView(pressMouse);
        pressMouseView.setStyle("fx-background-color: transparent;");
        pressMouseView.toFront();
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500), pressMouseView);
        fadeTransition.setCycleCount(Transition.INDEFINITE);
        pressMouseView.setOpacity(0);
        getChildren().add(pressMouseView);

        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }


    /**
     * Lägger till listener för knapptryck och skiftar scen till menyn
     */
    public void addListener(){
        this.setOnMouseClicked(mouseEvent -> {
            mainProgram.changeToMenu();
            AudioPlayer.playButtonSound();
        });
    }

}

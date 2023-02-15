package view;

import control.MainProgram;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import model.World;

import java.io.File;

/**
 * @author André Eklund
 */
public class WorldIntroAnimation extends Pane {

    /**
     * Default konstruktor
     */
    public WorldIntroAnimation(){}

    /**
     * Konstruktor som tar emot en sträng
     * Sätter sedan bilderna och animationen
     * @param world tas emot och currentWorld sätts
     */
    public WorldIntroAnimation(World world) {
        introAnimation(setupImages(world));
    }

    /**
     * Metod som länkar worldIntro-objektet till en png-fil för currentWorld.
     */
    private Image setupImages(World world) {
        return new Image("file:files/worlds/World" + world + ".png", 600, 600, false, false);
    }

    /**
     * En fade transition för animation av bilden
     */
    private boolean introAnimation(Image image) {
        try {
            ImageView introView = new ImageView(image);
            introView.setStyle("fx-background-color: transparent;");
            FadeTransition ft = new FadeTransition(Duration.millis(4000), introView);
            getChildren().add(introView);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.play();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

package view;

import control.MainProgram;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Player;

/**
 * @author André Eklund
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables methods and dependencies
 */
public class GameOverScreen extends Pane {

    private ImageView introView;

    /**
     * Konstruktor som tar emot mainProgram
     * Kör sedan metoder för bild och animation
     */
    public GameOverScreen(Player player, String cause) {
        if(null == cause || MainProgram.wrongCauseInput(cause)) {
            throw new IllegalArgumentException("Invalid input: Cause");
        }
        if(null == player) {
            throw new IllegalArgumentException("Invalid input: Player");
        }
        setWidth(MainProgram.WIDTH);
        setHeight(MainProgram.HEIGHT);
        setOnMouseClicked(e -> {
            MainProgram mp = MainProgram.getMainProgram();
            getChildren().remove(introView);
            mp.removeGameOver("Campaign");
            if (mp.isQualified(player)) {
                mp.showVictoryScene();
            } else {
                mp.showHighScoreList();
            }

        });
        gameOverAnimation(cause);
    }

    public GameOverScreen(String cause, String remove) {
        if(null == cause || MainProgram.wrongCauseInput(cause)) {
            throw new IllegalArgumentException("Invalid input: Cause");
        }
        setOnMouseClicked(e -> {
            MainProgram mp = MainProgram.getMainProgram();
            getChildren().remove(introView);
            mp.removeGameOver(remove);
            mp.changeToMenu();
        });
        gameOverAnimation(cause);
    }

    /**
     * Animation för gameOver-bilden
     */
    private boolean gameOverAnimation(String cause) {
        if(null == cause || MainProgram.wrongCauseInput(cause)) {
            throw new IllegalArgumentException("Invalid input: Cause");
        }
        try {
            introView = new ImageView(new Image("file:files/texts/gameover" + cause + ".png", 600, 100, false, false));
            introView.setX(-3);
            introView.setY(250);
            introView.setStyle("fx-background-color: transparent;");
            FadeTransition ft = new FadeTransition(Duration.millis(4000.0), introView);
            getChildren().add(introView);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }
}

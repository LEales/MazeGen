package view.menu;

import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.enums.World;
import control.AudioPlayer;
import java.io.FileNotFoundException;

/**
 * @author Viktor Näslund
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables, methods and dependencies
 */

public class Menu extends Pane {
    private final MainProgram mainProgram;

    /**
     * Konstruktor som tar emot mainProgram, audioPlayer och panel
     * Kör sedan metoder för att länka Image-objekten med png-filer
     */
    public Menu() {
        mainProgram = MainProgram.getMainProgram();
        setBackground(new Background(setBackground()));
        getChildren().addAll(getCampaignView(), getRandomizeView(), getHelpView(), getMazeGenView(), getHighscoreView(), getSandBoxView());
    }


    /**
     * Metod som sätter bakgrundsbilden
     */
    private BackgroundImage setBackground() {
        return new BackgroundImage(new Image("file:files/MenuBackground.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }

    private ImageView getMazeGenView() {
        Image mazegen = new Image("file:files/texts/MazegenTitel.png", 800, 600, false, false);
        ImageView mazegenView = new ImageView(mazegen);
        mazegenView.setStyle("fx-background-color: transparent;");
        return mazegenView;
    }

    private void onEnterAndExit(ImageView view, Image image, double translateX, double translateY) {
        validate(image, translateX, translateY);
        if (null == view) {
            throw new IllegalArgumentException("Invalid Imageview");
        }
        view.setImage(image);
        view.setTranslateY(translateY);
        view.setTranslateX(translateX);
    }

    private boolean validate(Image image, double translateX, double translateY) {
        if (0 >= translateY || MainProgram.HEIGHT < translateY) {
            throw new IllegalArgumentException("Invalid translateY");
        }
        if (0 >= translateX || MainProgram.WIDTH < translateX) {
            throw new IllegalArgumentException("Invalid translateX");
        }
        if (null == image) {
            throw new NullPointerException("Invalid image");
        }
        return true;
    }

    private ImageView createImageView(Image image, double translateX, double translateY) {
        validate(image, translateX, translateY);
        ImageView view = new ImageView(image);
        view.setStyle("fx-background-color: transparent;");
        view.setTranslateX(translateX);
        view.setTranslateY(translateY);
        view.toFront();
        return view;
    }

    private Label getCampaignView() {
        Label campaign = createLabel("Campaign", 305.0, 200.0);
        campaign.setOnMouseClicked(e -> {
            try {
                mainProgram.changeToCampaign();
                AudioPlayer.playLevelMusic(World.FOREST);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        return campaign;
        /*
        Image campaign = new Image("file:files/texts/Campaign.png", 250, 30, false, false);
        Image campaignResize = new Image("file:files/texts/Campaign.png", 255, 33, false, false);
        ImageView campaignView = createImageView(campaign, 275.0, 200.0);
        campaignView.setOnMouseEntered(e -> onEnterAndExit(campaignView, campaignResize, 273.0, 197.0));
        campaignView.setOnMouseExited(e -> onEnterAndExit(campaignView, campaign, 275.0, 200.0));
        campaignView.setOnMouseClicked(e -> {
            try {
                mainProgram.changeToCampaign();
                AudioPlayer.playLevelMusic(World.FOREST);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        return campaignView;

         */
    }

    private Label getRandomizeView() {
        Label randomize = createLabel("Randomize", 295.0, 250.0);
        randomize.setOnMouseClicked(e -> {
            mainProgram.chooseDimension();
            AudioPlayer.playButtonSound();
        });
        return randomize;
        /*
        Image randomize = new Image("file:files/texts/Randomize.png", 250, 30, false, false);
        Image randomizeResize = new Image("file:files/texts/Randomize.png", 255, 33, false, false);
        ImageView randomizeView = createImageView(randomize, 275.0, 250.0);
        randomizeView.setOnMouseEntered(e -> onEnterAndExit(randomizeView, randomizeResize, 273.0, 247.0));
        randomizeView.setOnMouseExited(e -> onEnterAndExit(randomizeView, randomize, 275.0, 250.0));
        randomizeView.setOnMouseClicked(e -> {
            mainProgram.chooseDimension();
            AudioPlayer.playButtonSound();
        });
        return randomizeView;

         */
    }

    private Label getHelpView() {
        Label help = createLabel("Help", 350.0, 300.0);
        help.setOnMouseClicked(e -> {
            mainProgram.changeToHelp();
            AudioPlayer.playButtonSound();
        });
        return help;

        /*Image help = new Image("file:files/texts/Help.png", 250, 30, false, false);
        Image helpResize = new Image("file:files/texts/Help.png", 255, 33, false, false);
        ImageView helpView = createImageView(help, 275.0, 300.0);
        helpView.setOnMouseEntered(e -> onEnterAndExit(helpView, helpResize, 273.0, 297.0));
        helpView.setOnMouseExited(e -> onEnterAndExit(helpView, help, 275.0, 300.0));
        helpView.setOnMouseClicked(e -> {
            mainProgram.changeToHelp();
            AudioPlayer.playButtonSound();
        });
        return helpView;

         */
    }

    private Label getHighscoreView() {
        Label highscoreLabel = createLabel("Highscore", 300.0, 350.0);
        highscoreLabel.setOnMouseClicked(e -> {
            mainProgram.showHighScoreList();
            AudioPlayer.playButtonSound();
        });
        return highscoreLabel;
        /*
        Image highscoreImage = new Image("file:files/texts/Highscore.png", 250.0, 30.0, false, false);
        Image highscoreImageRezise = new Image("file:files/texts/Highscore.png", 255.0, 33.0, false, false);
        ImageView highscoreView = createImageView(highscoreImage, 275.0, 350.0);
        highscoreView.setOnMouseEntered(e -> onEnterAndExit(highscoreView, highscoreImageRezise, 273.0, 347.0));
        highscoreView.setOnMouseExited(e -> onEnterAndExit(highscoreView, highscoreImage, 275.0, 350.0));
        highscoreView.setOnMouseClicked(e -> {
            mainProgram.showHighScoreList();
            AudioPlayer.playButtonSound();
        });
        return highscoreView;
         */
    }
    private Label getSandBoxView() {
        Label sandboxLabel = createLabel("Sandbox", 320.0, 400.0);
        sandboxLabel.setOnMouseClicked(e -> {
            mainProgram.changeToSandBoxLoader();
            AudioPlayer.playButtonSound();
        });
        return sandboxLabel;
    }

    private Label createLabel(String text, double x, double y) {
        Label label = new Label(text);
        label.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 24));
        label.setTextFill(Color.web("#0000D6"));
        label.setTranslateX(x);
        label.setTranslateY(y);
        label.setOnMouseEntered(e -> label.setTextFill(Color.ORANGERED));
        label.setOnMouseExited(e -> label.setTextFill(Color.web("#0000D6")));
        return label;
    }
}

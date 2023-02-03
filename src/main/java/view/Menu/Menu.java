package view.Menu;

import control.MainProgram;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import view.AudioPlayer;

import java.io.FileNotFoundException;

/**
 * @author Viktor Näslund
 */

public class Menu extends Pane {
    private MainProgram mainProgram;
    private Image campaign;
    private Image campaignResize;
    private Image randomize;
    private Image randomizeResize;
    private Image help;
    private Image helpResize;
    private Image mazegen;
    private AudioPlayer audioPlayer;
    private RightPanel panel;



    private Image testImage;
    private Image testImageRezise;


    /**
     * Konstruktor som tar emot mainProgram, audioPlayer och panel
     * Kör sedan metoder för att länka Image-objekten med png-filer
     * @param mainProgram tas emot och sätts
     * @param audioPlayer tas emot och sätts
     * @param panel tas emot och sätts
     */
    public Menu(MainProgram mainProgram, AudioPlayer audioPlayer, RightPanel panel){
        this.mainProgram = mainProgram;
        this.audioPlayer = audioPlayer;
        this.panel = panel;
        this.setBackground(new Background(setBackground()));
        this.getChildren().addAll(getCampaignView(),getRandomizeView(),getHelpView(),getMazegenView(),getTestView(),getVictoryView());
        setBackground();
        setupImages();
    }

    /**
     * Metod som länkar Image-objekten till png-filer
     */
    public void setupImages(){
        mazegen = new Image("file:files/texts/MazegenTitel.png", 800, 600, false,false);
        campaign = new Image("file:files/texts/Campaign.png", 250, 30, false, false);
        campaignResize = new Image("file:files/texts/Campaign.png", 255, 33, false, false);
        randomize = new Image("file:files/texts/Randomize.png", 250, 30, false, false);
        randomizeResize = new Image("file:files/texts/Randomize.png", 255, 33, false, false);
        help = new Image("file:files/texts/Help.png", 250, 30, false, false);
        helpResize = new Image("file:files/texts/Help.png", 255, 33, false, false);
        testImage = new Image("file:files/texts/download.png", 250, 30, false, false);
        testImageRezise = new Image("file:files/texts/download.png", 255, 33, false, false);
    }

    /**
     * Metod som sätter bakgrundsbilden
     */
    public BackgroundImage setBackground(){
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return menuBackground;
    }

    public ImageView getMazegenView() {
        ImageView mazegenView = new ImageView(mazegen);
        mazegenView.setStyle("fx-background-color: transparent;");
        return mazegenView;
    }

    public ImageView getCampaignView() {
        ImageView campaignView = new ImageView(campaign);
        campaignView.setStyle("fx-background-color: transparent;");
        campaignView.setTranslateX(275);
        campaignView.setTranslateY(200);
        campaignView.toFront();
        campaignView.setOnMouseEntered(e -> {
            campaignView.setImage(campaignResize);
            campaignView.setTranslateX(273);
            campaignView.setTranslateY(197);
        });
        campaignView.setOnMouseExited(e -> {
            campaignView.setImage(campaign);
            campaignView.setTranslateX(275);
            campaignView.setTranslateY(200);
        });
        campaignView.setOnMouseClicked(e -> {
            try {
                mainProgram.changeToCampaign();
                audioPlayer.playLevelMusic("forest");
                panel.setTheTime(25);
                panel.resetTimerLabel();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        return campaignView;
    }

    public ImageView getRandomizeView() {
        ImageView randomizeView = new ImageView(randomize);
        randomizeView.setStyle("fx-background-color: transparent;");
        randomizeView.setTranslateX(275);
        randomizeView.setTranslateY(250);
        randomizeView.toFront();
        randomizeView.setOnMouseEntered(e -> {
            randomizeView.setImage(randomizeResize);
            randomizeView.setTranslateX(273);
            randomizeView.setTranslateY(247);
        });
        randomizeView.setOnMouseExited(e -> {
            randomizeView.setImage(randomize);
            randomizeView.setTranslateX(275);
            randomizeView.setTranslateY(250);
        });
        randomizeView.setOnMouseClicked(e -> {
            mainProgram.chooseDimension();
            audioPlayer.playButtonSound();
        });
        return randomizeView;
    }

    public ImageView getHelpView() {
        ImageView helpView = new ImageView(help);
        helpView.setStyle("fx-background-color: transparent;");
        helpView.setTranslateX(275);
        helpView.setTranslateY(300);
        helpView.toFront();
        helpView.setOnMouseEntered(e -> {
            helpView.setImage(helpResize);
            helpView.setTranslateX(273);
            helpView.setTranslateY(297);
        });
        helpView.setOnMouseExited(e -> {
            helpView.setImage(help);
            helpView.setTranslateX(275);
            helpView.setTranslateY(300);
        });
        helpView.setOnMouseClicked(e -> {
            mainProgram.changeToHelp();
            audioPlayer.playButtonSound();
        });
        return helpView;
    }

    public ImageView getTestView() {
        ImageView testView = new ImageView(testImage);
        testView.setStyle("fx-background-color: transparent;");
        testView.setTranslateX(275);
        testView.setTranslateY(347);
        testView.toFront();
        testView.setOnMouseEntered(e -> {
            testView.setImage(testImageRezise);
            testView.setTranslateX(273);
            testView.setTranslateY(347);
        });
        testView.setOnMouseExited(e -> {testView.setImage(testImage);
            testView.setTranslateX(275);
            testView.setTranslateY(350);
        });
        testView.setOnMouseClicked(e -> {
            mainProgram.showHighScoreList();
            audioPlayer.playButtonSound();
        });
        return testView;
    }

    public ImageView getVictoryView() {
        ImageView victoryView = new ImageView(testImage);
        victoryView.setStyle("fx-background-color: transparent;");
        victoryView.setTranslateX(275);
        victoryView.setTranslateY(397);
        victoryView.toFront();
        victoryView.setOnMouseEntered(e -> {
            victoryView.setImage(testImageRezise);
            victoryView.setTranslateX(273);
            victoryView.setTranslateY(397);
        });
        victoryView.setOnMouseExited(e -> {victoryView.setImage(testImage);
            victoryView.setTranslateX(275);
            victoryView.setTranslateY(400);
        });
        victoryView.setOnMouseClicked(e -> {
            mainProgram.showVcitoryScene();
            audioPlayer.playButtonSound();
        });
        return victoryView;
    }
}

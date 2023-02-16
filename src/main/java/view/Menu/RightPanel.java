package view.Menu;

import control.MainProgram;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import control.AudioPlayer;

import java.io.FileNotFoundException;

/**
 * @author Filip Örnling
 * @edit Viktor Näslund, Sebastian Helin
 */

public class RightPanel extends GridPane {

    private final MainProgram mainProgram;
    private Image levelNumber, heart, soundImage, musicImage;
    private final ImageView currentLevelView, currentHeartView, pickaxeView, soundView, musicView, emptyView;
    private final Label levelLabel, heartLabel, pickaxeLabel, soundLabel, musicLabel, timerLabel;
    private boolean soundOn, musicOn;

    private final IntegerProperty timeSeconds = new SimpleIntegerProperty(15);
    private Timeline timeline = new Timeline();


    /**
     * Instansierar objekten och lägger till bilder och labels på scenen
     * @param gameMode    Kollar ifall användaren valt randomized eller kampanjläge
     * @throws FileNotFoundException
     */
    public RightPanel(String gameMode) throws FileNotFoundException { //TODO ska gameMode va string?
        this.mainProgram = MainProgram.getMainProgram();

        soundOn = true;
        musicOn = true;

        Image imageMenu = new Image("file:files/texts/Menu.png", 90, 30, false, false);
        ImageView menuView = new ImageView(imageMenu);

        Image emptySprite = new Image("file:files/emptySprite.png", 30, 30, false, false);
        emptyView = new ImageView(emptySprite);

        Image pickaxe = new Image("file:files/items/pickaxe.png", 30, 30, false, false);
        pickaxeView = new ImageView(pickaxe);
        pickaxeLabel = new Label();
        pickaxeLabel.setGraphic(emptyView);

        levelNumber = new Image("file:files/levelcounter/" + gameMode + ".png", 90, 30, false, false);
        currentLevelView = new ImageView(levelNumber);
        levelLabel = new Label();
        levelLabel.setGraphic(currentLevelView);

        soundImage = new Image("file:files/soundbuttons/soundon.png", 30, 30, false, false);
        soundView = new ImageView(soundImage);
        soundLabel = new Label();
        soundLabel.setTranslateX(30);
        soundLabel.setTranslateY(440);
        soundLabel.setGraphic(soundView);

        musicImage = new Image("file:files/soundbuttons/musicon.png", 30, 30, false, false);
        musicView = new ImageView(musicImage);
        musicLabel = new Label();
        musicLabel.setTranslateX(60);
        musicLabel.setTranslateY(440);
        musicLabel.setGraphic(musicView);

        heartLabel = new Label();
        currentHeartView = new ImageView(heart);
        if (!gameMode.equals("Random")) {
            heart = new Image("file:files/hearts/3heart.png", 90, 30, false, false);
            heartLabel.setGraphic(currentHeartView);
            add(heartLabel, 0, 2);
        }

        timerLabel = new Label();
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.WHITE);
        Font font = Font.loadFont("file:files/fonts/PressStart2P.ttf", 35);
        timerLabel.setFont(font);
        timerLabel.setTranslateY(200);
        timerLabel.setTranslateX(8);

        add(timerLabel, 0, 4);
        add(levelLabel, 0, 1);
        add(pickaxeLabel, 0, 3);

        soundLabel.setOnMouseClicked(e -> soundLabelClicked());
        musicLabel.setOnMouseClicked(e -> musicLabelClicked());

        add(soundLabel, 0, 4);
        add(musicLabel, 0, 4);

        menuView.setOnMouseClicked(e -> mainMenuClicked());
        add(menuView, 0, 0);

    }

    /**
     * Slår på/av spelljud
     */
    private boolean soundLabelClicked() {
        if (soundOn) {
            soundImage = new Image("file:files/soundbuttons/soundoff.png", 30, 30, false, false);
            AudioPlayer.muteSound(true);
            soundOn = false;
        } else {
            soundImage = new Image("file:files/soundbuttons/soundon.png", 30, 30, false, false);
            AudioPlayer.muteSound(false);
            soundOn = true;
        }
        soundView.setImage(soundImage);
        soundLabel.setGraphic(soundView);
        return soundOn;
    }

    /**
     * Slår på/av musik
     */
    private boolean musicLabelClicked() {
        if (musicOn) {
            musicImage = new Image("file:files/soundbuttons/musicoff.png", 30, 30, false, false);
            AudioPlayer.muteMusic(true);
            musicOn = false;
        } else {
            musicImage = new Image("file:files/soundbuttons/musicon.png", 30, 30, false, false);
            AudioPlayer.muteMusic(false);
            musicOn = true;
        }
        musicView.setImage(musicImage);
        musicLabel.setGraphic(musicView);
        return musicOn;
    }

    public boolean getMusicOn() {
        return musicOn;
    }

    /**
     * Sätter en ny bild beroende på om man plockar upp/tappar ett liv
     *
     * @param amountOfHearts
     */
    public void changeHeartCounter(int amountOfHearts) {
        if (0 <= amountOfHearts && 3 >= amountOfHearts) {
            heart = new Image("file:files/hearts/" + amountOfHearts + "heart.png", 90, 30, false, false);
            currentHeartView.setImage(heart);
            heartLabel.setGraphic(currentHeartView);
        } else {
            throw new IllegalArgumentException("Invalid amount of hearts");
        }
    }

    /**
     * Lägger till yxan i guit.
     */
    public void addPickaxe() {
        pickaxeLabel.setGraphic(pickaxeView);
    }

    /**
     * Tar bort yxan från guit.
     */
    public void removePickaxe() {
        pickaxeLabel.setGraphic(emptyView);
    }

    /**
     * Byter bild beroende vilken nivå man befinner sig på
     *
     * @param number
     */

    public void changeLevelCounter(String number) { //TODO is number the right datatype?
        levelNumber = new Image("file:files/levelcounter/" + number + ".png", 90, 30, false, false);
        currentLevelView.setImage(levelNumber);
        levelLabel.setGraphic(currentLevelView);
    }

    /**
     * Byter scen till menyn
     */
    private void mainMenuClicked() {
        mainProgram.changeToMenu();
        AudioPlayer.playButtonSound();
        AudioPlayer.stopMusic();
    }

    /**
     * Pausar klockan vid avancemang till ny nivå
     */
    public boolean pauseClock() {
        timeline.stop();
        return timeline.getStatus().equals(Animation.Status.STOPPED);
    }

    /**
     * Sätter tiden som visuella klockan ska visa
     *
     * @param time
     */
    public void setTheTime(int time) {
        timeSeconds.set(time);
    }

    /**
     * Kör igång klockan när spelaren trycker på startknappen
     */
    public boolean resumeClock(int startTime) {
        timeSeconds.set(startTime);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(startTime), new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        return timeline.getStatus().equals(Animation.Status.RUNNING);
    }

    /**
     * Tasks run-metod som sätter den totala tiden det tog att spela
     * Pausar musik & visar Game Over texten
     */
    public void gameIsOver() {
        Platform.runLater(() -> {
            mainProgram.gameOver();
            AudioPlayer.playGameOverSound();
            AudioPlayer.stopMusic();
            removePickaxe();
        });
    }

    /**
     * Om spelaren har 5 sekunder kvar kallas denna metod från tråden
     */
    public void fiveSecLeft() {
        AudioPlayer.playTimeLeftSound();
        timerLabel.setStyle("-fx-text-fill: red;");
    }

    /**
     * Nollställer textens färg till vit och stoppar klockljudet
     */
    public void resetTimerLabel() {
        timerLabel.setStyle("-fx-text-fill: white;");
        AudioPlayer.stopClockSound();
    }
}
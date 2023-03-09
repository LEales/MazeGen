package view;

import control.MainProgram;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import model.Player;

/**
 * @author Max Tideman, Linus Regander
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables methods and dependencies
 */

public class VictoryScreen extends Pane {
    private final MainProgram mainProgram;
    private int totalTime, backSpaceCheck;
    private Label errorLabel, enterLabel, highScoreLabel, currCharLabel;
    private StringProperty firstProperty = new SimpleStringProperty("_");
    private StringProperty secondProperty = new SimpleStringProperty("_");
    private StringProperty thirdProperty = new SimpleStringProperty("_");
    private String current;

    private AnimationTimer timer;

    public VictoryScreen() {
        this.mainProgram = MainProgram.getMainProgram();
        this.setBackground(new Background(setBackground()));
        setupTextLabels();
        setupScene();

    }

    private void setupScene() {
        errorLabel = new Label("Not A Valid Input");
        errorLabel.setTranslateY(500);
        errorLabel.setTranslateX(240);
        errorLabel.setFont(getFont(20));
        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.web("#FF0004"));
        this.getChildren().add(errorLabel);

        highScoreLabel = new Label();
        highScoreLabel.setFont(getFont(36));
        highScoreLabel.setText("NEW HIGHSCORE");
        highScoreLabel.setTranslateX(170);
        highScoreLabel.setTranslateY(100);
        getChildren().add(highScoreLabel);

        AnimationTimer timer = new AnimationTimer() {
            private int hue = 0;
            private boolean visible = true;
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    hue = (hue + 10) % 360;
                    Color color = Color.hsb(hue, 1, 1);
                    String css = "-fx-text-fill: " + toWebColor(color) + ";";
                    highScoreLabel.setStyle(css);
                    visible = !visible;
                    highScoreLabel.setVisible(visible);
                    lastUpdate = now;
                }
            }
        };
        timer.start();
    }

    private String toWebColor(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        return String.format("#%02x%02x%02x", r, g, b);
    }


    private void setupTextLabels() {
        Label first = setupTextArea(315.0, 200.0);
        Label second = setupTextArea(375.0, 200.0);
        Label third = setupTextArea(435.0, 200.0);
        first.textProperty().bind(firstProperty);
        second.textProperty().bind(secondProperty);
        third.textProperty().bind(thirdProperty);

        this.getChildren().add(0, first);
        this.getChildren().add(1, second);
        this.getChildren().add(2, third);

        current = "first";
        createCharAnimation(first);

    }

    private void createCharAnimation(Label label) {
        if( 2 == backSpaceCheck) {
            return;
        }
        if(currCharLabel != null) {
            currCharLabel.setVisible(true);
        }
        currCharLabel = label;
        timer = new AnimationTimer() {
            private long lastUpdate;
            private boolean isLabelVisible;
            @Override
            public void handle(long now) {
                // Only update the visibility of the label once every 500 million nanoseconds (0.5 seconds)
                if (now - lastUpdate >= 500_000_000) {
                    isLabelVisible = !isLabelVisible;
                    label.setVisible(isLabelVisible);
                    lastUpdate = now;
                }
            }
        };
        timer.start();
    }

    public BackgroundImage setBackground() {
        return new BackgroundImage(new Image("file:files/MenuBackground.jpg", MainProgram.WIDTH, MainProgram.HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }


    private Label setupTextArea(double xValue, double yValue) {
        Label label = new Label();
        label.setTranslateX(xValue);
        label.setTranslateY(yValue);
        label.setFont(getFont(50));
        label.setTextFill(Color.web("#ffffff"));
        return label;
    }

    private Font getFont(int size) {
        return Font.loadFont("file:files/fonts/PressStart2P.ttf", size);
    }

    private void updateToScoreList() {
        String file = "files/ScoreList.dat";
        Player player = new Player(buildName(), totalTime, mainProgram.getLvlCleared());
        mainProgram.addPlayerToFile(player, file);
        mainProgram.showHighScoreList();
    }

    private String buildName() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstProperty.get()).append(secondProperty.get()).append(thirdProperty.get());
        return sb.toString();
    }

    public int setTime(int time) {
        totalTime = time;
        return totalTime;
    }

    private void changeCharAnimation() {
        timer.stop();
        int index = -1;

        switch (current) {
            case "first" -> index = 0;
            case "second" -> index = 1;
            case "third" -> index = 2;

        }
        createCharAnimation((Label) this.getChildren().get(index));
    }

    public void setTextCurrent(String code) {
        String temp = "";
        errorLabel.setVisible(false);

        switch (code) {
            case "BACK_SPACE" -> current = "BACK_SPACE";
            case "ENTER" -> current = "ENTER";
            case "invalid" -> {
                temp = current;
                current = "invalid";
            }
        }
        switch (current) {
            case "invalid" -> {
                current = temp;
                errorLabel.setVisible(!errorLabel.isVisible());
            }
            case "first" -> {
                firstProperty.set(code);
                current = "second";
                backSpaceCheck++;
                timer.stop();
            }
            case "second" -> {
                secondProperty.set(code);
                current = "third";
                backSpaceCheck++;

                timer.stop();
            }
            case "third" -> {
                thirdProperty.set(code);
                if (2 > backSpaceCheck) {
                    backSpaceCheck++;
                }
                timer.stop();
            }
            case "BACK_SPACE" -> {
                if (2 == backSpaceCheck) {
                    thirdProperty.set("_");
                    backSpaceCheck--;
                    current = "third";
                } else if (1 == backSpaceCheck) {
                    secondProperty.set("_");
                    backSpaceCheck--;
                    current = "second";
                } else if (0 == backSpaceCheck) {
                    firstProperty.set("_");
                    current = "first";
                }
            }
            case "ENTER" -> {
                updateToScoreList();
                firstProperty.set("_");
                secondProperty.set("_");
                thirdProperty.set("_");
                current = "first";
            }
        }
        changeCharAnimation();
    }

    public void startLabelTimer() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            enterLabel = new Label("Press Enter To Continue");
            enterLabel.setFont(getFont(20));
            enterLabel.setTextFill(Color.web("#ffffff"));
            getChildren().add(enterLabel);
        }));
        timeline.play();
    }
}

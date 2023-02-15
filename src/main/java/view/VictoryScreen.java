package view;

import control.MainProgram;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class VictoryScreen extends Pane {
    private MainProgram mainProgram;
    private int totalTime;
    private int backSpaceCheck;
    private Label errorLabel;
    private Label first;
    private Label second;
    private Label third;
    StringProperty firstProperty = new SimpleStringProperty("_");
    StringProperty secondProperty = new SimpleStringProperty("_");
    StringProperty thirdProperty = new SimpleStringProperty("_");

    private String current;


    public VictoryScreen() {
        this.mainProgram = MainProgram.getMainProgram();
        this.setBackground(new Background(setBackground()));
        setupTextLabels();
        setupScene();
        this.setOnMouseClicked(e -> mainProgram.showHighScoreList());
    }

    private void setupScene() {
        errorLabel = new Label("Not A Valid Input");
        errorLabel.setTranslateY(100);
        errorLabel.setTranslateX(240);
        errorLabel.setFont(getFont(20));
        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.web("#FF0004"));
        this.getChildren().add(errorLabel);
    }

    private void setupTextLabels() {
        first = setupTextArea(315.0, 200.0);
        second = setupTextArea(375.0, 200.0);
        third = setupTextArea(435.0, 200.0);
        first.textProperty().bind(firstProperty);
        second.textProperty().bind(secondProperty);
        third.textProperty().bind(thirdProperty);
        this.getChildren().add(0, first);
        this.getChildren().add(1, second);
        this.getChildren().add(2, third);
        current = "first";
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
        Player playerToAdd = new Player(buildName(), totalTime, mainProgram.getLvlCleared());
        ArrayList<Player> scoreList = new ArrayList<>();
        Player player;
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (null != (player = (Player) ois.readObject())) {
                scoreList.add(player);
            }
        } catch (Exception ignored) {

        }
        addToScoreList(scoreList, playerToAdd, file);
        mainProgram.showHighScoreList();
    }

    private String buildName() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstProperty.get()).append(secondProperty.get()).append(thirdProperty.get());
        return sb.toString();
    }

    private void addToScoreList(ArrayList<Player> scoreList, Player playerToAdd, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            if (10 == scoreList.size() && 0 < scoreList.get(9).compareTo(playerToAdd)) {
                scoreList.set(9, playerToAdd);
            } else {
                scoreList.add(playerToAdd);
            }
            Collections.sort(scoreList);
            for (Player current : scoreList) {
                if (null != current) {
                    oos.writeObject(current);
                }
            }
            oos.flush();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int setTime(int time) {
        totalTime = time;
        return totalTime;
    }

    public void setTextCurrent(String code) {
        String temp = "";
        errorLabel.setVisible(false);

        if (code.equals("BACK_SPACE")) {
            current = "BACK_SPACE";
        } else if (code.equals("ENTER")) {
            current = "ENTER";
        } else if (code.equals("invalid")) {
            temp = current;
            current = "invalid";
        }
        switch (current) {
            case "invalid":
                current = temp;
                errorLabel.setVisible(!errorLabel.isVisible());
                break;
            case "first":
                firstProperty.set(code);
                current = "second";
                backSpaceCheck++;
                break;
            case "second":
                secondProperty.set(code);
                current = "third";
                backSpaceCheck++;
                break;
            case "third":
                thirdProperty.set(code);
                if (2 > backSpaceCheck) {
                    backSpaceCheck++;
                }
                break;
            case "BACK_SPACE":
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
                break;
            case "ENTER":
                updateToScoreList();
                firstProperty.set("_");
                secondProperty.set("_");
                thirdProperty.set("_");
                current = "first";
                break;
        }
    }
}

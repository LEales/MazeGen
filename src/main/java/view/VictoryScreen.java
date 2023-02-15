package view;

import control.MainProgram;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Player;

import java.io.*;

public class VictoryScreen extends Pane {
    private MainProgram mainProgram;
    private int totalTime;
    private int scoreListCounter;
    private int backSpaceCheck;
    private Label errorLabel;
    private Label first;
    private Label second;
    private Label third;
    private String current;


    public VictoryScreen() {
        this.mainProgram = MainProgram.getMainProgram();
        this.setBackground(new Background(setBackground()));
        setupTextLabels();
        setupScene();

        this.setOnMouseClicked(e->mainProgram.showHighScoreList());
    }

    private void setupScene() {
        errorLabel = new Label("Not A Valid Input");
        errorLabel. setTranslateY(100);
        errorLabel.setTranslateX(240);
        errorLabel.setFont(getFont(20));
        errorLabel.setVisible(false);
        errorLabel.setTextFill(Color.web("#FF0004"));
        this.getChildren().add(errorLabel);
    }

    private void setupTextLabels() {
        first = setupTextArea("_",315,200);
        second = setupTextArea("_",375,200);
        third = setupTextArea("_",435,200);
        first.setId("first");
        second.setId("second");
        third.setId("third");
        this.getChildren().add(0,first);
        this.getChildren().add(1,second);
        this.getChildren().add(2,third);
        current = first.getId();
    }

    public BackgroundImage setBackground(){
        return new BackgroundImage(new Image("file:files/MenuBackground.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);    }


    private Label setupTextArea(String text, int xValue, int yValue) {
        Label label = new Label(text);
        label.setTranslateX(xValue);
        label.setTranslateY(yValue);
        label.setFont(getFont(50));
        label.setTextFill(Color.web("#ffffff"));
        return label;
    }

    private Font getFont(int size) {
        Font font;
        return font = Font.loadFont("file:files/fonts/PressStart2P.ttf",size);
    }

    private void updateToScoreList() {

        String file = "files/ScoreList.dat";
        System.out.println(buildName());
        Player playerToAdd = new Player(buildName(),totalTime, mainProgram.getLvlCleared());
        Player[] scoreList = new Player[10];
        Player player;
        int counter = 0;
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            while((player = (Player)ois.readObject())!=null){
                scoreList[counter] = player;
                counter++;
            }
        }catch (Exception e ){
            System.out.println("end of file");
        }
        if (scoreListCounter<10){
           addToScoreList(scoreList, counter,playerToAdd,file);
        } else {
            int indexToChangePLayer =11;
            indexToChangePLayer = findIndex(scoreList, indexToChangePLayer,playerToAdd);
            scoreList = insertNewPlayerToScorelist(indexToChangePLayer,scoreList,playerToAdd);
            addScore(scoreList, file);
        }
        mainProgram.showHighScoreList();
    }

    private String buildName() {
        Label label;
        label = (Label) this.getChildren().get(0);
        String s =label.getText();
        label = (Label) this.getChildren().get(1);
        s +=label.getText();
        label = (Label) this.getChildren().get(2);
        s += label.getText();
        return s;
    }

    private Player[] insertNewPlayerToScorelist(int indexToChangePLayer, Player[] scoreList, Player playerToAdd) {
        if (indexToChangePLayer<=10) {
            for (int i = scoreList.length - 1; i >= indexToChangePLayer; i--) {
                if (scoreList[i] != null) {
                    if (i == indexToChangePLayer) {
                        scoreList[i] = playerToAdd;
                    } else {
                        scoreList[i] = scoreList[i - 1];
                    }
                }
            }
        }
        return scoreList;
    }

    private int findIndex(Player[] scoreList, int indexToChangePLayer, Player playerToAdd) {
        for (int i = scoreList.length-1; i >= 0 ; i--) {
            if (scoreList[i]!=null) {
                System.out.println(scoreList[i].getPlayer()+" ---TIME: "+scoreList[i].getSeconds());
                if ((scoreList[i].getLvl() <= playerToAdd.getLvl())){
                    indexToChangePLayer = i;
                    if (playerToAdd.getSeconds() < scoreList[i].getSeconds()){
                        indexToChangePLayer = i;
                    }
                }
            }
        }
        return indexToChangePLayer;
    }

    private void addToScoreList(Player[] scoreList, int counter, Player playerToAdd, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            scoreList[counter] = playerToAdd;
            scoreList = sortList(scoreList);

            for (Player current : scoreList) {
                if (current!=null) {
                    oos.writeObject(current);
                }
            }
            oos.flush();
            oos.close();
            scoreListCounter++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addScore(Player[] scoreList, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for (Player score : scoreList) {
                if (score != null) {
                    oos.writeObject(score);
                }
            }
            oos.flush();
            oos.close();
            scoreListCounter++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Player[] sortList(Player[] scoreList) {
        for (int i = 0; i < scoreList.length; i++) {
            for (int j = i+1; j < scoreList.length; j++) {
                if (scoreList[i]!=null && scoreList[j]!=null) {
                    if ((scoreList[i].getLvl() < scoreList[j].getLvl())){
                        Player temp = scoreList[i];
                        scoreList[i] = scoreList[j];
                        scoreList[j] = temp;
                    }else if (scoreList[i].getLvl() == scoreList[j].getLvl()){
                        if (scoreList[i].getSeconds() > scoreList[j].getSeconds()){
                            Player temp = scoreList[i];
                            scoreList[i] = scoreList[j];
                            scoreList[j] = temp;
                        }
                    }
                }
            }
        }
        return scoreList;
    }

    public int setTime(int time) {
        totalTime = time;
        return totalTime;
    }

    public void setTextCurrent(String code) {
        String temp="";
        errorLabel.setVisible(false);

        if (code.equals("BACK_SPACE")){
            current="BACK_SPACE";
        }else if (code.equals("ENTER")){
            current = "ENTER";
        }else if (code.equals("invalid")){
            temp = current;
            current = "invalid";
        }
        switch (current){
            case "invalid":
                current = temp;
                errorLabel.setVisible(!errorLabel.isVisible());
                break;
            case "first":
                this.getChildren().remove(0);
                this.getChildren().add(0,setupTextArea(code,315,200));
                current = "second";
                backSpaceCheck++;
                break;
            case "second":
                this.getChildren().remove(1);
                this.getChildren().add(1,setupTextArea(code,375,200));
                current = "third";
                backSpaceCheck++;
                break;
            case "third":
                this.getChildren().remove(2);
                this.getChildren().add(2,setupTextArea(code,435,200));
                if (backSpaceCheck <2){
                    backSpaceCheck++;
                }
                break;
            case "BACK_SPACE":
                if (backSpaceCheck ==2){
                    this.getChildren().remove(2);
                    this.getChildren().add(2,setupTextArea("_",435,200));
                    backSpaceCheck--;
                    current = "third";
                }else if (backSpaceCheck ==1) {
                    this.getChildren().remove(1);
                    this.getChildren().add(1, setupTextArea("_", 375, 200));
                    backSpaceCheck--;
                    current = "second";
                }
                else if (backSpaceCheck ==0){
                    this.getChildren().remove(0);
                    this.getChildren().add(0,setupTextArea("_",315,200));
                    current ="first";
                }
                break;
            case "ENTER":
                updateToScoreList();
                resetLabels(0, 315, 200);
                resetLabels(1, 375, 200);
                resetLabels(2,435,200);
                current="first";
                break;
        }
    }

    private Node resetLabels(int i, int xValue, int yValue) {
        this.getChildren().remove(i);
        this.getChildren().add(i,setupTextArea("_",xValue,yValue));
        return this.getChildren().get(i);
    }


}

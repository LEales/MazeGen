package view;

import control.MainProgram;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.PlayerScore;

import java.io.*;

public class VictoryScreen extends Pane {
    private MainProgram mainProgram;
    private AudioPlayer audioPlayer;
    private TextField textField;
    private int[] totalTime;
    private int scoreListCounter;

    private Label first;
    private Label second;
    private Label third;
    private int backspcaeCheck=0;
    private String current;
    private String remover = "third";


    public VictoryScreen(MainProgram mainProgram, AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
        this.mainProgram = mainProgram;
        this.setBackground(new Background(setBackground()));

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

        this.setOnMouseClicked(e->mainProgram.showHighScoreList());
        //this.getChildren().addAll(setupTextArea(),setupSendButton());
    }
    public BackgroundImage setBackground(){
        return new BackgroundImage(new Image("file:files/MenuBackground.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);    }

    private Label setupTextArea(String text, int xValue, int yValue) {
        Font font = Font.loadFont("file:files/fonts/PressStart2P.ttf",50);
        Label label = new Label(text);
        label.setTranslateX(xValue);
        label.setTranslateY(yValue);
        label.setFont(font);
        label.setTextFill(Color.web("#ffffff"));
        /*textField = new TextField();
        textField.setMaxHeight(50);
        textField.setMaxWidth(450);
        textField.setTranslateY(300);
        textField.setTranslateX(200);*/
        return label;
    }

    private void updateToScoreList() {

        String file = "files/ScoreList.dat";
        System.out.println(buildName());
        PlayerScore playerToAdd = new PlayerScore(buildName(),totalTime[0],totalTime[1],totalTime[2], mainProgram.getLvlCleared());
        PlayerScore[] scoreList = new PlayerScore[10];
        PlayerScore player;
        int counter = 0;
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            while((player = (PlayerScore)ois.readObject())!=null){
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

    private PlayerScore[] insertNewPlayerToScorelist(int indexToChangePLayer, PlayerScore[] scoreList, PlayerScore playerToAdd) {
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

    private int findIndex(PlayerScore[] scoreList, int indexToChangePLayer, PlayerScore playerToAdd) {
        for (int i = scoreList.length-1; i >= 0 ; i--) {
            if (scoreList[i]!=null) {
                System.out.println(scoreList[i].getPlayer()+" ---TIME: "+scoreList[i].getTotalTimeInSeconds());
                if ((scoreList[i].getLvl() <= playerToAdd.getLvl())){
                    indexToChangePLayer = i;
                    if (playerToAdd.getTotalTimeInSeconds() < scoreList[i].getTotalTimeInSeconds()){
                        indexToChangePLayer = i;
                    }
                }
            }
        }
        return indexToChangePLayer;
    }

    private void addToScoreList(PlayerScore[] scoreList, int counter, PlayerScore playerToAdd, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            scoreList[counter] = playerToAdd;
            scoreList = sortList(scoreList);

            for (PlayerScore current : scoreList) {
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

    private void addScore(PlayerScore[] scoreList, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for (PlayerScore score : scoreList) {
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

    private PlayerScore[] sortList(PlayerScore[] scoreList) {
        for (int i = 0; i < scoreList.length; i++) {
            for (int j = i+1; j < scoreList.length; j++) {
                if (scoreList[i]!=null && scoreList[j]!=null) {
                    if ((scoreList[i].getLvl() < scoreList[j].getLvl())){
                        PlayerScore temp = scoreList[i];
                        scoreList[i] = scoreList[j];
                        scoreList[j] = temp;
                    }else if (scoreList[i].getLvl() == scoreList[j].getLvl()){
                        if (scoreList[i].getTotalTimeInSeconds() > scoreList[j].getTotalTimeInSeconds()){
                            PlayerScore temp = scoreList[i];
                            scoreList[i] = scoreList[j];
                            scoreList[j] = temp;
                        }
                    }
                }
            }
        }
        return scoreList;
    }

    public int[] setTime(int[] time) {
        this.totalTime = new int[3];
        totalTime[0] = time[0];
        totalTime[1] = time[1];
        totalTime[2] = time[2];
        return totalTime;
    }

    public void setTextCurrent(String code) {

        if (code.equals("BACK_SPACE")){
            current="BACK_SPACE";
        }else if (code.equals("ENTER")){
            current = "ENTER";
        }
        switch (current){
            case "first":
                this.getChildren().remove(0);
                this.getChildren().add(0,setupTextArea(code,315,200));
                current = "second";
                backspcaeCheck ++;
                break;
            case "second":
                this.getChildren().remove(1);
                this.getChildren().add(1,setupTextArea(code,375,200));
                current = "third";
                backspcaeCheck ++;
                break;
            case "third":
                this.getChildren().remove(2);
                this.getChildren().add(2,setupTextArea(code,435,200));
                if (backspcaeCheck<2){
                    backspcaeCheck ++;
                }
                break;
            case "BACK_SPACE":
                if (backspcaeCheck==2){
                    this.getChildren().remove(2);
                    this.getChildren().add(2,setupTextArea("_",435,200));
                    backspcaeCheck --;
                    current = "third";
                }else if (backspcaeCheck==1) {
                    this.getChildren().remove(1);
                    this.getChildren().add(1, setupTextArea("_", 375, 200));
                    backspcaeCheck--;
                    current = "second";
                }
                else if (backspcaeCheck==0){
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


       /* current = setupTextArea(first,315,200);
        current.setId("first");
        current.setText(code.getChar());
        this.getChildren().clear();
        this.getChildren().addAll(current, setupTextArea(second,375,200), setupTextArea(third,435,200));

        current = setupTextArea(second,315,200);
        current.setId("second");
        current.setText(code.getChar());
        this.getChildren().clear();
        this.getChildren().addAll(current, setupTextArea(second,375,200), setupTextArea(third,435,200));

        current = setupTextArea(second,315,200);
        current.setId("second");
        current.setText(code.getChar());
        this.getChildren().clear();
        this.getChildren().addAll(current, setupTextArea(second,375,200), setupTextArea(third,435,200));*/
    }

    private Node resetLabels(int i, int xValue, int yValue) {
        this.getChildren().remove(i);
        this.getChildren().add(i,setupTextArea("_",xValue,yValue));
        return this.getChildren().get(i);
    }


}

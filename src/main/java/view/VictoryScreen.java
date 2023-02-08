package view;

import control.MainProgram;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import view.Menu.PlayerScore;

import java.io.*;

public class VictoryScreen extends Pane {
    private MainProgram mainProgram;
    private AudioPlayer audioPlayer;
    private TextField textField;
    private int[] totalTime;
    private int scoreListCounter;

    public VictoryScreen(MainProgram mainProgram, AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
        this.mainProgram = mainProgram;
        this.setBackground(new Background(setBackground()));
        this.getChildren().addAll(setupTextArea(),setupSendButton());
    }
    public BackgroundImage setBackground(){
        return new BackgroundImage(new Image("file:files/MenuBackground.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }

    private TextField setupTextArea() {
        textField = new TextField();
        textField.setMaxHeight(50);
        textField.setMaxWidth(450);
        textField.setTranslateY(300);
        textField.setTranslateX(200);
        return textField;
    }

    private Button setupSendButton() {
        Button button = new Button("Send");
        button.setMaxHeight(25);
        button.setMaxWidth(50);
        button.setTranslateY(350);
        button.setTranslateX(200);
        button.setOnMouseClicked(e-> updateToScoreList());
        return button;
    }

    private void updateToScoreList() {

        String file = "files/ScoreList.dat";
        PlayerScore playerToAdd = new PlayerScore(textField.getText(),totalTime[0],totalTime[1],totalTime[2], mainProgram.getLvlCleared());
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
            scoreList = checkIfToAddNewPlayer(indexToChangePLayer,scoreList,playerToAdd);
            addScore(scoreList, file);
        }
        mainProgram.showHighScoreList();
    }

    private PlayerScore[] checkIfToAddNewPlayer(int indexToChangePLayer, PlayerScore[] scoreList, PlayerScore playerToAdd) {
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
        for (int i = 0; i < scoreList.length ; i++) {
            if (scoreList[i]!=null) {
                if (playerToAdd.getTotalTimeInSeconds() < scoreList[i].getTotalTimeInSeconds()){
                    indexToChangePLayer =i;
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
}

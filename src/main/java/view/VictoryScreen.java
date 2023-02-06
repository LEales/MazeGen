package view;

import control.MainProgram;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import view.Menu.PlayerScore;

import java.io.*;

public class VictoryScreen extends Pane {
    private MainProgram mainProgram;
    private AudioPlayer audioPlayer;
    private TextArea textArea;
    private int[] totalTime;
    private int scoreListCounter;
    private int counter;
    public VictoryScreen(MainProgram mainProgram, AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
        this.mainProgram = mainProgram;
        this.setBackground(new Background(setBackground()));
        setupScreen();
    }
    public BackgroundImage setBackground(){
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return menuBackground;
    }

    private void setupScreen() {
        textArea = new TextArea();
        textArea.setMaxHeight(50);
        textArea.setMaxWidth(450);
        textArea.setTranslateY(300);
        textArea.setTranslateX(200);

        Button button = new Button("Send");
        button.setMaxHeight(25);
        button.setMaxWidth(50);
        button.setTranslateY(350);
        button.setTranslateX(200);

        button.setOnMouseClicked(e-> addToScoreList());

        this.getChildren().addAll(textArea,button);
    }

    private void addToScoreList() {
        //TODO skapa dat fill och kontrollera den
        //System.out.println("Hour :"+totalTime[2]);
        String obj = "files/ScoreList.dat";
        PlayerScore playerScore = new PlayerScore(textArea.getText(),totalTime[0],totalTime[1],totalTime[2]);
        PlayerScore[] scoreList = new PlayerScore[10];
        PlayerScore player;
        int counter = 0;
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(obj)))){
            while((player = (PlayerScore)ois.readObject())!=null){
                scoreList[counter] = player;
                counter++;
            }
        }catch (Exception e ){
            System.out.println("end of file");
        }
        if (scoreListCounter<10){
            try {// TODO LÄSS FÖRST IN dat filen sedan lägg till i arrayen sedan skriv över den gamla filen
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(obj)));


                scoreList[counter] = playerScore;
                for (int i = 0; i < scoreList.length; i++) {
                    for (int j = i+1; j < scoreList.length; j++) {
                        if (scoreList[i]!=null && scoreList[j]!=null) {
                            if (scoreList[i].getTotalTimeInSeconds() > scoreList[j].getTotalTimeInSeconds()) {
                                PlayerScore temp = scoreList[i];
                                scoreList[i] = scoreList[j];
                                scoreList[j] = temp;
                            }
                        }
                    }
                }


                for (PlayerScore current : scoreList) {
                    if (current!=null) {
                        oos.writeObject(current);
                    }
                }

                oos.flush();
                oos.close();
                scoreListCounter++;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {
            int indexToChangePLayer =11;

            for (int i = 0; i < scoreList.length ; i++) {
                if (scoreList[i]!=null) {
                    if (playerScore.getTotalTimeInSeconds() < scoreList[i].getTotalTimeInSeconds()){
                        indexToChangePLayer =i;
                    }
                }
            }
            if (indexToChangePLayer<=10) {
                for (int i = scoreList.length - 1; i >= indexToChangePLayer; i--) {
                    if (scoreList[i] != null) {
                        if (i == indexToChangePLayer) {
                            scoreList[i] = playerScore;
                        } else {
                            scoreList[i] = scoreList[i - 1];
                        }
                    }
                }
            }
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(obj)));
                for (int i = 0; i < scoreList.length; i++) {
                    if (scoreList[i]!=null){
                        oos.writeObject(scoreList[i]);
                    }
                }
                oos.flush();
                oos.close();
                scoreListCounter++;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        mainProgram.addToScoreList(textArea.getText(),totalTime);
        mainProgram.showHighScoreList();
    }

    public int[] setTime(int[] time) {
        this.totalTime = new int[3];
        totalTime[0] = time[0];
        totalTime[1] = time[1];
        totalTime[2] = time[2];
        return totalTime;
    }
}

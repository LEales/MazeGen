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
        try {
            if (scoreListCounter==0){
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(obj)));
                oos.writeObject(playerScore);
                oos.flush();
                oos.close();
                scoreListCounter++;
            }else {
                PlayerScore[] scoreList = new PlayerScore[10];
                PlayerScore player;
                try{
                    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(obj)));
                    int counter = 0;
                    while((player = (PlayerScore)ois.readObject())!=null){
                        scoreList[counter] = player;
                        counter++;
                    }
                    for (int i = 0; i < 10; i++) {
                        if (scoreList[i]!=null) {
                            System.out.println(scoreList[i].getPlayer());
                        }
                    }
                    ois.close();
                }catch (Exception e ){
                    System.out.println("end of file");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainProgram.addToScoreList(textArea.getText(),totalTime);
        mainProgram.changeToMenu();
    }

    public int[] setTime(int[] time) {
        System.out.println(time[0]);
        this.totalTime = new int[3];
        totalTime[0] = time[0];
        totalTime[1] = time[1];
        totalTime[2] = time[2];
        return totalTime;
    }
}

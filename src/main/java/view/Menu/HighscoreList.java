package view.Menu;

import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import view.AudioPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class HighscoreList extends VBox{
    private MainProgram mainProgram;
    private AudioPlayer audioPlayer;

    public HighscoreList(MainProgram mainProgram, AudioPlayer audioPlayer) {
        this.setOnMouseClicked(e->mainProgram.changeToMenu());
        this.audioPlayer = audioPlayer;
        this.mainProgram = mainProgram;
        this.setBackground(new Background(setBackground()));
        setupHighscoreList();
    }
    public int setupHighscoreList (){
        //TODO fixa så att den läser in från .dat filen
        String obj = "files/ScoreList.dat";
        PlayerScore scoreList;
        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(obj)));
            scoreList = (PlayerScore)ois.readObject();
            System.out.println(scoreList.getPlayer());
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 10; i++) {
            Label label = createLabels(scoreList.getPlayer());
            this.getChildren().add(i,label );
        }
        return this.getChildren().size();
    }
    public Label createLabels(String player){
        Label label2 = new Label(player);
        label2.setTranslateX(350);
        label2.setTextFill(Color.color(1,1,1));
        label2.setFont(Font.font("verdana", null, FontPosture.REGULAR,20));
        return label2;
    }
    public BackgroundImage setBackground(){
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return menuBackground;
    }

    public void controlList(String text, int[] totalTime) {
    }
}

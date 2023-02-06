package view.Menu;

import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Label[] labelArr = new Label[10];

    private Image image;
    private ImageView imageView = new ImageView(image);

    public HighscoreList(MainProgram mainProgram, AudioPlayer audioPlayer) {
        this.setOnMouseClicked(e->backToMenu());
        this.audioPlayer = audioPlayer;
        this.mainProgram = mainProgram;
        this.setBackground(new Background(setBackground()));
        this.getChildren().add(sutupImage());
    }

    private ImageView sutupImage() {
       image = new Image("file:files/texts/Highscore.png", 255, 33, false, false);
       return imageView = new ImageView(image);
    }

    private void backToMenu() {
        cleaChildren(true);
        mainProgram.changeToMenu();
    }

    private boolean cleaChildren(boolean b) {
        if (b){
            this.getChildren().clear();
            return true;
        }
        return false;
    }

    public int setupHighscoreList (){
        String file = "files/ScoreList.dat";
        PlayerScore[] scoreList = new PlayerScore[10];
        PlayerScore player;
        int counter = 0;
        try{
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            while((player = (PlayerScore)ois.readObject())!=null){
                scoreList[counter] = player;
                labelArr[counter]=new Label(player.getPlayer());
                counter++;
            }
            ois.close();
        }catch (Exception e ){
            //System.out.println("end of file");
        }

        for (int i = 0; i < 10; i++) {
            if (scoreList[i]!=null) {
                Label label = createLabels((i+1)+": "+scoreList[i].getPlayer()+ " PLAYERS TIME: "+ scoreList[i].getTotalTimeInSeconds());
                this.getChildren().add(i, label);
            }else {
                Label label = createLabels((i+1)+": TO BE DECIDED");
                this.getChildren().add(i, label);
            }
        }
        return this.getChildren().size();
    }
    public Label createLabels(String player){
        Label label2 = new Label(player);
        label2.setTranslateX(300);
        label2.setTranslateY(180);
        label2.setTextFill(Color.color(1,.4,1));
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

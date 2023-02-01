package view.Menu;

import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import view.AudioPlayer;

public class highscoreList extends VBox{
    private MainProgram mainProgram;
    private AudioPlayer audioPlayer;

    public highscoreList(MainProgram mainProgram, AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
        this.mainProgram = mainProgram;
        this.setBackground(new Background(setBackground()));
        setupHighscoreList();
    }
    public int setupHighscoreList (){
        //TODO fixa så att den läser in från .dat filen
        for (int i = 0; i < 10; i++) {
            Label label = createLabels("eeeeeeee");
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
}

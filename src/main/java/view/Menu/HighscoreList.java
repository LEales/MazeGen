package view.Menu;

import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Player;
import view.AudioPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class HighscoreList extends HBox{
    private MainProgram mainProgram;
    private Label[] labelArr = new Label[10];

    private VBox nameVbox;
    private VBox lvlVbox;
    private VBox timeVbox;
    private Image image;
    private ImageView imageView = new ImageView(image);

    public HighscoreList() {
        this.setOnMouseClicked(e->backToMenu());
        this.mainProgram = MainProgram.getMainProgram();
        this.setBackground(new Background(setBackground()));
    }

    private void setupVBoxes() {
        nameVbox = new VBox();
        nameVbox.setTranslateX(70);
        nameVbox.setTranslateY(165);
        this.getChildren().add(nameVbox);
        lvlVbox = new VBox();
        lvlVbox.setTranslateX(140);
        lvlVbox.setTranslateY(165);
        this.getChildren().add(lvlVbox);
        timeVbox = new VBox();
        timeVbox.setTranslateX(210);
        timeVbox.setTranslateY(165);
        this.getChildren().add(timeVbox);
    }

    private ImageView setupImage() {
        image = new Image("file:files/texts/Highscore.png", 255, 33, false, false);
        imageView = new ImageView(image);
        imageView.setTranslateX(0);
        imageView.setTranslateY(0);
        return imageView;
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
        setupVBoxes();
        String file = "files/ScoreList.dat";
        Player[] scoreList = new Player[10];
        Player player;
        int counter = 0;
        try{
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            while((player = (Player)ois.readObject())!=null){
                scoreList[counter] = player;
                labelArr[counter]=new Label(player.getPlayer());
                counter++;
            }
            ois.close();
        }catch (Exception e ){
            System.out.println("end of file");
        }

        for (int i = 0; i < 10; i++) {
            if (scoreList[i]!=null) {
                //Label label = createLabels((i+1)+": "+scoreList[i].getPlayer()+"    (LVL)   "+ scoreList[i].getLvl() +" // PLAYERS TIME: "+ scoreList[i].getTotalTimeInSeconds());
                Label label = createLabels((i+1)+": "+scoreList[i].getPlayer(),0, 0);
                Label label2 = createLabels(" LVL CLEARED: "+scoreList[i].getLvl(),0, 0);
                Label label3 = createLabels(" TIME: "+scoreList[i].getSeconds(),0, 0);
                nameVbox.getChildren().add(label);
                lvlVbox.getChildren().add(label2);
                timeVbox.getChildren().add(label3);
            }else {
                Label label = createLabels((i+1)+": ",0, 0);
                nameVbox.getChildren().add(label);
            }
        }
        return counter;
    }
    public Label createLabels(String text, int positionX, int positionY){
        Font font = Font.loadFont("file:files/fonts/PressStart2P.ttf",18);
        Label label2 = new Label(text);
        label2.setTranslateX(positionX);
        label2.setTranslateY(positionY);
        label2.setTextFill(Color.color(1,1,1));
        label2.setFont(font);
        return label2;
    }
    public BackgroundImage setBackground(){
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/HighscoreBackground.png",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return menuBackground;
    }

}

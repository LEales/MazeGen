package view;

import control.MainProgram;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.*;

public class VictoryScreen extends Pane {
    private MainProgram mainProgram;
    private AudioPlayer audioPlayer;
    private TextArea textArea;
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
        button.setOnMouseClicked(e->CreateFile());

        this.getChildren().addAll(textArea,button);
    }

    private void CreateFile() {
        try {
            DataOutputStream dos = new DataOutputStream( new BufferedOutputStream(new FileOutputStream("files//Highscore")));
            dos.writeBytes(textArea.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

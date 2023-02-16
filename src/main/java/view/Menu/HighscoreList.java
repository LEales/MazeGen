package view.Menu;

import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Player;

import java.io.*;

public class HighscoreList extends HBox {
    private final MainProgram mainProgram;
    private Label[] labelArr = new Label[10];

    private VBox nameVbox;
    private VBox lvlVbox;
    private VBox timeVbox;

    public HighscoreList() {
        this.setOnMouseClicked(e -> backToMenu());
        this.mainProgram = MainProgram.getMainProgram();
        this.setBackground(new Background(setBackground()));
    }

    private void setupVBoxes() {
        nameVbox = new VBox();
        nameVbox.setTranslateX(55.0);
        nameVbox.setTranslateY(165.0);
        this.getChildren().add(nameVbox);
        lvlVbox = new VBox();
        lvlVbox.setTranslateX(125.0);
        lvlVbox.setTranslateY(165.0);
        this.getChildren().add(lvlVbox);
        timeVbox = new VBox();
        timeVbox.setTranslateX(195.0);
        timeVbox.setTranslateY(165.0);
        this.getChildren().add(timeVbox);
    }

    private void backToMenu() {
        cleaChildren(true);
        mainProgram.changeToMenu();
    }

    private boolean cleaChildren(boolean b) {
        if (b) {
            this.getChildren().clear();
            return true;
        }
        return false;
    }

    public int setupHighscoreList() {
        setupVBoxes();
        String file = "files/ScoreList.dat";
        Player[] scoreList = new Player[10];
        Player player;
        int counter = 0;
        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            while (null != (player = (Player) ois.readObject())) {
                if (counter == 10) break;
                scoreList[counter] = player;
                labelArr[counter++] = new Label(player.getPlayer());
            }
            ois.close();
        } catch (IOException | ClassNotFoundException ignored) {

        }
        for (int i = 0; i < labelArr.length; i++) {
            if (null != scoreList[i]) {
                Label label = createLabels(String.format("%3d : %s", (i + 1), scoreList[i].getPlayer()), 0, 0);
                Label label2 = createLabels(String.format(" LEVEL: %2d", scoreList[i].getLvl()), 0, 0);
                Label label3 = createLabels(String.format(" TIME: %4d", scoreList[i].getSeconds()), 0, 0);
                nameVbox.getChildren().add(label);
                lvlVbox.getChildren().add(label2);
                timeVbox.getChildren().add(label3);
            } else {
                Label label = createLabels(String.format("%3d : ", (i + 1)), 0, 0);
                nameVbox.getChildren().add(label);
            }
        }
        return counter;
    }

    private Label createLabels(String text, int positionX, int positionY) {
        Font font = Font.loadFont("file:files/fonts/PressStart2P.ttf", 18);
        Label label = new Label(text);
        label.setTranslateX(positionX);
        label.setTranslateY(positionY);
        label.setTextFill(Color.color(1, 1, 1));
        label.setFont(font);
        return label;
    }

    private BackgroundImage setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/HighscoreBackground.png", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return menuBackground;
    }

}

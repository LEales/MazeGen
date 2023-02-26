package view.sandbox;

import control.AudioPlayer;
import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SandboxLoadNew extends Pane {
    private final MainProgram mainProgram;

    public SandboxLoadNew() {
        mainProgram = MainProgram.getMainProgram();
        setBackground();
        getChildren().addAll(getNew(), getLoad(), getReturn(), getMazeGenView());
    }
    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
    }

    private Label getNew() {
        Label newLabel = createLabel(310, 250, "New Maze");
        newLabel.setOnMouseClicked(e -> mainProgram.changeToSandBoxDimension());
        return newLabel;
    }

    private Label getLoad() {
         Label load = createLabel(300, 300, "Load Maze");
         load.setOnMouseClicked(e -> {
            mainProgram.changeToSandBoxLoader();
         });
         return load;
    }

    private Label getReturn() {
        Label aReturn = createLabel(320, 450, "Return");
        aReturn.setOnMouseClicked(e ->{
            AudioPlayer.playButtonSound();
            mainProgram.changeToMenu();
        });
        return aReturn;
    }

    private Label createLabel(double x, double y, String text) {
        Label label = new javafx.scene.control.Label(text);
        label.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 24));
        label.setTextFill(javafx.scene.paint.Color.web("#0000D6"));
        label.setTranslateX(x);
        label.setTranslateY(y);
        label.setOnMouseEntered(e -> label.setTextFill(javafx.scene.paint.Color.ORANGERED));
        label.setOnMouseExited(e -> label.setTextFill(Color.web("#0000D6")));
        return label;
    }

    private ImageView getMazeGenView() {
        Image mazegen = new Image("file:files/texts/MazegenTitel.png", 800, 600, false, false);
        ImageView mazegenView = new ImageView(mazegen);
        mazegenView.setStyle("fx-background-color: transparent;");
        return mazegenView;
    }
}

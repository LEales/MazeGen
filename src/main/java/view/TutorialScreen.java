package view;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class TutorialScreen extends Pane {

    private Label messageLabel = new Label();
    private ImageView arrow;
    private AnimationTimer animationTimer;
    private ImageView introView;

    public TutorialScreen() {
        arrow = new ImageView(new Image("file:files/arrow.png", 80, 80, false, false));
        setupScene();
    }


    private String nextMessage(String message) {
        return switch (message) {
            case "first" -> "HAHAHAHA WELCOME TO MY WORLD...";
            case "HAHAHAHA WELCOME TO MY WORLD..." -> "I AM THE GREAT AND POWERFUL SVEN...";
            case "I AM THE GREAT AND POWERFUL SVEN..." -> "I WILL TEACH YOU HOW TO PLAY THIS GAME...";
            case "I WILL TEACH YOU HOW TO PLAY THIS GAME..." ->
                    "BUT FIRST LET ME TELL YOU ABOUT MY TIME AT ELECTROLUX...";
            case "BUT FIRST LET ME TELL YOU ABOUT MY TIME AT ELECTROLUX..." -> "I WAS A SOFTWARE ENGINEER...";
            case "I WAS A SOFTWARE ENGINEER..." -> "EHHM I WAS A SOFTWARE ENGINEER...";
            case "EHHM I WAS A SOFTWARE ENGINEER..." -> "WE USED TO... NEVERMIND...";
            case "WE USED TO... NEVERMIND..." -> "ANYWAY...";
            case "ANYWAY..." -> "YOU ARE A SOFTWARE ENGINEER...";
            case "YOU ARE A SOFTWARE ENGINEER..." -> "NO, EHHM, WHERE WAS I, YOU ARE PLAYING MY GAME...";
            case "NO, EHHM, WHERE WAS I, YOU ARE PLAYING MY GAME..." -> "CLICK ON THE LADDER TO START THE GAME...";
            case "CLICK ON THE LADDER TO START THE GAME..." -> "COLLECT ALL THE CRYSTALS...";
            case "COLLECT ALL THE CRYSTALS..." -> "WATCH OUT FOR THE WALLS...";
            case "WATCH OUT FOR THE WALLS..." -> "IF YOU HIT A WALL YOU WILL DIE... OR LOSE A LIFE...";
            case "IF YOU HIT A WALL YOU WILL DIE... OR LOSE A LIFE..." -> "AND PRESS THE START LADDER AGAIN...";
            case "AND PRESS THE START LADDER AGAIN..." -> "NOW GO ON FINISH THE MAZE...";
            case "NOW GO ON FINISH THE MAZE..." -> "OR WHATEVER...";
            default -> null;
        };
    }

    private void onMouseClick(String message) {
        String next = nextMessage(message);
        if (null == next) {
            FadeTransition ft = new FadeTransition(Duration.millis(3000.0), introView);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.play();
            getChildren().remove(messageLabel);
            return;
        }
        setOnMouseClicked(e -> onMouseClick(next));
        messageLabel.setText(next);

        switch (next) {
            case "CLICK ON THE LADDER TO START THE GAME..." -> {
                setMessageLabelPosition(-100.0, -270.0, 0.0);
                animationUpDown();
                getChildren().add(arrow);
            }
            case "COLLECT ALL THE CRYSTALS..." -> setMessageLabelPosition(200.0, -37.0, 0.0);
            case "WATCH OUT FOR THE WALLS..." -> setMessageLabelPosition(82.0, 270.0, 0.0);
            case "IF YOU HIT A WALL YOU WILL DIE... OR LOSE A LIFE..." -> setMessageLabelPosition(563.0, -80.0, 180.0);
            case "AND PRESS THE START LADDER AGAIN..." -> setMessageLabelPosition(318.0, -70.0, 180.0);
            case "NOW GO ON FINISH THE MAZE..." -> {
                getChildren().remove(arrow);
                animationTimer.stop();
            }
        }
    }

    private void setMessageLabelPosition(double x, double y, double rotation) {
        arrow.setLayoutX(x);
        arrow.setLayoutY(y);
        arrow.setRotate(rotation);
    }

    private void setupScene() {
        introView = new ImageView(new Image("file:files/sven.png", 500, 500, false, false));
        introView.setStyle("fx-background-color: transparent;");
        setLayoutX(150);
        setLayoutY(150);
        FadeTransition ft = new FadeTransition(Duration.millis(8000.0), introView);
        getChildren().add(introView);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        messageLabel.setLayoutX(85);
        messageLabel.setLayoutY(100);
        messageLabel.setMaxSize(300, 200);
        messageLabel.setStyle("-fx-text-fill: black;");
        messageLabel.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 20));
        messageLabel.setWrapText(true);
        getChildren().add(messageLabel);
        setOnMouseClicked(e -> onMouseClick("first"));
    }

    private void animationUpDown() {
        boolean[] up = {true};
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (up[0]) {
                    arrow.setFitHeight(arrow.getFitHeight() + 0.5);
                    if (arrow.getFitHeight() > 120) {
                        up[0] = false;
                    }
                } else {
                    arrow.setFitHeight(arrow.getFitHeight() - 0.5);
                    if (arrow.getFitHeight() < 80) {
                        up[0] = true;
                    }
                }
            }
        };
        animationTimer.start();
    }
}

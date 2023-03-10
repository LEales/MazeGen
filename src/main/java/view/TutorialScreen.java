package view;

import control.MainProgram;
import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import model.enums.World;

public class TutorialScreen extends Pane {

    private Label messageLabel;
    private ImageView arrow;
    private ImageView moreTextArrow;
    private AnimationTimer animationTimer;
    private ImageView introView;

    public TutorialScreen() {
        arrow = new ImageView(new Image("file:files/arrow.png", 80, 80, false, false));
        moreTextArrow = new ImageView(new Image("file:files/tutarrow.png", 80, 80, false, false));
        messageLabel = new Label();
        introView = new ImageView(new Image("file:files/sven.png", 500, 500, false, false));
        introView.setStyle("fx-background-color: transparent;");
        setLayoutX(150);
        setLayoutY(150);
        messageLabel.setLayoutX(85);
        messageLabel.setLayoutY(100);
        messageLabel.setMaxSize(300, 200);
        messageLabel.setStyle("-fx-text-fill: black;");
        messageLabel.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 20));
        messageLabel.setWrapText(true);
        getChildren().add(messageLabel);
    }

    private String nextMessageFirst(String message) {
        if (null == message) return null;
        return switch (message) {
            case "HAHAHAHA WELCOME TO MY WORLD..." -> "I AM THE GREAT AND POWERFUL SVEN...";
            case "I AM THE GREAT AND POWERFUL SVEN..." -> "I WILL TEACH YOU HOW TO PLAY THIS GAME...";
            case "I WILL TEACH YOU HOW TO PLAY THIS GAME..." ->
                    "BUT FIRST LET ME TELL YOU ABOUT MY TIME AT ELECTROLUX...";
            case "BUT FIRST LET ME TELL YOU ABOUT MY TIME AT ELECTROLUX..." -> "I WAS A SOFTWARE ENGINEER...";
            case "I WAS A SOFTWARE ENGINEER..." -> "EHHM I WAS A SOFTWARE ENGINEER...";
            case "EHHM I WAS A SOFTWARE ENGINEER..." -> "WE USED TO... NEVERMIND...";
            case "WE USED TO... NEVERMIND..." -> "ANYWAY...";
            case "ANYWAY..." -> "NO, EHHM, WHERE WAS I, YOU ARE PLAYING MY GAME...";
            case "NO, EHHM, WHERE WAS I, YOU ARE PLAYING MY GAME..." -> "CLICK ON THE LADDER TO START THE GAME...";
            case "CLICK ON THE LADDER TO START THE GAME..." -> "COLLECT ALL THE CRYSTALS...";
            case "COLLECT ALL THE CRYSTALS..." -> "WATCH OUT FOR THE WALLS...";
            case "WATCH OUT FOR THE WALLS..." -> "IF YOU HIT A WALL YOU WILL DIE... OR LOSE A LIFE...";
            case "IF YOU HIT A WALL YOU WILL DIE... OR LOSE A LIFE..." -> "AND PRESS THE START LADDER AGAIN...";
            case "AND PRESS THE START LADDER AGAIN..." -> "NOW GO ON FINISH THE MAZE...";
            case "NOW GO ON FINISH THE MAZE..." -> "OR WHATEVER...";
            case "OR WHATEVER..." -> "last";
            default -> null;
        };
    }

    private String nextMessageSecond(String message) {
        if (null == message) return null;
        return switch (message) {
            case "LOOKS LIKE YOU MADE IT THIS FAR..." -> "I AM PROUD OF YOU...";
            case "I AM PROUD OF YOU..." -> "BUT YOU ARE NOT DONE YET...";
            case "BUT YOU ARE NOT DONE YET..." -> "NOW THERE ARE BREAKABLE WALLS...";
            case "NOW THERE ARE BREAKABLE WALLS..." -> "YOU CAN BREAK THEM BY PICKING UP THE AXE...";
            case "YOU CAN BREAK THEM BY PICKING UP THE AXE..." -> "AND IF YOU GOT HIT ON THE HEAD...";
            case "AND IF YOU GOT HIT ON THE HEAD..." -> "I'VE ADDED A HEART JUST FOR YOU...";
            default -> null;
        };
    }

    private String nextMessageThird(String message) {
        if (null == message) return null;
        return switch (message) {
            case "WOW LOOK AT YOU..." -> "YOU ARE REALLY GOOD AT THIS...";
            case "YOU ARE REALLY GOOD AT THIS..." -> "SO I ADDED GHOSTS...";
            case "SO I ADDED GHOSTS..." -> "BWAHAHAHAH...";
            default -> null;
        };
    }

    private void onMouseClickFirst(String message) {
        String next = nextMessageFirst(message);
        if ("last".equals(next)) {
            FadeTransition ft = removeTutorial();
            ft.play();
            ft.setOnFinished(e -> {
                getChildren().removeAll(arrow, introView);
                MainProgram mp = MainProgram.getMainProgram();
                mp.playWorldIntroAnimation(World.FOREST);
                mp.startLadderAnimation();
                mp.removeTutorialScreen();
            });
            getParent().setOnMouseClicked(null);
            return;
        }
        switch (next) {
            case "CLICK ON THE LADDER TO START THE GAME..." -> {
                setMessageLabelPosition(-100.0, 270.0, 0.0);
                animationUpDown();
                getChildren().add(arrow);
            }
            case "COLLECT ALL THE CRYSTALS..." -> setMessageLabelPosition(-37.0, 200.0, 0.0);
            case "WATCH OUT FOR THE WALLS..." -> setMessageLabelPosition(82.0, 270.0, 0.0);
            case "IF YOU HIT A WALL YOU WILL DIE... OR LOSE A LIFE..." -> setMessageLabelPosition(563.0, -80.0, 180.0);
            case "AND PRESS THE START LADDER AGAIN..." -> setMessageLabelPosition(-100.0, 270.0, 0.0);
            case "NOW GO ON FINISH THE MAZE..." -> setMessageLabelPosition(318.0, -70.0, 180.0);
            case "OR WHATEVER..." -> {
                getChildren().remove(arrow);
                animationTimer.stop();
            }
        }
        showMessage(next);
        if (getParent() != null) {
            getParent().setOnMouseClicked(e -> onMouseClickFirst(next));
        }
    }

    private void onMouseClickSecond(String message) {
        setOnMouseClicked(null);
        String next = nextMessageSecond(message);
        if (null == next) {
            FadeTransition ft = removeTutorial();
            ft.play();
            getChildren().remove(arrow);
            ft.setOnFinished(e -> {
                getChildren().remove(introView);
                this.toBack();
            });
            getParent().setOnMouseClicked(null);
            return;
        }
        switch (next) {
            case "NOW THERE ARE BREAKABLE WALLS..." -> {
                setMessageLabelPosition(-39.0, 120.0, 0.0);
                animationUpDown();
                getChildren().add(arrow);
            }
            case "YOU CAN BREAK THEM BY PICKING UP THE AXE..." -> setMessageLabelPosition(87.0, -115.0, 0.0);
            case "I'VE ADDED A HEART JUST FOR YOU..." -> {
                setMessageLabelPosition(-39.0, 188.0, 0.0);
            }
        }
        showMessage(next);
        if (getParent() != null) {
            getParent().setOnMouseClicked(e -> onMouseClickSecond(next));
        }
    }

    private void onMouseClickThird(String message) {
        setOnMouseClicked(null);
        String next = nextMessageThird(message);
        if (null == next) {
            FadeTransition ft = removeTutorial();
            ft.play();
            ft.setOnFinished(e -> {
                getChildren().remove(introView);
                this.toBack();
            });
            getParent().setOnMouseClicked(null);
            return;
        }
        showMessage(next);
        if (getParent() != null) {
            getParent().setOnMouseClicked(e -> onMouseClickThird(next));
        }
    }

    private void setMessageLabelPosition(double x, double y, double rotation) {
        arrow.setLayoutX(x);
        arrow.setLayoutY(y);
        arrow.setRotate(rotation);
    }

    public void setupFirstScene() {
        String first = "HAHAHAHA WELCOME TO MY WORLD...";
        FadeTransition ft = addTutorial();
        ft.play();
        ft.setOnFinished(e -> {
            createSkipLabel();
            showMessage(first);
            messageLabel.toFront();
            addMoreTextArrow();
            if (getParent() != null) {
                getParent().setOnMouseClicked(ex -> onMouseClickFirst(first));
            }
        });
    }

    public void setupSecondScene() {
        String first = "LOOKS LIKE YOU MADE IT THIS FAR...";
        FadeTransition ft = addTutorial();
        ft.play();
        ft.setOnFinished(e -> {
            createSkipLabel();
            showMessage(first);
            addMoreTextArrow();
            messageLabel.toFront();
            if (getParent() != null) {
                getParent().setOnMouseClicked(ex -> onMouseClickSecond(first));
            }
        });


    }

    public void setupThirdScene() {
        String first = "WOW LOOK AT YOU...";
        FadeTransition ft = addTutorial();
        ft.play();
        ft.setOnFinished(e -> {
            createSkipLabel();
            showMessage(first);
            addMoreTextArrow();
            messageLabel.toFront();
            if (getParent() != null) {
                getParent().setOnMouseClicked(ex -> onMouseClickThird(first));
            }
        });
    }

    private Image createSkipLabel() {
        Image image = new Image("file:files/skip_tutorial.png");
        ImageView imageView = new ImageView(image);
        imageView.setStyle("-fx-background-color: transparent;");
        imageView.setLayoutX(457.0);
        imageView.setLayoutY(380.0);
        imageView.setFitHeight(80);
        imageView.setFitWidth(130);
        imageView.setId("#skipLabel");
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), imageView);
        translateTransition.setFromY(0);
        translateTransition.setToY(-30);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.setInterpolator(Interpolator.EASE_BOTH);
        translateTransition.play();
        getChildren().add(imageView);
        return image;
    }

    private void showMessage(String message) {
        if (null == message) return;
        Timeline timeline = new Timeline();
        for (int i = 0; i < message.length(); i++) {
            int duration = i * 50;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(duration),
                    new KeyValue(messageLabel.textProperty(), message.substring(0, i + 1)));
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }

    private FadeTransition removeTutorial() {
        FadeTransition ft = new FadeTransition(Duration.millis(3000.0), introView);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        getChildren().removeAll(messageLabel, moreTextArrow, lookup("#skipLabel"));
        //getChildren().removeAll();
        setOnMouseClicked(null);
        return ft;
    }

    private FadeTransition addTutorial() {
        FadeTransition ft = new FadeTransition(Duration.millis(3000.0), introView);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        getChildren().add(introView);
        return ft;
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

    public void addMoreTextArrow() {
        getChildren().add(moreTextArrow);
        moreTextArrow.toFront();
        moreTextArrow.setX(arrow.getTranslateX() + 280);
        moreTextArrow.setY(arrow.getTranslateY() + 190);

        Timeline moreTextTimer = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(moreTextArrow.visibleProperty(), true)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(moreTextArrow.visibleProperty(), false)),
                new KeyFrame(Duration.seconds(1.0), new KeyValue(moreTextArrow.visibleProperty(), true))
        );
        moreTextTimer.setCycleCount(Timeline.INDEFINITE);
        moreTextTimer.play();
    }
}

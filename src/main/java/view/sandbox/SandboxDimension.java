package view.sandbox;

import control.AudioPlayer;
import control.MainProgram;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SandboxDimension extends Pane {
    private final MainProgram mainProgram;

    private Label sliderLabel;


    public SandboxDimension() {
        mainProgram = MainProgram.getMainProgram();
        setBackground();
        getChildren().addAll(getDimensionView(), getSlider(), getOk(), getReturn(), getSliderLabel());
    }

    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
    }
    private ImageView getDimensionView() {
        Image chooseDimension = new Image("file:files/texts/ChooseDimension.png", 800, 600, false, false);
        ImageView dimensionView = new ImageView(chooseDimension);
        dimensionView.setStyle("fx-background-color: transparent;");
        return dimensionView;
    }

    private Slider getSlider() {
        Slider slider = new Slider(5, 25, 5);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setShowTickLabels(false);
        slider.setShowTickMarks(false);
        slider.setTranslateX(240.0);
        slider.setTranslateY(300);
        slider.setValue(10);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSliderLabel(String.format("%.0f", newValue));
        });
        return slider;
    }

    private void updateSliderLabel(String format) {
        if (Integer.parseInt(format) < 10) {
            sliderLabel.setText(" " + format + "x" + format);
            return;
        }
        sliderLabel.setText(format + "x" + format);
    }

    private Label getReturn() {
        Label aReturn = createLabel(320, 450, "Return");
        aReturn.setOnMouseClicked(e ->{
            AudioPlayer.playButtonSound();
            mainProgram.changeToSandBoxLoader();
        });
        return aReturn;
    }

    private Label getOk() {
        Label ok = createLabel(360.0, 380, "OK");
        ok.setOnMouseClicked(e -> {
            String s = sliderLabel.getText();
            int dim = 10;
            if (s.charAt(0) == ' ') {
                dim = Integer.parseInt(s.substring(1, 2));
            } else {
                dim = Integer.parseInt(s.substring(0, 2));
            }
            AudioPlayer.playButtonSound();
            mainProgram.changeToSandBox(dim);
        });
        return ok;
    }

    private Label getSliderLabel() {
        sliderLabel = new Label("10x10"); //createLabel(300, 250, "10x10");
        sliderLabel.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 32));
        sliderLabel.setTextFill(Color.web("#0000D6"));
        sliderLabel.setTranslateX(300.0);
        sliderLabel.setTranslateY(200.0);
        return sliderLabel;
    }

    private Label createLabel(double x, double y, String text) {
        Label label = new Label(text);
        label.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 24));
        label.setTextFill(Color.web("#0000D6"));
        label.setTranslateX(x);
        label.setTranslateY(y);
        label.setOnMouseEntered(e -> label.setTextFill(Color.ORANGERED));
        label.setOnMouseExited(e -> label.setTextFill(Color.web("#0000D6")));
        return label;
    }
}

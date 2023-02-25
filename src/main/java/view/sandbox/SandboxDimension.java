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
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setTranslateX(300.0);
        slider.setTranslateY(300);
        slider.setValue(10);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateSliderLabel(String.format("%.0f", newValue));
        });
        return slider;
    }

    private void updateSliderLabel(String format) {
        sliderLabel.setText(format + "x" + format);
    }

    private Label getReturn() {
        Label aReturn = createLabel(320, 450, "Return");
        aReturn.setOnMouseClicked(e ->{
            AudioPlayer.playButtonSound();
            mainProgram.changeToMenu();
        });
        return aReturn;
    }

    private Label getOk() {
        Label ok = createLabel(330.0, 350, "OK");
        ok.setOnMouseClicked(e -> {
            String s = sliderLabel.getText();
            int dim = Integer.parseInt(s.substring(0, s.indexOf('x')));
            AudioPlayer.playButtonSound();
            mainProgram.changeToSandBox(dim);
        });
        return ok;
    }

    private Label getSliderLabel() {
        sliderLabel = createLabel(300, 250, "10x10");
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

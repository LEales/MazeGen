package view.Menu;

import control.MainProgram;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import control.AudioPlayer;

import java.io.FileNotFoundException;

/**
 * @author Viktor Näslund
 */

public class ChooseDimension extends Pane {
    private final MainProgram mainProgram;
    /**
     * Konstruktor som tar emot mainProgram och audioPlayer och kör några metoder för att
     * sätta bilder och knappar
     */
    public ChooseDimension() {
        this.mainProgram = MainProgram.getMainProgram();
        setBackground();
        addButtons();
    }

    /**
     * Metod som sätter bakgrundsbilden
     */
    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(menuBackground));
    }

    private ImageView createImageView(Image image, double translateX, double translateY) {
        validate(image, translateX, translateY);
        ImageView view = new ImageView(image);
        view.setStyle("fx-background-color: transparent;");
        view.setTranslateX(translateX);
        view.setTranslateY(translateY);
        view.toFront();
        return view;
    }

    private boolean validate(Image image, double translateX, double translateY) {
        if (0 >= translateY || MainProgram.HEIGHT < translateY) {
            throw new IllegalArgumentException("Invalid translateY");
        }
        if (0 >= translateX || MainProgram.WIDTH < translateX) {
            throw new IllegalArgumentException("Invalid translateX");
        }
        if (null == image) {
            throw new NullPointerException("Invalid image");
        }
        return true;
    }

    private void onEnterAndExit(ImageView view, Image image, double translateX, double translateY) {
        validate(image, translateX, translateY);
        if (null == view) {
            throw new IllegalArgumentException("Invalid Imageview");
        }
        view.setImage(image);
        view.setTranslateY(translateY);
        view.setTranslateX(translateX);
    }

    private void onClick(ImageView view, int dim) {
        if (null == view) {
            throw new IllegalArgumentException("Invalid Imageview");
        }
        if (dim != 10 && dim != 14 && dim != 18 && dim != 28) {
            throw new IllegalArgumentException("Invalid dimension");
        }
        try {
            mainProgram.changeToRandomize(dim);
            AudioPlayer.playButtonSound();
        } catch (FileNotFoundException ignored) {
            mainProgram.changeToMenu();
        }
    }

    /**
     * Metod som placerar bilderna som klickbara ImageViews i scenen med events för knapptryck och hovering.
     * Bilderna förstoras när man hovrar över dem och scenen byts när man trycker på dem.
     */
    private void addButtons() {
        Image chooseDimension = new Image("file:files/texts/ChooseDimension.png", 800, 600, false, false);
        Image tenByTen = new Image("file:files/texts/10x10.png", 250, 30, false, false);
        Image tenByTenResize = new Image("file:files/texts/10x10.png", 255, 33, false, false);
        Image fourteen = new Image("file:files/texts/14x14.png", 250, 30, false, false);
        Image fourteenResize = new Image("file:files/texts/14x14.png", 255, 33, false, false);
        Image eighteen = new Image("file:files/texts/18x18.png", 250, 30, false, false);
        Image eighteenResize = new Image("file:files/texts/18x18.png", 255, 33, false, false);
        Image pain = new Image("file:files/texts/Pain.png", 250, 30, false, false);
        Image painResize = new Image("file:files/texts/Pain.png", 255, 33, false, false);
        Image returnImage = new Image("file:files/texts/return.png", 250, 30, false, false);
        Image returnResize = new Image("file:files/texts/return.png", 255, 33, false, false);

        ImageView dimensionView = new ImageView(chooseDimension);
        dimensionView.setStyle("fx-background-color: transparent;");

        ImageView tenByTenView = createImageView(tenByTen, 275.0, 200.0);
        tenByTenView.setOnMouseEntered(e -> onEnterAndExit(tenByTenView, tenByTenResize, 273.0, 198.0));
        tenByTenView.setOnMouseExited(e -> onEnterAndExit(tenByTenView, tenByTen, 275.0, 200.0));
        tenByTenView.setOnMouseClicked(e -> onClick(tenByTenView, 10));

        ImageView fourteenView = createImageView(fourteen, 275.0, 250.0);
        fourteenView.setOnMouseEntered(e -> onEnterAndExit(fourteenView, fourteenResize, 273.0, 248.0));
        fourteenView.setOnMouseExited(e -> onEnterAndExit(fourteenView, fourteen, 275.0, 250.0));
        fourteenView.setOnMouseClicked(e -> onClick(fourteenView, 14));

        ImageView eighteenView = createImageView(eighteen, 275.0, 300.0);
        eighteenView.setOnMouseEntered(e -> onEnterAndExit(eighteenView, eighteenResize, 273.0, 298.0));
        eighteenView.setOnMouseExited(e -> onEnterAndExit(eighteenView, eighteen, 275.0, 300.0));
        eighteenView.setOnMouseClicked(e -> onClick(eighteenView, 18));

        ImageView painView = createImageView(pain, 275.0, 350.0);
        painView.setOnMouseEntered(e -> onEnterAndExit(painView, painResize, 273.0, 348.0));
        painView.setOnMouseExited(e -> onEnterAndExit(painView, pain, 275.0, 350.0));
        painView.setOnMouseClicked(e -> onClick(painView, 28));

        ImageView returnView = createImageView(returnImage, 300.0, 450.0);
        returnView.setOnMouseEntered(e -> onEnterAndExit(returnView, returnResize, 298.0, 448.0));
        returnView.setOnMouseExited(e -> onEnterAndExit(returnView, returnImage, 300.0, 450.0));
        returnView.setOnMouseClicked(e -> {
            mainProgram.changeToMenu();
            AudioPlayer.playButtonSound();
        });
        getChildren().addAll(dimensionView, tenByTenView, fourteenView, eighteenView, painView, returnView);
    }
}

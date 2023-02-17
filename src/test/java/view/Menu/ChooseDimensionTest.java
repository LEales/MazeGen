package view.Menu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChooseDimensionTest {
    ChooseDimension chooseDimension = new ChooseDimension();

    @Test
    void createImageViewTest() {
        double X = 5.0;
        double Y = 4.0;
        Image image = new Image("file:/files/items/heart.png");
        ImageView imageView = new ImageView(image);
        imageView.setStyle("fx-background-color: transparent;");
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);

        Method
        ImageView methodView = ChooseDimension.class.getDeclaredMethod("createImageView", Image.class, double.class, double.class)

        assertAll(
                () -> assertTrue(imageView, chooseDimension.createImageView())
        );
    }
}

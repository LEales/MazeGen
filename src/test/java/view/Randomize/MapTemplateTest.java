package view.Randomize;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class MapTemplateTest {


    @Test
    void getWallPos(){

    }

    Image getSpecificLabel(String folder, String type, int squareSize) {
            return new Image("file:files/" + folder + "/" + type + ".png", squareSize, squareSize, false, false);
        }

}

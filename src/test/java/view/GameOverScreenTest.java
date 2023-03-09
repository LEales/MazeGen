package view;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.sandbox.SandboxDimension;
import view.sandbox.SandboxScreen;

import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GameOverScreenTest {

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }

    @Test
    void gameOverAnimationHeart(){
        GameOverScreen gameOverScreen = new GameOverScreen("died");
        ImageView imageView = (ImageView) gameOverScreen.getChildren().get(0);
        assertEquals("file:files/texts/gameoverdied.png",imageView.getImage().getUrl());
    }
    @Test
    void gameOverAnimationTime() {
        GameOverScreen gameOverScreen = new GameOverScreen("time");
        ImageView imageView = (ImageView) gameOverScreen.getChildren().get(0);
        assertEquals("file:files/texts/gameovertime.png",imageView.getImage().getUrl());
    }
    @Test
    void gameOverAnimationNull() {
        try {
            GameOverScreen gameOverScreen = new GameOverScreen(null);
            ImageView imageView = (ImageView) gameOverScreen.getChildren().get(0);
            fail("no nullpointer check");
        }catch (NullPointerException e){
            assertEquals("Cause is not defined",e.getMessage());
        }
    }
    @Test
    void gameOverAnimationWrongCause() {
        try {
            GameOverScreen gameOverScreen = new GameOverScreen("TJENIXEN");
            ImageView imageView = (ImageView) gameOverScreen.getChildren().get(0);
            fail("Not a valid cause");
        }catch (IllegalArgumentException e){
            assertEquals("Not a cause",e.getMessage());
        }
    }


}
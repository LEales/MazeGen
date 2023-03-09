package view;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class TutorialScreenTest {
    @BeforeAll
    static void initJFXRuntime() {
        Platform.startup(() -> {
        });
    }
    @Test
    void testBackspaceIconExists() {
        File file = new File("files/skip_tutorial.png");
        assertTrue(file.exists());
    }

    @Test
    void testBackSpaceButtonInTutorial() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TutorialScreen ts = new TutorialScreen();

        Method skipLabel = TutorialScreen.class.getDeclaredMethod("createSkipLabel");
        skipLabel.setAccessible(true);

        Image expectedImage = new Image("file:files/skip_tutorial.png");
        System.out.println(expectedImage.getHeight());
        Image received = (Image) skipLabel.invoke(ts);
        assertAll(
                () -> assertEquals(expectedImage.getUrl(), received.getUrl()),
                () -> assertEquals(expectedImage.getWidth(), received.getWidth()),
                () -> assertEquals(expectedImage.getHeight(), received.getHeight())
        );
    }
}

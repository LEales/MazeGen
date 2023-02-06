package view;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldIntroAnimationTest {

    @BeforeAll
    static void initJFXRuntime() {
        Platform.startup(()-> {});
    }

    @Test
    void setupImageWorld1() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        Image expected = new Image("file:files/worlds/World1.png", 600, 600, false, false);
        Image received = wia.setupImages("1");
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
                );
    }

    @Test
    void setupImageWorld2() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        Image expected = new Image("file:files/worlds/World2.png", 600, 600, false, false);
        Image received = wia.setupImages("2");
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld3() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        Image expected = new Image("file:files/worlds/World3.png", 600, 600, false, false);
        Image received = wia.setupImages("3");
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld4() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        Image expected = new Image("file:files/worlds/World4.png", 600, 600, false, false);
        Image received = wia.setupImages("4");
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld5() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        Image expected = new Image("file:files/worlds/World5.png", 600, 600, false, false);
        Image received = wia.setupImages("5");
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld6() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        Image expected = new Image("file:files/worlds/World6.png", 600, 600, false, false);
        Image received = wia.setupImages("6");
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageNull() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertNull(wia.setupImages(null));
    }

    @Test
    void setupImageBadString() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertNull(wia.setupImages("Jjadfjasd"));
    }

    @Test
    void introAnimation() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertTrue(wia.introAnimation(new Image("file:files/worlds/World6.png", 600, 600, false, false)));
    }

    @Test
    void introAnimationBadWidth() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertFalse(wia.introAnimation(new Image("file:files/worlds/World6.png", 599, 600, false, false)));
    }

    @Test
    void introAnimationBadHeight() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertFalse(wia.introAnimation(new Image("file:files/worlds/World6.png", 600, 601, false, false)));
    }

    @Test
    void introAnimationBadSmooth() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertFalse(wia.introAnimation(new Image("file:files/worlds/World6.png", 600, 600, false, true)));
    }

    @Test
    void introAnimationBadPreserveRatio() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertFalse(wia.introAnimation(new Image("file:files/worlds/World6.png", 599, 600, true, false)));
    }

    @Test
    void introAnimationBadURL() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertFalse(wia.introAnimation(new Image("file:files/worlds/vaaaaaaaad.png", 599, 600, false, false)));
    }

    @Test
    void introAnimationNull() {
        WorldIntroAnimation wia = new WorldIntroAnimation();
        assertFalse(wia.introAnimation(null));
    }
}
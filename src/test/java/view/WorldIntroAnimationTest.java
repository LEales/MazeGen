package view;

import javafx.application.Platform;
import javafx.scene.image.Image;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldIntroAnimationTest {
    WorldIntroAnimation wia;

    @BeforeAll
    static void initJFXRuntime() {
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    void init() {
        wia = new WorldIntroAnimation();
    }
/*
    @Test
    void setupImageWorld1() {
        Image expected = new Image("file:files/worlds/Worldforest.png", 600, 600, false, false);
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
        Image expected = new Image("file:files/worlds/Worldunderground.png", 600, 600, false, false);
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
        Image expected = new Image("file:files/worlds/Worldlava.png", 600, 600, false, false);
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
        Image expected = new Image("file:files/worlds/Worldcloud.png", 600, 600, false, false);
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
        Image expected = new Image("file:files/worlds/Worlddesert.png", 600, 600, false, false);
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
        Image expected = new Image("file:files/worlds/Worldspace.png", 600, 600, false, false);
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
        assertNull(wia.setupImages(null));
    }

    @Test
    void setupImageBadString() {
        assertNull(wia.setupImages("Jjadfjasd"));
    }

    @Test
    void introAnimation() {
        assertTrue(wia.introAnimation(new Image("file:files/worlds/Worldspace.png", 600, 600, false, false)));
    }

    @Test
    void introAnimationBadWidth() {
        assertFalse(wia.introAnimation(new Image("file:files/worlds/Worldspace.png", 599, 600, false, false)));
    }

    @Test
    void introAnimationBadHeight() {
        assertFalse(wia.introAnimation(new Image("file:files/worlds/Worldspace.png", 600, 601, false, false)));
    }

    @Test
    void introAnimationBadSmooth() {
        assertFalse(wia.introAnimation(new Image("file:files/worlds/Worldspace.png", 600, 600, false, true)));
    }

    @Test
    void introAnimationBadPreserveRatio() {
        assertFalse(wia.introAnimation(new Image("file:files/worlds/Worldspace.png", 599, 600, true, false)));
    }

    @Test
    void introAnimationBadURL() {
        assertFalse(wia.introAnimation(new Image("file:files/worlds/vaaaaaaaad.png", 599, 600, false, false)));
    }

    @Test
    void introAnimationNull() {
        assertFalse(wia.introAnimation(null));
    }

 */
}
package view;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.enums.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class WorldIntroAnimationTest {
    WorldIntroAnimation wia;
    Method setupImages;

    @BeforeAll
    static void initJFXRuntime() {
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    void init() throws NoSuchMethodException {
        wia = new WorldIntroAnimation();
        setupImages = wia.getClass().getDeclaredMethod("setupImages", World.class);
        setupImages.setAccessible(true);
    }

    @Test
    void setupImageWorld1() throws InvocationTargetException, IllegalAccessException {
        Image expected = new Image("file:files/worlds/Worldforest.png", 600, 600, false, false);
        Image received = (Image) setupImages.invoke(wia,World.FOREST);

        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }



    @Test
    void setupImageWorld2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Image expected = new Image("file:files/worlds/Worldunderground.png", 600, 600, false, false);
        Image received = (Image) setupImages.invoke(wia,World.UNDERGROUND);
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld3() throws InvocationTargetException, IllegalAccessException {
        Image expected = new Image("file:files/worlds/Worldlava.png", 600, 600, false, false);
        Image received = (Image) setupImages.invoke(wia,World.LAVA);
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld4() throws InvocationTargetException, IllegalAccessException {
        Image expected = new Image("file:files/worlds/Worldcloud.png", 600, 600, false, false);
        Image received = (Image) setupImages.invoke(wia,World.CLOUD);
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld5() throws InvocationTargetException, IllegalAccessException {
        Image expected = new Image("file:files/worlds/Worlddesert.png", 600, 600, false, false);
        Image received = (Image) setupImages.invoke(wia,World.DESERT);
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }

    @Test
    void setupImageWorld6() throws InvocationTargetException, IllegalAccessException {
        Image expected = new Image("file:files/worlds/Worldspace.png", 600, 600, false, false);
        Image received = (Image) setupImages.invoke(wia,World.SPACE);
        assertAll(() -> assertEquals(expected.getUrl(), received.getUrl()),
                () -> assertEquals(expected.getWidth(), received.getWidth()),
                () -> assertEquals(expected.getHeight(), received.getHeight()),
                () -> assertFalse(received.isPreserveRatio()),
                () -> assertFalse(received.isSmooth())
        );
    }


    @Test
    void introAnimation() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method introAnimation = wia.getClass().getDeclaredMethod("introAnimation",Image.class);
        introAnimation.setAccessible(true);
        assertTrue((Boolean) introAnimation.invoke(wia,new Image("file:files/worlds/Worldspace.png", 600, 600, false, false)));
    }

    @Test
    void introAnimationBadWidth() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException{
        Method introAnimation = wia.getClass().getDeclaredMethod("introAnimation",Image.class);
        introAnimation.setAccessible(true);
        assertFalse((Boolean) introAnimation.invoke(wia,new Image("file:files/worlds/Worldspace.png", 599, 600, false, false)));
    }

    @Test
    void introAnimationBadHeight() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException{
        Method introAnimation = wia.getClass().getDeclaredMethod("introAnimation",Image.class);
        introAnimation.setAccessible(true);
        assertFalse((Boolean) introAnimation.invoke(wia,new Image("file:files/worlds/Worldspace.png", 600, 601, false, false)));
    }

    @Test
    void introAnimationBadSmooth() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException{
        Method introAnimation = wia.getClass().getDeclaredMethod("introAnimation",Image.class);
        introAnimation.setAccessible(true);
        assertFalse((Boolean) introAnimation.invoke(wia,new Image("file:files/worlds/Worldspace.png", 600, 600, false, true)));
    }

    @Test
    void introAnimationBadPreserveRatio() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException{
        Method introAnimation = wia.getClass().getDeclaredMethod("introAnimation",Image.class);
        introAnimation.setAccessible(true);
        assertFalse((Boolean) introAnimation.invoke(wia,new Image("file:files/worlds/Worldspace.png", 599, 600, true, false)));
    }

    @Test
    void introAnimationBadURL() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException{
        Method introAnimation = wia.getClass().getDeclaredMethod("introAnimation",Image.class);
        introAnimation.setAccessible(true);
        assertFalse((Boolean) introAnimation.invoke(wia,new Image("file:files/worlds/vaaaaaaaad.png", 599, 600, false, false)));
    }

 

}

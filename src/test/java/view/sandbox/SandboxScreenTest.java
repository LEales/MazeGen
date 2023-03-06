package view.sandbox;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SandboxScreenTest {
    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void RightMenuPathLabel() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        Field privateField = SandboxScreen.class.getDeclaredField("path");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertTrue(label != null);
    }
    @Test
    void RightMenuPathLabelInvalidDimension() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(-1);
        Field privateField = SandboxScreen.class.getDeclaredField("path");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertEquals(null,label);
    }
    @Test
    void RightMenuWallLabel() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        Field privateField = SandboxScreen.class.getDeclaredField("wall");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertTrue(label != null);
    }
    @Test
    void RightMenuWallLabelInvalidDimension() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(-1);
        Field privateField = SandboxScreen.class.getDeclaredField("wall");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertEquals(null,label);
    }
    @Test
    void RightMenuHeartLabel() throws NoSuchFieldException, IllegalAccessException {
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        Field privateField = SandboxScreen.class.getDeclaredField("heart");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertTrue(label != null);
    }
    @Test
    void RightMenuHeartLabelInvalidDimension() throws NoSuchFieldException, IllegalAccessException {
        SandboxScreen sandboxScreen = new SandboxScreen(-1);
        Field privateField = SandboxScreen.class.getDeclaredField("heart");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertEquals(null,label);
    }

    @Test
    void RightMenuBreakableWallLabel() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        Field privateField = SandboxScreen.class.getDeclaredField("breakableWall");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertTrue(label != null);
    }
    @Test
    void RightMenuBreakableWallLabelInvalidDimension() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(-1);
        Field privateField = SandboxScreen.class.getDeclaredField("breakableWall");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertEquals(null,label);
    }
    @Test
    void RightMenuAxeLabel() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        Field privateField = SandboxScreen.class.getDeclaredField("axe");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertTrue(label != null);
    }
    @Test
    void RightMenuAxeLabelInvalidDimension() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(-1);
        Field privateField = SandboxScreen.class.getDeclaredField("axe");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertEquals(null,label);
    }

    @Test
    void RightMenuCollectableLabel() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        Field privateField = SandboxScreen.class.getDeclaredField("collectible");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertTrue(label != null);
    }
    @Test
    void RightMenuCollectableLabelInvalidDimension() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(-1);
        Field privateField = SandboxScreen.class.getDeclaredField("collectible");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertEquals(null,label);
    }
    @Test
    void RightMenuDeleteLabel() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        Field privateField = SandboxScreen.class.getDeclaredField("delete");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertTrue(label != null);
    }
    @Test
    void RightMenuDeleteLabelInvalidDimension() throws NoSuchFieldException, IllegalAccessException{
        SandboxScreen sandboxScreen = new SandboxScreen(-1);
        Field privateField = SandboxScreen.class.getDeclaredField("delete");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        assertEquals(null,label);
    }
}
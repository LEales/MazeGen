package view.sandbox;

import control.MainProgram;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import model.enums.World;
import model.maps.CreatedMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.util.WaitForAsyncUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
        SandboxScreen sandboxScreen = null;
        try{
            sandboxScreen = new SandboxScreen(-1);
        }catch (IllegalArgumentException e){
            assertEquals("Not a valid dimension", e.getMessage());
        }

        Field privateField = SandboxScreen.class.getDeclaredField("path");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        fail("not a valid dimention");
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
        SandboxScreen sandboxScreen = null;
        try{
            sandboxScreen = new SandboxScreen(-1);
        }catch (IllegalArgumentException e){
            assertEquals("Not a valid dimension", e.getMessage());
        }
        Field privateField = SandboxScreen.class.getDeclaredField("wall");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        fail("not a valid dimention");
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
        SandboxScreen sandboxScreen = null;
        try{
            sandboxScreen = new SandboxScreen(-1);
        }catch (IllegalArgumentException e){
            assertEquals("Not a valid dimension", e.getMessage());
        }
        Field privateField = SandboxScreen.class.getDeclaredField("heart");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        fail("not a valid dimention");
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
        SandboxScreen sandboxScreen = null;
        try{
            sandboxScreen = new SandboxScreen(-1);
        }catch (IllegalArgumentException e){
            assertEquals("Not a valid dimension", e.getMessage());
        }
        Field privateField = SandboxScreen.class.getDeclaredField("breakableWall");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        fail("not a valid dimention");
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
        SandboxScreen sandboxScreen = null;
        try{
            sandboxScreen = new SandboxScreen(-1);
        }catch (IllegalArgumentException e){
            assertEquals("Not a valid dimension", e.getMessage());
        }
        Field privateField = SandboxScreen.class.getDeclaredField("axe");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        fail("not a valid dimention");
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
        SandboxScreen sandboxScreen = null;
        try{
            sandboxScreen = new SandboxScreen(-1);
        }catch (IllegalArgumentException e){
            assertEquals("Not a valid dimension", e.getMessage());
        }
        Field privateField = SandboxScreen.class.getDeclaredField("collectible");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        fail("not a valid dimention");
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
        SandboxScreen sandboxScreen = null;
        try{
            sandboxScreen = new SandboxScreen(-1);
        }catch (IllegalArgumentException e){
            assertEquals("Not a valid dimension", e.getMessage());
        }
        Field privateField = SandboxScreen.class.getDeclaredField("delete");
        privateField.setAccessible(true);
        Label label = (Label) privateField.get(sandboxScreen);
        fail("not a valid dimention");
    }

    @Test
    void testChangeWorld() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        SandboxScreen sandboxScreen = new SandboxScreen(20);
        ComboBox<World> worldComboBox = new ComboBox<>();
        Label world = new Label("World");
        world.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        world.setTextFill(javafx.scene.paint.Color.WHITE);

        worldComboBox.getItems().addAll(World.values());
        worldComboBox.setValue(World.FOREST);
        worldComboBox.valueProperty().addListener((observableValue, world1, newValue) -> {
            try {
                Field worldField = SandboxScreen.class.getDeclaredField("world");
                worldField.setAccessible(true);
                worldField.set(sandboxScreen, newValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        Font font = Font.loadFont(MainProgram.class.getResourceAsStream("PressStart2P.ttf"), 10);
        worldComboBox.setStyle("-fx-font-family: '" + font.getName() + "';");

        Method setup = SandboxScreen.class.getDeclaredMethod("setUpPanel");
        setup.setAccessible(true);
        try {
            setup = (Method) setup.invoke(sandboxScreen);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        worldComboBox.setValue(World.CLOUD);

        Field worldField = SandboxScreen.class.getDeclaredField("world");
        worldField.setAccessible(true);
        World currentWorld = (World) worldField.get(sandboxScreen);

        assertEquals(World.CLOUD, currentWorld);
    }

    @Test
    void testSaveWorld() throws NoSuchFieldException, IllegalAccessException {
        MainProgram mainProgram = MainProgram.getMainProgram();
        Optional<Boolean> result = Optional.of(mainProgram.checkMap("fest"));
        assertTrue(result.get());
    }
}
package view.sandbox;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.maps.CreatedMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class SandboxLoaderTest {

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
    void labelCreatedMazesExists(){
        SandboxLoader sandboxLoader = new SandboxLoader();
        boolean exists = false;
        Label labelReturn = null;
        for (int i = 0; i < sandboxLoader.getChildren().size(); i++) {
            try {
                Label label = (Label) sandboxLoader.getChildren().get(i);
                if (label != null && label.getText() == "CREATED MAZES"){
                    exists = true;
                    labelReturn = label;
                }else {
                    throw new NoSuchElementException("Doesnt Exists A Title");
                }
            }catch (NoSuchElementException e){
                assertEquals("Doesnt Exists A Title",e.getMessage());
            }catch (ClassCastException e){

            }
        }
        if (exists){
            assertEquals("CREATED MAZES",labelReturn.getText());
        }else {
            assertEquals("null",labelReturn.getText());
        }
    }
    @Test
    void buttonNewMazeExists(){
        SandboxLoader sandboxLoader = new SandboxLoader();
        boolean exists = false;
        Label labelReturn = null;
        for (int i = 0; i < sandboxLoader.getChildren().size(); i++) {
            try {
                Label label = (Label) sandboxLoader.getChildren().get(i);
                if (label != null && label.getText() == "Create New Maze"){
                    exists = true;
                    labelReturn = label;
                }else {
                    throw new NoSuchElementException("Doesnt Exists A Title");
                }
            }catch (NoSuchElementException e){
                assertEquals("Doesnt Exists A Title",e.getMessage());
            }catch (ClassCastException e){

            }
        }
        if (exists){
            assertEquals("Create New Maze",labelReturn.getText());
        }else {
            assertEquals("null",labelReturn.getText());
        }
    }
    @Test
    void buttonReturnExists(){
        SandboxLoader sandboxLoader = new SandboxLoader();
        boolean exists = false;
        Label labelReturn = null;
        for (int i = 0; i < sandboxLoader.getChildren().size(); i++) {
            try {
                Label label = (Label) sandboxLoader.getChildren().get(i);
                if (label != null && label.getText() == "Return"){
                    exists = true;
                    labelReturn = label;
                }else {
                    throw new NoSuchElementException("Doesnt Exists A Title");
                }
            }catch (NoSuchElementException e){
                assertEquals("Doesnt Exists A Title",e.getMessage());
            }catch (ClassCastException e){

            }
        }
        if (exists){
            assertEquals("Return",labelReturn.getText());
        }else {
            assertEquals("null",labelReturn.getText());
        }
    }

    @Test
    void scrollPainContentCheck (){
        SandboxLoader sandboxLoader = new SandboxLoader();
        ScrollPane scrollPane = null;
        for (int i = 0; i < sandboxLoader.getChildren().size(); i++) {
            try {
                scrollPane = (ScrollPane) sandboxLoader.getChildren().get(i);
            } catch (ClassCastException e) {
                System.out.println(e.getMessage());
            }
        }
        VBox vBox = (VBox) scrollPane.getContent();
        System.out.println(vBox.getChildren().size());

    }

    @Test
    void playButtonExists () throws NoSuchMethodException {
        CreatedMap testMap = new CreatedMap();
        SandboxLoader sandboxLoader = new SandboxLoader();

        Method addMapMethod = SandboxLoader.class.getDeclaredMethod("addMap", CreatedMap.class);
        addMapMethod.setAccessible(true);

        VBox vbox = null;
        try {
            vbox = (VBox) addMapMethod.invoke(sandboxLoader, testMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean playExists = false;
        for (Node node : vbox.getChildren()) {
            if (node instanceof HBox) {
                HBox buttons = (HBox) node;
                for (Node buttonNode : buttons.getChildren()) {
                    if (buttonNode instanceof Label) {
                        Label buttonLabel = (Label) buttonNode;
                        if (buttonLabel.getText().equals("Play")) {
                            playExists = true;
                            break;
                        }
                    }
                }
            }
        }

        assertTrue(playExists);
    }

    @Test
    void deleteButtonExists () throws NoSuchMethodException {
        CreatedMap testMap = new CreatedMap();
        SandboxLoader sandboxLoader = new SandboxLoader();

        Method addMapMethod = SandboxLoader.class.getDeclaredMethod("addMap", CreatedMap.class);
        addMapMethod.setAccessible(true);

        VBox vbox = null;
        try {
            vbox = (VBox) addMapMethod.invoke(sandboxLoader, testMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean playExists = false;
        for (Node node : vbox.getChildren()) {
            if (node instanceof HBox) {
                HBox buttons = (HBox) node;
                for (Node buttonNode : buttons.getChildren()) {
                    if (buttonNode instanceof Label) {
                        Label buttonLabel = (Label) buttonNode;
                        if (buttonLabel.getText().equals("Delete")) {
                            playExists = true;
                            break;
                        }
                    }
                }
            }
        }

        assertTrue(playExists);
    }

    @Test
    public void testLabelFonts() throws NoSuchMethodException {
        CreatedMap testMap = new CreatedMap();
        SandboxLoader sandboxLoader = new SandboxLoader();

        Method addMapMethod = SandboxLoader.class.getDeclaredMethod("addMap", CreatedMap.class);
        addMapMethod.setAccessible(true);

        VBox vbox = null;
        try {
            vbox = (VBox) addMapMethod.invoke(sandboxLoader, testMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Label nameLabel = (Label) vbox.getChildren().get(0);
        Font nameFont = nameLabel.getFont();
        assertEquals("Press Start 2P", nameFont.getFamily());
        assertEquals(18.0, nameFont.getSize());

        HBox buttons = (HBox) vbox.getChildren().get(1);
        Label loadLabel = (Label) buttons.getChildren().get(0);
        Font loadFont = loadLabel.getFont();
        assertEquals("Press Start 2P", loadFont.getFamily());
        assertEquals(14.0, loadFont.getSize());

        Label playLabel = (Label) buttons.getChildren().get(1);
        Font playFont = playLabel.getFont();
        assertEquals("Press Start 2P", playFont.getFamily());
        assertEquals(14.0, playFont.getSize());

        Label deleteLabel = (Label) buttons.getChildren().get(2);
        Font deleteFont = deleteLabel.getFont();
        assertEquals("Press Start 2P", deleteFont.getFamily());
        assertEquals(14.0, deleteFont.getSize());
    }
}
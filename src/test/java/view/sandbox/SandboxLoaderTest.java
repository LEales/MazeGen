package view.sandbox;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
}
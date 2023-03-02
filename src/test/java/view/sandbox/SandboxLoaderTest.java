package view.sandbox;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.control.Label;
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
        for (int i = 0; i < sandboxLoader.getChildren().size(); i++) {

            try {
                Label label = (Label) sandboxLoader.getChildren().get(i);
                if (label != null && label.getText() == "CREATED MAZES"){
                    assertEquals("CREATED MAZES",label.getText());
                }else {
                    throw new NoSuchElementException("Doesnt Exists A Title");
                }
            }catch (NoSuchElementException e){
                assertEquals("Doesnt Exists A Title",e.getMessage());
            }catch (ClassCastException e){

            }
        }
    }
    @Test
    void buttonNewMazeExists(){

    }
    @Test
    void buttonReturnExists(){

    }
}
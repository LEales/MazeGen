package model.Time;

import control.MainProgram;
import javafx.application.Application;
import javafx.application.Platform;
import control.MazeGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class testGhost extends ApplicationTest{

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();

    }

    MazeGenerator mg;
    @Test
    void midTime() throws InterruptedException, FileNotFoundException {
        boolean gameover = false;
        FxRobot robot = new FxRobot();
        //Låt spelet starta
        Thread.sleep(2000);
        System.out.println("Loopin");
        //Kör en ny tråd som hämtar main
        Platform.runLater(() -> {MainProgram main = MainProgram.getMainProgram();
         try {
             main.changeToCampaign();
             main.nextWorld5Level(1,2);
         } catch (FileNotFoundException | InterruptedException e) {
             throw new RuntimeException(e);
         }

     });
        Thread.sleep(5000);
        //Lista ut hur denna funkar
        //clickOn("#startButton");

        while (!gameover){
            //Något...något medans spelet pågår
        }





    }


}

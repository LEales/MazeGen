package control.time;

import control.MainProgram;
import javafx.application.Application;
import model.enums.GameMode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.menu.RightPanel;


import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TimeThreadtest {


    @BeforeAll
    static void initJFXRuntime() throws InterruptedException {
        new Thread(() -> Application.launch(MainProgram.class)).start();
        Thread.sleep(1000); //Tid för att starta programmet
    }

    @Test
    void minusOneSecondsLeft() {
        assertThrows(IllegalArgumentException.class, () -> {
            RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
            TimeThread timeThread = new TimeThread(-1,panel,GameMode.CAMPAIGN);
            timeThread.start();
        });
    }

    @Test
    void zeroSecondsLeft() throws FileNotFoundException, InterruptedException {

        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        TimeThread timeThread = new TimeThread(0,panel,GameMode.CAMPAIGN);
        timeThread.start();
        //Thread.sleep(2000);
        while (timeThread.isAlive()!=true){
            System.out.println("Staying alive");
        }
        assertFalse(timeThread.isAlive()==false);
    }

    //
    @Test
    void oneSecondsLeft() throws Exception {
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        TimeThread timeThread = new TimeThread(0,panel,GameMode.CAMPAIGN);
        timeThread.start();
        Thread.sleep(1000);
        while (timeThread.isAlive()!=true){
            System.out.println("Staying alive");
        }
        assertFalse(timeThread.isAlive()==false);
    }

    @Test
    void FiveSecondsLeft() throws Exception {
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        TimeThread timeThread = new TimeThread(5,panel,GameMode.CAMPAIGN);
        timeThread.start();
        Thread.sleep(6000);
        System.out.println("is alive: " + timeThread.isAlive());
        assertFalse(timeThread.isAlive());
    }

    @Test
    void sixSecondsLeft() throws InterruptedException, FileNotFoundException {
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        TimeThread timeThread = new TimeThread(6,panel,GameMode.CAMPAIGN);
        timeThread.start();
        Thread.sleep(6000);
        assertFalse(timeThread.isAlive() == false);
    }

    @Test
    void fifteenSecondsLeft() throws InterruptedException, FileNotFoundException {
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        TimeThread timeThread = new TimeThread(15,panel,GameMode.CAMPAIGN);
        timeThread.start();
        Thread.sleep(15000);
        System.out.println("is alive: " + timeThread.isAlive());
        assertFalse(timeThread.isAlive() == false);
    }




}

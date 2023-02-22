package model.time;

import control.MainProgram;
import javafx.application.Application;
import control.time.TimeThread;
import model.enums.GameMode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.menu.RightPanel;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TimeThreadtest {


    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }

    @Test
    void minusOneSecondsLeft() {
        assertThrows(IllegalArgumentException.class, () -> {
            TimeThread timeThread = null;
            RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
            timeThread = new TimeThread(-1,panel, false);
            timeThread.start();
        });
    }
    //Failar för att timern=0 avslutar inte tråden utan fortsätter räkna ner.
    @Test
    void zeroSecondsLeft() throws FileNotFoundException, InterruptedException {
        TimeThread timeThread = null;
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        timeThread = new TimeThread(0,panel, false);
        timeThread.start();
        //Thread.sleep(2000);
        while (timeThread.isAlive()!=true){
            System.out.println("Staying alive");
        }
        assertFalse(timeThread.isAlive()==false);
    }
    //skicka in 5 sekunder, sov och se om spelet avslutas efter det
    @Test
    void oneSecondsLeft() throws Exception {
        TimeThread timeThread = null;
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        timeThread = new TimeThread(1,panel, false);
        timeThread.start();
        Thread.sleep(1000);
        System.out.println("is alive: " + timeThread.isAlive());
        assertFalse(timeThread.isAlive());
    }
    @Test
    void FiveSecondsLeft() throws Exception {
        TimeThread timeThread = null;
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        timeThread = new TimeThread(5,panel, false);
        timeThread.start();
        Thread.sleep(5000);
        System.out.println("is alive: " + timeThread.isAlive());
        assertFalse(timeThread.isAlive());
    }
    @Test
    void sixSecondsLeft() throws InterruptedException, FileNotFoundException {
        TimeThread timeThread = null;
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        timeThread = new TimeThread(6,panel, false);
        timeThread.start();
        Thread.sleep(6000);
        assertFalse(timeThread.isAlive());
    }
    @Test
    void fifteenSecondsLeft() throws InterruptedException, FileNotFoundException {
        TimeThread timeThread = null;
        RightPanel panel= new RightPanel(GameMode.CAMPAIGN);
        timeThread = new TimeThread(15,panel, false);
        timeThread.start();
        Thread.sleep(15000);
        System.out.println("is alive: " + timeThread.isAlive());
        assertFalse(timeThread.isAlive());
    }


}

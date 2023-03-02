package control.time;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TotalTimetest {

    @BeforeAll
    static void IntizializeJavaFX() {
        Platform.startup(() -> {});
    }

    @Test
    void minimumTime(){
        TotalTime totalTime = new TotalTime(true);
        totalTime.start();
        int runningtime = totalTime.setGameOver(true);
        assertTrue(runningtime == 0);
    }

    @Test
    void neverStarted() {
        TotalTime totalTime = new TotalTime(true);
        totalTime.start();
        int elapsedSeconds = totalTime.setGameOver(true);
        assertTrue(elapsedSeconds == 0);

    }

    @Test
    void midTime() {
        try {
            TotalTime totalTime = new TotalTime(false);
            totalTime.start();
            Thread.sleep(10000);
            int elapsedSeconds = totalTime.setGameOver(true);
            assertTrue(elapsedSeconds == 9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void maximumTime() {
        try {
            TotalTime totalTime = new TotalTime(false);
            totalTime.start();
            Thread.sleep(25000);
            int elapsedSeconds = totalTime.setGameOver(true);
            assertTrue(elapsedSeconds == 24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void interruptedTime() {
        try {
            TotalTime totalTime = new TotalTime(false);
            totalTime.start();
            Thread.sleep(5000);
            totalTime.interrupt();
            int elapsedSeconds = totalTime.setGameOver(true);
            assertTrue(elapsedSeconds == 4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


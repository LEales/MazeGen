package model.Time;

import model.time.TotalTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TotalTimetest {


    @Test
    void minimumTime(){
        TotalTime totalTime = new TotalTime(true);
        totalTime.start();
        int runningtime = totalTime.setGameOver(true);
        assertTrue(runningtime == 0);
    }

    @Test
    void midTime() throws InterruptedException {
        TotalTime totalTime = new TotalTime(false);
        totalTime.start();
        Thread.sleep(10000); // Wait for 2 seconds
        int elapsedSeconds = totalTime.setGameOver(true);
        System.out.println(elapsedSeconds);
        assertTrue(elapsedSeconds ==9);

    }
    @Test
    void maximumTime() throws InterruptedException {
        TotalTime totalTime = new TotalTime(false);
        totalTime.start();
        Thread.sleep(25000); // Wait for 2 seconds
        int elapsedSeconds = totalTime.setGameOver(true);
        assertTrue(elapsedSeconds == 24);

    }
    @Test
    void neverStarted() throws InterruptedException {
        TotalTime totalTime = new TotalTime(true);
        totalTime.start();
        Thread.sleep(25000); // Wait for 2 seconds
        int elapsedSeconds = totalTime.setGameOver(true);
        assertTrue(elapsedSeconds == 0);

    }
    @Test
    void interruptedTime() throws InterruptedException {
        TotalTime totalTime = new TotalTime(false);
        totalTime.start();
        Thread.sleep(5000); // Wait for 2 seconds
        totalTime.interrupt();
        int elapsedSeconds = totalTime.setGameOver(true);
        assertTrue(elapsedSeconds == 4);

    }

}


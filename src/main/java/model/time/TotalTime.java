package model.time;

import model.time.Time;

/**
 * @author Sebastian Helin
 * Tråd som räknar den totala tiden det tog att spela
 */
public class TotalTime extends Thread {

    private boolean gameOver;
    private Time time = new Time();

    /**
     * @param gameOver Tar en boolen som används som villkor
     */
    public TotalTime(boolean gameOver) {
        this.gameOver = gameOver;
    }


    /**
     * Tråden sover i 1000 millisekunder
     * Inkrementerar int variabeln med 1
     */
    public void run() {
        while (!gameOver) {
            try {
                Thread.sleep(1000);
                time.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param gameOver Setter för villkoret
     */
    public int setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        return time.getSeconds();
    }
}

package model;

/**
 * @author Sebastian Helin
 * Tråd som räknar den totala tiden det tog att spela
 */
public class TotalTime extends Thread{

    private boolean gameOver;
    private int seconds = 0;
    private int minutes = 0;
    private int hour = 0;

    /**
     *
     * @param gameOver Tar en boolen som används som villkor
     */
    public TotalTime(boolean gameOver){
        this.gameOver = gameOver;
    }


    /**
     * Tråden sover i 1000 millisekunder
     * Inkrementerar int variabeln med 1
     */
    public void run(){
        while(!gameOver){
            try {
                Thread.sleep(1000);
                seconds++;
                if (seconds==60){
                    minutes++;
                    seconds = 0;
                }
                if (minutes==60){
                    hour++;
                    minutes=0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param gameOver Setter för villkoret
     */
    public int[] setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        int[] arr = {hour,minutes,seconds};
        return arr;
    }
}

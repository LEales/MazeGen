package model;

import view.Menu.RightPanel;

/**
 * @author Sebastian Helin
 * En tråd som räknar ner den
 * totala tiden som skickas in från konstruktorn
 */

public class TimeThread extends Thread {

    private Time time;
    private RightPanel panel;
    private boolean gameOver = false;

    /**
     * @param seconds Varje nivå skickar in en seconds variabel till tråden
     * @param panel
     */
    public TimeThread(int seconds, RightPanel panel) {
        this.time = new Time(seconds);
        this.panel = panel;
    }

    /**
     * Körs tills det blir GameOver eller en bana blir avklarad
     * Instansieras om och körs igen för varje nivå
     */
    public void run() {
        while (!gameOver) {
            try {
                Thread.sleep(1000);
                time.decrement();
                if (time.getSeconds() == 5) {
                    panel.fiveSecLeft();
                }
                if (time.getSeconds() == 0) {
                    panel.startTask();
                    gameOver = true;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param gameOver setter för trådens villkor
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}

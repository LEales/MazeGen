package view.Menu;

import java.io.Serializable;

public class PlayerScore implements Serializable {
    private String player = "";
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;


    public PlayerScore(String player, int hours, int minutes, int seconds) {
        this.player = player;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getPlayer() {
        return player;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getTotalTimeInSeconds(){
        return this.seconds + (this.minutes*60)+ (this.hours*60*60);
    }
}

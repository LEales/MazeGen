package model;

import java.io.Serializable;

public class PlayerScore implements Serializable {
    private String player = "";
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;
    private int lvl;



    public PlayerScore(String player, int hours, int minutes, int seconds, int lvlCleared) {
        this.player = player;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.lvl = lvlCleared;
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
    public int getLvl(){
        return lvl;
    }
}

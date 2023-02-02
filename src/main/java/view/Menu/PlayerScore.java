package view.Menu;

import java.io.Serializable;

public class PlayerScore implements Serializable {
    private String player = "SVEN";
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

    public String setPlayer(String player) {
        return this.player = player;
    }

    public int getHours() {
        return hours;
    }

    public int setHours(int hours) {
        return this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int setMinutes(int minutes) {
        return this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int setSeconds(int seconds) {
        return this.seconds = seconds;
    }
}

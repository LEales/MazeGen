package model;

import java.io.Serializable;

public class PlayerScore implements Serializable {
    private String player = "";
    private Time time;
    private int lvl;


    public PlayerScore(String player, Time time, int lvlCleared) {
        playerCheck(player);
        this.player = player;
        this.time = time;
        this.lvl = lvlCleared;
    }

    public PlayerScore(String player, int seconds, int lvlCleared) {
        this(player, new Time(seconds), lvlCleared);
    }

    private void playerCheck(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name not allowed to be null");
        } else if (name.contains("\n")) {
            throw new IllegalArgumentException("Name not allowed to contain new line");
        } else if (name.contains("\t")) {
            throw new IllegalArgumentException("Name not allowed to contain tab");
        } else if (name.length() != 3) {
            throw new IllegalArgumentException("Name length invalid");
        }
    }

    public String getPlayer() {
        return player;
    }

    public int getSeconds() {
        return time.getSeconds();
    }

    public int getLvl() {
        return lvl;
    }
}

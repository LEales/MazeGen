package model;

import java.io.Serializable;

/**
 * @author Max Tideman, Linus Regander
 * @edit Luke Eales, Teodor Wegestål - Added error handling and compareTo
 */

public class Player implements Serializable, Comparable<Player> {

    public static final long serialVersionUID = 3482904832L;
    private String player = "";
    private final Time time;
    private final int lvl;


    public Player(String player, Time time, int lvl) {
        playerCheck(player);
        this.player = player;
        this.time = time;
        this.lvl = lvl;
    }

    public Player(String player, int seconds, int lvlCleared) {
        this(player, new Time(seconds), lvlCleared);
    }

    private void playerCheck(String name) {
        if (null == name) {
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

    @Override
    public int compareTo(Player o) {
        if (o.lvl == lvl) {
            return Integer.compare(time.getSeconds(), o.time.getSeconds());
        }
        return Integer.compare(o.lvl, lvl);
    }
}

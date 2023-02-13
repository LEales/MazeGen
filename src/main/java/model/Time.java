package model;

import java.io.Serial;
import java.io.Serializable;

public class Time implements Serializable {

    public static long serialVersionUID = 1948391084L;
    private int seconds;

    public Time(int seconds) {
        checkTime(seconds);
        this.seconds = seconds;
    }
    public Time() {
        seconds = 0;
    }

    private void checkTime(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Invalid seconds");
        }
    }

    public synchronized int increment() {
        return ++seconds;
    }

    public synchronized int decrement() {
        return --seconds;
    }

    public int setTime(int seconds) {
        checkTime(seconds);
        this.seconds = seconds;
        return seconds;
    }

    public int getSeconds() {
        return seconds;
    }
}

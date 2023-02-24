package model;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

/**
 * @author Luke Eales, Teodor Wegestål
 * Class that keeps track of played seconds
 */
public class Time implements Serializable {

    public static long serialVersionUID = 1948391084L;
    private SerializableIntegerProperty seconds;

    public Time(int seconds) {
        checkTime(seconds);
        this.seconds = new SerializableIntegerProperty(seconds);
    }

    public Time() {
        seconds = new SerializableIntegerProperty(0);
    }

    private void checkTime(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Invalid seconds");
        }
    }

    public int increment() {
        Platform.runLater(() -> seconds.set(seconds.get() + 1));
        return seconds.get();
    }

    public int decrement() {
        Platform.runLater(() -> seconds.set(seconds.get() - 1));
        return seconds.get();
    }

    public int setTime(int seconds) {
        checkTime(seconds);
        this.seconds = new SerializableIntegerProperty(seconds);
        return seconds;
    }

    public int getSeconds() {
        return seconds.get();
    }

    public SimpleIntegerProperty secondsProperty() {
        return seconds;
    }
}

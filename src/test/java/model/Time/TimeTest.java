package model.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.time.Time;
import org.junit.jupiter.api.Test;

public class TimeTest {


    @Test
    public void validInt() {
        Time time = new Time(1);
        assertEquals(1, time.getSeconds());
    }

    @Test
    public void setIntTozero() {
        Time time = new Time(0);
        assertEquals(0, time.getSeconds());
    }

    @Test
    public void negativeInt() {
        assertThrows(IllegalArgumentException.class, () -> new Time(-1));
    }

    @Test
    public void testGetSeconds() {
        Time time = new Time(5);
        assertEquals(5, time.getSeconds());
    }

    @Test
    public void increment() {
        Time time = new Time(0);
        assertEquals(1, time.increment());
    }

    @Test
    public void decrement() {
        Time time = new Time(1);
        assertEquals(0, time.decrement());
    }

    @Test
    public void setTimeValidInt() {
        Time time = new Time();
        assertEquals(2147483647, time.setTime(2147483647));
    }
    @Test
    public void setTimeZeroInt() {
        Time time = new Time();
        assertEquals(0, time.setTime(0));
    }

    @Test
    public void setTimeNegativeInt() {
        Time time = new Time();
        assertThrows(IllegalArgumentException.class, () -> time.setTime(-1));
    }



}


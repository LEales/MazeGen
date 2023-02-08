package view.Menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerScoreTest {
    @Test
    void createValid() {
        PlayerScore ps = new PlayerScore("Hello", 1, 2, 3);
        assertEquals(3723, ps.getTotalTimeInSeconds());
    }

    @Test
    void createInvalidNameNewline() {
        try {
            new PlayerScore("\n", 0, 0, 0);
            fail("NewLine not allowed");
        } catch (IllegalArgumentException e) {
        }
        try {
            new PlayerScore("\t", 0, 0, 0);
            fail("Tab not allowed");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void createInvalidNameTab() {
        try {
            new PlayerScore("\t", 0, 0, 0);
            fail("Tab not allowed");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void createInvalidNameEmpty() {
        try {
            new PlayerScore("", 0, 0, 0);
            fail("Empty string not allowed");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void createInvalidNameNull() {
        try {
            new PlayerScore(null, 0, 0, 0);
            fail("Null not allowed");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void invalidSeconds() {
        try {
            new PlayerScore("a", 0, 0, -1);
            fail("Negative seconds not allowed");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void invalidMinutes() {
        try {
            new PlayerScore("a", 0, -1, 0);
            fail("Negative minutes not allowed");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void invalidHours() {
        try {
            new PlayerScore("a", -1, 0, 0);
            fail("Negative hours not allowed");
        } catch (IllegalArgumentException e) {

        }
    }

}
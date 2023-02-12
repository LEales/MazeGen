package view.Menu;

import model.PlayerScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerScoreTest {
    @Test
    void createValid() {
        PlayerScore ps = new PlayerScore("ABC", 1, 2, 3, 11);
        assertEquals(3723, ps.getTotalTimeInSeconds());
    }

    @Test
    void createFourChars() {
        try {
            new PlayerScore("ABCC", 1, 2, 3, 11);
            fail("Four chars not allowed");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void createTwoChars() {
        try {
            new PlayerScore("AV", 1, 2, 3, 11);
            fail("Two chars not allowed");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void createInvalidNameNewline() {
        try {
            new PlayerScore("\n", 0, 0, 0, 11);
            fail("NewLine not allowed");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    void createInvalidNameTab() {
        try {
            new PlayerScore("\t", 0, 0, 0, 11);
            fail("Tab not allowed");
        } catch (IllegalArgumentException ignored) {

        }
    }

    @Test
    void createInvalidNameEmpty() {
        try {
            new PlayerScore("", 0, 0, 0, 11);
            fail("Empty string not allowed");
        } catch (IllegalArgumentException ignored) {

        }
    }

    @Test
    void createInvalidNameNull() {
        try {
            new PlayerScore(null, 0, 0, 0, 11);
            fail("Null not allowed");
        } catch (IllegalArgumentException ignored) {

        }
    }

    @Test
    void invalidSeconds() {
        try {
            new PlayerScore("ABC", 0, 0, -1, 11);
            fail("Negative seconds not allowed");
        } catch (IllegalArgumentException ignored) {

        }
    }

    @Test
    void invalidMinutes() {
        try {
            new PlayerScore("ABC", 0, -1, 0, 11);
            fail("Negative minutes not allowed");
        } catch (IllegalArgumentException ignored) {

        }
    }

    @Test
    void invalidHours() {
        try {
            new PlayerScore("ABC", -1, 0, 0, 11);
            fail("Negative hours not allowed");
        } catch (IllegalArgumentException ignored) {

        }
    }
}
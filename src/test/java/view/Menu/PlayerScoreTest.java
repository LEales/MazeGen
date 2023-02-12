package view.Menu;

import model.PlayerScore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerScoreTest {
    @Test
    void createValid() {
        PlayerScore ps = new PlayerScore("ABC", 1, 2, 3, 11);
        assertAll(() -> assertEquals("ABC", ps.getPlayer()),
                () -> assertEquals(11, ps.getLvl()),
                () -> assertEquals(3723, ps.getTotalTimeInSeconds()));
    }

    @Test
    void createFourChars() {
        try {
            new PlayerScore("ABCC", 1, 2, 3, 11);
            fail("Four chars not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name length invalid", e.getMessage());
        }
    }

    @Test
    void createTwoChars() {
        try {
            new PlayerScore("AV", 1, 2, 3, 11);
            fail("Two chars not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name length invalid", e.getMessage());
        }
    }

    @Test
    void createInvalidNameNewline() {
        try {
            new PlayerScore("\n", 0, 0, 0, 11);
            fail("NewLine not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name not allowed to contain new line", e.getMessage());
        }
    }

    @Test
    void createInvalidNameTab() {
        try {
            new PlayerScore("\t", 0, 0, 0, 11);
            fail("Tab not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name not allowed to contain tab", e.getMessage());
        }
    }

    @Test
    void createInvalidNameEmpty() {
        try {
            new PlayerScore("", 0, 0, 0, 11);
            fail("Empty string not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name length invalid", e.getMessage());
        }
    }

    @Test
    void createInvalidNameNull() {
        try {
            new PlayerScore(null, 0, 0, 0, 11);
            fail("Null not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name not allowed to be null", e.getMessage());
        }
    }

    @Test
    void invalidLowerSeconds() {
        try {
            new PlayerScore("ABC", 0, 0, -1, 11);
            fail("Negative seconds not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid seconds", e.getMessage());
        }
    }

    @Test
    void invalidLowerMinutes() {
        try {
            new PlayerScore("ABC", 0, -1, 0, 11);
            fail("Negative minutes not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid minutes", e.getMessage());
        }
    }

    @Test
    void invalidLowerHours() {
        try {
            new PlayerScore("ABC", -1, 0, 0, 11);
            fail("Negative hours not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid hours", e.getMessage());
        }
    }

    @Test
    void invalidUpperSeconds() {
        try {
            new PlayerScore("ABC", 0, 0, 60, 11);
            fail("Seconds over 59 not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid seconds", e.getMessage());
        }
    }

    @Test
    void invalidUpperMinutes() {
        try {
            new PlayerScore("ABC", 0, 60, 0, 11);
            fail("Minutes over 59 not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid minutes", e.getMessage());
        }
    }
}
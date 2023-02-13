package view.Menu;

import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void createValid() {
        Player ps = new Player("ABC", 1, 11);
        assertAll(() -> assertEquals("ABC", ps.getPlayer()),
                () -> assertEquals(11, ps.getLvl()),
                () -> assertEquals(1, ps.getSeconds()));
    }

    @Test
    void createFourChars() {
        try {
            new Player("ABCC", 1, 11);
            fail("Four chars not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name length invalid", e.getMessage());
        }
    }

    @Test
    void createTwoChars() {
        try {
            new Player("AV", 1, 11);
            fail("Two chars not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name length invalid", e.getMessage());
        }
    }

    @Test
    void createInvalidNameNewline() {
        try {
            new Player("\n", 0, 11);
            fail("NewLine not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name not allowed to contain new line", e.getMessage());
        }
    }

    @Test
    void createInvalidNameTab() {
        try {
            new Player("\t", 0, 11);
            fail("Tab not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name not allowed to contain tab", e.getMessage());
        }
    }

    @Test
    void createInvalidNameEmpty() {
        try {
            new Player("", 0, 11);
            fail("Empty string not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name length invalid", e.getMessage());
        }
    }

    @Test
    void createInvalidNameNull() {
        try {
            new Player(null, 0, 11);
            fail("Null not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Name not allowed to be null", e.getMessage());
        }
    }

    @Test
    void invalidLowerSeconds() {
        try {
            new Player("ABC", -1, 11);
            fail("Negative seconds not allowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid seconds", e.getMessage());
        }
    }
}
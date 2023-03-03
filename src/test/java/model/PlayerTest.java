package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void playerNameWithNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null, new Time(12), 2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null, 12, 2);
        });
    }

    @Test
    void playerNameWithLine() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Player("AL\nI", new Time(12), 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("AL\nI", 12, 2);
        });
    }

    @Test
    void playerNameWithTab() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Player("AL\tI", new Time(12), 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("AL\tI", 12, 2);
        });
    }


    @Test
    void playerWithNegativeSeconds() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("BAB", new Time(-1), 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("BAB", -1, 2);
        });
    }

    //Ska inte gå att ha en spelare med negativa nivåer / negativt antal avklara nivåer
    @Test
    void playerWithNegLvlsCleared() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("BAB", new Time(-1), -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("BAB", 12, -1);
        });
    }


    @Test
    void playerInvalidLengthName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Player("ALIAL", new Time(12), 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("ALIAL", 12, 2);
        });
    }

    @Test
    void getPlayer() {
        final Player player = new Player("BAB", new Time(12), 2);
        assertEquals("BAB", player.getPlayer());
    }

    @Test
    void getSeconds() {
        final Player player = new Player("BAB", new Time(12), 2);
        assertEquals(12, player.getSeconds());
    }

    @Test
    void getLvl() {

        final Player player = new Player("BAB", new Time(12), 2);
        assertEquals(2, player.getLvl());

    }

    @Test
    void compareTo() {
        // Samma nivå samma tider
        final Player player1 = new Player("BAB", new Time(12), 2);
        Player player2 = new Player("ABC", new Time(12), 2);
        assertEquals(0, player1.compareTo(player2));

        // Sama nivå men olika tider
        player2 = new Player("ABC", new Time(10), 2);
        assertTrue(player1.compareTo(player2) > 0);

        // Olika nivåer
        player2 = new Player("ABC", new Time(12), 3);
        assertTrue(player1.compareTo(player2) > 0);
    }
}
package model.Maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Gets all maps in the fifth level of the campaign and tests that the correct one is returned.
class World5MapsTest {
    World5Maps w;

    @BeforeEach
    void init() {
        w = new World5Maps();
    }

    @Test
    void level51pos() {
        Sprite[][] level51 = {{Sprite.START, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.GOAL},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.BREAKABLE_WALL},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.HEART, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.AXE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},};

        Sprite[][] level5Get = w.getLevel51();
        boolean equal = true;
        for (int i = 0; i < level51.length; i++) {
            for (int j = 0; j < level51[i].length; j++) {
                if (level5Get[i][j] != level51[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level51neg() {
        Sprite[][] level51 = {{Sprite.START, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.GOAL},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.BREAKABLE_WALL},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.HEART, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.AXE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},};

        Sprite[][] level5Get = w.getLevel51();
        boolean equal = true;
        for (int i = 0; i < level51.length; i++) {
            for (int j = 0; j < level51[i].length; j++) {
                if (level5Get[i][j] != level51[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level52pos() {
        Sprite[][] level52 = {{Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.START},
                {Sprite.PATH, Sprite.AXE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.AXE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.GOAL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH}};

        Sprite[][] level5Get = w.getLevel52();
        boolean equal = true;
        for (int i = 0; i < level52.length; i++) {
            for (int j = 0; j < level52[i].length; j++) {
                if (level5Get[i][j] != level52[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level52neg() {
        Sprite[][] level52 = {{Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.START},
                {Sprite.PATH, Sprite.AXE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.AXE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.GOAL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH}};

        Sprite[][] level5Get = w.getLevel52();
        boolean equal = true;
        for (int i = 0; i < level52.length; i++) {
            for (int j = 0; j < level52[i].length; j++) {
                if (level5Get[i][j] != level52[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level53pos() {
        Sprite[][] level53 = {{Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.AXE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.COLLECTIBLE},
                {Sprite.START, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.BREAKABLE_WALL, Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.GOAL}};

        Sprite[][] level5Get = w.getLevel53();
        boolean equal = true;
        for (int i = 0; i < level53.length; i++) {
            for (int j = 0; j < level53[i].length; j++) {
                if (level5Get[i][j] != level53[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level53neg() {
        Sprite[][] level53 = {{Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.AXE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.COLLECTIBLE},
                {Sprite.START, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.BREAKABLE_WALL, Sprite.HEART, Sprite.START, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.GOAL}};

        Sprite[][] level5Get = w.getLevel53();
        boolean equal = true;
        for (int i = 0; i < level53.length; i++) {
            for (int j = 0; j < level53[i].length; j++) {
                if (level5Get[i][j] != level53[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level54pos() {
        Sprite[][] level54 = {{Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.AXE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.HEART, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.BREAKABLE_WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.GOAL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.START}};

        Sprite[][] level5Get = w.getLevel54();
        boolean equal = true;
        for (int i = 0; i < level54.length; i++) {
            for (int j = 0; j < level54[i].length; j++) {
                if (level5Get[i][j] != level54[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level54neg() {
        Sprite[][] level54 = {{Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.AXE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.HEART, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.BREAKABLE_WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.GOAL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.GOAL}};

        Sprite[][] level5Get = w.getLevel54();
        boolean equal = true;
        for (int i = 0; i < level54.length; i++) {
            for (int j = 0; j < level54[i].length; j++) {
                if (level5Get[i][j] != level54[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level55pos() {
        Sprite[][] level55 = {{Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.HEART},
                {Sprite.PATH, Sprite.HEART, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.AXE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.BREAKABLE_WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.HEART, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.START, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.GOAL}};

        Sprite[][] level5Get = w.getLevel55();
        boolean equal = true;
        for (int i = 0; i < level55.length; i++) {
            for (int j = 0; j < level55[i].length; j++) {
                if (level5Get[i][j] != level55[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level55neg() {
        Sprite[][] level55 = {{Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.HEART},
                {Sprite.PATH, Sprite.HEART, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.AXE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.BREAKABLE_WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.HEART, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.START, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.GOAL}};

        Sprite[][] level5Get = w.getLevel55();
        boolean equal = true;
        for (int i = 0; i < level55.length; i++) {
            for (int j = 0; j < level55[i].length; j++) {
                if (level5Get[i][j] != level55[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }
}
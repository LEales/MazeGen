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
        int[][] level51 = {{2, 0, 4, 1, 1, 0, 0, 0, 1, 4, 0, 1, 1, 1, 1, 3},
                {1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 4, 0, 0, 1, 1},
                {0, 4, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 6},
                {0, 0, 0, 1, 1, 0, 4, 1, 1, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 7, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 4, 1, 1, 4, 0, 4},
                {1, 1, 1, 1, 0, 1, 1, 4, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, 1, 0, 4},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 1, 1},
                {4, 1, 1, 4, 0, 4, 1, 0, 4, 0, 1, 0, 1, 0, 4, 0},
                {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1},
                {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {4, 0, 1, 1, 0, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 4, 1, 0, 0, 0, 4, 1, 1, 4, 1, 1, 4, 1, 1, 4},};
        int[][] level5Get = w.getLevel51();
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
        int[][] level51 = {{2, 0, 4, 1, 1, 0, 0, 0, 1, 4, 0, 1, 1, 1, 1, 3},
                {1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 4, 0, 0, 1, 1},
                {0, 4, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 6},
                {0, 0, 0, 1, 1, 0, 4, 1, 1, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 7, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 4, 1, 1, 4, 0, 4},
                {1, 1, 1, 1, 0, 1, 1, 4, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, 1, 0, 4},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 4, 0, 1, 1},
                {4, 1, 1, 4, 0, 4, 1, 0, 4, 0, 1, 0, 1, 0, 4, 0},
                {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1},
                {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {4, 0, 1, 1, 0, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 4, 1, 0, 0, 0, 4, 1, 1, 4, 1, 1, 4, 1, 0, 4},};
        int[][] level5Get = w.getLevel51();
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
        int[][] level52 = {{4, 0, 0, 4, 1, 1, 4, 0, 0, 0, 1, 1, 1, 1, 0, 2},
                {1, 5, 1, 1, 0, 0, 1, 1, 4, 1, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 0, 1},
                {4, 0, 1, 5, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 1, 4, 0, 0, 0, 0, 1, 4, 0, 1, 0, 0, 0, 7, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 4, 1, 0, 0, 1},
                {0, 1, 1, 4, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 1, 1, 4},
                {4, 0, 0, 1, 0, 0, 0, 0, 1, 1, 4, 1, 4, 0, 6, 0},
                {1, 0, 0, 1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 4, 1, 0, 0, 0, 1},
                {4, 1, 4, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {6, 0, 0, 0, 4, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 4},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                {3, 0, 0, 4, 1, 1, 1, 1, 4, 0, 1, 1, 1, 4, 1, 1}};
        int[][] level5Get = w.getLevel52();
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
        int[][] level52 = {{4, 0, 0, 4, 1, 1, 4, 0, 0, 0, 1, 1, 1, 1, 0, 2},
                {1, 5, 1, 1, 0, 0, 1, 1, 4, 1, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 0, 1},
                {4, 0, 1, 5, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                {1, 1, 4, 0, 0, 0, 0, 1, 4, 0, 1, 0, 0, 0, 7, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 4, 1, 0, 0, 1},
                {0, 1, 1, 4, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 1, 1, 4},
                {4, 0, 0, 1, 0, 0, 0, 0, 1, 1, 4, 1, 4, 0, 6, 0},
                {1, 0, 0, 1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 4, 1, 0, 0, 0, 1},
                {4, 1, 4, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {6, 0, 0, 0, 4, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 4},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                {3, 1, 0, 4, 1, 1, 1, 1, 4, 0, 1, 1, 1, 4, 1, 1}};
        int[][] level5Get = w.getLevel52();
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
        int[][] level53 = {{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 4, 1, 1, 1, 4, 1},
                {4, 1, 0, 0, 0, 1, 1, 0, 1, 4, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 4, 0, 0, 0, 1, 0},
                {4, 0, 1, 0, 4, 0, 0, 1, 1, 1, 1, 1, 0, 0, 4, 0},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
                {1, 0, 4, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 4, 0, 1, 1, 1, 1, 1, 1, 4, 0, 1},
                {4, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 6, 0, 4},
                {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 4},
                {0, 0, 1, 0, 4, 0, 0, 0, 1, 0, 1, 4, 1, 0, 0, 1},
                {1, 4, 1, 1, 1, 0, 1, 1, 1, 4, 1, 0, 0, 1, 1, 4},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 5, 0, 1, 0, 1, 0, 0, 4},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 4, 4},
                {2, 0, 0, 4, 6, 7, 0, 0, 1, 1, 4, 1, 0, 0, 4, 3}};
        int[][] level5Get = w.getLevel53();
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
        int[][] level53 = {{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 4, 1, 1, 1, 4, 1},
                {4, 1, 0, 0, 0, 1, 1, 0, 1, 4, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 4, 0, 0, 0, 1, 0},
                {4, 0, 1, 0, 4, 0, 0, 1, 1, 1, 1, 1, 0, 0, 4, 0},
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
                {1, 0, 4, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 4, 0, 1, 1, 1, 1, 1, 1, 4, 0, 1},
                {4, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 6, 0, 4},
                {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 4},
                {0, 0, 1, 0, 4, 0, 0, 0, 1, 0, 1, 4, 1, 0, 0, 1},
                {1, 4, 1, 1, 1, 0, 1, 1, 1, 4, 1, 0, 0, 1, 1, 4},
                {1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 5, 0, 1, 0, 1, 0, 0, 4},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 4, 4},
                {2, 0, 0, 4, 6, 7, 0, 0, 1, 1, 0, 1, 0, 0, 4, 3}};
        int[][] level5Get = w.getLevel53();
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
        int[][] level54 = {{1, 0, 0, 1, 1, 4, 1, 1, 0, 1, 1, 0, 1, 4, 1, 0},
                {1, 4, 1, 0, 0, 0, 0, 4, 1, 4, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 4, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 4, 0, 0, 1, 1, 4, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 4, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 5, 0, 1, 0, 0, 1, 1, 1},
                {4, 1, 0, 0, 4, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1},
                {0, 0, 1, 1, 1, 0, 0, 1, 7, 1, 0, 0, 1, 1, 1, 4},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                {4, 1, 1, 1, 1, 0, 1, 1, 1, 1, 4, 1, 0, 4, 1, 0},
                {1, 0, 1, 4, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {4, 0, 0, 0, 0, 0, 1, 1, 4, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 4, 1, 0, 1, 0, 1, 1, 4, 1, 0, 4},
                {0, 1, 1, 6, 4, 1, 1, 0, 4, 0, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 4, 0, 1, 1, 1},
                {3, 0, 0, 0, 0, 0, 1, 1, 4, 1, 1, 0, 0, 1, 0, 2}};
        int[][] level5Get = w.getLevel54();
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
        int[][] level54 = {{1, 0, 0, 1, 1, 4, 1, 1, 0, 1, 1, 0, 1, 4, 1, 0},
                {1, 4, 1, 0, 0, 0, 0, 4, 1, 4, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 4, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 4, 0, 0, 1, 1, 4, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 4, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0, 0, 5, 0, 1, 0, 0, 1, 1, 1},
                {4, 1, 0, 0, 4, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1},
                {0, 0, 1, 1, 1, 0, 0, 1, 7, 1, 0, 0, 1, 1, 1, 4},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                {4, 1, 1, 1, 1, 0, 1, 1, 1, 1, 4, 1, 0, 4, 1, 0},
                {1, 0, 1, 4, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {4, 0, 0, 0, 0, 0, 1, 1, 4, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 4, 1, 0, 1, 0, 1, 1, 4, 1, 0, 4},
                {0, 1, 1, 6, 4, 1, 1, 0, 4, 0, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 4, 0, 1, 1, 1},
                {3, 0, 0, 0, 0, 0, 1, 1, 4, 1, 1, 0, 1, 1, 0, 2}};
        int[][] level5Get = w.getLevel54();
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
        int[][] level55 = {{0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {4, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 7},
                {1, 7, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 4, 1, 1, 4, 1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 5, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 4, 0, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 4, 0, 0, 1, 0, 1, 1, 6, 1},
                {0, 1, 0, 0, 4, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 4},
                {0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1, 4, 0, 4, 1, 1, 1, 1, 0, 1, 0, 4},
                {0, 0, 4, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 7, 0, 1},
                {1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 4},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 3}};
        int[][] level5Get = w.getLevel55();
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
    void level65neg() {
        int[][] level55 = {{0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {4, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 7},
                {1, 7, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 4, 1, 1, 4, 1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 5, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 4, 0, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 4, 0, 0, 1, 0, 1, 1, 6, 1},
                {0, 1, 0, 0, 4, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 4},
                {0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1, 4, 0, 4, 1, 1, 1, 1, 0, 1, 0, 4},
                {0, 0, 4, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 7, 0, 1},
                {1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 4},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0}};
        int[][] level5Get = w.getLevel55();
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
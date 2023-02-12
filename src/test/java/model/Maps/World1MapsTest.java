package model.Maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Gets all maps in the first level of the campaign and tests that the correct one is returned.

class World1MapsTest {
    World1Maps w;

    @BeforeEach
    void init() {
        w = new World1Maps();
    }

    @Test
    void level11pos() {
        int[][] level11 = {{0, 0, 0, 0, 0, 0, 1, 3},
                {0, 0, 1, 1, 4, 1, 1, 1},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 4, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 4, 0},
                {1, 4, 1, 1, 0, 0, 0, 0},
                {2, 1, 1, 0, 0, 0, 0, 0}};
        int[][] level1Get = w.getLevel11();
        boolean equal = true;
        for (int i = 0; i < level11.length; i++) {
            for (int j = 0; j < level11[i].length; j++) {
                if (level1Get[i][j] != level11[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level11neg() {
        int[][] level11 = {{0, 1, 0, 0, 0, 0, 1, 3},
                {0, 0, 1, 1, 4, 1, 1, 1},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 4, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 4, 0},
                {1, 4, 1, 1, 0, 0, 0, 2},
                {2, 1, 1, 0, 0, 0, 0, 0}};
        int[][] level1Get = w.getLevel11();
        boolean equal = true;
        for (int i = 0; i < level11.length; i++) {
            for (int j = 0; j < level11[i].length; j++) {
                if (level1Get[i][j] != level11[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level12pos() {
        int[][] level12 = {{0, 0, 0, 0, 0, 0, 1, 2},
                {0, 4, 1, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 4, 0},
                {0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 4, 1, 0, 1, 1, 4, 1},
                {0, 0, 1, 1, 4, 0, 0, 3}};
        int[][] level1Get = w.getLevel12();
        boolean equal = true;
        for (int i = 0; i < level12.length; i++) {
            for (int j = 0; j < level12[i].length; j++) {
                if (level1Get[i][j] != level12[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level12neg() {
        int[][] level12 = {{0, 0, 0, 0, 0, 0, 1, 2},
                {0, 4, 1, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 4, 0},
                {0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 4, 1, 0, 1, 1, 4, 1},
                {0, 0, 1, 1, 4, 0, 0, 2}};
        int[][] level1Get = w.getLevel12();
        boolean equal = true;
        for (int i = 0; i < level12.length; i++) {
            for (int j = 0; j < level12[i].length; j++) {
                if (level1Get[i][j] != level12[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level13pos() {
        int[][] level13 = {{4, 0, 0, 0, 0, 0, 0, 4},
                {1, 0, 1, 1, 4, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 4, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 4, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 4, 1},
                {0, 3, 1, 4, 1, 0, 0, 2}};
        int[][] level1Get = w.getLevel13();
        boolean equal = true;
        for (int i = 0; i < level13.length; i++) {
            for (int j = 0; j < level13[i].length; j++) {
                if (level1Get[i][j] != level13[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level13neg() {
        int[][] level13 = {{4, 0, 0, 0, 0, 0, 0, 4},
                {1, 1, 1, 1, 4, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 4, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 1, 2, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 4, 1},
                {0, 3, 1, 4, 1, 0, 0, 2}};
        int[][] level1Get = w.getLevel13();
        boolean equal = true;
        for (int i = 0; i < level13.length; i++) {
            for (int j = 0; j < level13[i].length; j++) {
                if (level1Get[i][j] != level13[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level14pos() {
        int[][] level14 = {{0, 0, 0, 0, 0, 0, 0, 0},
                {4, 1, 0, 1, 4, 1, 0, 4},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 4, 1, 1},
                {4, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 4, 1, 0, 4},
                {0, 1, 0, 1, 0, 1, 4, 0},
                {0, 2, 1, 1, 0, 0, 1, 3}};
        int[][] level1Get = w.getLevel14();
        boolean equal = true;
        for (int i = 0; i < level14.length; i++) {
            for (int j = 0; j < level14[i].length; j++) {
                if (level1Get[i][j] != level14[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level14neg() {
        int[][] level14 = {{0, 2, 0, 0, 0, 0, 0, 0},
                {4, 1, 0, 1, 4, 1, 0, 4},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 4, 1, 0, 4, 1, 1},
                {4, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 4, 1, 0, 4},
                {0, 1, 0, 1, 0, 1, 4, 0},
                {0, 2, 1, 1, 0, 0, 1, 3}};
        int[][] level1Get = w.getLevel14();
        boolean equal = true;
        for (int i = 0; i < level14.length; i++) {
            for (int j = 0; j < level14[i].length; j++) {
                if (level1Get[i][j] != level14[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level15pos() {
        int[][] level15 = {{0, 0, 0, 0, 0, 4, 0, 0},
                {0, 4, 1, 5, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 4, 0, 1},
                {0, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 6, 0, 1, 1, 0, 0, 0},
                {4, 7, 4, 0, 1, 1, 1, 0},
                {4, 3, 4, 0, 0, 0, 1, 2}};
        int[][] level1Get = w.getLevel15();
        boolean equal = true;
        for (int i = 0; i < level15.length; i++) {
            for (int j = 0; j < level15[i].length; j++) {
                if (level1Get[i][j] != level15[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level15neg() {
        int[][] level15 = {{0, 0, 0, 0, 0, 4, 0, 0},
                {0, 4, 1, 5, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 4, 0, 1},
                {0, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 2, 1, 0},
                {0, 6, 0, 1, 1, 0, 0, 0},
                {4, 7, 4, 0, 1, 1, 1, 0},
                {4, 3, 4, 0, 0, 0, 1, 2}};
        int[][] level1Get = w.getLevel15();
        boolean equal = true;
        for (int i = 0; i < level15.length; i++) {
            for (int j = 0; j < level15[i].length; j++) {
                if (level1Get[i][j] != level15[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }
}
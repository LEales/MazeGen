package model.Maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class World1MapsTest {


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
       World1Maps w = new World1Maps();
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
        World1Maps w = new World1Maps();
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
        World1Maps w = new World1Maps();
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
        World1Maps w = new World1Maps();
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
    
}
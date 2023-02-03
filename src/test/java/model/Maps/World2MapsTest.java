package model.Maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class World2MapsTest {

    @Test
    void level21pos() {
        int[][] level = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 4, 1, 1, 0, 0, 0, 3, 0},
                {1, 1, 1, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 4, 1, 1, 0, 0},
                {1, 0, 4, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 1, 4, 0, 1, 1, 4},
                {1, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                {7, 0, 2, 0, 0, 1, 1, 1, 1, 4}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel21();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level21neg() {
        int[][] level = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 4, 1, 1, 0, 0, 0, 3, 0},
                {1, 1, 1, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 4, 1, 1, 0, 0},
                {1, 0, 4, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 1, 4, 0, 1, 1, 4},
                {1, 0, 1, 1, 0, 1, 4, 0, 0, 1},
                {7, 0, 2, 0, 0, 1, 1, 1, 1, 4}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel21();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level22pos() {
        int[][] level = {{0, 5, 1, 4, 0, 0, 4, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 0, 2, 0},
                {1, 4, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {4, 1, 0, 1, 1, 4, 0, 1, 4, 0},
                {0, 1, 0, 6, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 4, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 4, 0, 1, 0},
                {1, 4, 1, 1, 0, 3, 0, 0, 1, 4}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel22();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level22neg() {
        int[][] level = {{1, 5, 1, 4, 0, 0, 4, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 0, 2, 0},
                {1, 4, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {4, 1, 0, 1, 1, 4, 0, 1, 4, 0},
                {0, 1, 0, 6, 0, 1, 1, 0, 1, 4},
                {0, 1, 1, 4, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 4, 0, 1, 0},
                {1, 4, 1, 1, 0, 3, 0, 0, 1, 4}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel22();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level23pos() {
        int[][] level = {{0, 1, 1, 4, 0, 0, 1, 0, 0, 0},
                {1, 4, 0, 1, 0, 0, 1, 4, 6, 4},
                {4, 0, 1, 1, 0, 1, 1, 0, 0, 1},
                {1, 0, 4, 0, 0, 1, 0, 0, 0, 4},
                {4, 0, 1, 0, 0, 4, 1, 1, 0, 1},
                {1, 0, 4, 1, 0, 1, 0, 0, 0, 4},
                {4, 0, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 4, 1, 4, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {5, 4, 1, 1, 1, 2, 0, 0, 0, 3}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel23();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level23neg() {
        int[][] level = {{4, 1, 1, 4, 0, 0, 1, 0, 0, 0},
                {1, 4, 0, 1, 0, 0, 1, 4, 6, 4},
                {4, 0, 1, 1, 0, 1, 1, 0, 0, 1},
                {1, 0, 4, 0, 0, 1, 0, 0, 0, 4},
                {4, 0, 1, 0, 0, 4, 1, 1, 0, 1},
                {1, 0, 4, 1, 0, 1, 0, 0, 0, 4},
                {4, 0, 0, 1, 1, 1, 3, 1, 1, 1},
                {1, 1, 0, 0, 0, 4, 1, 4, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {5, 4, 1, 1, 1, 2, 0, 0, 0, 3}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel23();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level24pos() {
        int[][] level = {{0, 1, 4, 6, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 0, 1, 1, 1, 3},
                {0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 4, 1, 1, 1, 4},
                {5, 1, 1, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0 ,4},
                {0, 1, 4, 0, 0, 4, 1, 4, 0 ,1},
                {0, 4, 0, 0, 0, 1, 0, 1, 0 ,4},
                {0, 1, 1, 4, 0, 1, 0, 1, 0 ,1},
                {0, 0, 0, 1, 1, 1, 0, 1, 1 ,2}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel24();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level24neg() {
        int[][] level = {{0, 1, 4, 6, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 2, 1, 0, 1, 1, 1, 3},
                {0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 4, 1, 1, 1, 4},
                {5, 1, 1, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0, 0, 0 ,4},
                {0, 1, 4, 0, 0, 4, 1, 4, 0 ,1},
                {0, 4, 0, 0, 4, 1, 0, 1, 0 ,4},
                {0, 1, 1, 4, 0, 1, 0, 1, 0 ,1},
                {0, 0, 0, 1, 1, 1, 0, 1, 1 ,2}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel24();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level25pos() {
        int[][] level = {{0, 0, 0, 0, 0, 3, 0, 0, 5, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 1, 0, 0},
                {4, 1, 1, 0, 0, 1, 0, 0, 4, 1, 2},
                {1, 0, 1, 4, 0, 6, 0, 0, 1, 0, 0},
                {4, 1, 0, 1, 0, 1, 0, 0, 1, 4, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                {4, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 4, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {1, 0, 4, 1, 1, 0, 1, 0, 0, 1, 4},
                {4, 1, 1 ,0 ,1 ,6 ,1 ,1 ,4 ,1 ,0}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel25();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level25neg() {
        int[][] level = {{0, 2, 0, 0, 0, 3, 0, 0, 5, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 1, 0, 0},
                {4, 1, 1, 0, 0, 1, 0, 0, 4, 1, 2},
                {1, 0, 1, 4, 0, 6, 0, 0, 1, 0, 0},
                {4, 1, 4, 1, 0, 1, 0, 0, 1, 4, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                {4, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 4, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {1, 0, 4, 1, 1, 0, 1, 0, 0, 1, 4},
                {4, 1, 1 ,0 ,1 ,6 ,1 ,1 ,4 ,1 ,0}};
        World2Maps w = new World2Maps();
        int[][] level1Get = w.getLevel25();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level1Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

}
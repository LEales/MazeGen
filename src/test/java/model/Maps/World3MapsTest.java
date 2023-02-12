package model.Maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class World3MapsTest {
    World3Maps w;

    @BeforeEach
    void init() {
        w = new World3Maps();
    }

    @Test
    void level31pos() {
        int[][] level = {{0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 3},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 4, 0, 0, 0, 0, 0},
                {4, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 7, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 4, 0, 1, 0, 1, 0, 1, 1, 1},
                {4, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 4, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 4, 0, 0, 1, 0, 1, 0, 4, 0},
                {2, 1, 4, 1, 1, 1, 1, 1, 1, 0, 1, 0},};
        int[][] level1Get = w.getLevel31();
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
    void level31neg() {
        int[][] level = {{0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 3},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 2, 1, 4, 0, 0, 0, 0, 0},
                {4, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 7, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 4, 0, 1, 0, 1, 0, 1, 1, 1},
                {4, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 4, 0, 1, 1, 4, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 4, 0, 0, 1, 0, 1, 0, 4, 0},
                {2, 1, 4, 1, 1, 1, 1, 1, 1, 0, 1, 0},};
        int[][] level1Get = w.getLevel31();
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
    void level32pos() {
        int[][] level = {{1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 2},
                {1, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0, 0, 6, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {5, 0, 0, 0, 0, 0, 1, 1, 1, 1, 4, 3},};
        int[][] level1Get = w.getLevel32();
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
    void level32neg() {
        int[][] level = {{1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 2},
                {1, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 4, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0, 0, 6, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {5, 0, 0, 0, 0, 0, 1, 1, 1, 1, 4, 3},};
        int[][] level1Get = w.getLevel32();
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
    void level33pos() {
        int[][] level = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 4, 0, 1, 0, 4, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 0, 4, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 4, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},};
        int[][] level1Get = w.getLevel33();
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
    void level33neg() {
        int[][] level = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 4, 0, 1, 0, 4, 0, 0, 1, 0},
                {1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 0, 4, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 1, 4, 1, 1, 1, 1, 2},
                {1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},};
        int[][] level1Get = w.getLevel33();
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
    void level34pos() {
        int[][] level = {{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2},
                {0, 1, 1, 1, 0, 4, 0, 0, 0, 0, 0, 0},
                {1, 7, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 4, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 4, 1, 1, 7, 3},};
        int[][] level1Get = w.getLevel34();
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
    void level34neg() {
        int[][] level = {{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2},
                {0, 1, 1, 1, 0, 4, 0, 0, 0, 0, 0, 0},
                {1, 7, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0},
                {1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 4, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 4, 1, 1, 7, 3},};
        int[][] level1Get = w.getLevel34();
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
    void level35pos() {
        int[][] level = {{1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 3},
                {6, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 5, 0, 0, 0, 1, 4, 1, 1, 4},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
                {4, 0, 1, 0, 1, 0, 0, 0, 0, 4, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 2},};
        int[][] level1Get = w.getLevel35();
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
    void level35neg() {
        int[][] level = {{0, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 3},
                {6, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, 0, 0, 5, 0, 0, 0, 1, 4, 1, 1, 4},
                {1, 0, 1, 1, 1, 1, 1, 1, 2, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
                {4, 0, 1, 0, 1, 0, 0, 0, 0, 4, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 2},};
        int[][] level1Get = w.getLevel35();
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
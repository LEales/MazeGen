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
        Sprite[][] level11 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Goal},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall}};
        Sprite[][] level1Get = w.getLevel11();
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
        Sprite[][] level11 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Goal},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall}};
        Sprite[][] level1Get = w.getLevel11();
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
        Sprite[][] level12 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Start},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Goal}};
        Sprite[][] level1Get = w.getLevel12();
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
        Sprite[][] level12 = {{Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Start},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Goal}};
        Sprite[][] level1Get = w.getLevel12();
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
        Sprite[][] level13 = {{Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Wall, Sprite.Goal, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Start}};
        Sprite[][] level1Get = w.getLevel13();
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
        Sprite[][] level13 = {{Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Wall, Sprite.Goal, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Start}};
        Sprite[][] level1Get = w.getLevel13();
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
        Sprite[][] level14 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Goal}};
        Sprite[][] level1Get = w.getLevel14();
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
        Sprite[][] level14 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Goal}};
        Sprite[][] level1Get = w.getLevel14();
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
        Sprite[][] level15 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Axe, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Heart, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Goal, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Start}};
        Sprite[][] level1Get = w.getLevel15();
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
        Sprite[][] level15 = {{Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Axe, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Heart, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Goal, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Start}};
        Sprite[][] level1Get = w.getLevel15();
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
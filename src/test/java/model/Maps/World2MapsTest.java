package model.Maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Gets all maps in the second level of the campaign and tests that the correct one is returned.

class World2MapsTest {
    World2Maps w;

    @BeforeEach
    void init() {
        w = new World2Maps();
    }
    @Test
    void level21pos() {
        Sprite[][] level = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Heart, Sprite.Wall, Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible}};
        Sprite[][] level1Get = w.getLevel21();
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
        Sprite[][] level = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Heart, Sprite.Wall, Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible}};
        Sprite[][] level1Get = w.getLevel21();
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
        Sprite[][] level = {{Sprite.Wall, Sprite.Axe, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Start, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Goal, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible}};
        Sprite[][] level1Get = w.getLevel22();
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
        Sprite[][] level = {{Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Start, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Goal, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible}};
        Sprite[][] level1Get = w.getLevel22();
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
        Sprite[][] level = {{Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Axe, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal}};
        Sprite[][] level1Get = w.getLevel23();
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
        Sprite[][] level = {{Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Axe, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal}};
        Sprite[][] level1Get = w.getLevel23();
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
        Sprite[][] level = {{Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Goal},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Start}};
        Sprite[][] level1Get = w.getLevel24();
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
        Sprite[][] level = {{Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Goal},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Start}};
        Sprite[][] level1Get = w.getLevel24();
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
        Sprite[][] level = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal, Sprite.Wall, Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Start},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.BreakableWall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall}};
        Sprite[][] level1Get = w.getLevel25();
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
        Sprite[][] level = {{Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal, Sprite.Wall, Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Start},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.BreakableWall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall}};
        Sprite[][] level1Get = w.getLevel25();
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
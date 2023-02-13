package model.Maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Gets all maps in the fourth level of the campaign and tests that the correct one is returned.

class World4MapsTest {
    World4Maps w;

    @BeforeEach
    void init() {
        w = new World4Maps();
    }

    @Test
    void level41pos() {
        Sprite[][] level = new Sprite[][]{{Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Start},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Goal}};

        Sprite[][] level4Get = w.getLevel41();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level41neg() {
        Sprite[][] level = new Sprite[][]{{Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Start},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.BreakableWall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Goal}};

        Sprite[][] level4Get = w.getLevel41();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level42pos() {
        Sprite[][] level = new Sprite[][]{{Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Goal, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Start}};

        Sprite[][] level4Get = w.getLevel42();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level42neg() {
        Sprite[][] level = new Sprite[][]{{Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Goal, Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Start}};

        Sprite[][] level4Get = w.getLevel42();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level43pos() {
        Sprite[][] level = new Sprite[][]{{Sprite.Goal, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.BreakableWall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Axe, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Heart, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall},
                {Sprite.Start, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall}};

        Sprite[][] level4Get = w.getLevel43();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level43neg() {
        Sprite[][] level = new Sprite[][]{{Sprite.Heart, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.BreakableWall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Axe, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Heart, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall},
                {Sprite.Start, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall}};

        Sprite[][] level4Get = w.getLevel43();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level44pos() {
        Sprite[][] level = new Sprite[][]{{Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Axe, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal}};

        Sprite[][] level4Get = w.getLevel44();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level44neg() {
        Sprite[][] level = new Sprite[][]{{Sprite.Start, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Axe, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Goal}};

        Sprite[][] level4Get = w.getLevel44();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }

    @Test
    void level45pos() {
        Sprite[][] level = new Sprite[][]{{Sprite.Goal, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Start}};

        Sprite[][] level4Get = w.getLevel45();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertTrue(equal);
    }

    @Test
    void level45neg() {
        Sprite[][] level = new Sprite[][]{{Sprite.Goal, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.BreakableWall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Start}};

        Sprite[][] level4Get = w.getLevel45();
        boolean equal = true;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level4Get[i][j] != level[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        assertFalse(equal);
    }
}
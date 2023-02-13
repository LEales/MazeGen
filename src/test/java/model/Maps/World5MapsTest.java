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
        Sprite[][] level51 = {{Sprite.Start, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Goal},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.BreakableWall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Heart, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible},};

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
        Sprite[][] level51 = {{Sprite.Start, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Goal},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.BreakableWall},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Heart, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible},};

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
        Sprite[][] level52 = {{Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Start},
                {Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.BreakableWall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Goal, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path}};

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
        Sprite[][] level52 = {{Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Start},
                {Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.BreakableWall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Goal, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path}};

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
        Sprite[][] level53 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Axe, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Collectible},
                {Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.BreakableWall, Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Goal}};

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
        Sprite[][] level53 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.BreakableWall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Axe, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Collectible},
                {Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.BreakableWall, Sprite.Heart, Sprite.Start, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Goal}};

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
        Sprite[][] level54 = {{Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Heart, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.BreakableWall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Goal, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Start}};

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
        Sprite[][] level54 = {{Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Axe, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Heart, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall},
                {Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path},
                {Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.BreakableWall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Goal, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Goal}};

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
        Sprite[][] level55 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Heart},
                {Sprite.Path, Sprite.Heart, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.BreakableWall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Heart, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Goal}};

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
        Sprite[][] level55 = {{Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall},
                {Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Heart},
                {Sprite.Path, Sprite.Heart, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Axe, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.BreakableWall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Path, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path},
                {Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Collectible, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Wall, Sprite.Wall, Sprite.Collectible, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Heart, Sprite.Wall, Sprite.Path},
                {Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Path, Sprite.Wall, Sprite.Collectible},
                {Sprite.Start, Sprite.Wall, Sprite.Wall, Sprite.Heart, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Wall, Sprite.Path, Sprite.Path, Sprite.Path, Sprite.Wall, Sprite.Goal}};

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
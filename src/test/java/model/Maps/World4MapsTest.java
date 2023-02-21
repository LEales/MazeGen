package model.Maps;

import model.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Gets all maps in the fourth level of the campaign and tests that the correct one is returned.

class World4MapsTest {
    private World4Maps w;
    private World world;
    private int heartCrystals;
    private int seconds;
    private int nextLevel;


    @BeforeEach
    void init() {
        world = World.CLOUD;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);
    }



    @Test
    void level41pos() {
        nextLevel = 1;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);
        Sprite[][] level = {{Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.START},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.GOAL}};

        Sprite[][] level4Get = w.getMap();
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

        nextLevel = 1;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);
        Sprite[][] level = new Sprite[][]{{Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.START},
               {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.BREAKABLE_WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.GOAL}};

        Sprite[][] level4Get = w.getMap();
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

        nextLevel = 2;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);


        Sprite[][] level = {{Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.GOAL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.START}};

        Sprite[][] level4Get = w.getMap();
        boolean equal = true;
        for (int i = 0; i < level4Get.length; i++) {

            for (int j = 0; j < level[i].length; j++) {
                System.out.println(level4Get[i][j] + " and " + level[i][j] );
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

        nextLevel = 2;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);
        Sprite[][] level = {{Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},

                {Sprite.GOAL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.START}};

        Sprite[][] level4Get = w.getMap();
        boolean equal = true;
        for (int i = 0; i < level4Get.length; i++) {
            for (int j = 0; j < level4Get[i].length; j++) {
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

        nextLevel = 3;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);

        Sprite[][] level = {{Sprite.GOAL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.AXE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.HEART, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL},
                {Sprite.START, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL}};

        Sprite[][] level4Get = w.getMap();
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

        nextLevel = 3;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);
        Sprite[][] level = new Sprite[][]{{Sprite.HEART, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
 {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.AXE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.HEART, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL},
                {Sprite.START, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL}};

        Sprite[][] level4Get = w.getMap();
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

        nextLevel = 4;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);

        Sprite[][] level = {{Sprite.START, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.AXE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.BREAKABLE_WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.GOAL}};

        Sprite[][] level4Get = w.getMap();
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

        nextLevel = 4;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);
        Sprite[][] level ={{Sprite.START, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.AXE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.BREAKABLE_WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.AXE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.GOAL}};

        Sprite[][] level4Get = w.getMap();
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

        nextLevel = 5;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);

        Sprite[][] level = {{Sprite.GOAL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.BREAKABLE_WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.AXE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.START}};

        Sprite[][] level4Get = w.getMap();
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

        nextLevel = 5;
        w = new World4Maps(heartCrystals,seconds,nextLevel,world);

        Sprite[][] level = {{Sprite.GOAL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
                {Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.BREAKABLE_WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL},
                {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE},
                {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH},
                {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
                {Sprite.AXE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.START}};

        Sprite[][] level4Get = w.getMap();
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
    public void HeartCrystalBoundaryHigh() {
        heartCrystals = 3;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(3, w.getHeartCrystals());
    }
    @Test
    public void HeartCrystalBoundaryLow() {
        heartCrystals = 1;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(1, w.getHeartCrystals());
    }

    @Test
    public void SecondsHighBoundary() {
        seconds = 25;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(25, w.getSeconds());
    }

    @Test
    public void SecondsMidBoundary() {
        seconds = 15;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(15, w.getSeconds());
    }

    @Test
    public void SecondsLowBoundary() {
        seconds = 0;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(0, w.getSeconds());
    }

    @Test
    public void SecondsInvalidBoundary() {
        seconds = -1;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(-1, w.getSeconds());
    }

    @Test
    public void NextLevelBoundaryHigh() {
        nextLevel = 3;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(3, w.getNextLevel());
    }
    @Test

    public void NextLevelBoundaryLow() {
        nextLevel = 0;
        w = new World4Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(0, w.getNextLevel());
    }






}
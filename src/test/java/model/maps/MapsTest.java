package model.maps;

import static org.junit.Assert.*;
import org.junit.*;

import model.enums.Sprite;
import model.enums.World;
import model.maps.*;

public class MapsTest {

    private Maps map;

    @Test
    public void constructorHeartsLow() {
        map = new TestMaps(1,1,1,World.FOREST);
        assertEquals(1, map.getHeartCrystals());
    }

    @Test
    public void constructorHeartsHigh() {
        map = new TestMaps(3,1,1,World.FOREST);
        assertEquals(3, map.getHeartCrystals());
    }

    //Ska inte gå att ha minus hjärtan
    @Test
    public void constructorHeartsInvalid() {
        map = new TestMaps(-1,1,1,World.FOREST);
        assertTrue(map.getHeartCrystals()>0);
    }
    @Test
    public void constructorSecondsLow() {
        map = new TestMaps(1,0,1,World.FOREST);
        assertEquals(0, map.getSeconds());
    }

    @Test
    public void constructorSecondsHigh() {
        map = new TestMaps(1,25,1,World.FOREST);
        assertEquals(25, map.getSeconds());
    }


    @Test
    public void heartsLost() {
        map = new TestMaps(3,1,1,World.FOREST);
        assertTrue(map.getHeartCrystals()==3);
        map.heartCrystalLost();
        map.heartCrystalLost();
        map.heartCrystalLost();
        assertTrue(map.getHeartCrystals()==0);
    }

    @Test
    public void incrementCollectible() {
        map = new TestMaps(1,1,1,World.FOREST);
        map.incrementCollectible();
        assertFalse(map.allCollectiblesObtained());
    }

    @Test
    public void incrementCollectiblesObtained() {
        map = new TestMaps(1,1,1,World.FOREST);
        map.incrementCollectible();
        assertFalse(map.allCollectiblesObtained());
        map.incrementCollectiblesObtained();
        assertTrue(map.allCollectiblesObtained());
    }

    @Test
    public void setPickAxeInInventory() {
        map = new TestMaps(1,1,1,World.FOREST);
        assertFalse(map.isPickAxeInInventory());
        map.setPickAxeInInventory(true);
        assertTrue(map.isPickAxeInInventory());
    }

    @Test
    public void setGameStarted() {
        map = new TestMaps(1,1,1,World.FOREST);
        assertFalse(map.isGameStarted());
        map.setGameStarted(true);
        assertTrue(map.isGameStarted());
    }

    @Test
    public void setTimeStarted() {
        map = new TestMaps(1,1,1,World.FOREST);
        assertFalse(map.isTimeStarted());
        map.setTimeStarted(true);
        assertTrue(map.isTimeStarted());
    }

    @Test
    public void SetWorld(){
        map = new TestMaps(1,1,1,World.LAVA);
        map.setWorld(World.FOREST);
        assertEquals(World.FOREST,map.getWorld());
    }
    //Maps är en abstract-klass
    private static class TestMaps extends Maps {

        private Sprite[][] map = {
                { Sprite.START, Sprite.PATH, Sprite.COLLECTIBLE },
                { Sprite.HEART, Sprite.WALL, Sprite.PATH },
                { Sprite.GOAL, Sprite.PATH, Sprite.PATH },
        };

        public TestMaps(int heartCrystals, int seconds, int nextLevel, World world) {
            super(heartCrystals, seconds, nextLevel, world);
        }

        @Override
        public Sprite[][] getMap() {
            return map;
        }
    }


}

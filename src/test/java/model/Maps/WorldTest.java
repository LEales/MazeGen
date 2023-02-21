package model.Maps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import model.Maps.World1Maps;
import model.World;

public class WorldTest {
    World world = World.CLOUD;
    int heartCrystals = 1;
    int seconds = 25;
    int nextLevel = 1;
    World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);

    @Test
    public void HeartCrystalBoundaryHigh() {
        heartCrystals = 3;
        World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(3, world1Maps.getHeartCrystals());
    }
    @Test
    public void HeartCrystalBoundaryLow() {
        heartCrystals = 1;
        World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(1, world1Maps.getHeartCrystals());
    }

    @Test
    public void testSecondsHighBoundary() {
        seconds = 25;
        World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(25, world1Maps.getSeconds());
    }

    @Test
    public void testSecondsMidBoundary() {
        seconds = 15;
        World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(15, world1Maps.getSeconds());
    }

    @Test
    public void testSecondsLowBoundary() {
        seconds = 0;
        World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(0, world1Maps.getSeconds());
    }

    @Test
    public void testSecondsInvalidBoundary() {
        seconds = -1;
        World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(-1, world1Maps.getSeconds());
    }

    @Test
    public void testNextLevelBoundaryHigh() {
        nextLevel = 3;
        World1Maps world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(3, world1Maps.getNextLevel());
    }
    @Test

    public void testNextLevelBoundaryLow() {
        nextLevel = 0;
        world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(0, world1Maps.getNextLevel());
    }




 /*

    @Test
    public void testHeartCrystalBoundary3() {
        heartCrystals = 3;
        world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(3, world1Maps.getHeartCrystals());
    }

    @Test
    public void testSecondsBoundary() {
        assertEquals(25, world1Maps.getSeconds());
    }

    @Test
    public void testNextLevelBoundary0() {
        assertEquals(0, world1Maps.getNextLevel());
    }

    @Test
    public void testNextLevelBoundary5() {
        nextLevel = 5;
        world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(5, world1Maps.getNextLevel());
    }

    @Test
    public void testWorldBoundary0() {
        assertEquals(0, world1Maps.getWorld());
    }

    @Test
    public void testWorldBoundary5() {
        world = World.CLOUD;
        world1Maps = new World1Maps(heartCrystals, seconds, nextLevel, world);
        assertEquals(5, world1Maps.getWorld());
    }
    @Test
    void testWorldMiddle() {
        World1Maps maps = new World1Maps(1, 25, 0, world);
        assertEquals(world, maps.getWorld());
    }

    // Test cases for getMap
    @Test
    void testGetMapLowerBound() {
        World1Maps maps = new World1Maps(1, 25, 0, world);
        assertEquals("res/maps/world1/1.tmx", maps.getMap());
    }

    @Test
    void testGetMapMiddle() {
        World1Maps maps = new World1Maps(2, 25, 0, world);
        assertEquals("res/maps/world1/2.tmx", maps.getMap());
    }

    @Test
    void testGetMapUpperBound() {
        World1Maps maps = new World1Maps(3, 25, 3, world);
        assertEquals("res/maps/world1/3.tmx", maps.getMap());
    }

    // Test cases for getSprite



  */
}

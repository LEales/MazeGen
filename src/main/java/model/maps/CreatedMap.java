package model.maps;

import model.enums.Sprite;
import model.enums.World;

import java.io.Serializable;
import java.util.Objects;

public class CreatedMap implements Serializable {

    private final World world;
    private final int seconds;
    private Sprite[][] map;
    public int dimension;

    private final String name;

    private int collectibles, collectiblesObtained, heartCrystals;
    private boolean pickAxeInInventory, gameStarted, timeStarted;
    public static final long serialVersionUID = 329832084320L;
    public CreatedMap(int heartCrystals, int seconds, int dimension, String name, World world) {
        if(0 > heartCrystals) {
            throw new IllegalArgumentException("Invalid input: Negative amount of heartcrystals");
        }
        if(0 > seconds) {
            throw new IllegalArgumentException("Invalid input: Negative amout of seconds");
        }
        if( 0 > dimension) {
            throw new IllegalArgumentException("Invalid input: Negative dimension");
        }
        this.heartCrystals = heartCrystals;
        this.seconds = seconds;
        this.dimension = dimension;
        this.name = name;
        this.world = world;
        map = new Sprite[dimension][dimension];
    }
    public CreatedMap() {
        this(3,45,10,"DEFAULT",World.FOREST);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        CreatedMap that = (CreatedMap) o;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    public void incrementCollectible() {
        collectibles++;
    }

    public void incrementCollectiblesObtained() {
        collectiblesObtained++;
    }

    public boolean allCollectiblesObtained() {
        return collectibles == collectiblesObtained;
    }

    public boolean heartCrystalLost() {
        return 0 == --heartCrystals;
    }

    public void heartCrystalCollected() {
        if (3 > heartCrystals) {
            heartCrystals++;
        }
    }

    public void setPickAxeInInventory(boolean pickAxeInInventory) {
        this.pickAxeInInventory = pickAxeInInventory;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public boolean isTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(boolean timeStarted) {
        this.timeStarted = timeStarted;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public boolean isPickAxeInInventory() {
        return this.pickAxeInInventory;
    }

    public World getWorld() {
        return world;
    }

    public int getHeartCrystals() {
        return this.heartCrystals;
    }

    public Sprite[][] getMap() {
        return map;
    }


    public void setSprite(int x, int y, Sprite sprite) {
        if (!validate(x, y) || null == sprite) {
            throw new RuntimeException("Invalid parameters");
        }
        map[x][y] = sprite;
    }

    private boolean validate(int x, int y) {
        return (x >= 0 && x < dimension) && (y >= 0 && y < dimension);
    }
}

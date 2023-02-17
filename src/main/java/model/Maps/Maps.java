package model.Maps;

import javafx.scene.control.Label;
import model.World;
import java.util.HashSet;

public abstract class Maps {
    HashSet<Label> destroyedWalls = new HashSet<>();
    private boolean pickAxeInInventory, gameStarted, timeStarted;
    private final int seconds, nextLevel;
    private int collectibles;
    private int collectiblesObtained;
    private int heartCrystals;
    private final World world;

    public Maps(int heartCrystals, int seconds, int nextLevel, World world) {
        this.seconds = seconds;
        this.heartCrystals = heartCrystals;
        this.nextLevel = nextLevel;
        this.world = world;
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

    public boolean destroyWall(Label label) {
        if (pickAxeInInventory) {
            destroyedWalls.add(label);
            return true;
        }
        return false;
    }

    public boolean isWallDestroyed(Label label) {
        return destroyedWalls.contains(label);
    }

    public boolean heartCrystalLost() {
        return 0 == --heartCrystals;
    }

    public void heartCrystalCollected() {
        if (3 > heartCrystals) {
            heartCrystals++;
        }
    }

    public boolean noHeartCrystalsLeft() {
        return 0 == heartCrystals;
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

    public int getNextLevel() {
        return nextLevel;
    }

    public World getWorld() {
        return world;
    }

    public int getHeartCrystals() {
        return this.heartCrystals;
    }

    public abstract Sprite[][] getMap();
}

package model.maps;

import model.enums.Sprite;
import model.enums.World;


public abstract class Maps {
    private World world;
    private final int seconds, nextLevel;
    private int collectibles, collectiblesObtained, heartCrystals;
    private boolean pickAxeInInventory, gameStarted, timeStarted;

    public Maps(int heartCrystals, int seconds, int nextLevel, World world) {
        this.seconds = seconds;
        this.heartCrystals = heartCrystals;
        this.nextLevel = nextLevel;
        this.world = world;
    }

    public Maps(int heartCrystals, int seconds) {
        this.heartCrystals = heartCrystals;
        this.seconds = seconds;
        this.nextLevel = 0;
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

    public void setWorld(World world) {
        this.world = world;
    }


}

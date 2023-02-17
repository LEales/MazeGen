package model.Maps;

import model.World;

/**
 * @author André Eklund, Sebastian Helin, Viktor Näslund, Filip Örnling
 * @edit Teodor Wegestål, Luke Eales - Changed int[][] to Sprite[][]
 */

public class World3Maps extends Maps {

    public World3Maps(int heartCrystals, int seconds, int nextLevel, World world) {
        super(heartCrystals, seconds, nextLevel, world);
    }
    private final Sprite[][] level31 = {{Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.GOAL},
            {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
            {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
            {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL},
            {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL},
            {Sprite.START, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL}};

    private final Sprite[][] level32 = {{Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.START},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
            {Sprite.AXE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.GOAL}};

    private final Sprite[][] level33 = {{Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.GOAL},
            {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
            {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL},
            {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
            {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
            {Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.START}};

    private final Sprite[][] level34 = {{Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.START},
            {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.HEART, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL},
            {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
            {Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.HEART, Sprite.GOAL}};

    private final Sprite[][] level35 = {{Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.GOAL},
            {Sprite.BREAKABLE_WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL},
            {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.AXE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
            {Sprite.COLLECTIBLE, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL},
            {Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
            {Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH},
            {Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.START}};


    /**
     * Returnerar en array som representerar en nivå i spelet.
     *
     * @return returnerar en array av siffror.
     */
    public Sprite[][] getMap() {
        return switch (getNextLevel()) {
            case 1 -> level31;
            case 2 -> level32;
            case 3 -> level33;
            case 4 -> level34;
            case 5 -> level35;
            default -> throw new IllegalStateException("Unexpected value: " + getNextLevel());
        };
    }
}

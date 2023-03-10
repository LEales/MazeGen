package model.maps;

import model.enums.Sprite;
import model.enums.World;

/**
 * @author André Eklund, Sebastian Helin, Viktor Näslund, Filip Örnling
 * @edit Teodor Wegestål, Luke Eales - Changed int[][] to Sprite[][]
 */
public class World4Maps extends Maps {

    public World4Maps(int heartCrystals, int seconds, int nextLevel, World world) {
        super(heartCrystals, seconds, nextLevel, world);
    }

    private final Sprite[][] level41 = {{Sprite.HEART, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.START},
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

    private final Sprite[][] level42 = {{Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.HEART, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.WALL, Sprite.WALL, Sprite.PATH, Sprite.PATH, Sprite.PATH, Sprite.PATH},
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


    private final Sprite[][] level43 = {{Sprite.GOAL, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.BREAKABLE_WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.WALL, Sprite.WALL, Sprite.COLLECTIBLE},
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

    private final Sprite[][] level44 = {{Sprite.START, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.WALL, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH},
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

    private final Sprite[][] level45 = {{Sprite.GOAL, Sprite.PATH, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.PATH, Sprite.COLLECTIBLE, Sprite.WALL, Sprite.COLLECTIBLE, Sprite.PATH, Sprite.COLLECTIBLE},
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

    /**
     * Returnerar en array som representerar en nivå i spelet.
     *
     * @return returnerar en array av siffror.
     */
    public Sprite[][] getMap() {
        return switch (getNextLevel() - 1) {
            case 1 -> level41;
            case 2 -> level42;
            case 3 -> level43;
            case 4 -> level44;
            case 5 -> level45;
            default -> throw new IllegalStateException("Unexpected value: " + getNextLevel());
        };
    }
}

package model.Maps;

import java.util.Arrays;

public class RandomizeMap extends Maps {

    private Sprite[][] map;
    public int dimension;

    public RandomizeMap(int heartCrystals, int seconds, int dimension) {
        super(heartCrystals, seconds);
        this.dimension = dimension;
        map = new Sprite[dimension][dimension];
    }

    public void fillArray() {
        for (Sprite[] sprites : map) {
            Arrays.fill(sprites, Sprite.WALL);
        }
    }

    @Override
    public Sprite[][] getMap() {
        return map;
    }

    public void setMap(Sprite[][] map) {
        this.map = map;
    }

    public void setSprite(int y, int x, Sprite sprite) {
        map[y][x] = sprite;
    }

    public boolean spriteEquals(int y, int x, Sprite sprite) {
        return map[y][x] == sprite;
    }

    public Sprite getSprite(int x, int y) {
        return map[x][y];
    }
}

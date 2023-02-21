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

    public void setSprite(int x, int y, Sprite sprite) {
        if (!validate(x, y) || null == sprite) {
            throw new RuntimeException("Invalid parameters");
        }
        map[x][y] = sprite;
    }

    public boolean spriteEquals(int x, int y, Sprite sprite) {
        if (!validate(x, y) || null == sprite) {
            throw new RuntimeException("Invalid parameters");
        }
        return map[x][y] == sprite;
    }

    public Sprite getSprite(int x, int y) {
        if (validate(x, y)) {
            return map[x][y];
        }
        return null;
    }

    private boolean validate(int x, int y) {
        return (x >= 0 && x < dimension) && (y >= 0 && y < dimension);
    }
}

package model.Maps;

public class RandomizeMap extends Maps {

    Sprite[][] map;

    int dimension;

    public RandomizeMap(int heartCrystals, int seconds, int dimension) {
        super(heartCrystals, seconds);
        this.dimension = dimension;
    }

    @Override
    public Sprite[][] getMap() {
        return map;
    }
    public void setMap(Sprite[][] map) {
        this.map = map;
    }

}

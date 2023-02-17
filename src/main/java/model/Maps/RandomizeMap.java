package model.Maps;

public class RandomizeMap extends Maps {

    private Sprite[][] map;

    public RandomizeMap(int heartCrystals, int seconds) {
        super(heartCrystals, seconds);
    }

    @Override
    public Sprite[][] getMap() {
        return map;
    }

    public void setMap(Sprite[][] map) {
        this.map = map;
    }

}

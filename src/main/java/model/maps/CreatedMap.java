package model.maps;

public class CreatedMap extends RandomizeMap {

    private String name;
    public CreatedMap(int heartCrystals, int seconds, int dimension, String name) {
        super(heartCrystals, seconds, dimension);
        this.name = name;
    }
}

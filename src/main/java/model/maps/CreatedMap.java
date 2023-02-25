package model.maps;

import java.io.Serializable;
import java.util.Objects;

public class CreatedMap extends RandomizeMap implements Serializable {
    public static final long serialVersionUID = 432143219847L;
    private String name;
    public CreatedMap(int heartCrystals, int seconds, int dimension, String name) {
        super(heartCrystals, seconds, dimension);
        this.name = name;
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
}

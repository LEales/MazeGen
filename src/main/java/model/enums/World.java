package model.enums;

import java.io.Serializable;

/**
 * @author Luke Eales, Teodor Wegestål
 * enum for handling the worlds
 */
public enum World implements Serializable {
    FOREST("forest"),
    LAVA("lava"),
    UNDERGROUND("underground"),
    DESERT("desert"),
    SPACE("space"),
    CLOUD("cloud");

    String name;
    public static final long serialVersionUID = 43214324903248L;

    World(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


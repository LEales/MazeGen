package model;

/**
 * @author Luke Eales, Teodor Wegestål
 * enum for handling the worlds
 */
public enum World {
    FOREST("forest"),
    LAVA("lava"),
    UNDERGROUND("underground"),
    DESERT("desert"),
    SPACE("space"),
    CLOUD("cloud");

    String name;

    World(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


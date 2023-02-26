package model.enums;

import java.io.Serializable;

/**
 * @author Luke Eales, Teodor Wegestål
 * Enums for sprites
 */
public enum Sprite implements Serializable {
    WALL,
    BREAKABLE_WALL,
    START,
    GOAL,
    COLLECTIBLE,
    AXE,
    PATH,
    HEART;

    public static final long serialVersionUID = 43214321839211L;
}

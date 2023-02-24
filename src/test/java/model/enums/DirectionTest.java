package model.enums;

import model.enums.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    public void EnumValues() {
        Assertions.assertEquals("NORTH", Direction.NORTH.toString());
        Assertions.assertEquals("EAST", Direction.EAST.toString());
        Assertions.assertEquals("SOUTH", Direction.SOUTH.toString());
        Assertions.assertEquals("WEST", Direction.WEST.toString());

    }

}
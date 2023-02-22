package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorldTest {

    @Test
    public void EnumValues() {
        Assertions.assertEquals("forest", World.FOREST.toString());
        Assertions.assertEquals("lava", World.LAVA.toString());
        Assertions.assertEquals("underground", World.UNDERGROUND.toString());
        Assertions.assertEquals("desert", World.DESERT.toString());
        Assertions.assertEquals("space", World.SPACE.toString());
        Assertions.assertEquals("cloud", World.CLOUD.toString());
    }


}

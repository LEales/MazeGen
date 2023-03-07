package view;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TutorialScreenTest {
    @Test
    void testBackspaceIconExists() {
        File file = new File("files/skip_tutorial.png");
        assertTrue(file.exists());
    }
}

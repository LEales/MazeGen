package view;

import control.MainProgram;
import javafx.application.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverScreenTest {

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }
/*
    @Test
    void gameOverAnimation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        MainProgram mp = MainProgram.getMainProgram();
        GameOverScreen gms = new GameOverScreen(mp);
        assertTrue(gms.gameOverAnimation());
    }

 */
}
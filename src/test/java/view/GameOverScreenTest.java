package view;

import control.MainProgram;
import javafx.application.Application;
import model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GameOverScreenTest {

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }
    @Test
    void gameOverAnimation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        Player player = new Player("SVE", 1, 1);
        GameOverScreen gms = new GameOverScreen(player);
        Method gameOver = GameOverScreen.class.getDeclaredMethod("gameOverAnimation");
        gameOver.setAccessible(true);
        assertTrue((Boolean) gameOver.invoke(gms));
    }
}
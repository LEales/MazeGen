package view.menu;

import control.MainProgram;
import javafx.application.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import static org.junit.jupiter.api.Assertions.*;

class HighscoreListTest {

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }

    //Test that the right amount of Players are present in the highscore list.
    @Test
    void setupHighscore() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MainProgram mp = MainProgram.getMainProgram();
        HighscoreList h = mp.getHighscoreList();
        int count = 0;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/ScoreList.dat"))) {
            while (ois.readObject() != null) {
                count++;
            }
        } catch (Exception ignored) {
        }
        assertEquals(count, h.setupHighscoreList());
    }
}
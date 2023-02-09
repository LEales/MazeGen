package view;

import com.sun.javafx.scene.control.skin.Utils;
import control.MainProgram;
import javafx.application.Application;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.Menu.HighscoreList;
import model.PlayerScore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class VictoryScreenTest {
    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }

    @Test
    void addScoresAndCheckOrder() {
        fail("Test not working due to objectstreams");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Platform.runLater(() -> {
            MainProgram mp = MainProgram.getMainProgram();
            VictoryScreen v = mp.getVictoryScreen();
            File file = new File("files/ScoreList.dat");
            if (!file.delete()) {
                fail("failed to delete file");
            }
            file = null;

            addScores(new int[]{10, 20, 30}, v);
            addScores(new int[]{0, 20, 30}, v);
            addScores(new int[]{9, 20, 30}, v);
            addScores(new int[]{8, 20, 30}, v);
            addScores(new int[]{10, 20, 29}, v);
            addScores(new int[]{10, 20, 31}, v);
            addScores(new int[]{7, 20, 30}, v);
            addScores(new int[]{3, 20, 30}, v);
            addScores(new int[]{2, 20, 30}, v);
            addScores(new int[]{1, 20, 30}, v);
            addScores(new int[]{5, 20, 30}, v);
            addScores(new int[]{6, 20, 30}, v);
            addScores(new int[]{0, 0, 1}, v);

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/ScoreList.dat"))) {
                Object o;
                int[] expected = {1, 1230, 4830, 8430, 12030, 19230, 22830, 26430, 30030, 33630};
                int i = 0;
                while ((o = ois.readObject()) != null) {
                    PlayerScore ps = (PlayerScore) o;
                    assertEquals(expected[i++], ps.getTotalTimeInSeconds());
                }
            } catch (Exception e) {
                fail("failed to read file");
            }
        });
    }

    void addScores(int[] time, VictoryScreen v) {
        v.setTime(time);
        try {
            getAddToScoreList().invoke(v);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("fail");
            //fail("cant invoke method");
            throw new RuntimeException(e);
        }
    }

    Method getAddToScoreList() {
        Method method = null;
        try {
            method = VictoryScreen.class.getDeclaredMethod("addToScoreList");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        method.setAccessible(true);
        return method;
    }

}
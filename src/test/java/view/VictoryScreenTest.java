package view;

import control.MainProgram;
import javafx.application.Application;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import model.PlayerScore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class VictoryScreenTest {
    VictoryScreen v;

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }

    //Tests that players appear in the correct order based on finished maps
    @Test
    void addScoreMapOrder() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Platform.runLater(() -> {
            MainProgram mp = MainProgram.getMainProgram();
            v = mp.getVictoryScreen();
            File file = new File("files/ScoreList.dat");
            file.delete();
            try {
                mp.nextWorld6Level(1, 3);
                addScores(0, v);
                mp.nextWorld6Level(2, 3);
                addScores(0, v);
                mp.nextWorld5Level(4, 3);
                addScores(0, v);
                mp.nextWorld5Level(1, 3);
                addScores(0, v);
                mp.nextWorld4Level(1, 3);
                addScores(0, v);
                mp.nextWorld4Level(1, 3);
                addScores(0, v);
                mp.nextWorld3Level(1, 3);
                addScores(0, v);
                mp.nextWorld2Level(1, 3);
                addScores(0, v);
                mp.nextWorld1Level(1, 3);
                addScores(0, v);
                mp.nextWorld6Level(6, 3);
                addScores(0, v);
            } catch (FileNotFoundException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/ScoreList.dat"))) {
            Object o;
            int[] expected = {66, 62, 61, 54, 51, 41, 41, 31, 21, 11};
            int i = 0;
            while ((o = ois.readObject()) != null) {
                PlayerScore ps = (PlayerScore) o;
                assertEquals(expected[i++], ps.getLvl());
            }
        } catch (Exception e) {
            fail("failed to read file");
        }


    }

    //Tests that players appear in the correct order based on time.
    @Test
    void addScoresAndCheckOrderByTime() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Platform.runLater(() -> {
            MainProgram mp = MainProgram.getMainProgram();
            v = mp.getVictoryScreen();

            File file = new File("files/ScoreList.dat");
            file.delete();
            addScores(33631, v);
            addScores(1230, v);
            addScores(33630, v);
            addScores(30030, v);
            addScores(37809, v);
            addScores(41999, v);
            addScores(26430, v);
            addScores(12030, v);
            addScores(8430, v);
            addScores(4830, v);
            addScores(19230, v);
            addScores(22830, v);
            addScores(1, v);
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/ScoreList.dat"))) {
            Object o;
            int[] expected = {1, 1230, 4830, 8430, 12030, 19230, 22830, 26430, 30030, 33630};
            int i = 0;
            while ((o = ois.readObject()) != null) {
                PlayerScore ps = (PlayerScore) o;
                assertEquals(expected[i++], ps.getSeconds());
            }
        } catch (Exception e) {
            fail("failed to read file");
        }
    }

    //help methods for access to private methods.
    void addScores(int time, VictoryScreen v) {
        v.setTime(time);
        try {
            getAddToScoreList().invoke(v);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("fail");
            //fail("cant invoke method");
            throw new RuntimeException(e);
        }
    }
    //help methods for access to private methods.
    Method getAddToScoreList() {
        Method method;
        try {
            method = VictoryScreen.class.getDeclaredMethod("updateToScoreList");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        method.setAccessible(true);
        return method;
    }

    //tests the sorting algorithm based on levels completed.
    @Test
    void playerScoreSortLevel() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        MainProgram mp = MainProgram.getMainProgram();
        v = mp.getVictoryScreen();
        PlayerScore[] ps = new PlayerScore[]{new PlayerScore("A", 0, 11),
                new PlayerScore("B", 0, 21),
                new PlayerScore("C", 0, 13),
                new PlayerScore("C", 0, 12),
                new PlayerScore("C", 0, 21),
                new PlayerScore("C", 0, 41),
                new PlayerScore("C", 0, 31),
                new PlayerScore("C", 0, 0),
        };
        //int[] expected = new int[]{0, 11, 12, 13, 21, 21, 31, 41};
        int[] expected = new int[]{41, 31, 21, 21, 13, 12, 11, 0};
        Method sort;
        try {
            sort = VictoryScreen.class.getDeclaredMethod("sortList", PlayerScore[].class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        sort.setAccessible(true);
        PlayerScore[] sorted;
        try {
            sorted = (PlayerScore[]) sort.invoke(v, (Object) ps);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < sorted.length; i++) {
            System.out.println();
            assertEquals(expected[i], sorted[i].getLvl());
        }
    }

    //tests the sorting algorithm based on time.
    @Test
    void playerScoreSortSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        MainProgram mp = MainProgram.getMainProgram();
        v = mp.getVictoryScreen();
        PlayerScore[] ps = new PlayerScore[]{new PlayerScore("A", 20, 0),
                new PlayerScore("B", 20, 0),
                new PlayerScore("C", 19, 0),
                new PlayerScore("C", 17, 0),
                new PlayerScore("C", 18, 0),
                new PlayerScore("C", 17, 0),
                new PlayerScore("C", 21, 0),
                new PlayerScore("C", 15, 0),
        };
        //int[] expected = new int[]{0, 11, 12, 13, 21, 21, 31, 41};
        int[] expected = new int[]{15, 17, 17, 18, 19, 20, 20, 21};
        Method sort;
        try {
            sort = VictoryScreen.class.getDeclaredMethod("sortList", PlayerScore[].class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        sort.setAccessible(true);
        PlayerScore[] sorted;
        try {
            sorted = (PlayerScore[]) sort.invoke(v, (Object) ps);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < sorted.length; i++) {
            System.out.println();
            assertEquals(expected[i], sorted[i].getSeconds());
        }
    }
}
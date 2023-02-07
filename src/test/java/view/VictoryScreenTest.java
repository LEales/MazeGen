package view;

import control.MainProgram;
import javafx.application.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.Menu.HighscoreList;

import static org.junit.jupiter.api.Assertions.*;

class VictoryScreenTest {
    @BeforeAll
    static void initJFXRuntime() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Application.launch(MainProgram.class);
            }
        }).start();
    }

    @Test
    void setupHighscore() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MainProgram mp = MainProgram.getMainProgram();
        VictoryScreen v = mp.getVictoryScreen();


    }

}
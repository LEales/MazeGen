package control;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.enums.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

//An example class for how to test fx dependent classes.


class MainProgramTest {
    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testPlayRandomizeMusic() {
        AudioPlayer audioPlayer = new AudioPlayer();
        File testSongFile = new File("files/music/forest.mp3");
        File result = audioPlayer.playLevelMusic(World.FOREST);
        assertEquals(testSongFile, result);
    }
}
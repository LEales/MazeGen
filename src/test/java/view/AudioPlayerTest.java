package view;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AudioPlayerTest {

    @BeforeAll
    static void initJXRuntime() {
        Platform.startup(()-> {});
    }

    @Test
    void playLevelMusicNull() {
        AudioPlayer ap = new AudioPlayer();
        assertNull(ap.playLevelMusic(null));
    }

    @Test
    void playLevelMusicForest() {

        File f = new File("files/music/forest.mp3");
        AudioPlayer ap = new AudioPlayer();
        assertEquals(f, ap.playLevelMusic("forest"));
    }

    @Test
    void playLevelMusicDesert() {
        File f = new File("files/music/lava.mp3");
        AudioPlayer ap = new AudioPlayer();
        assertEquals(f, ap.playLevelMusic("lava"));
    }

    @Test
    void playLevelMusicHeaven() {
        File f = new File("files/music/heaven.mp3");
        AudioPlayer ap = new AudioPlayer();
        assertEquals(f, ap.playLevelMusic("heaven"));
    }

    @Test
    void playLevelMusicEgypt() {
        File f = new File("files/music/egypt.mp3");
        AudioPlayer ap = new AudioPlayer();
        assertEquals(f, ap.playLevelMusic("egypt"));
    }

    @Test
    void playLevelMusicUppercase() {
        AudioPlayer ap = new AudioPlayer();
        assertNull(ap.playLevelMusic("FOREST"));
    }

    @Test
    void playLevelMusicSpecChar() {
        AudioPlayer ap = new AudioPlayer();
        assertNull(ap.playLevelMusic("#€%%%)((@£$∞"));
    }


}
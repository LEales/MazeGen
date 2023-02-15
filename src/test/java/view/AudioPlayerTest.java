package view;

import control.MainProgram;
import javafx.application.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AudioPlayerTest {
    AudioPlayer ap;
/*
    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }

    @BeforeEach
    void init() {
        ap = new AudioPlayer();
    }

    @Test
    void playLevelMusicNull() {
        assertNull(ap.playLevelMusic(null));
    }

    @Test
    void playLevelMusicForest() {
        File f = new File("files/music/forest.mp3");
        assertEquals(f, ap.playLevelMusic("forest"));
    }

    @Test
    void playLevelMusicDesert() {
        File f = new File("files/music/lava.mp3");
        assertEquals(f, ap.playLevelMusic("lava"));
    }

    @Test
    void playLevelMusicHeaven() {
        File f = new File("files/music/cloud.mp3");
        assertEquals(f, ap.playLevelMusic("heaven"));
    }

    @Test
    void playLevelMusicEgypt() {
        File f = new File("files/music/desert.mp3");
        assertEquals(f, ap.playLevelMusic("egypt"));
    }

    @Test
    void playLevelMusicUppercase() {
        assertNull(ap.playLevelMusic("FOREST"));
    }

    @Test
    void playLevelMusicSpecChar() {
        assertNull(ap.playLevelMusic("#€%%%)((@£$∞"));
    }

    @Test
    void playCollectibleSound() {
        assertTrue(ap.playCollectibleSound());
    }

    @Test
    void playDeathSound() {
        assertTrue(ap.playDeathSound());
    }

    @Test
    void playStartSound() {
        assertTrue(ap.playStartSound());
    }

    @Test
    void playGoalSound() {
        assertTrue(ap.playGoalSound());
    }

    @Test
    void playHeartSound() {
        assertTrue(ap.playHeartSound());
    }

    @Test
    void playBreakableWallSound() {
        assertTrue(ap.playBreakableWallSound());
    }

    @Test
    void playPickaxeSound() {
        assertTrue(ap.playPickAxeSound());
    }

    @Test
    void playGameOverSound() {
        assertTrue(ap.playGameOverSound());
    }

    @Test
    void playIntroMusic() {
        assertTrue(ap.playIntroMusic());
    }

    @Test
    void stopMusic() {
        assertTrue(ap.stopMusic());
    }

    @Test
    void playButtonSound() {
        assertTrue(ap.playButtonSound());
    }

    @Test
    void playWorldIntroSound() {
        assertTrue(ap.playWorldIntroSound());
    }

    @Test
    void playTimeLeftSound() {
        assertTrue(ap.playTimeLeftSound());
    }

    @Test
    void playMobSound() {
        assertTrue(ap.playMobSound());
    }

    @Test
    void muteMusic() {
        assertTrue(ap.muteMusic(true));
    }

    @Test
    void unMuteMusic() {
        assertFalse(ap.muteMusic(false));
    }

    @Test
    void muteSound() {
        assertTrue(ap.muteSound(true));
    }

    @Test
    void unMuteSound() {
        assertFalse(ap.muteSound(false));
    }

    @Test
    void stopClockSound() {
        assertTrue(ap.stopClockSound());
    }

 */
}
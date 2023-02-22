package view;

import control.AudioPlayer;
import control.MainProgram;
import javafx.application.Application;
import model.enums.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.Assert.*;

class AudioPlayerTest {
    AudioPlayer ap;

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

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        File f = new File("files/music/forest.mp3");
        assertEquals(f, ap.playLevelMusic(World.FOREST));
    }

    @Test
    void playLevelMusicDesert() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File f = new File("files/music/lava.mp3");
        assertEquals(f, ap.playLevelMusic(World.LAVA));
    }

    @Test
    void playLevelMusicHeaven() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File f = new File("files/music/cloud.mp3");
        assertEquals(f, ap.playLevelMusic(World.CLOUD));
    }

    @Test
    void playLevelMusicEgypt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File f = new File("files/music/desert.mp3");
        assertEquals(f, ap.playLevelMusic(World.DESERT));
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
        assertTrue(ap.stopTimeLeftSound());
    }
}
package view;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AudioPlayerTest {

    @BeforeAll
    static void initJFXRuntime() {
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

    @Test
    void playCollectibleSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playCollectibleSound());
    }

    @Test
    void playDeathSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playDeathSound());
    }

    @Test
    void playStartSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playStartSound());
    }

    @Test
    void playGoalSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playGoalSound());
    }

    @Test
    void playHeartSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playHeartSound());
    }

    @Test
    void playBreakableWallSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playBreakableWallSound());
    }

    @Test
    void playPickaxeSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playPickAxeSound());
    }

    @Test
    void playGameOverSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playGameOverSound());
    }

    @Test
    void playIntroMusic() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playIntroMusic());
    }

    @Test
    void stopMusic() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.stopMusic());
    }

    @Test
    void playButtonSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playButtonSound());
    }

    @Test
    void playWorldIntroSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playWorldIntroSound());
    }

    @Test
    void playTimeLeftSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playTimeLeftSound());
    }

    @Test
    void playMobSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.playMobSound());
    }

    @Test
    void muteMusic() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.muteMusic(true));
    }

    @Test
    void unmuteMusic() {
        AudioPlayer ap = new AudioPlayer();
        assertFalse(ap.muteMusic(false));
    }

    @Test
    void muteSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.muteSound(true));
    }

    @Test
    void unmuteSound() {
        AudioPlayer ap = new AudioPlayer();
        assertFalse(ap.muteSound(false));
    }

    @Test
    void stopClockSound() {
        AudioPlayer ap = new AudioPlayer();
        assertTrue(ap.stopClockSound());
    }



}
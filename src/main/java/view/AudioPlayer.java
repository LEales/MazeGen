package view;

import control.MainProgram;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.World;

import java.io.File;

/**
 * @author André Eklund
 * @edit Viktor Näslund
 */

public class AudioPlayer {

    private MediaPlayer diamondPlayer;

    private MediaPlayer deathPlayer;

    private MediaPlayer startPlayer;

    private MediaPlayer goalPlayer;

    private MediaPlayer heartPlayer;

    private MediaPlayer breakableWallPlayer;

    private File currentSong;
    private Media currentMedia;
    private MediaPlayer currentSongPlayer;

    private MediaPlayer pickAxeMediaPlayer;

    private MediaPlayer gameOverMediaPlayer;

    private MediaPlayer buttonClickedMediaPlayer;

    private MediaPlayer introMediaPlayer;

    private MediaPlayer worldIntroMediaPlayer;

    private MediaPlayer timeLeftMediaPlayer;

    private MediaPlayer mobSoundMediaPlayer;

    /**
     * Kör metoden som instanierar ljudfilerna.
     */
    public AudioPlayer() {
        setupAudioFiles();
    }

    /**
     * Instansierar alla ljudfiler.
     */
    public void setupAudioFiles() {

        File diamondSound = new File("files/sounds/Diamond1.mp3");
        Media diamondMedia = new Media(diamondSound.toURI().toString());
        diamondPlayer = new MediaPlayer(diamondMedia);

        File deathSound = new File("files/sounds/MazegenDeath.mp3");
        Media deathMedia = new Media(deathSound.toURI().toString());
        deathPlayer = new MediaPlayer(deathMedia);

        File startSound = new File("files/sounds/MazegenStart.mp3");
        Media startMedia = new Media(startSound.toURI().toString());
        startPlayer = new MediaPlayer(startMedia);

        File goalSound = new File("files/sounds/MazegenGoal.mp3");
        Media goalMedia = new Media(goalSound.toURI().toString());
        goalPlayer = new MediaPlayer(goalMedia);

        File heartSound = new File("files/sounds/Heart.mp3");
        Media heartMedia = new Media(heartSound.toURI().toString());
        heartPlayer = new MediaPlayer(heartMedia);

        File breakableWallSound = new File("files/sounds/AxeUsed.mp3");
        Media breakableWallMedia = new Media(breakableWallSound.toURI().toString());
        breakableWallPlayer = new MediaPlayer(breakableWallMedia);

        File pickAxeSound = new File("files/sounds/pickaxe.mp3");
        Media pickAxeMedia = new Media(pickAxeSound.toURI().toString());
        pickAxeMediaPlayer = new MediaPlayer(pickAxeMedia);

        File gameOverSound = new File("files/sounds/gameover.mp3");
        Media gameOverMedia = new Media(gameOverSound.toURI().toString());
        gameOverMediaPlayer = new MediaPlayer(gameOverMedia);

        File buttonClickSound = new File("files/sounds/menubuttons.mp3");
        Media buttonClickMedia = new Media(buttonClickSound.toURI().toString());
        buttonClickedMediaPlayer = new MediaPlayer(buttonClickMedia);

        File introSound = new File("files/sounds/introsound.mp3");
        Media introMedia = new Media(introSound.toURI().toString());
        introMediaPlayer = new MediaPlayer(introMedia);

        File worldIntroSound = new File("files/sounds/nextworld.mp3");
        Media worldIntroMedia = new Media(worldIntroSound.toURI().toString());
        worldIntroMediaPlayer = new MediaPlayer(worldIntroMedia);

        currentSong = new File("files/music/forest.mp3");
        currentMedia = new Media(currentSong.toURI().toString());
        currentSongPlayer = new MediaPlayer(currentMedia);

        File timeLeftSound = new File("files/sounds/timeLeft.mp3");
        Media timeLeftMedia = new Media(timeLeftSound.toURI().toString());
        timeLeftMediaPlayer = new MediaPlayer(timeLeftMedia);

        File mobSound = new File("files/sounds/mobsound.mp3");
        Media mobSoundMedia = new Media(mobSound.toURI().toString());
        mobSoundMediaPlayer = new MediaPlayer(mobSoundMedia);

    }

    /**
     * Spelar musik baserad på given input.
     *
     * @param songToPlay Låten som ska spelas.
     */
    public File playLevelMusic(World songToPlay) {
        MainProgram mainProgram = MainProgram.getMainProgram();
        currentSong = new File("files/music/" + songToPlay + ".mp3");
        currentMedia = new Media(currentSong.toURI().toString());
        currentSongPlayer = new MediaPlayer(currentMedia);
        currentSongPlayer.setOnEndOfMedia(() -> currentSongPlayer.seek(Duration.ZERO));
        currentSongPlayer.play();
        if (!mainProgram.getMusicIsOn()) {
            currentSongPlayer.setMute(true);
        }
        System.out.println(currentSongPlayer.isMute());
        return currentSong;
    }

    /**
     * Spelar ett ljud när spelaren plockar upp en collectible.
     */
    public boolean playCollectibleSound() {
        try {
            diamondPlayer.play();
            diamondPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när spelaren dör.
     */
    public boolean playDeathSound() {
        try {
            deathPlayer.play();
            deathPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när spelrundan startas.
     */
    public boolean playStartSound() {
        try {
            startPlayer.play();
            startPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när spelaren går i mål.
     */
    public boolean playGoalSound() {
        try {
            goalPlayer.play();
            goalPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när spelaren plockar upp ett liv.
     */
    public boolean playHeartSound() {
        try {
            heartPlayer.play();
            heartPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när spelaren förstör en vägg.
     */
    public boolean playBreakableWallSound() {
        try {
            breakableWallPlayer.play();
            breakableWallPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när spelaren plockar upp en yxa.
     */
    public boolean playPickAxeSound() {
        try {
            pickAxeMediaPlayer.play();
            pickAxeMediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när det blir gameOver.
     */
    public boolean playGameOverSound() {
        try {
            gameOverMediaPlayer.play();
            gameOverMediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * En metod som mutear alla speleffekters ljud.
     *
     * @param mute True om ljudet ska vara avstängt och false om ljudet ska vara på.
     */
    public boolean muteSound(boolean mute) {
        breakableWallPlayer.setMute(mute);
        deathPlayer.setMute(mute);
        heartPlayer.setMute(mute);
        startPlayer.setMute(mute);
        goalPlayer.setMute(mute);
        diamondPlayer.setMute(mute);
        worldIntroMediaPlayer.setMute(mute);
        timeLeftMediaPlayer.setMute(mute);
        gameOverMediaPlayer.setMute(mute);

        return breakableWallPlayer.isMute() &&
                deathPlayer.isMute() &&
                heartPlayer.isMute() &&
                startPlayer.isMute() &&
                goalPlayer.isMute() &&
                diamondPlayer.isMute() &&
                worldIntroMediaPlayer.isMute() &&
                timeLeftMediaPlayer.isMute() &&
                gameOverMediaPlayer.isMute();
    }

    /**
     * Spelar ett ljud när spelet startas.
     */
    public boolean playIntroMusic() {
        try {
            introMediaPlayer.play();
            introMediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Stänger av all musik.
     */
    public boolean stopMusic() {
        currentSongPlayer.stop();
        introMediaPlayer.stop();
        return currentSongPlayer.currentCountProperty().intValue() == 0 && introMediaPlayer.currentCountProperty().intValue() == 0;
    }

    /**
     * Spelar ett ljud vid alla knapptryck i menyerna.
     */
    public boolean playButtonSound() {
        try {
            buttonClickedMediaPlayer.play();
            buttonClickedMediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud vid varje ny värld.
     */
    public boolean playWorldIntroSound() {
        try {
            worldIntroMediaPlayer.play();
            worldIntroMediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när det endast är fem sekunder kvar på timern.
     */
    public boolean playTimeLeftSound() {
        try {
            timeLeftMediaPlayer.play();
            timeLeftMediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Spelar ett ljud när spelaren kolliderar med en fiende.
     */
    public boolean playMobSound() {
        try {
            mobSoundMediaPlayer.play();
            mobSoundMediaPlayer.seek(Duration.ZERO);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * En metod som mutear all musik .
     *
     * @param mute True om ljudet ska vara avstängt och false om ljudet ska vara på.
     */
    public boolean muteMusic(boolean mute) {
        currentSongPlayer.setMute(mute);
        return currentSongPlayer.isMute();
    }

    /**
     * Stänger av timerns ljud.
     */

    public boolean stopClockSound() {
        timeLeftMediaPlayer.stop();
        return timeLeftMediaPlayer.currentCountProperty().intValue() == 0;
    }
}

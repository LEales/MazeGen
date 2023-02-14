package control;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import model.Maps.*;

import model.MazeGeneration.GenerateNextLevel;
import model.World;
import model.time.TotalTime;
import view.AudioPlayer;
import view.Campaign.*;
import view.GameOverScreen;
import view.Randomize.MapTemplate;
import model.MazeGeneration.MazeGenerator;
import view.Menu.*;
import view.VictoryScreen;
import view.WorldIntroAnimation;


import java.io.FileNotFoundException;

/**
 * @author André Eklund
 */

public class MainProgram extends Application {

    private Stage mainWindow;
    private BorderPane mainPaneRandomMaze;
    private BorderPane mainPaneCampaign;
    private Scene menuScene;
    private Scene helpScene;
    private Scene chooseDimensionScene;
    private Scene highscoreScene;
    private Scene victoryScene;
    private HighscoreList highscoreList;
    private VictoryScreen victoryScreen;
    private Scene randomScene;
    private Scene campaignScene;
    private RightPanel rightPanel;
    private GenerateNextLevel generateNextLevel;
    private World1Maps world1Maps;
    private WorldIntroAnimation introAnimation;
    private AudioPlayer audioPlayer;

    public static MainProgram mainProgram;
    private int lvlCleared;
    private TotalTime totTime;

    public static final double WIDTH = 800.0d;
    public static final double HEIGHT = 600.0d;

    /**
     * En metod som startar programmet.
     * Metoden instanierar även de olika komponenterna.
     *
     * @param primaryStage JavaFX top Container, huvudkomponenten till programmet.
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        audioPlayer = new AudioPlayer();
        audioPlayer.playIntroMusic();

        rightPanel = new RightPanel(this, "11", audioPlayer, null);
        rightPanel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Menu menu = new Menu(this, audioPlayer, rightPanel);
        Intro intro = new Intro(this, audioPlayer);
        Help help = new Help(this, audioPlayer);
        highscoreList = new HighscoreList(this, audioPlayer);
        victoryScreen = new VictoryScreen(this, audioPlayer);

        ChooseDimension chooseDimension = new ChooseDimension(this, audioPlayer);
        Scene introScene = new Scene(intro, WIDTH, HEIGHT);
        helpScene = new Scene(help, WIDTH, HEIGHT);

        highscoreScene = new Scene(highscoreList, WIDTH, HEIGHT);
        victoryScene = new Scene(victoryScreen, WIDTH, HEIGHT);


        victoryScene.setOnKeyPressed(event -> {
            String pattern = "[a-zA-Z0-9]";
            String stringEvent;
            KeyCode code = event.getCode();
            switch (code) {
                case DIGIT0 -> stringEvent = "0";
                case DIGIT1 -> stringEvent = "1";
                case DIGIT2 -> stringEvent = "2";
                case DIGIT3 -> stringEvent = "3";
                case DIGIT4 -> stringEvent = "4";
                case DIGIT5 -> stringEvent = "5";
                case DIGIT6 -> stringEvent = "6";
                case DIGIT7 -> stringEvent = "7";
                case DIGIT8 -> stringEvent = "8";
                case DIGIT9 -> stringEvent = "9";
                default -> stringEvent = String.valueOf(code);
            }
            if (stringEvent.matches(pattern) || stringEvent.equals("BACK_SPACE") || stringEvent.equals("ENTER")) {
                victoryScreen.setTextCurrent(stringEvent);
            } else {
                victoryScreen.setTextCurrent("invalid");
            }
        });

        chooseDimensionScene = new Scene(chooseDimension, WIDTH, HEIGHT);

        mainPaneRandomMaze = new BorderPane();
        mainPaneCampaign = new BorderPane();
        introAnimation = new WorldIntroAnimation();

        mainWindow = primaryStage;
        Image cursorImage = new Image("file:files/imagecursor.png");

        mainWindow.setTitle("Mazegen");
        mainWindow.setResizable(false);
        mainWindow.setOnCloseRequest(windowEvent -> System.exit(0));
        world1Maps = new World1Maps();
        mainPaneCampaign.setRight(rightPanel);

        RightPanel rightPnlRndm = new RightPanel(this, "Random", audioPlayer, null);
        rightPnlRndm.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        mainPaneRandomMaze.setRight(rightPnlRndm);

        campaignScene = new Scene(mainPaneCampaign, WIDTH, HEIGHT);
        randomScene = new Scene(mainPaneRandomMaze, WIDTH, HEIGHT);
        menuScene = new Scene(menu, WIDTH, HEIGHT);

        mainWindow.setScene(introScene);
        mainWindow.show();

        introScene.setCursor(new ImageCursor(cursorImage));
        menuScene.setCursor(new ImageCursor(cursorImage));
        campaignScene.setCursor(new ImageCursor(cursorImage));
        chooseDimensionScene.setCursor(new ImageCursor(cursorImage));
        helpScene.setCursor(new ImageCursor(cursorImage));
        randomScene.setCursor(new ImageCursor(cursorImage));
    }

    /**
     * Byter scen till huvudmenyn.
     */
    public void changeToMenu() {
        mainWindow.setScene(menuScene);
    }

    /**
     * Byter scen till Randomize.
     *
     * @param dimension Storleken på labyrinten som ska genereras.
     * @throws FileNotFoundException
     */
    public void changeToRandomize(int dimension) throws FileNotFoundException {
        MazeGenerator mazeGenerator = new MazeGenerator(dimension, true);
        generateNextLevel = new GenerateNextLevel(mainPaneRandomMaze, mazeGenerator, dimension);
        MapTemplate mapTemplate = new MapTemplate(mazeGenerator.getMaze(), generateNextLevel);
        mainPaneRandomMaze.setCenter(mapTemplate);
        mainWindow.setScene(randomScene);
    }

    /**
     * Byter scen till kampanjläget.
     *
     * @throws FileNotFoundException
     */
    public void changeToCampaign() throws FileNotFoundException {
        lvlCleared = 0;
        World1Template world1Template = new World1Template(world1Maps.getLevel11(), 1, 3, rightPanel, World.FOREST, audioPlayer, 25);

        mainPaneCampaign.setCenter(world1Template);
        mainWindow.setScene(campaignScene);
        introAnimation = new WorldIntroAnimation("1");
        mainPaneCampaign.getChildren().add(introAnimation);
        introAnimation.setDisable(true);

        try {
            nextWorld2Level(5,3);
        } catch (Exception e){}

        startTotalTime();
    }

    /**
     * Byter scen till den del av menyn där användaren får välja dimension på labyrinten.
     */
    public void chooseDimension() {
        mainWindow.setScene(chooseDimensionScene);
    }

    /**
     * Byter scen till hjälpfönstret.
     */
    public boolean changeToHelp() {
        mainWindow.setScene(helpScene);
        return true;
    }

    /**
     * Vid gameOver körs denna metod.
     * Kör en enkel animation med texten "Game Over".
     */
    public void gameOver() {
        victoryScreen.setTime(totTime.setGameOver(true));
        GameOverScreen gameOverScreen = new GameOverScreen(this);
        mainPaneCampaign.getChildren().add(gameOverScreen);
    }

    /**
     * Byter scen till en ny nivå i kampanjläget baserad på givna parametrar.
     *
     * @param level         Den aktuella nivån.
     * @param heartCrystals Spelarens aktuella liv.
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void nextWorld1Level(int level, int heartCrystals) throws FileNotFoundException, InterruptedException {

        switch (level) {
            case 1 -> {
                lvlCleared = 11;
                rightPanel.changeLevelCounter("12");
                mainPaneCampaign.setCenter(new World1Template(world1Maps.getLevel12(), 2, heartCrystals, rightPanel, World.FOREST, audioPlayer, 25));
            }
            case 2 -> {
                lvlCleared = 12;
                rightPanel.changeLevelCounter("13");
                mainPaneCampaign.setCenter(new World1Template(world1Maps.getLevel13(), 3, heartCrystals, rightPanel, World.FOREST, audioPlayer, 25));
            }
            case 3 -> {
                lvlCleared = 13;
                rightPanel.changeLevelCounter("14");
                mainPaneCampaign.setCenter(new World1Template(world1Maps.getLevel14(), 4, heartCrystals, rightPanel, World.FOREST, audioPlayer, 25));
            }
            case 4 -> {
                lvlCleared = 14;
                rightPanel.changeLevelCounter("15");
                mainPaneCampaign.setCenter(new World1Template(world1Maps.getLevel15(), 5, heartCrystals, rightPanel, World.FOREST, audioPlayer, 25));
            }
            case 5 -> {
                lvlCleared = 15;
                nextWorld2Level(1, heartCrystals);
            }
        }

    }

    /**
     * Byter scen till en ny nivå i kampanjläget baserad på givna parametrar.
     *
     * @param level         Den aktuella nivån.
     * @param heartCrystals Spelarens aktuella liv.
     * @throws FileNotFoundException
     * @throws InterruptedException
     */

    public void nextWorld2Level(int level, int heartCrystals) throws FileNotFoundException, InterruptedException {

        World2Maps world2Maps = new World2Maps();

        switch (level) {
            case 1 -> {
                rightPanel.changeLevelCounter("21");
                mainPaneCampaign.setCenter(new World2Template(world2Maps.getLevel21(), 2, heartCrystals, rightPanel, World.UNDERGROUND, audioPlayer));
                introAnimation = new WorldIntroAnimation("2");
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                audioPlayer.playWorldIntroSound();
            }
            case 2 -> {
                lvlCleared = 21;
                rightPanel.changeLevelCounter("22");
                mainPaneCampaign.setCenter(new World2Template(world2Maps.getLevel22(), 3, heartCrystals, rightPanel, World.UNDERGROUND, audioPlayer));
            }
            case 3 -> {
                lvlCleared = 22;
                rightPanel.changeLevelCounter("23");
                mainPaneCampaign.setCenter(new World2Template(world2Maps.getLevel23(), 4, heartCrystals, rightPanel, World.UNDERGROUND, audioPlayer));
            }
            case 4 -> {
                lvlCleared = 23;
                rightPanel.changeLevelCounter("24");
                mainPaneCampaign.setCenter(new World2Template(world2Maps.getLevel24(), 5, heartCrystals, rightPanel, World.UNDERGROUND, audioPlayer));
            }
            case 5 -> {
                lvlCleared = 24;
                rightPanel.changeLevelCounter("25");
                mainPaneCampaign.setCenter(new World2Template(world2Maps.getLevel25(), 6, heartCrystals, rightPanel, World.UNDERGROUND, audioPlayer));
            }
            case 6 -> {
                lvlCleared = 25;
                nextWorld3Level(1, heartCrystals);
            }
        }
    }

    /**
     * Byter scen till en ny nivå i kampanjläget baserad på givna parametrar.
     *
     * @param level         Den aktuella nivån.
     * @param heartCrystals Spelarens aktuella liv.
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void nextWorld3Level(int level, int heartCrystals) throws FileNotFoundException, InterruptedException {

        World3Maps world3Maps = new World3Maps();

        switch (level) {
            case 1 -> {
                rightPanel.changeLevelCounter("31");
                mainPaneCampaign.setCenter(new World3Template(world3Maps.getLevel31(), 2, heartCrystals, rightPanel, World.LAVA, audioPlayer));
                introAnimation = new WorldIntroAnimation("3");
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                audioPlayer.playWorldIntroSound();
                audioPlayer.stopMusic();
                audioPlayer.playLevelMusic("lava");
            }
            case 2 -> {
                lvlCleared = 31;
                rightPanel.changeLevelCounter("32");
                mainPaneCampaign.setCenter(new World3Template(world3Maps.getLevel32(), 3, heartCrystals, rightPanel, World.LAVA, audioPlayer));
            }
            case 3 -> {
                lvlCleared = 32;
                rightPanel.changeLevelCounter("33");
                mainPaneCampaign.setCenter(new World3Template(world3Maps.getLevel33(), 4, heartCrystals, rightPanel, World.LAVA, audioPlayer));
            }
            case 4 -> {
                lvlCleared = 33;
                rightPanel.changeLevelCounter("34");
                mainPaneCampaign.setCenter(new World3Template(world3Maps.getLevel34(), 5, heartCrystals, rightPanel, World.LAVA, audioPlayer));
            }
            case 5 -> {
                lvlCleared = 34;
                rightPanel.changeLevelCounter("35");
                mainPaneCampaign.setCenter(new World3Template(world3Maps.getLevel35(), 6, heartCrystals, rightPanel, World.LAVA, audioPlayer));
            }
            case 6 -> {
                lvlCleared = 35;
                nextWorld4Level(1, heartCrystals);
            }
        }
    }

    /**
     * Byter scen till en ny nivå i kampanjläget baserad på givna parametrar.
     *
     * @param level         Den aktuella nivån.
     * @param heartCrystals Spelarens aktuella liv.
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void nextWorld4Level(int level, int heartCrystals) throws FileNotFoundException, InterruptedException {

        World4Maps world4Maps = new World4Maps();

        switch (level) {
            case 1 -> {
                rightPanel.changeLevelCounter("41");
                mainPaneCampaign.setCenter(new World4Template(world4Maps.getLevel41(), 2, heartCrystals, rightPanel, World.CLOUD, audioPlayer));
                introAnimation = new WorldIntroAnimation("4");
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                audioPlayer.playWorldIntroSound();
                audioPlayer.stopMusic();
                audioPlayer.playLevelMusic("heaven");
            }
            case 2 -> {
                lvlCleared = 41;
                rightPanel.changeLevelCounter("42");
                mainPaneCampaign.setCenter(new World4Template(world4Maps.getLevel42(), 3, heartCrystals, rightPanel, World.CLOUD, audioPlayer));
            }
            case 3 -> {
                lvlCleared = 42;
                rightPanel.changeLevelCounter("43");
                mainPaneCampaign.setCenter(new World4Template(world4Maps.getLevel43(), 4, heartCrystals, rightPanel, World.CLOUD, audioPlayer));
            }
            case 4 -> {
                lvlCleared = 43;
                rightPanel.changeLevelCounter("44");
                mainPaneCampaign.setCenter(new World4Template(world4Maps.getLevel44(), 5, heartCrystals, rightPanel, World.CLOUD, audioPlayer));
            }
            case 5 -> {
                lvlCleared = 44;
                rightPanel.changeLevelCounter("45");
                mainPaneCampaign.setCenter(new World4Template(world4Maps.getLevel45(), 6, heartCrystals, rightPanel, World.CLOUD, audioPlayer));
            }
            case 6 -> {
                lvlCleared = 45;
                nextWorld5Level(1, heartCrystals);
            }
        }
    }

    /**
     * Byter scen till en ny nivå i kampanjläget baserad på givna parametrar.
     *
     * @param level         Den aktuella nivån.
     * @param heartCrystals Spelarens aktuella liv.
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void nextWorld5Level(int level, int heartCrystals) throws FileNotFoundException, InterruptedException {

        World5Maps world5Maps = new World5Maps();

        switch (level) {
            case 1 -> {
                rightPanel.changeLevelCounter("51");
                mainPaneCampaign.setCenter(new World5Template(world5Maps.getLevel51(), 2, heartCrystals, rightPanel, World.DESERT, audioPlayer));
                introAnimation = new WorldIntroAnimation("5");
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                audioPlayer.playWorldIntroSound();
                audioPlayer.stopMusic();
                audioPlayer.playLevelMusic("egypt");
            }
            case 2 -> {
                lvlCleared = 51;
                rightPanel.changeLevelCounter("52");
                mainPaneCampaign.setCenter(new World5Template(world5Maps.getLevel52(), 3, heartCrystals, rightPanel, World.DESERT, audioPlayer));
            }
            case 3 -> {
                lvlCleared = 52;
                rightPanel.changeLevelCounter("53");
                mainPaneCampaign.setCenter(new World5Template(world5Maps.getLevel53(), 4, heartCrystals, rightPanel, World.DESERT, audioPlayer));
            }
            case 4 -> {
                lvlCleared = 53;
                rightPanel.changeLevelCounter("54");
                mainPaneCampaign.setCenter(new World5Template(world5Maps.getLevel54(), 5, heartCrystals, rightPanel, World.DESERT, audioPlayer));
            }
            case 5 -> {
                lvlCleared = 54;
                rightPanel.changeLevelCounter("55");
                mainPaneCampaign.setCenter(new World5Template(world5Maps.getLevel55(), 6, heartCrystals, rightPanel, World.DESERT, audioPlayer));
            }
            case 6 -> {
                lvlCleared = 55;
                nextWorld6Level(1, heartCrystals);
            }
        }
    }

    /**
     * Byter scen till en ny nivå i kampanjläget baserad på givna parametrar.
     *
     * @param level         Den aktuella nivån.
     * @param heartCrystals Spelarens aktuella liv.
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    public void nextWorld6Level(int level, int heartCrystals) throws FileNotFoundException, InterruptedException {

        World6Maps world6Maps = new World6Maps();

        switch (level) {
            case 1 -> {
                rightPanel.changeLevelCounter("61");
                mainPaneCampaign.setCenter(new World6Template(world6Maps.getLevel61(), 2, heartCrystals, rightPanel, World.SPACE, audioPlayer));
                introAnimation = new WorldIntroAnimation("6");
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                audioPlayer.playWorldIntroSound();
            }
            case 2 -> {
                lvlCleared = 61;
                rightPanel.changeLevelCounter("62");
                mainPaneCampaign.setCenter(new World6Template(world6Maps.getLevel62(), 3, heartCrystals, rightPanel, World.SPACE, audioPlayer));
            }
            case 3 -> {
                lvlCleared = 62;
                rightPanel.changeLevelCounter("63");
                mainPaneCampaign.setCenter(new World6Template(world6Maps.getLevel63(), 4, heartCrystals, rightPanel, World.SPACE, audioPlayer));
            }
            case 4 -> {
                lvlCleared = 63;
                rightPanel.changeLevelCounter("64");
                mainPaneCampaign.setCenter(new World6Template(world6Maps.getLevel64(), 5, heartCrystals, rightPanel, World.SPACE, audioPlayer));
            }
            case 5 -> {
                lvlCleared = 64;
                rightPanel.changeLevelCounter("65");
                mainPaneCampaign.setCenter(new World6Template(world6Maps.getLevel65(), 6, heartCrystals, rightPanel, World.SPACE, audioPlayer));
            }
            case 6 -> {
                lvlCleared = 65;
                victoryScreen.setTime(totTime.setGameOver(true));
                audioPlayer.stopMusic();
                showVictoryScene();
            }
        }
    }

    /**
     * Main startar programmet.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    public synchronized static MainProgram getMainProgram() {
        return mainProgram;
    }

    public void showHighScoreList() {
        highscoreList.setupHighscoreList();
        mainWindow.setScene(highscoreScene);
    }

    public void showVictoryScene() {
        mainWindow.setScene(victoryScene);
    }

    @Override
    public void init() throws Exception {
        mainProgram = this;
    }

    private boolean startTotalTime() {
        try {
            totTime = new TotalTime(false);
            totTime.start();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getLvlCleared() {
        return lvlCleared;
    }

    public boolean getMusiIsOn() {
        return rightPanel.getMusicOn();
    }

    public HighscoreList getHighscoreList() {
        return highscoreList;
    }

    public VictoryScreen getVictoryScreen() {
        return victoryScreen;
    }

    public GenerateNextLevel getGenerateNextLevel() {
        return generateNextLevel;
    }
}

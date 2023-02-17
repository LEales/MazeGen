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

import model.Player;
import model.World;
import control.time.TotalTime;
import view.Campaign.*;
import view.GameOverScreen;
import view.Randomize.MapTemplate;
import view.Menu.*;
import view.VictoryScreen;
import view.WorldIntroAnimation;


import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author André Eklund
 * @edit Teodor Wegestål, Luke Eales - Removed unnecessary variables, methods and dependencies. General code clean up.
 */

public class MainProgram extends Application {

    public static MainProgram mainProgram;
    public static final double WIDTH = 800.0d;
    public static final double HEIGHT = 600.0d;
    private Stage mainWindow;
    private BorderPane mainPaneRandomMaze, mainPaneCampaign;
    private Scene menuScene, helpScene, chooseDimensionScene, highscoreScene, victoryScene, randomScene, campaignScene;
    private HighscoreList highscoreList;
    private VictoryScreen victoryScreen;
    private RightPanel rightPanel;
    private GenerateNextLevel generateNextLevel;

    private WorldIntroAnimation introAnimation;
    private int lvlCleared;
    private TotalTime totTime;


    /**
     * En metod som startar programmet.
     * Metoden instanierar även de olika komponenterna.
     *
     * @param primaryStage JavaFX top Container, huvudkomponenten till programmet.
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        AudioPlayer.playIntroMusic();

        rightPanel = new RightPanel("11");
        rightPanel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Menu menu = new Menu();
        Intro intro = new Intro();
        Help help = new Help();
        highscoreList = new HighscoreList();
        victoryScreen = new VictoryScreen();

        ChooseDimension chooseDimension = new ChooseDimension();
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
        mainPaneCampaign.setRight(rightPanel);

        RightPanel rightPnlRndm = new RightPanel("Random");
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
        highscoreScene.setCursor(new ImageCursor(cursorImage));
        victoryScene.setCursor(new ImageCursor(cursorImage));
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
        RandomizeMap map = new RandomizeMap(3, getSeconds(dimension));
        map.setMap(mazeGenerator.getMaze());
        MapTemplate mapTemplate = new MapTemplate(map, generateNextLevel);
        mainPaneRandomMaze.setCenter(mapTemplate);
        mainWindow.setScene(randomScene);
    }

    public int getSeconds(int dimension) {
        return switch (dimension) {
            case 10 -> 25;
            case 14 -> 60;
            case 18 -> 80;
            case 28 -> 99;
            default -> throw new IllegalStateException("Unexpected value: " + dimension);
        };
    }

    /**
     * Byter scen till kampanjläget.
     *
     * @throws FileNotFoundException
     */
    public void changeToCampaign() throws FileNotFoundException {
        lvlCleared = 0;
        World1Template world1Template = new World1Template(new World1Maps(3, 25, 1, World.FOREST), rightPanel);
        rightPanel.changeLevelCounter("11");
        mainPaneCampaign.setCenter(world1Template);
        mainWindow.setScene(campaignScene);
        introAnimation = new WorldIntroAnimation(World.FOREST);
        mainPaneCampaign.getChildren().add(introAnimation);
        introAnimation.setDisable(true);
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
        Player player = new Player("___", totTime.setGameOver(true), lvlCleared);
        GameOverScreen gameOverScreen = new GameOverScreen(player);
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
            }
            case 2 -> {
                lvlCleared = 12;
                rightPanel.changeLevelCounter("13");
            }
            case 3 -> {
                lvlCleared = 13;
                rightPanel.changeLevelCounter("14");
            }
            case 4 -> {
                lvlCleared = 14;
                rightPanel.changeLevelCounter("15");
            }
            case 5 -> {
                lvlCleared = 15;
                nextWorld2Level(1, heartCrystals);
                return;
            }
        }
        mainPaneCampaign.setCenter(new World1Template(new World1Maps(heartCrystals, 25, level + 1, World.FOREST), rightPanel));
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

        switch (level) {
            case 1 -> {
                lvlCleared = 15;
                rightPanel.changeLevelCounter("21");
                introAnimation = new WorldIntroAnimation(World.UNDERGROUND);
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                AudioPlayer.playWorldIntroSound();
            }
            case 2 -> {
                lvlCleared = 21;
                rightPanel.changeLevelCounter("22");
            }
            case 3 -> {
                lvlCleared = 22;
                rightPanel.changeLevelCounter("23");
            }
            case 4 -> {
                lvlCleared = 23;
                rightPanel.changeLevelCounter("24");
            }
            case 5 -> {
                lvlCleared = 24;
                rightPanel.changeLevelCounter("25");
            }
            case 6 -> {
                lvlCleared = 25;
                nextWorld3Level(1, heartCrystals);
                return;
            }
        }
        mainPaneCampaign.setCenter(new World2Template(new World2Maps(heartCrystals, 35, level, World.UNDERGROUND), rightPanel));
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

        switch (level) {
            case 1 -> {
                lvlCleared = 25;
                rightPanel.changeLevelCounter("31");
                introAnimation = new WorldIntroAnimation(World.LAVA);
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                AudioPlayer.playWorldIntroSound();
                AudioPlayer.stopMusic();
                AudioPlayer.playLevelMusic(World.LAVA);
            }
            case 2 -> {
                lvlCleared = 31;
                rightPanel.changeLevelCounter("32");
            }
            case 3 -> {
                lvlCleared = 32;
                rightPanel.changeLevelCounter("33");
            }
            case 4 -> {
                lvlCleared = 33;
                rightPanel.changeLevelCounter("34");
            }
            case 5 -> {
                lvlCleared = 34;
                rightPanel.changeLevelCounter("35");
            }
            case 6 -> {
                lvlCleared = 35;
                nextWorld4Level(1, heartCrystals);
                return;
            }
        }
        mainPaneCampaign.setCenter(new World3Template(new World3Maps(heartCrystals, 60, level, World.LAVA), rightPanel));
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
        switch (level) {
            case 1 -> {
                lvlCleared = 35;
                rightPanel.changeLevelCounter("41");
                introAnimation = new WorldIntroAnimation(World.CLOUD);
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                AudioPlayer.playWorldIntroSound();
                AudioPlayer.stopMusic();
                AudioPlayer.playLevelMusic(World.CLOUD);
            }
            case 2 -> {
                lvlCleared = 41;
                rightPanel.changeLevelCounter("42");
            }
            case 3 -> {
                lvlCleared = 42;
                rightPanel.changeLevelCounter("43");
            }
            case 4 -> {
                lvlCleared = 43;
                rightPanel.changeLevelCounter("44");
            }
            case 5 -> {
                lvlCleared = 44;
                rightPanel.changeLevelCounter("45");
            }
            case 6 -> {
                lvlCleared = 45;
                nextWorld5Level(1, heartCrystals);
                return;
            }
        }
        mainPaneCampaign.setCenter(new World4Template(new World4Maps(heartCrystals, 80, level, World.CLOUD), rightPanel));
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
        switch (level) {
            case 1 -> {
                lvlCleared = 45;
                rightPanel.changeLevelCounter("51");
                introAnimation = new WorldIntroAnimation(World.DESERT);
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                AudioPlayer.playWorldIntroSound();
                AudioPlayer.stopMusic();
                AudioPlayer.playLevelMusic(World.DESERT);
            }
            case 2 -> {
                lvlCleared = 51;
                rightPanel.changeLevelCounter("52");
            }
            case 3 -> {
                lvlCleared = 52;
                rightPanel.changeLevelCounter("53");
            }
            case 4 -> {
                lvlCleared = 53;
                rightPanel.changeLevelCounter("54");
            }
            case 5 -> {
                lvlCleared = 54;
                rightPanel.changeLevelCounter("55");
            }
            case 6 -> {
                lvlCleared = 55;
                nextWorld6Level(1, heartCrystals);
                return;
            }
        }
        mainPaneCampaign.setCenter(new World5Template(new World5Maps(heartCrystals, 90, level, World.DESERT), rightPanel));
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
        switch (level) {
            case 1 -> {
                lvlCleared = 55;
                rightPanel.changeLevelCounter("61");
                introAnimation = new WorldIntroAnimation(World.SPACE);
                mainPaneCampaign.getChildren().add(introAnimation);
                introAnimation.setDisable(true);
                AudioPlayer.playWorldIntroSound();
            }
            case 2 -> {
                lvlCleared = 61;
                rightPanel.changeLevelCounter("62");
            }
            case 3 -> {
                lvlCleared = 62;
                rightPanel.changeLevelCounter("63");
            }
            case 4 -> {
                lvlCleared = 63;
                rightPanel.changeLevelCounter("64");
            }
            case 5 -> {
                lvlCleared = 64;
                rightPanel.changeLevelCounter("65");
            }
            case 6 -> {
                lvlCleared = 65;
                victoryScreen.setTime(totTime.setGameOver(true));
                AudioPlayer.stopMusic();
                showVictoryScene();
                return;
            }
        }
        mainPaneCampaign.setCenter(new World6Template(new World6Maps(heartCrystals, 99, level, World.SPACE), rightPanel));
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

    public boolean getMusicIsOn() {
        return rightPanel.getMusicOn();
    }

    public LinkedList<Player> getPlayerList(String file) {
        LinkedList<Player> list = new LinkedList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Player player;
            while (null != (player = (Player) ois.readObject())) {
                list.add(player);
            }
        } catch (IOException | ClassNotFoundException e) {
        }
        return list;
    }

    public void addPlayerToFile(Player player, String file) {
        LinkedList<Player> scoreList = getPlayerList(file);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            if (10 == scoreList.size() && 0 < scoreList.get(9).compareTo(player)) {
                scoreList.set(9, player);
            } else if (10 > scoreList.size()) {
                scoreList.add(player);
            }
            Collections.sort(scoreList);
            for (Player current : scoreList) {
                if (null != current) {
                    oos.writeObject(current);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isQualified(Player player) {
        LinkedList<Player> scoreList = getPlayerList("files/scoreList.dat");
        if (10 == scoreList.size() && 0 < scoreList.get(9).compareTo(player)) return true;
        return 10 > scoreList.size();
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

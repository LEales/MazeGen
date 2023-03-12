package control;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.util.Duration;
import model.enums.GameMode;
import model.maps.*;

import model.Player;
import model.enums.World;
import control.time.TotalTime;
import view.TutorialScreen;
import view.campaign.*;
import view.GameOverScreen;
import view.menu.Menu;
import view.randomize.MapTemplate;
import view.menu.*;
import view.VictoryScreen;
import view.WorldIntroAnimation;
import view.sandbox.*;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * @author André Eklund
 * @edit Teodor Wegestål, Luke Eales - Removed unnecessary variables, methods and dependencies. General code clean up.
 */

public class MainProgram extends Application {

    public static MainProgram mainProgram;
    public static final double WIDTH = 800.0d;
    public static final double HEIGHT = 600.0d;
    private Stage mainWindow;
    private BorderPane mainPaneRandomMaze, mainPaneCampaign, mainPaneSandbox;
    private Scene menuScene, helpScene, chooseDimensionScene, highscoreScene, victoryScene, randomScene, campaignScene, sandboxLoader, sandboxScene, sandboxPlayScene;
    private HighscoreList highscoreList;
    private VictoryScreen victoryScreen;
    private RightPanel rightPanel, rightPnlRndm, rightPanelSandbox;
    private MazeGenerator mazeGenerator;

    private WorldIntroAnimation introAnimation;
    private int lvlCleared;
    private TotalTime totTime;

    private MapTemplate mapTemplate;
    private SandboxTemplate sandboxTemplate;
    private World1Template worldTemplate;

    private TutorialScreen tutorialScreen;

    private ArrayList<CreatedMap> createdMaps;


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

        createdMaps = new ArrayList<>();
        addMapsFromDat();

        rightPanel = new RightPanel(GameMode.CAMPAIGN);
        rightPanel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        rightPanelSandbox = new RightPanel(GameMode.CUSTOM);
        rightPanelSandbox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Menu menu = new Menu();
        Intro intro = new Intro();
        Help help = new Help();
        highscoreList = new HighscoreList();
        victoryScreen = new VictoryScreen();
        mazeGenerator = new MazeGenerator();

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

        setTaskBar();

        chooseDimensionScene = new Scene(chooseDimension, WIDTH, HEIGHT);

        mainPaneRandomMaze = new BorderPane();
        mainPaneCampaign = new BorderPane();
        mainPaneSandbox = new BorderPane();
        introAnimation = new WorldIntroAnimation();

        mainWindow = primaryStage;
        Image cursorImage = new Image("file:files/imagecursor.png");

        mainWindow.setTitle("Mazegen");
        mainWindow.setResizable(false);
        mainWindow.setOnCloseRequest(windowEvent -> {
            saveMapsToDat();
            System.exit(0);
        });
        mainPaneCampaign.setRight(rightPanel);
        mainPaneSandbox.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        mainPaneSandbox.setRight(rightPanelSandbox);

        rightPnlRndm = new RightPanel(GameMode.RANDOMIZE);
        rightPnlRndm.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        mainPaneRandomMaze.setRight(rightPnlRndm);

        campaignScene = new Scene(mainPaneCampaign, WIDTH, HEIGHT);
        randomScene = new Scene(mainPaneRandomMaze, WIDTH, HEIGHT);
        menuScene = new Scene(menu, WIDTH, HEIGHT);
        sandboxPlayScene = new Scene(mainPaneSandbox, WIDTH, HEIGHT);

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
        sandboxPlayScene.setCursor(new ImageCursor(cursorImage));
    }

    /**
     * Byter scen till huvudmenyn.
     */
    public void changeToMenu() {
        removeTutorialScreen();
        mainWindow.setScene(menuScene);
        sandboxScene = null;
    }

    /**
     * Byter scen till Randomize.
     *
     * @param dimension Storleken på labyrinten som ska genereras.
     * @throws FileNotFoundException
     */
    public void changeToRandomize(int dimension) throws FileNotFoundException {
        mazeGenerator.generateNewMaze(dimension);
        mapTemplate = new MapTemplate(mazeGenerator, rightPnlRndm);
        mainPaneRandomMaze.setCenter(mapTemplate);
        mainWindow.setScene(randomScene);
    }

    public void changeRandomMapPane(MazeGenerator mazeGenerator) {
        try {
            mapTemplate = new MapTemplate(mazeGenerator, rightPnlRndm);
            mainPaneRandomMaze.setCenter(mapTemplate);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void playRandomizeMusic(World world) {
        AudioPlayer.playLevelMusic(world);
    }

    /**
     * Byter scen till kampanjläget.
     *
     * @throws FileNotFoundException
     */
    public void changeToCampaign() throws FileNotFoundException {
        lvlCleared = 0;
        worldTemplate = new World1Template(new World1Maps(3, 25, 1, World.FOREST), rightPanel);
        rightPanel.changeLevelCounter("11");
        mainPaneCampaign.setCenter(worldTemplate);
        mainWindow.setScene(campaignScene);
        campaignScene.setOnKeyPressed(e -> keyPressed(e));
        tutorialScreen = new TutorialScreen();
        tutorialScreen.setupFirstScene();

        mainPaneCampaign.getChildren().add(tutorialScreen);
        startTotalTime();
    }

    private void keyPressed(KeyEvent e) {
        if (null != e) {
            if (KeyCode.SPACE == e.getCode() && tutorialScreen !=null && !(tutorialScreen.isDisable())) {
                removeTutorialScreen();
                if (rightPanel.getFirstLevel()) {
                    playWorldIntroAnimation(World.FOREST);
                }
                else {
                    worldTemplate.startLadderAnimation(worldTemplate.getMap().getWorld());
                }



            }
        }
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

    public void gameOverRandomize() {
        ImageView introView = new ImageView(new Image("file:files/texts/Gameover.png", 600, 600, false, false));
        introView.setStyle("fx-background-color: transparent;");
        FadeTransition ft = new FadeTransition(Duration.millis(4000.0), introView);
        mainPaneRandomMaze.getChildren().add(introView);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        mainPaneRandomMaze.setOnMouseClicked(e -> {
            AudioPlayer.stopMusic();
            changeToMenu();
            mainPaneRandomMaze.setOnMouseClicked(null);
        });
    }

    public void gameOverSandbox() {
        ImageView introView = new ImageView(new Image("file:files/texts/Gameover.png", 600, 600, false, false));
        introView.setStyle("fx-background-color: transparent;");
        FadeTransition ft = new FadeTransition(Duration.millis(4000.0), introView);
        mainPaneSandbox.getChildren().add(introView);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        mainPaneSandbox.setOnMouseClicked(e -> {
            changeToMenu();
            mainPaneSandbox.setOnMouseClicked(null);
        });
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
        rightPanel.removePickaxe();
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
        worldTemplate = new World1Template(new World1Maps(heartCrystals, 25, level + 1, World.FOREST), rightPanel);
        mainPaneCampaign.setCenter(worldTemplate);
        worldTemplate.startLadderAnimation(worldTemplate.getMap().getWorld());
        if (4 == level) {
            tutorialScreen = new TutorialScreen();
            tutorialScreen.setupSecondScene();
            mainPaneCampaign.getChildren().add(tutorialScreen);
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
        rightPanel.removePickaxe();

        switch (level) {
            case 1 -> {
                lvlCleared = 15;
                rightPanel.changeLevelCounter("21");
                playWorldIntroAnimation(World.UNDERGROUND);
                AudioPlayer.playWorldIntroSound();
                AudioPlayer.stopMusic();
                AudioPlayer.playLevelMusic(World.UNDERGROUND);
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

        worldTemplate = new World2Template(new World2Maps(heartCrystals, 35, level + 1, World.UNDERGROUND), rightPanel);
        worldTemplate.startLadderAnimation(worldTemplate.getMap().getWorld());
        mainPaneCampaign.setCenter(worldTemplate);
        if (5 == level) {
            tutorialScreen = new TutorialScreen();
            tutorialScreen.setupThirdScene();
            mainPaneCampaign.getChildren().add(tutorialScreen);
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
        rightPanel.removePickaxe();
        switch (level) {
            case 1 -> {
                lvlCleared = 25;
                rightPanel.changeLevelCounter("31");
                playWorldIntroAnimation(World.LAVA);
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
        worldTemplate = new World3Template(new World3Maps(heartCrystals, 45, level + 1, World.LAVA), rightPanel);
        worldTemplate.startLadderAnimation((World.LAVA));
        mainPaneCampaign.setCenter(worldTemplate);
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
        rightPanel.removePickaxe();
        switch (level) {
            case 1 -> {
                lvlCleared = 35;
                rightPanel.changeLevelCounter("41");
                playWorldIntroAnimation(World.CLOUD);
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

        worldTemplate = new World4Template(new World4Maps(heartCrystals, 55, level + 1, World.CLOUD), rightPanel);
        worldTemplate.startLadderAnimation(World.CLOUD);
        mainPaneCampaign.setCenter(worldTemplate);
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
        rightPanel.removePickaxe();
        switch (level) {
            case 1 -> {
                lvlCleared = 45;
                rightPanel.changeLevelCounter("51");
                playWorldIntroAnimation(World.DESERT);
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

        worldTemplate = new World5Template(new World5Maps(heartCrystals, 65, level + 1, World.DESERT), rightPanel);
        worldTemplate.startLadderAnimation(World.DESERT);
        mainPaneCampaign.setCenter(worldTemplate);
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
        rightPanel.removePickaxe();
        switch (level) {
            case 1 -> {
                lvlCleared = 55;
                rightPanel.changeLevelCounter("61");
                playWorldIntroAnimation(World.SPACE);
                AudioPlayer.playWorldIntroSound();
                AudioPlayer.stopMusic();
                AudioPlayer.playLevelMusic(World.SPACE);
            }
            case 2 -> {
                lvlCleared = 61;
                rightPanel.changeLevelCounter("62");
                worldTemplate.startLadderAnimation(worldTemplate.getMap().getWorld());
            }
            case 3 -> {
                lvlCleared = 62;
                rightPanel.changeLevelCounter("63");
                worldTemplate.startLadderAnimation(worldTemplate.getMap().getWorld());
            }
            case 4 -> {
                lvlCleared = 63;
                rightPanel.changeLevelCounter("64");
                worldTemplate.startLadderAnimation(worldTemplate.getMap().getWorld());
            }
            case 5 -> {
                lvlCleared = 64;
                rightPanel.changeLevelCounter("65");
                worldTemplate.startLadderAnimation(worldTemplate.getMap().getWorld());
            }
            case 6 -> {
                lvlCleared = 65;
                victoryScreen.setTime(totTime.setGameOver(true));
                AudioPlayer.stopMusic();
                showVictoryScene();
                return;
            }
        }
        worldTemplate = new World6Template(new World6Maps(heartCrystals, 99, level + 1, World.SPACE), rightPanel);
        worldTemplate.startLadderAnimation(World.SPACE);
        mainPaneCampaign.setCenter(worldTemplate);
    }

    public void stopTime() {
        if (null != worldTemplate) {
            worldTemplate.stopTime();
        }
        if (null != mapTemplate) {
            mapTemplate.stopTime();
        }
        if (null != sandboxTemplate) {
            sandboxTemplate.stopTime();
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
        victoryScreen.startLabelTimer();
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

    public MazeGenerator getMazeGenerator() {
        return mazeGenerator;
    }

    public void removeTutorialScreen() {
        mainPaneCampaign.getChildren().remove(tutorialScreen);
        tutorialScreen = null;
    }

    public void playWorldIntroAnimation(World world) {
        if (null != world) {
            introAnimation = new WorldIntroAnimation(world);
            mainPaneCampaign.getChildren().add(introAnimation);
            introAnimation.setDisable(true);
            worldTemplate.startLadderAnimation(world);

        }
    }

    /**
     * Changes scene to sandbox mode
     */
    public void changeToSandBox(int dimension) {
        sandboxScene = new Scene(new SandboxScreen(dimension), WIDTH, HEIGHT);
        sandboxScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        mainWindow.setScene(sandboxScene);
    }

    public void changeToSandBoxDimension() {
        Scene scene = new Scene(new SandboxDimension(), WIDTH, HEIGHT);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        mainWindow.setScene(scene);
    }


    /**
     * Sets the taskbar icon
     */
    private void setTaskBar() {
        if (Taskbar.isTaskbarSupported()) {
            Taskbar taskbar = Taskbar.getTaskbar();
            if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
                Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
                taskbar.setIconImage(defaultToolkit.getImage(getClass().getResource("/images/ghost.png")));
            }
        }
    }

    public boolean saveMap(CreatedMap map, boolean overwrite) {
        CreatedMap clone = cloneMap(map);
        if (createdMaps.contains(clone) && !overwrite) {
            return false;
        } else if (createdMaps.contains(clone) && overwrite) {
            createdMaps.set(createdMaps.indexOf(clone), clone);
        } else {
            createdMaps.add(clone);
        }
        return true;
    }

    public boolean checkMap(String id) {
        for (CreatedMap map : createdMaps) {
            if (map.getName().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private void saveMapsToDat() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/maps.dat"))) {
            for (CreatedMap map : createdMaps) {
                CreatedMap clone = cloneMap(map);
                oos.writeObject(clone);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addMapsFromDat() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/maps.dat"))) {
            CreatedMap map;
            while (null != (map = (CreatedMap) ois.readObject())) {
                CreatedMap clone = cloneMap(map);
                createdMaps.add(clone);
            }
        } catch (IOException | ClassNotFoundException ignored) {

        }
    }

    public void loadMap(CreatedMap map) {
        CreatedMap clone = cloneMap(map);
        SandboxScreen sandboxScreen = new SandboxScreen(map.dimension);
        sandboxScreen.loadMap(clone);
        sandboxScene = new Scene(sandboxScreen, WIDTH, HEIGHT);
        sandboxScreen.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        mainWindow.setScene(sandboxScene);
    }

    public void playMap(CreatedMap map) {
        CreatedMap clone = cloneMap(map);
        sandboxTemplate = new SandboxTemplate(clone, rightPanelSandbox);
        mainPaneSandbox.setCenter(sandboxTemplate);
        mainWindow.setScene(sandboxPlayScene);
        sandboxTemplate.startLadderAnimation(clone.getWorld());
    }

    //Metod som gör en kopia av ett objekt så att orginalet inte förändras. No pass by value in java :(
    private CreatedMap cloneMap(CreatedMap map) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        CreatedMap copy = null;
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            copy = (CreatedMap) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return copy;
    }

    public void deleteMap(CreatedMap map) {
        CreatedMap clone = cloneMap(map);
        createdMaps.remove(clone);
    }

    public void changeToSandBoxLoader() {
        sandboxLoader = new Scene(new SandboxLoader(createdMaps), WIDTH, HEIGHT);
        mainWindow.setScene(sandboxLoader);
    }
}

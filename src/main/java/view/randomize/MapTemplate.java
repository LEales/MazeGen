package view.randomize;


import control.MazeGenerator;
import control.MainProgram;
import control.time.TimeThread;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.enums.GameMode;
import model.maps.RandomizeMap;
import model.enums.World;
import control.AudioPlayer;
import view.menu.RightPanel;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * @author André Eklund
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables methods and dependencies
 */

public class MapTemplate extends GridPane {

    private final MazeGenerator mazeGenerator;
    private final int squareSize;
    private final MainProgram mainProgram;

    private TimeThread time;

    private final RightPanel rightPanel;
    private Image wall, path, border, goal, diamond, start;
    private AnimationTimer timer;
    private Label startLabel;

    /**
     * Konstruktorn ska kunna ta emot int-arrayer och representera dem i GUIt
     */
    public MapTemplate(MazeGenerator mazeGenerator, RightPanel rightPanel) throws FileNotFoundException {
        this.mazeGenerator = mazeGenerator;
        this.rightPanel = rightPanel;
        mainProgram = MainProgram.getMainProgram();
        rightPanel.changeHeartCounter(3);
        time = new TimeThread(mazeGenerator.getMap().getSeconds(), rightPanel, GameMode.RANDOMIZE);
        squareSize = (int) MainProgram.HEIGHT / (mazeGenerator.getMap().dimension + 2);
        setBackground();
        World world = randomizeWorld();
        mazeGenerator.setWorld(world);
        setupImages(world);
        setupBorders();
        setupLevel();
        mainProgram.playRandomizeMusic(world);

        rightPanel.resetTimerLabel();

    }

    /**
     * Sätter bakgrunden i fönstret.
     */
    public void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg", MainProgram.WIDTH, MainProgram.HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
    }

    /**
     * Skapar en ram runt spelplanen.
     */
    private void setupBorders() {
        for (int i = 0; i < mazeGenerator.getMap().dimension + 1; i++) {
            add(getBorders(), i, 0);
        }
        for (int i = 0; i < mazeGenerator.getMap().dimension + 1; i++) {
            add(getBorders(), 0, i);
        }
        for (int i = 0; i < mazeGenerator.getMap().dimension + 2; i++) {
            add(getBorders(), i, mazeGenerator.getMap().dimension + 1);
        }
        for (int i = 0; i < mazeGenerator.getMap().dimension + 2; i++) {
            add(getBorders(), mazeGenerator.getMap().dimension + 1, i);
        }
    }

    /**
     * Omvandlar värdena i arrayen av siffror till olika grafiska komponenter baserat på vilken siffra en position har.
     */
    private void setupLevel() {
        for (int i = 0; i < mazeGenerator.getMap().dimension; i++) {
            for (int j = 0; j < mazeGenerator.getMap().dimension; j++) {

                switch (mazeGenerator.getSprite(i, j)) {
                    case PATH -> {
                        add(getPath(), j + 1, i + 1);
                        if (4 == new Random().nextInt(5)) {
                            add(addCollectible(), j + 1, i + 1);
                        }
                    }
                    case WALL -> add(getWall(), j + 1, i + 1);
                    case START -> add(getStart(), j + 1, i + 1);
                    case GOAL -> add(getGoal(), j + 1, i + 1);
                }
            }
        }
    }

    /**
     * Randomizes a world
     *
     * @return The randomized world
     */
    private World randomizeWorld() {
        World[] worlds = World.values();
        return worlds[new Random().nextInt(worlds.length)];
    }

    /**
     * Instansierar de olika bilderna som används som grafik inuti spelet.
     * Baserad på value så sätts bilderna till en specifik folder per värld.
     *
     * @param world Den aktuella världen.
     */
    public void setupImages(World world) {
        if (null == world) throw new IllegalArgumentException("Invalid world");
        path = new Image("file:files/" + world + "/path.png", squareSize, squareSize, false, false);
        goal = new Image("file:files/" + world + "/goal.png", squareSize, squareSize, false, false);
        diamond = new Image("file:files/" + world + "/collectible.png", squareSize, squareSize, false, false);
        start = new Image("file:files/" + world + "/start.png", squareSize, squareSize, false, false);

        if (World.SPACE != world) {
            border = new Image("file:files/" + world + "/border.png", squareSize, squareSize, false, false);
            wall = new Image("file:files/" + world + "/wall.png", squareSize, squareSize, false, false);
        }
    }

    /**
     * En metod som skapar ett objekt av label som representerar en vägg.
     *
     * @return Returnerar en label.
     */
    public Label getWall() {
        Label label = new Label();
        ImageView wallView = new ImageView(wall);
        wallView.setFitHeight(squareSize);
        wallView.setFitWidth(squareSize);
        label.setGraphic(wallView);
        label.setOnMouseEntered(e -> enteredWall(e));
        label.setOnMouseExited(e -> exitedLabel(e));
        return label;
    }

    /**
     * En metod som skapar ett objekt av label som representerar en väg.
     *
     * @return Returnerar en label.
     */
    private Label getPath() {
        Label label = new Label();
        ImageView pathView = new ImageView(path);
        pathView.setFitHeight(squareSize);
        pathView.setFitWidth(squareSize);
        label.setGraphic(pathView);
        return label;
    }

    /**
     * En metod som skapar ett objekt av label som representerar en border.
     *
     * @return Returnerar en label.
     */
    private Label getBorders() {
        Label label = new Label();
        ImageView borderView = new ImageView(border);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        label.setGraphic(borderView);
        label.setOnMouseEntered(e -> enteredWall(e));
        label.setOnMouseExited(e -> exitedLabel(e));
        return label;
    }

    /**
     * En metod som skapar ett objekt av label som representerar en förstörbar vägg.
     *
     * @return Returnerar en label.
     */
    private Label getGoal() {
        Label label = new Label();
        ImageView borderView = new ImageView(goal);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        label.setGraphic(borderView);
        label.setOnMouseEntered(e -> {
            try {
                enteredGoal();
            } catch (FileNotFoundException | InterruptedException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        return label;
    }

    /**
     * En metod som skapar ett objekt av label som representerar start.
     *
     * @return Returnerar en label.
     */
    private Label getStart() {
        Label label = new Label();
        ImageView borderView = new ImageView(start);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        label.setGraphic(borderView);
        label.setOnMouseClicked(e -> startLevel());
        startLabel = label;
        startLadderAnimation();
        return label;
    }

    /**
     * En metod som skapar ett objekt av label som representerar en collectible.
     *
     * @return Returnerar en label.
     */
    private Label addCollectible() {
        Label collectible = new Label();
        ImageView borderView = new ImageView(diamond);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        Glow glow = new Glow();
        glow.setLevel(0.7);
        borderView.setEffect(glow);
        collectible.setStyle("fx-background-color: transparent;");
        collectible.setGraphic(borderView);
        collectible.setOnMouseEntered(e -> collectibleEntered(e));
        mazeGenerator.getMap().incrementCollectible();
        return collectible;
    }

    private void collectibleEntered(MouseEvent e) {
        if (mazeGenerator.getMap().isGameStarted() && !timeIsNullOrOver()) {
            AudioPlayer.playCollectibleSound();
            Label label = (Label) e.getSource();
            label.setVisible(false);
            mazeGenerator.getMap().incrementCollectiblesObtained();
        }
    }

    /**
     * Om spelaren vidrör muspekaren vid en vägg avslutas spelrundan.
     *
     * @param e Används för att hitta rätt label.
     */
    public void enteredWall(MouseEvent e) {
        if (!timeIsNullOrOver()) {
            Label label = (Label) e.getSource();
            FadeTransition fade = new FadeTransition();
            fade.setNode(label);
            fade.setDuration(Duration.seconds(0.3));
            fade.setFromValue(10);
            fade.setToValue(0.6);
            fade.play();
            if (mazeGenerator.getMap().isGameStarted()) {
                AudioPlayer.playDeathSound();
                mazeGenerator.getMap().setGameStarted(false);
                if (mazeGenerator.getMap().heartCrystalLost()) {
                    gameOver("died");
                } else {
                    startLadderAnimation();
                }
                rightPanel.changeHeartCounter(mazeGenerator.getMap().getHeartCrystals());

            }
        }
    }

    private void gameOver(String cause) {
        if (null == cause || MainProgram.wrongCauseInput(cause)) {
            throw new IllegalArgumentException("Invalid input: Cause");
        }
        AudioPlayer.playGameOverSound();
        AudioPlayer.stopMusic();
        AudioPlayer.stopTimeLeftSound();
        MainProgram.getMainProgram().gameOverRandomize(cause);
        time.setGameOver(true);
        time = null;
    }

    /**
     * Om spelrundan är aktiverad och spelaren har plockat upp alla collectibles startas nästa nivå.
     *
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    private void enteredGoal() throws FileNotFoundException, InterruptedException {
        if (mazeGenerator.getMap().isGameStarted() && mazeGenerator.getMap().allCollectiblesObtained() && !timeIsNullOrOver()) {
            AudioPlayer.playGoalSound();
            AudioPlayer.stopTimeLeftSound();
            AudioPlayer.stopMusic();
            stopTime();
            mazeGenerator.generateNextMaze();
        }
    }

    /**
     * Startar spelrundan och timern.
     */
    private void startLevel() {
        RandomizeMap map = mazeGenerator.getMap();
        if (!map.isTimeStarted()) {
            map.setTimeStarted(true);
            time.start();
        }
        if (!map.isGameStarted()) {
            AudioPlayer.playStartSound();
        }
        stopLadderAnimation();
        map.setGameStarted(true);
    }

    /**
     * När muspekaren lämnar en label slutar den att highlightas.
     *
     * @param e Används för att hitta rätt label.
     */
    private void exitedLabel(MouseEvent e) {
        Label label = (Label) e.getSource();
        FadeTransition fade = new FadeTransition();
        fade.setNode(label);
        fade.setDuration(Duration.seconds(0.3));
        fade.setFromValue(0.6);
        fade.setToValue(10);
        fade.play();
    }

    public void stopTime() {
        if (time != null) {
            time.setGameOver(true);
            time = null;
        }
    }

    private boolean timeIsNullOrOver() {
        return null == time || time.isGameOver();
    }

    public void startLadderAnimation() {
        timer = new AnimationTimer() {
            private long lastUpdate;
            private boolean isLabelVisible;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 500_000_000) {
                    isLabelVisible = !isLabelVisible;
                    if (isLabelVisible) {
                        startLabel.setGraphic(new ImageView(new Image("file:files/" + mazeGenerator.getMap().getWorld() + "/brightLadder.png", squareSize, squareSize, false, false)));
                    } else {
                        startLabel.setGraphic(new ImageView(new Image("file:files/" + mazeGenerator.getMap().getWorld() + "/start.png", squareSize, squareSize, false, false)));
                    }
                    lastUpdate = now;
                }
            }
        };
        timer.start();
    }

    public void stopLadderAnimation() {
        if (timer != null) {
            timer.stop();
            startLabel.setGraphic(new ImageView(new Image("file:files/" + mazeGenerator.getMap().getWorld() + "/start.png", squareSize, squareSize, false, false)));
            timer = null;
        }
    }
}

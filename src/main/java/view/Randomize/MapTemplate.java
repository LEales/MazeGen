package view.Randomize;


import model.Maps.Sprite;
import control.GenerateNextLevel;
import control.MainProgram;
import javafx.animation.FadeTransition;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.util.Duration;
import model.World;
import control.AudioPlayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author André Eklund
 * edit Viktor Näslund
 */

public class MapTemplate extends GridPane {

    private final GenerateNextLevel generateNextLevel;
    private final Sprite[][] level;
    private final List<Label> collectibles;

    private boolean startButtonPressed;
    private int collectiblesObtained;
    private final int squareSize;

    private Image wall;
    private Image path;
    private Image border;
    private Image goal;
    private Image diamond;
    private Image start;


    /**
     * Konstruktorn ska kunna ta emot int-arrayer och representera dem i GUIt
     */
    public MapTemplate(Sprite[][] level, GenerateNextLevel generateNextLevel) throws FileNotFoundException {
        this.level = level;
        this.generateNextLevel = generateNextLevel;
        collectibles = new ArrayList<>();

        squareSize = (int) MainProgram.HEIGHT / (level.length + 2);
        setBackground();
        setupImages(randomizeWorld());
        setupBorders();
        setupLevel();
    }

    /**
     * Sätter bakgrunden i fönstret.
     */
    public void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
    }

    /**
     * Skapar en ram runt spelplanen.
     */
    private void setupBorders() {
        for (int i = 0; i < level.length + 1; i++) {
            add(getBorders(), i, 0);
        }
        for (int i = 0; i < level.length + 1; i++) {
            add(getBorders(), 0, i);
        }
        for (int i = 0; i < level.length + 2; i++) {
            add(getBorders(), i, level.length + 1);
        }
        for (int i = 0; i < level.length + 2; i++) {
            add(getBorders(), level.length + 1, i);
        }
    }

    /**
     * Omvandlar värdena i arrayen av siffror till olika grafiska komponenter baserat på vilken siffra en position har.
     */
    private void setupLevel() {
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level.length; j++) {

                switch (level[i][j]) {
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
        collectibles.add(collectible);
        return collectible;
    }

    private void collectibleEntered(MouseEvent e) {
        if (startButtonPressed) {
            AudioPlayer.playCollectibleSound();
            for (Label label : collectibles) {
                if (e.getSource() == label) {
                    label.setVisible(false);
                    collectiblesObtained++;
                }
            }
        }
    }

    /**
     * Om spelaren vidrör muspekaren vid en vägg avslutas spelrundan.
     *
     * @param e Används för att hitta rätt label.
     */
    public void enteredWall(MouseEvent e) {
        Label label = (Label) e.getSource();
        FadeTransition fade = new FadeTransition();
        fade.setNode(label);
        fade.setDuration(Duration.seconds(0.3));
        fade.setFromValue(10);
        fade.setToValue(0.6);
        fade.play();

        if (startButtonPressed) {
            AudioPlayer.playDeathSound();
            startButtonPressed = false;
        }
    }

    /**
     * Om spelrundan är aktiverad och spelaren har plockat upp alla collectibles startas nästa nivå.
     *
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    private void enteredGoal() throws FileNotFoundException, InterruptedException {
        if (startButtonPressed && collectiblesObtained == collectibles.size()) {
            AudioPlayer.playGoalSound();
            generateNextLevel.generateNewMaze();
        }
    }

    /**
     * Startar spelrundan och timern.
     */
    private void startLevel() {
        if (!startButtonPressed) {
            AudioPlayer.playStartSound();
        }
        startButtonPressed = true;
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
    /**
     * En listener som körs när spelaren plockar upp en collectible.
     */
}

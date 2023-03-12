package view.campaign;

import control.AudioPlayer;
import control.MainProgram;
import control.time.TimeThread;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import model.enums.GameMode;
import model.enums.LifeLostCause;
import model.maps.Maps;
import model.enums.World;
import model.maps.Maps;
import view.menu.RightPanel;

import java.io.FileNotFoundException;

/**
 * @author André Eklund
 * @edit Filip Örnling, Sebastian Helin, Viktor Näslund
 * @edit Luke Eales, Teodor Wegestål - Removed unnecessary variables methods and dependencies
 */

public class World1Template extends GridPane {


    private final MainProgram mainProgram;
    private final Maps map;
    private Image wall, path, border, goal, diamond, start, heart, breakableWall, pickAxeImage;
    final int squareSize;
    private final RightPanel rightPanel;
    private TimeThread time;
    private boolean ladderClicked;
    private int ladderRow;
    private int ladderColumn;
    private int column;
    private int row;
    private Thread imageThread;
    private Label brightLadder;
    private Label normaLadder;

    private LifeLostCause worldCause;

    /**
     * Instansierar objekten.
     *
     * @param rightPanel Panelen som visar information så som liv, tid, nivå osv.
     * @throws FileNotFoundException
     */

    //Konstruktorn ska kunna ta emot int-arrayer och representera dem i GUIt
    public World1Template(Maps map, RightPanel rightPanel, LifeLostCause worldCause) throws FileNotFoundException {
        this.mainProgram = MainProgram.getMainProgram();
        this.map = map;
        rightPanel.changeHeartCounter(map.getHeartCrystals());
        time = new TimeThread(map.getSeconds(), rightPanel, GameMode.CAMPAIGN);
        this.rightPanel = rightPanel;
        this.worldCause = worldCause;
        squareSize = (int) MainProgram.HEIGHT / (map.getMap().length + 2);
        setBackground();
        setupImages(map.getWorld());
        setupBorders();
        setupLevel();
        rightPanel.resetTimerLabel();
    }

    /**
     * Sätter bakgrunden i fönstret.
     */
    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg",
                MainProgram.WIDTH, MainProgram.HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(menuBackground));
    }

    /**
     * Creates a path transition for an animation
     *
     * @param node        The node to be animation
     * @param duration    The duration in seconds of the animation
     * @param cycleCount  How many cycles the animation will run
     * @param path        The path of the animation
     * @param autoReverse If the animation returns to the starting point, following the same path
     * @return the path transition
     */
    PathTransition createPathTransition(Node node, double duration, int cycleCount, Shape path, boolean autoReverse) {
        if (0.0 >= duration) {
            throw new IllegalArgumentException("Duration invalid");
        }
        if (-1 > cycleCount || 0 == cycleCount) {
            throw new IllegalArgumentException("Cycle count invalid");
        }
        if (null == node) {
            throw new IllegalArgumentException("Invalid node");
        }
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(node);
        pathTransition.setAutoReverse(autoReverse);
        pathTransition.setDuration(Duration.seconds(duration));
        pathTransition.setCycleCount(cycleCount);
        pathTransition.setPath(path);
        return pathTransition;
    }

    /**
     * Creates an Image View and adds it to the grid pane
     *
     * @param image The image to be added
     * @param i     The row index
     * @param i1    The column index
     * @return
     */
    ImageView createImageView(Image image, int i, int i1) {
        if (null == image) {
            throw new IllegalArgumentException("Image invalid");
        }
        if (0 > i || 0 > i1) {
            throw new IllegalArgumentException("Negative numbers not allowed");
        }
        ImageView view = new ImageView(image);
        add(view, i, i1);
        return view;
    }

    /**
     * Creates a path for a ghost in the shape of a rectangle
     *
     * @param v  The width of the rectangle
     * @param v1 The height of the rectangle
     * @param y  The y-position of the rectangle
     * @param x  The x-position of the rectangle
     * @return the created rectangle
     */
    Rectangle createRectangle(double v, double v1, double y, double x) {
        Rectangle rectangle = new Rectangle(v, v1);
        rectangle.setY(y);
        rectangle.setX(x);
        return rectangle;
    }

    /**
     * Skapar en ram runt spelplanen.
     */
    private void setupBorders() {
        for (int i = 0; i < map.getMap().length + 1; i++) {
            add(getBorders(), i, 0);
        }
        for (int i = 0; i < map.getMap().length + 1; i++) {
            add(getBorders(), 0, i);
        }
        for (int i = 0; i < map.getMap().length + 2; i++) {
            add(getBorders(), i, map.getMap().length + 1);
        }
        for (int i = 0; i < map.getMap().length + 2; i++) {
            add(getBorders(), map.getMap().length + 1, i);
        }
    }

    /**
     * Omvandlar värdena i arrayen av siffror till olika grafiska komponenter baserat på vilken siffra en position har.
     * Exempelvis så representerar 1:or väg, 0:or väggar, och 7:or hjärtan osv.
     */
    private void setupLevel() {
        for (int i = 1; i < map.getMap().length + 1; i++) {
            for (int j = 1; j < map.getMap().length + 1; j++) {
                switch (map.getMap()[i - 1][j - 1]) {
                    case PATH -> add(getPath(), j, i);
                    case WALL -> add(getWall(), j, i);
                    case START -> add(getStart(), j, i);
                    case GOAL -> add(getGoal(), j, i);
                    case COLLECTIBLE -> {
                        add(getPath(), j, i);
                        add(addCollectible(), j, i);
                    }
                    case AXE -> {
                        add(getPath(), j, i);
                        add(addPickAxe(), j, i);
                    }
                    case BREAKABLE_WALL -> add(getBreakableWall(), j, i);
                    case HEART -> {
                        add(getPath(), j, i);
                        add(addHeartCrystal(), j, i);
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + map.getMap()[i - 1][j - 1]);
                }
            }
        }
    }

    /**
     * Instansierar de olika bilderna som används som grafik inuti spelet.
     * Baserad på value så sätts bilderna till en specifik folder per värld.
     *
     * @param world Den aktuella världen.
     */
    private void setupImages(World world) {
        path = new Image("file:files/" + world + "/path.png", squareSize, squareSize, false, false);
        goal = new Image("file:files/" + world + "/goal.png", squareSize, squareSize, false, false);
        diamond = new Image("file:files/" + world + "/collectible.png", squareSize, squareSize, false, false);
        start = new Image("file:files/" + world + "/start.png", squareSize, squareSize, false, false);
        pickAxeImage = new Image("file:files/items/pickaxe.png", squareSize, squareSize, false, false);
        heart = new Image("file:files/items/heart.png", squareSize, squareSize, false, false);
        if (World.CLOUD == world) {
            breakableWall = new Image("file:files/cloud/breakablewall.png", squareSize, squareSize, false, false);
        } else {
            breakableWall = new Image("file:files/breakablewall.png", squareSize, squareSize, false, false);
        }
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
    private Label getWall() {
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
    private Label getBreakableWall() {
        Label label = new Label();
        ImageView borderView = new ImageView(breakableWall);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        label.setGraphic(borderView);
        label.setOnMouseEntered(e -> enteredBreakableWall(e));
        label.setOnMouseExited(e -> exitedLabel(e));
        return label;
    }

    /**
     * En metod som skapar ett objekt av label som representerar ett mål.
     *
     * @return Returnerar en label.
     */
    private Label getGoal() {
        Label label = new Label();
        label.setId("goal");
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
        label.setId("start");
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
        collectible.setOnMouseEntered(e -> collectibleObtained(e));
        map.incrementCollectible();
        return collectible;
    }

    private void collectibleObtained(MouseEvent e) {
        if (map.isGameStarted() && !timeIsNullOrOver()) {
            AudioPlayer.playCollectibleSound();
            Label label = (Label) e.getSource();
            label.setVisible(false);
            map.incrementCollectiblesObtained();
        }
    }

    /**
     * En metod som skapar ett objekt av label som representerar ett spelarliv.
     *
     * @return Returnerar en label.
     */
    private Label addHeartCrystal() {
        Label heartCrystal = new Label();
        ImageView borderView = new ImageView(heart);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        Glow glow = new Glow();
        glow.setLevel(0.8);
        borderView.setEffect(glow);
        heartCrystal.setStyle("fx-background-color: transparent;");
        heartCrystal.setGraphic(borderView);
        heartCrystal.setOpacity(0.8);
        heartCrystal.setOnMouseEntered(e -> heartCrystalObtained(e));
        return heartCrystal;
    }

    /**
     * När en användare vidrör en label av typen heartCrystal körs denna metod.
     * Om spelaren har mindre än tre återstående liv inkrementeras variabeln heartCrystals.
     *
     * @param e Används för att hitta rätt label.
     */

    private void heartCrystalObtained(MouseEvent e) {
        Label label = (Label) e.getSource();
        if (map.isGameStarted() && !timeIsNullOrOver()) {
            AudioPlayer.playHeartSound();
            label.setVisible(false);
            map.heartCrystalCollected();
            rightPanel.changeHeartCounter(map.getHeartCrystals());
        }
    }

    /**
     * En metod som skapar ett objekt av label som representerar en yxa.
     *
     * @return Returnerar en label.
     */
    private Label addPickAxe() {
        Label pickAxe = new Label();
        ImageView borderView = new ImageView(pickAxeImage);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        Glow glow = new Glow();
        glow.setLevel(0.7);
        borderView.setEffect(glow);
        pickAxe.setStyle("fx-background-color: transparent;");
        pickAxe.setGraphic(borderView);
        pickAxe.setOnMouseEntered(e -> pickAxeObtained(e));
        return pickAxe;
    }

    /**
     * If the game is started, adds a pickaxe to the players inventory
     *
     * @param e MouseEvent
     */
    private void pickAxeObtained(MouseEvent e) {
        if (map.isGameStarted() && !map.isPickAxeInInventory() && !timeIsNullOrOver()) {
            AudioPlayer.playPickAxeSound();
            Label label = (Label) e.getSource();
            label.setVisible(false);
            map.setPickAxeInInventory(true);
            rightPanel.addPickaxe();
        }
    }

    /**
     * Om en spelare vidrör en vägg med muspekaren körs denna metod.
     * Om spelrundan är aktiverad förlorar spelaren ett liv.
     * Om spelaren endast har ett återstående liv kvar vid kollisionen körs metoden gameOver.
     *
     * @param e Används för att hitta rätt label.
     */
    private void enteredWall(MouseEvent e) {
        if (!timeIsNullOrOver()) {
            Label label = (Label) e.getSource();
            createFadeTransition(label, 0.3, 10.0, 0.6).play();
            if (map.isGameStarted()) {
                mainProgram.lostLife(worldCause, map.getHeartCrystals());
                if (map.heartCrystalLost()) {
                    gameOver("died");
                } else {
                    setLadderstatus(false);
                    startLadderAnimation(map.getWorld());
                }
                rightPanel.changeHeartCounter(map.getHeartCrystals());
                AudioPlayer.playDeathSound();
                map.setGameStarted(false);
            }
        }
    }

        /**
         * Om en spelare vidrör ett spöke med muspekaren körs denna metod.
         * Om spelrundan är aktiverad förlorar spelaren ett liv.
         * Om spelaren endast har ett återstående liv kvar vid kollisionen körs metoden gameOver.
         *
         * @param e
         */
        void enteredGhost (MouseEvent e){
            if (map.isGameStarted() && !timeIsNullOrOver()) {
                ImageView view = (ImageView) e.getSource();
                createFadeTransition(view, 0.2, 10, 0.6).play();
                AudioPlayer.playMobSound();
                AudioPlayer.playDeathSound();
                mainProgram.lostLife(LifeLostCause.GHOST, map.getHeartCrystals());
                if (map.heartCrystalLost()) {
                    gameOver("died");
                } else {
                    setLadderstatus(false);
                    startLadderAnimation(map.getWorld());
                }
                rightPanel.changeHeartCounter(map.getHeartCrystals());
                map.setGameStarted(false);
                createFadeTransition(view, 1.5, 0.6, 10).play();
            }
        }

        /**
         * Avslutar spelrundan och kör metoden gameOver i mainProgram.
         */
        private void gameOver (String cause){
            if (null == cause || MainProgram.wrongCauseInput(cause)) {
                throw new IllegalArgumentException("Invalid input: Cause");
            }
            AudioPlayer.playGameOverSound();
            AudioPlayer.stopTimeLeftSound();
            AudioPlayer.stopMusic();
            mainProgram.gameOver(cause);
            this.time.setGameOver(true);
            this.time = null;
            rightPanel.removePickaxe();
        }

        public void stopTime () {
            if (time != null) {
                time.setGameOver(true);
                time = null;
            }
        }

        /**
         * Om spelrundan är aktiverad och spelaren har plockat upp alla collectibles startas nästa nivå.
         *
         * @throws FileNotFoundException
         * @throws InterruptedException
         */
        private void enteredGoal () throws FileNotFoundException, InterruptedException {
            if (map.isGameStarted() && map.allCollectiblesObtained() && !timeIsNullOrOver()) {
                AudioPlayer.stopTimeLeftSound();
                AudioPlayer.playGoalSound();
                time.setGameOver(true);
                time = null;
                nextLevel();
            }
        }

        /**
         * Baserad på den aktuella världen väljer programmmet vilken nivå som ska spelas.
         *
         * @throws FileNotFoundException
         * @throws InterruptedException
         */
        private void nextLevel () throws FileNotFoundException, InterruptedException {
            switch (map.getWorld()) {
                case FOREST -> mainProgram.nextWorld1Level(map.getNextLevel(), map.getHeartCrystals());
                case UNDERGROUND -> mainProgram.nextWorld2Level(map.getNextLevel(), map.getHeartCrystals());
                case LAVA -> mainProgram.nextWorld3Level(map.getNextLevel(), map.getHeartCrystals());
                case CLOUD -> mainProgram.nextWorld4Level(map.getNextLevel(), map.getHeartCrystals());
                case DESERT -> mainProgram.nextWorld5Level(map.getNextLevel(), map.getHeartCrystals());
                case SPACE -> mainProgram.nextWorld6Level(map.getNextLevel(), map.getHeartCrystals());
            }
        }

        /**
         * Startar spelrundan och timern.
         */
        private void startLevel () {
            if (!map.isTimeStarted()) {
                map.setTimeStarted(true);
                time.start();
            }
            if (!map.isGameStarted()) {
                AudioPlayer.playStartSound();
            }
            if (mainProgram.isPlayerHurt()) {
                mainProgram.removeLostLifeText();
            }
            mainProgram.removeTutorialScreen();
            map.setGameStarted(true);
        }

        /**
         * När muspekaren lämnar en label slutar den att highlightas.
         *
         * @param e Används för att hitta rätt label.
         */
        private void exitedLabel (MouseEvent e){
            Label label = (Label) e.getSource();
            createFadeTransition(label, 0.3, 0.6, 10).play();
        }

        private FadeTransition createFadeTransition (Node node,double duration, double from, double to){
            FadeTransition fade = new FadeTransition();
            fade.setNode(node);
            fade.setDuration(Duration.seconds(duration));
            fade.setFromValue(from);
            fade.setToValue(to);
            return fade;
        }

        /**
         * Om spelrundan är startad och spelaren har plockat upp en yxa går det att förstöra väggen.
         * Om spelrundan är startad och spelaren inte plockat upp en yxa förlorar hen ett liv vid kollision med väggen.
         *
         * @param e Används för att hitta rätt label.
         */
        private void enteredBreakableWall (MouseEvent e){
            Label label = (Label) e.getSource();
            ImageView pathView = new ImageView(path);
            if (map.isGameStarted() && !timeIsNullOrOver()) {
                if (map.isPickAxeInInventory()) {
                    label.setGraphic(pathView);
                    map.setPickAxeInInventory(false);
                    rightPanel.removePickaxe();
                    label.setOnMouseEntered(null);
                    label.setOnMouseExited(null);
                    AudioPlayer.playBreakableWallSound();
                } else {
                    enteredWall(e);
                }
            }
        }

        private boolean timeIsNullOrOver () {
            return null == time || time.isGameOver();
        }

        public boolean hasLadderInitialized (World world){
            Label normal = (Label) lookup("#start");
            if (normal != null && normal.hasProperties()) {
                return true;
            }
            return false;
        }

        public void startLadderAnimation (World world){
            if (hasLadderInitialized(world)) {
                imageThread = new Thread(() -> {
                    brightLadder = getBrightStart(world);
                    normaLadder = (Label) lookup("#start");
                    row = getRowIndex(normaLadder);
                    column = getColumnIndex(normaLadder);
                    while (!getLadderstatus()) {
                        Platform.runLater(() -> {
                            if (!getChildren().contains(brightLadder)) {
                                getChildren().remove(normaLadder);
                                add(brightLadder, column, row);
                                brightLadder.toBack();
                                brightLadder.setOnMouseClicked(e -> {
                                    setLadderstatus(true);
                                    stopLadderAnimation(world);
                                    getChildren().remove(brightLadder);
                                    add(normaLadder, column, row);
                                    normaLadder.toBack();
                                });
                            } else if (!getChildren().contains(normaLadder)) {
                                getChildren().remove(brightLadder);
                                add(normaLadder, column, row);
                                normaLadder.toBack();
                                normaLadder.setOnMouseClicked(e -> {
                                    setLadderstatus(true);
                                    stopLadderAnimation(world);
                                });
                            }

                        });
                        sleepFor(1000);
                    }
                });
                imageThread.start();
            }
            ;


        }

        private void sleepFor ( long milliseconds){
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


        public Label getBrightStart (World world){
            start = new Image("file:files/" + world + "/brightLadder.png", squareSize, squareSize, false, false);
            Label label = new Label();
            label.setId("#brightStart");
            ImageView borderView = new ImageView(start);
            borderView.setFitHeight(squareSize);
            borderView.setFitWidth(squareSize);
            label.setGraphic(borderView);
            return label;
        }


        public void stopLadderAnimation (World world){
            setLadderstatus(true);
            imageThread.stop();
            startLevel();
        }
        public boolean getLadderstatus () {
            return ladderClicked;
        }

        public void setLadderstatus ( boolean ladderstatus){
            this.ladderClicked = ladderstatus;
        }

        public Maps getMap () {
            return map;
        }


    }


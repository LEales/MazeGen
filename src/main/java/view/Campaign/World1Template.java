package view.Campaign;

import control.MainProgram;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.Maps.Sprite;
import model.World;
import model.time.TimeThread;
import view.AudioPlayer;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author André Eklund
 * @edit Filip Örnling, Sebastian Helin, Viktor Näslund
 */

public class World1Template extends GridPane {


    private final MainProgram mainProgram;
    private final Sprite[][] level;
    private final Collection<Label> collectibles = new ArrayList<>();
    private final Collection<Label> pickaxes = new ArrayList<>();
    private Image wall;
    private Image path;
    private Image border;
    private Image goal;
    private Image diamond;
    private Image start;
    private Image heart;
    private Image breakableWall;
    private boolean startButtonPressed;
    private boolean allCollectiblesObtained;
    private boolean wallDestroyed;
    private int collectiblesObtained = 0;
    private final int squareSize;
    private final int currentLevel;
    private int heartCrystals;
    private Image pickAxeImage;
    private boolean pickaxeObtained;
    private boolean gameStarted;
    private boolean startNotClickedOnce = true;
    private boolean totalTimeStarted = true;
    private final World world;
    private int seconds;

    private final RightPanel rightPanel;
    private final AudioPlayer audioPlayer;
    private TimeThread time;

    /**
     * Instansierar objekten.
     *
     * @param level         Den array som sedan omvandlas till en nivå inuti spelet.
     * @param currentLevel  Den aktuella nivån
     * @param heartCrystals Spelarens liv.
     * @param rightPanel    Panelen som visar information så som liv, tid, nivå osv.
     * @param world         Används för att sätta rätt grafik på världen.
     * @param audioPlayer   Används för att spela upp ljud inne i spelet.
     * @param seconds       Tidsbegränsningen för varje bana.
     * @throws FileNotFoundException
     */

    //Konstruktorn ska kunna ta emot int-arrayer och representera dem i GUIt
    public World1Template(Sprite[][] level, int currentLevel, int heartCrystals, RightPanel rightPanel, World world, AudioPlayer audioPlayer, int seconds) throws FileNotFoundException {
        this.mainProgram = MainProgram.getMainProgram();
        this.currentLevel = currentLevel;
        this.level = level.clone();
        this.heartCrystals = heartCrystals;
        this.seconds = seconds;

        rightPanel.changeHeartCounter(String.valueOf(heartCrystals));
        this.rightPanel = rightPanel;
        this.audioPlayer = audioPlayer;
        this.world = world;
        squareSize = (int) MainProgram.HEIGHT / (level.length + 2);
        setBackground();
        setupImages(world);
        setupBorders();
        setupLevel();
        rightPanel.setSTARTTIME(seconds);
        rightPanel.resetTimerLabel();
    }

    /**
     * Sätter bakgrunden i fönstret.
     */
    public void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg",
                MainProgram.WIDTH, MainProgram.HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(menuBackground));
    }
    PathTransition createPathTransition(Node node, double duration, int cycleCount, Rectangle path, boolean autoReverse) {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(node);
        pathTransition.setAutoReverse(autoReverse);
        pathTransition.setDuration(Duration.seconds(duration));
        pathTransition.setCycleCount(cycleCount);
        pathTransition.setPath(path);
        return pathTransition;
    }

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
     * Exempelvis så representerar 1:or väg, 0:or väggar, och 7:or hjärtan osv.
     */
    private void setupLevel() {
        for (int i = 1; i < level.length+1; i++) {
            for (int j = 1; j < level.length+1; j++) {
                switch (level[i-1][j-1]) {
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
                    default -> throw new IllegalStateException("Unexpected value: " + level[i-1][j-1]);
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
    public void setupImages(World world) {

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
    private Label getBreakableWall() {
        Label label = new Label();
        ImageView borderView = new ImageView(breakableWall);
        borderView.setFitHeight(squareSize);
        borderView.setFitWidth(squareSize);
        label.setGraphic(borderView);
        label.setOnMouseEntered(e -> enteredBreakableWall(e));
        return label;
    }

    /**
     * En metod som skapar ett objekt av label som representerar ett mål.
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
        collectible.setOnMouseEntered(e -> collectibleObtained(e));
        collectibles.add(collectible);
        return collectible;
    }

    private void collectibleObtained(MouseEvent e) {
        audioPlayer.playCollectibleSound();
        Label label = (Label) e.getSource();
        label.setVisible(false);
        collectiblesObtained++;
        if (collectiblesObtained == collectibles.size()) {
            allCollectiblesObtained = true;
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

        if (startButtonPressed) {
            audioPlayer.playHeartSound();
            label.setVisible(false);
            if (3 > heartCrystals) {
                rightPanel.changeHeartCounter(String.valueOf(++heartCrystals));
            }
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
        pickaxes.add(pickAxe);
        return pickAxe;
    }

    private void pickAxeObtained(MouseEvent e) {
        if (startButtonPressed) {
            audioPlayer.playPickAxeSound();
            Label label = (Label) e.getSource();
            label.setVisible(false);
            pickaxeObtained = true;
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
    public void enteredWall(MouseEvent e) {
        Label label = (Label) e.getSource();
        createFadeTransition(label, 0.3, 10.0, 0.6).play();

        if (startButtonPressed) {
            rightPanel.changeHeartCounter(String.valueOf(--heartCrystals));
            if (0 == heartCrystals) {
                gameOver();
            }
            audioPlayer.playDeathSound();
            startButtonPressed = false;
        }
    }

    /**
     * Om en spelare vidrör ett spöke med muspekaren körs denna metod.
     * Om spelrundan är aktiverad förlorar spelaren ett liv.
     * Om spelaren endast har ett återstående liv kvar vid kollisionen körs metoden gameOver.
     *
     * @param e
     */
    public void enteredGhost(MouseEvent e) {
        if (startButtonPressed) {
            ImageView view = (ImageView) e.getSource();
            createFadeTransition(view, 0.2, 10, 0.6).play();
            audioPlayer.playMobSound();
            audioPlayer.playDeathSound();
            rightPanel.changeHeartCounter(String.valueOf(--heartCrystals));
            if (0 == heartCrystals) {
                gameOver();
            }
            startButtonPressed = false;
            createFadeTransition(view, 1.5, 0.6, 10).play();
        }
    }

    /**
     * Avslutar spelrundan och kör metoden gameOver i mainProgram.
     */
    private void gameOver() {
        audioPlayer.playGameOverSound();
        audioPlayer.stopMusic();
        mainProgram.gameOver();
        rightPanel.pauseClock();
        gameStarted = true;
        time.setGameOver(true);
        time = null;
        rightPanel.removePickaxe();

    }

    /**
     * Om spelrundan är aktiverad och spelaren har plockat upp alla collectibles startas nästa nivå.
     *
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    private void enteredGoal() throws FileNotFoundException, InterruptedException {
        if (startButtonPressed && allCollectiblesObtained) {
            audioPlayer.stopClockSound();
            audioPlayer.playGoalSound();
            nextLevel();
            rightPanel.pauseClock();
            rightPanel.setTheTime(seconds);
            gameStarted = true;
            time.setGameOver(true);
            time = null;
        }
    }

    /**
     * Baserad på den aktuella världen väljer programmmet vilken nivå som ska spelas.
     *
     * @throws FileNotFoundException
     * @throws InterruptedException
     */
    private void nextLevel() throws FileNotFoundException, InterruptedException {
        switch (world) {
            case FOREST -> mainProgram.nextWorld1Level(currentLevel, heartCrystals);
            case UNDERGROUND -> mainProgram.nextWorld2Level(currentLevel, heartCrystals);
            case LAVA -> mainProgram.nextWorld3Level(currentLevel, heartCrystals);
            case CLOUD -> mainProgram.nextWorld4Level(currentLevel, heartCrystals);
            case DESERT -> mainProgram.nextWorld5Level(currentLevel, heartCrystals);
            case SPACE -> mainProgram.nextWorld6Level(currentLevel, heartCrystals);
        }
    }

    /**
     * Startar spelrundan och timern.
     */
    private void startLevel() {
        if (totalTimeStarted) {
            rightPanel.startTotalTimer();
            rightPanel.setTimerIsStarted(true);
        }

        if (!gameStarted) {
            rightPanel.resumeClock();
            gameStarted = true;
            time = new TimeThread(seconds, rightPanel);
            time.setGameOver(false);
            time.start();

        } else if (startNotClickedOnce) {
            rightPanel.runClock();
            time = new TimeThread(seconds, rightPanel);
            time.setGameOver(false);
            time.start();

        }
        totalTimeStarted = false;
        startNotClickedOnce = false;
        audioPlayer.playStartSound();
        startButtonPressed = true;
    }

    /**
     * När muspekaren lämnar en label slutar den att highlightas.
     *
     * @param e Används för att hitta rätt label.
     */
    private void exitedLabel(MouseEvent e) {
        Label label = (Label) e.getSource();
        createFadeTransition(label, 0.3, 0.6, 10).play();
    }

    private FadeTransition createFadeTransition(Node node, double duration, double from, double to) {
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
    private void enteredBreakableWall(MouseEvent e) {

        Label label = (Label) e.getSource();
        ImageView pathView = new ImageView(path);

        if (startButtonPressed) {
            if (pickaxeObtained) {
                label.setGraphic(pathView);
                pickaxeObtained = false;
                rightPanel.removePickaxe();
                wallDestroyed = true;
                audioPlayer.playBreakableWallSound();
            } else if (!wallDestroyed) {
                enteredWall(e);
            }
        }
    }
}

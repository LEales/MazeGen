package view.sandbox;

import control.MainProgram;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import model.enums.Sprite;
import model.enums.World;
import model.maps.Maps;
import model.maps.RandomizeMap;

import java.util.ArrayList;

public class SandboxScreen extends BorderPane {

    private final GridPane sandBoxMap;
    private Label path, wall, heart, breakableWall, axe, collectible, delete;
    private ComboBox<World> worldComboBox = new ComboBox<>();


    private final ArrayList<Label> labels;

    private final int squareSize, dimension;
    private Image redHeart = new Image("file:files/items/heart.png", 20, 20, false, false);
    private Image greyHeart = new Image("file:files/hearts/greyheart.png", 20, 20, false, false);
    private ImageView firstHeart = new ImageView(redHeart), secondHeart = new ImageView(redHeart), thirdHeart = new ImageView(redHeart);
    private Spinner<Integer> spinner = new Spinner<>();
    private World world;
    private int hearts;

    public SandboxScreen(int dimension) {
        this.dimension = dimension;
        this.squareSize = (int) MainProgram.HEIGHT / dimension;
        labels = new ArrayList<>();
        sandBoxMap = new GridPane();
        setUpSandboxMap();
        setUpPanel();
        setCenter(sandBoxMap);
    }

    private void setUpPanel() {
        Label world = new Label("World");
        world.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        world.setTextFill(javafx.scene.paint.Color.WHITE);

        worldComboBox.getItems().addAll(World.values());
        worldComboBox.setValue(World.FOREST);
        worldComboBox.valueProperty().addListener((observableValue, world1, newValue) -> changeImages(newValue));

        path = new Label();
        wall = new Label();
        heart = new Label();
        breakableWall = new Label();
        axe = new Label();
        collectible = new Label();
        delete = new Label();

        path.setId("path");
        wall.setId("wall");
        heart.setId("heart");
        breakableWall.setId("breakableWall");
        axe.setId("axe");
        collectible.setId("collectible");
        delete.setId("delete");

        addListenerToLabel(path);
        addListenerToLabel(wall);
        addListenerToLabel(heart);
        addListenerToLabel(breakableWall);
        addListenerToLabel(axe);
        addListenerToLabel(collectible);
        labels.add(delete);
        delete.setOnDragDetected(e -> {
            Dragboard db = delete.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(new Image("file:files/emptySprite.png"));
            content.putString(delete.getId());
            db.setContent(content);
        });


        Image pathImage = new Image("file:files/forest/path.png", squareSize, squareSize, false, false);
        Image wallImage = new Image("file:files/forest/wall.png", squareSize, squareSize, false, false);
        Image heartImage = new Image("file:files/items/heart.png", squareSize, squareSize, false, false);
        Image breakableWallImage = new Image("file:files/breakablewall.png", squareSize, squareSize, false, false);
        Image axeImage = new Image("file:files/items/pickaxe.png", squareSize, squareSize, false, false);
        Image collectibleImage = new Image("file:files/forest/collectible.png", squareSize, squareSize, false, false);
        Image deleteImage = new Image("file:files/garbage.png", squareSize, squareSize, false, false);

        ImageView pathImageView = new ImageView(pathImage);
        ImageView wallImageView = new ImageView(wallImage);
        ImageView heartImageView = new ImageView(heartImage);
        ImageView breakableWallImageView = new ImageView(breakableWallImage);
        ImageView axeImageView = new ImageView(axeImage);
        ImageView collectibleImageView = new ImageView(collectibleImage);
        ImageView deleteImageView = new ImageView(deleteImage);

        pathImageView.setFitWidth(squareSize);
        pathImageView.setFitHeight(squareSize);
        wallImageView.setFitWidth(squareSize);
        wallImageView.setFitHeight(squareSize);
        heartImageView.setFitWidth(squareSize);
        heartImageView.setFitHeight(squareSize);
        breakableWallImageView.setFitWidth(squareSize);
        breakableWallImageView.setFitHeight(squareSize);
        axeImageView.setFitWidth(squareSize);
        axeImageView.setFitHeight(squareSize);
        collectibleImageView.setFitWidth(squareSize);
        collectibleImageView.setFitHeight(squareSize);
        deleteImageView.setFitWidth(squareSize);
        deleteImageView.setFitHeight(squareSize);


        path.setGraphic(pathImageView);
        wall.setGraphic(wallImageView);
        heart.setGraphic(heartImageView);
        breakableWall.setGraphic(breakableWallImageView);
        axe.setGraphic(axeImageView);
        collectible.setGraphic(collectibleImageView);
        delete.setGraphic(deleteImageView);

        HBox firstBox = new HBox();
        firstBox.getChildren().addAll(path, wall);
        firstBox.setPadding(new Insets(5, 5, 5, 5));
        firstBox.setSpacing(5);
        HBox secondBox = new HBox();
        secondBox.getChildren().addAll(breakableWall, axe);
        secondBox.setPadding(new Insets(5, 5, 5, 5));
        secondBox.setSpacing(5);
        HBox thirdBox = new HBox();
        thirdBox.getChildren().addAll(collectible, heart);
        thirdBox.setPadding(new Insets(5, 5, 5, 5));
        thirdBox.setSpacing(5);
        HBox fourthBox = new HBox();
        fourthBox.getChildren().addAll(delete);
        fourthBox.setPadding(new Insets(5, 5, 5, 5));
        fourthBox.setSpacing(5);

        Label seconds = new Label("SECONDS");
        seconds.setPadding(new Insets(5, 5, 5, 5));
        seconds.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        seconds.setTextFill(javafx.scene.paint.Color.WHITE);

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(15, 1000, 1);
        spinner.setValueFactory(valueFactory);
        spinner.setEditable(true);
        spinner.setPadding(new Insets(5, 5, 5, 5));
        spinner.getEditor().setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 10));
        spinner.getStyleClass().add("pixel-art-spinner");

        Label hearts = new Label("HEARTS");
        hearts.setPadding(new Insets(5, 5, 5, 5));
        hearts.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        hearts.setTextFill(javafx.scene.paint.Color.WHITE);

        firstHeart.setOnMouseClicked(event -> firstHeartClicked());
        secondHeart.setOnMouseClicked(event -> secondHeartClicked());
        thirdHeart.setOnMouseClicked(event -> thirdHeartClicked());

        HBox heartsBox = new HBox(firstHeart, secondHeart, thirdHeart);
        heartsBox.setAlignment(Pos.TOP_LEFT);
        heartsBox.setPadding(new Insets(5));

        Button save = new Button("SAVE");
        save.setPadding(new Insets(5, 5, 5, 5));
        save.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        save.setOnMouseClicked(e -> MainProgram.getMainProgram().saveMap(getMap()));

        Button back = new Button("RETURN");
        back.setPadding(new Insets(5, 5, 5, 5));
        back.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        back.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to return to the menu? All unsaved changes will be lost.", ButtonType.YES, ButtonType.NO);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    MainProgram.getMainProgram().changeToMenu();
                }
            });
        });

        VBox panel = new VBox();
        panel.getChildren().addAll(world, worldComboBox, firstBox, secondBox, thirdBox, fourthBox, seconds, spinner, hearts, heartsBox, save, back);
        setRight(panel);


    }

    //byter ut images när världen byts i comboboxen
    private void changeImages(World newValue) {
        world = newValue;
        path.setGraphic(new ImageView(new Image("file:files/" + newValue.toString().toLowerCase() + "/path.png", squareSize, squareSize, false, false)));
        if (newValue != World.SPACE) {
            wall.setGraphic(new ImageView(new Image("file:files/" + newValue.toString().toLowerCase() + "/wall.png", squareSize, squareSize, false, false)));
        }
        collectible.setGraphic(new ImageView(new Image("file:files/" + newValue.toString().toLowerCase() + "/collectible.png", squareSize, squareSize, false, false)));
        for (Label label : labels) {
            String image = ((ImageView) label.getGraphic()).getImage().getUrl();
            if (image == null) continue;
            if (image.endsWith("start.png")) {
                label.setGraphic(new ImageView(new Image("file:files/" + newValue.toString().toLowerCase() + "/start.png", squareSize, squareSize, false, false)));
            } else if (image.endsWith("goal.png")) {
                label.setGraphic(new ImageView(new Image("file:files/" + newValue.toString().toLowerCase() + "/goal.png", squareSize, squareSize, false, false)));
            }
        }
    }

    private Maps getMap() {
        RandomizeMap map = new RandomizeMap(hearts, spinner.getValue(), dimension);
        for (int i = 0; i < dimension * dimension; i++) {
            Sprite sprite;
            String image = ((ImageView) labels.get(i).getGraphic()).getImage().getUrl();
            if (image.endsWith("path.png")) {
                sprite = Sprite.PATH;
            } else if (image.endsWith("wall.png")) {
                sprite = Sprite.WALL;
            } else if (image.endsWith("breakablewall.png")) {
                sprite = Sprite.BREAKABLE_WALL;
            } else if (image.endsWith("axe.png")) {
                sprite = Sprite.AXE;
            } else if (image.endsWith("collectible.png")) {
                sprite = Sprite.COLLECTIBLE;
            } else if (image.endsWith("start.png")) {
                sprite = Sprite.START;
            } else if (image.endsWith("goal.png")) {
                sprite = Sprite.GOAL;
            } else if (image.endsWith("heart.png")) {
                sprite = Sprite.HEART;
            } else {
                sprite = Sprite.WALL;
            }
            map.setSprite(i % dimension, i / dimension, sprite);
        }
        return map;
    }

    public void loadMap(Maps map) {
        world = map.getWorld();
        worldComboBox.setValue(world);
        Sprite[][] mapArray = map.getMap();
        for (int i = 0; i < dimension*dimension; i++) {
            labels.get(i).setGraphic(new ImageView(new Image("file:files/" + world.toString().toLowerCase() + "/" + mapArray[i % dimension][i / dimension].toString().toLowerCase() + ".png", squareSize, squareSize, false, false)));
        }
    }

    //uppdaterar antalet hjärtan som banan ska ha, och tillhörande grafiska element
    private void firstHeartClicked() {
        hearts = 1;
        firstHeart.setImage(redHeart);
        secondHeart.setImage(greyHeart);
        thirdHeart.setImage(greyHeart);
    }

    //uppdaterar antalet hjärtan som banan ska ha, och tillhörande grafiska element
    private void secondHeartClicked() {
        hearts = 2;
        firstHeart.setImage(redHeart);
        secondHeart.setImage(redHeart);
        thirdHeart.setImage(greyHeart);
    }

    //uppdaterar antalet hjärtan som banan ska ha, och tillhörande grafiska element
    private void thirdHeartClicked() {
        hearts = 3;
        firstHeart.setImage(redHeart);
        secondHeart.setImage(redHeart);
        thirdHeart.setImage(redHeart);
    }

    //Lägger till listners för labels i högra menyn
    private void addListenerToLabel(Label label) {
        labels.add(label);
        label.setOnDragDetected(e -> {
            Dragboard db = label.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(((ImageView) label.getGraphic()).getImage());
            content.putString(label.getId());
            db.setContent(content);
        });
    }

    //Metoder som kallas på för att sätta upp själva kartan
    private void setUpSandboxMap() {
        setBackground();
        sandBoxMap.setGridLinesVisible(true);
        setStyle("-fx-grid-lines-color: white;");
        setupLabels();
        setupListeners();
    }

    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new javafx.scene.image.Image("file:files/MenuBackground.jpg",
                MainProgram.WIDTH, MainProgram.HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(menuBackground));
    }

    //initierar kartan med två stegar som start och mål
    private void setupLabels() {
        int id = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (0 == i && j == dimension - 1) {
                    Label label = getStart();
                    label.setId(String.valueOf(id++));
                    sandBoxMap.add(label, i, j);
                    labels.add(label);
                } else if (i == dimension - 1 && 0 == j) {
                    Label label = getGoal();
                    label.setId(String.valueOf(id++));
                    sandBoxMap.add(label, i, j);
                    labels.add(label);
                } else {
                    Label label = getEmpty();
                    label.setId(String.valueOf(id++));
                    sandBoxMap.add(label, i, j);
                    labels.add(label);
                }
            }
        }
    }

    //listeners för att hantera drag and drop funktionalitet
    private void setupListeners() {
        for (Label label : labels) {
            label.setOnDragDetected(e -> {
                Dragboard db = label.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(((ImageView) label.getGraphic()).getImage()); //lägger bilden i minnet
                content.putString(label.getId()); //lägger id i minnet
                db.setContent(content); //lägger innehållet i dragboard
            });

            label.setOnDragDropped(e -> {
                Dragboard db = e.getDragboard();
                if (db.hasImage() && db.hasString()) {
                    Node target = e.getPickResult().getIntersectedNode(); //hämtar noden som vi drar labeln till
                    if (target != null && target instanceof Label) {
                        String sourceId = db.getString(); //hämtar id från dragboard
                        if (isNumeric(sourceId)) {
                            ImageView sourceImage = (ImageView) findLabelById(sourceId).getGraphic(); //hämtar bilden från labeln som vi drar
                            ImageView targetImage = (ImageView) ((Label) target).getGraphic(); //hämtar bilden från labeln som vi droppar på
                            Image temp = sourceImage.getImage(); //byter plats på bilderna
                            sourceImage.setImage(targetImage.getImage());
                            targetImage.setImage(temp);
                        } else {
                            ImageView targetImage = new ImageView(db.getImage());
                            ((Label) target).setGraphic(targetImage);
                        }
                    }
                }
            });

            label.setOnDragOver(e -> {
                if (e.getGestureSource() != label && e.getDragboard().hasImage() && e.getDragboard().hasString()) {
                    String image = ((ImageView) label.getGraphic()).getImage().getUrl();
                    if (image == null) {
                        e.acceptTransferModes(TransferMode.MOVE);
                    } else if (image.endsWith("start.png") || image.endsWith("goal.png") && !isNumeric(e.getDragboard().getString())) {
                        e.consume();
                    } else {
                        e.acceptTransferModes(TransferMode.MOVE);
                    }
                }
            });
        }
    }

    private boolean isNumeric(String sourceId) {
        try {
            Integer.parseInt(sourceId);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Label findLabelById(String id) {
        for (Label label : labels) {
            if (label.getId().equals(id)) {
                return label;
            }
        }
        return null;
    }

    private Label getGoal() {
        Label label = new Label();
        ImageView goalView = new ImageView(new javafx.scene.image.Image("file:files/forest/goal.png"));
        goalView.setFitHeight(squareSize);
        goalView.setFitWidth(squareSize);
        label.setGraphic(goalView);
        return label;
    }

    private Label getStart() {
        Label label = new Label();
        ImageView startView = new ImageView(new javafx.scene.image.Image("file:files/forest/start.png"));
        startView.setFitHeight(squareSize);
        startView.setFitWidth(squareSize);
        label.setGraphic(startView);
        return label;
    }

    private Label getEmpty() {
        Label label = new Label();
        ImageView emptyView = new ImageView(new Image("file:files/emptySprite.png"));
        emptyView.setFitHeight(squareSize);
        emptyView.setFitWidth(squareSize);
        label.setGraphic(emptyView);
        return label;
    }
}


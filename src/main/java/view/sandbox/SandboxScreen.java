package view.sandbox;

import control.MainProgram;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import model.enums.Sprite;
import model.enums.World;
import model.maps.CreatedMap;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;


public class SandboxScreen extends BorderPane {

    private final GridPane sandBoxMap;
    private Label path, wall, heart, breakableWall, axe, collectible;
    private ComboBox<World> worldComboBox = new ComboBox<>();

    private final MainProgram mainProgram = MainProgram.getMainProgram();


    private final ArrayList<Label> labels;

    private final int squareSizeMap, squareSizeMenu, dimension;
    private Image redHeart = new Image("file:files/items/heart.png", 20, 20, false, false);
    private Image greyHeart = new Image("file:files/hearts/greyheart.png", 20, 20, false, false);
    private ImageView firstHeart = new ImageView(redHeart), secondHeart = new ImageView(redHeart), thirdHeart = new ImageView(redHeart);
    private Spinner<Integer> spinner = new Spinner<>();
    private World world;
    private int hearts = 3;
    private Image pathImage, wallImage, heartImage, breakableWallImage, axeImage, collectibleImage, deleteImage, startImage, goalImage;
    private Image pathImageMenu, wallImageMenu, heartImageMenu, breakableWallImageMenu, axeImageMenu, collectibleImageMenu;
    private Button save;
    private String name;
    private Button fillWithWalls;

    public SandboxScreen(int dimension) {
        if (5 > dimension) {
            throw new IllegalArgumentException("Invalid dimension");
        }
        this.squareSizeMenu = 60;
        this.dimension = dimension;
        this.squareSizeMap = (int) MainProgram.HEIGHT / dimension;
        labels = new ArrayList<>();
        sandBoxMap = new GridPane();
        pathImage = new Image("file:files/forest/path.png", squareSizeMap, squareSizeMap, false, false);
        wallImage = new Image("file:files/forest/wall.png", squareSizeMap, squareSizeMap, false, false);
        heartImage = new Image("file:files/sandboxCollectibles/forestheart.png", squareSizeMap, squareSizeMap, false, false);
        breakableWallImage = new Image("file:files/breakablewall.png", squareSizeMap, squareSizeMap, false, false);
        axeImage = new Image("file:files/sandboxCollectibles/forestpickaxe.png", squareSizeMap, squareSizeMap, false, false);
        collectibleImage = new Image("file:files/sandboxCollectibles/forestcollectible.png", squareSizeMap, squareSizeMap, false, false);
        deleteImage = new Image("file:files/emptySprite.png", squareSizeMap, squareSizeMap, false, false);
        startImage = new Image("file:files/forest/start.png", squareSizeMap, squareSizeMap, false, false);
        goalImage = new Image("file:files/forest/goal.png", squareSizeMap, squareSizeMap, false, false);
        pathImageMenu = new Image("file:files/forest/path.png", squareSizeMenu, squareSizeMenu, false, false);
        wallImageMenu = new Image("file:files/forest/wall.png", squareSizeMenu, squareSizeMenu, false, false);
        heartImageMenu = new Image("file:files/items/heart.png", squareSizeMenu, squareSizeMenu, false, false);
        breakableWallImageMenu = new Image("file:files/breakablewall.png", squareSizeMenu, squareSizeMenu, false, false);
        axeImageMenu = new Image("file:files/items/pickaxe.png", squareSizeMenu, squareSizeMenu, false, false);
        collectibleImageMenu = new Image("file:files/forest/collectible.png", squareSizeMenu, squareSizeMenu, false, false);
        setUpSandboxMap();
        setUpPanel();
        setCenter(sandBoxMap);
    }

    //alldeles f??r l??ng setup metod som borde brytas upp i mindre metoder. S??tter upp alla grafiska element
    private void setUpPanel() {
        Label world = new Label("World");
        world.setTranslateX(5);
        world.setTranslateY(10);

        world.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 38));
        world.setTextFill(javafx.scene.paint.Color.WHITE);

        worldComboBox.getItems().addAll(World.values());
        worldComboBox.setValue(World.FOREST);
        worldComboBox.valueProperty().addListener((observableValue, world1, newValue) -> changeImages(newValue));
        worldComboBox.setStyle("-fx-font-family: 'Press Start 2P';");
        worldComboBox.setTranslateY(10);


        path = new Label();
        wall = new Label();
        heart = new Label();
        breakableWall = new Label();
        axe = new Label();
        collectible = new Label();

        path.setId("path");
        wall.setId("wall");
        heart.setId("heart");
        breakableWall.setId("breakableWall");
        axe.setId("axe");
        collectible.setId("collectible");


        ImageView pathImageView = new ImageView(pathImageMenu);
        ImageView wallImageView = new ImageView(wallImageMenu);
        ImageView heartImageView = new ImageView(heartImageMenu);
        ImageView breakableWallImageView = new ImageView(breakableWallImageMenu);
        ImageView axeImageView = new ImageView(axeImageMenu);
        ImageView collectibleImageView = new ImageView(collectibleImageMenu);

        pathImageView.setFitWidth(squareSizeMenu);
        pathImageView.setFitHeight(squareSizeMenu);
        wallImageView.setFitWidth(squareSizeMenu);
        wallImageView.setFitHeight(squareSizeMenu);
        heartImageView.setFitWidth(squareSizeMenu);
        heartImageView.setFitHeight(squareSizeMenu);
        breakableWallImageView.setFitWidth(squareSizeMenu); //this block can be deleted i think?
        breakableWallImageView.setFitHeight(squareSizeMenu);
        axeImageView.setFitWidth(squareSizeMenu);
        axeImageView.setFitHeight(squareSizeMenu);
        collectibleImageView.setFitWidth(squareSizeMenu);
        collectibleImageView.setFitHeight(squareSizeMenu);


        path.setGraphic(pathImageView);
        wall.setGraphic(wallImageView);
        heart.setGraphic(heartImageView);
        breakableWall.setGraphic(breakableWallImageView);
        axe.setGraphic(axeImageView);
        collectible.setGraphic(collectibleImageView);

        addListenerToLabel(path);
        addListenerToLabel(wall);
        addListenerToLabel(heart);
        addListenerToLabel(breakableWall);
        addListenerToLabel(axe);
        addListenerToLabel(collectible);


        HBox firstBox = new HBox();
        firstBox.getChildren().addAll(path, wall);
        firstBox.setPadding(new Insets(5, 5, 5, 5));
        firstBox.setSpacing(50);
        firstBox.setTranslateY(30);
        HBox secondBox = new HBox();
        secondBox.getChildren().addAll(breakableWall, axe);
        secondBox.setPadding(new Insets(5, 5, 5, 5));
        secondBox.setSpacing(50);
        secondBox.setTranslateY(30);
        HBox thirdBox = new HBox();
        thirdBox.getChildren().addAll(collectible, heart);
        thirdBox.setPadding(new Insets(5, 5, 5, 5));
        thirdBox.setTranslateY(30);
        thirdBox.setSpacing(50);

        Label seconds = new Label("SECONDS");
        seconds.setPadding(new Insets(5, 5, 5, 5));
        seconds.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        seconds.setTranslateY(30);
        seconds.setTextFill(javafx.scene.paint.Color.WHITE);

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(15, 1000, 1);
        spinner.setValueFactory(valueFactory);
        spinner.setEditable(true);
        spinner.setPadding(new Insets(5, 5, 5, 5));
        spinner.setTranslateY(30);
        spinner.getEditor().setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 10));
        spinner.getStyleClass().add("pixel-art-spinner");

        Label hearts = new Label("HEARTS");
        hearts.setPadding(new Insets(5, 5, 5, 5));
        hearts.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        hearts.setTextFill(javafx.scene.paint.Color.WHITE);
        hearts.setTranslateY(60);
        firstHeart.setOnMouseClicked(event -> firstHeartClicked());
        secondHeart.setOnMouseClicked(event -> secondHeartClicked());
        thirdHeart.setOnMouseClicked(event -> thirdHeartClicked());

        HBox heartsBox = new HBox(firstHeart, secondHeart, thirdHeart);
        heartsBox.setTranslateY(60);
        heartsBox.setAlignment(Pos.TOP_LEFT);
        heartsBox.setPadding(new Insets(5));

        save = new Button("SAVE");
        save.setPadding(new Insets(5, 5, 5, 5));
        save.setTranslateY(80);
        save.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        save.setOnMouseClicked(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Name");
            dialog.setHeaderText("Enter the name of your world:");
            dialog.setContentText("Name:");
            if (this.name != null) {
                dialog.getEditor().setText(this.name);
            }
            Optional<String> result = dialog.showAndWait();
            String name;
            if (result.isPresent()) {
                name = result.get();
            } else {
                return;
            }
            AtomicBoolean toMenu = new AtomicBoolean(true);
            if (mainProgram.checkMap(name)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "A world with this name already exists. Do you want to overwrite it?", ButtonType.YES, ButtonType.NO);
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.YES) {
                        mainProgram.saveMap(getMap(name), true);
                    } else {
                        toMenu.set(false);
                    }
                });
            } else {
                mainProgram.saveMap(getMap(name), false);
            }
            if (toMenu.get()) {
                mainProgram.changeToMenu();
            }

        });

        Button back = new Button("RETURN");
        back.setPadding(new Insets(5, 5, 5, 5));
        back.setTranslateY(80);
        back.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        back.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to return to the menu? All unsaved changes will be lost.", ButtonType.YES, ButtonType.NO);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    mainProgram.changeToSandBoxLoader();
                }
            });
        });

        fillWithWalls = new Button("FILL WALLS");
        fillWithWalls.setPadding(new Insets(5, 5, 5, 5));
        fillWithWalls.setTranslateY(80);
        fillWithWalls.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        fillWithWalls.setOnMouseClicked(e -> {
                    fillWithWalls();
                }
        );


        VBox panel = new VBox();
        panel.getChildren().addAll(world, worldComboBox, firstBox, secondBox, thirdBox, seconds, spinner, hearts, heartsBox, fillWithWalls, save, back);
        setRight(panel);


    }

    //byter ut images n??r v??rlden byts i comboboxen
    private void changeImages(World newValue) {
        if (null == newValue) return;
        world = newValue;
        pathImageMenu = new Image("file:files/" + newValue.toString().toLowerCase() + "/path.png", squareSizeMenu, squareSizeMenu, false, false);
        wallImageMenu = new Image("file:files/" + newValue.toString().toLowerCase() + "/wall.png", squareSizeMenu, squareSizeMenu, false, false);
        collectibleImageMenu = new Image("file:files/" + newValue.toString().toLowerCase() + "/collectible.png", squareSizeMenu, squareSizeMenu, false, false);
        path.setGraphic(new ImageView(pathImageMenu));
        wall.setGraphic(new ImageView(wallImageMenu));
        collectible.setGraphic(new ImageView(collectibleImageMenu));

        Image tempPath = pathImage;
        Image tempWall = wallImage;
        Image tempCollectible = collectibleImage;
        Image tempHeart = heartImage;
        Image tempAxe = axeImage;
        pathImage = new Image("file:files/" + newValue.toString().toLowerCase() + "/path.png", squareSizeMap, squareSizeMap, false, false);
        wallImage = new Image("file:files/" + newValue.toString().toLowerCase() + "/wall.png", squareSizeMap, squareSizeMap, false, false);
        collectibleImage = new Image("file:files/sandboxCollectibles/" + newValue.toString().toLowerCase() + "collectible.png", squareSizeMap, squareSizeMap, false, false);
        heartImage = new Image("file:files/sandboxCollectibles/" + newValue.toString().toLowerCase() + "heart.png", squareSizeMap, squareSizeMap, false, false);
        axeImage = new Image("file:files/sandboxCollectibles/" + newValue.toString().toLowerCase() + "pickaxe.png", squareSizeMap, squareSizeMap, false, false);
        for (Label label : labels) {
            Image image = ((ImageView) label.getGraphic()).getImage();
            if (compareImages(image, tempPath)) {
                label.setGraphic(new ImageView(pathImage));
            } else if (compareImages(image, tempWall)) {
                label.setGraphic(new ImageView(wallImage));
            } else if (compareImages(image, tempCollectible)) {
                label.setGraphic(new ImageView(collectibleImage));
            } else if (compareImages(image, tempAxe)) {
                label.setGraphic(new ImageView(axeImage));
            } else if (compareImages(image, tempHeart)) {
                label.setGraphic(new ImageView(heartImage));
            } else if (compareImages(image, startImage)) {
                startImage = new Image("file:files/" + newValue.toString().toLowerCase() + "/start.png", squareSizeMap, squareSizeMap, false, false);
                label.setGraphic(new ImageView(startImage));
            } else if (compareImages(image, goalImage)) {
                goalImage = new Image("file:files/" + newValue.toString().toLowerCase() + "/goal.png", squareSizeMap, squareSizeMap, false, false);
                label.setGraphic(new ImageView(goalImage));
            }
        }
    }

    //kallas p?? n??r en karta ska sparas ner
    private CreatedMap getMap(String name) {
        CreatedMap map = new CreatedMap(hearts, spinner.getValue(), dimension, name, worldComboBox.getValue());
        for (int i = 0; i < dimension * dimension; i++) {
            Sprite sprite;
            Image image = ((ImageView) labels.get(i).getGraphic()).getImage();
            if (compareImages(image, pathImage)) {
                sprite = Sprite.PATH;
            } else if (compareImages(image, wallImage)) {
                sprite = Sprite.WALL;
            } else if (compareImages(image, breakableWallImage)) {
                sprite = Sprite.BREAKABLE_WALL;
            } else if (compareImages(image, axeImage)) {
                sprite = Sprite.AXE;
            } else if (compareImages(image, collectibleImage)) {
                sprite = Sprite.COLLECTIBLE;
            } else if (compareImages(image, startImage)) {
                sprite = Sprite.START;
            } else if (compareImages(image, goalImage)) {
                sprite = Sprite.GOAL;
            } else if (compareImages(image, heartImage)) {
                sprite = Sprite.HEART;
            } else {
                sprite = Sprite.WALL;
            }
            map.setSprite(i % dimension, i / dimension, sprite);
        }
        return map;
    }

    //laddar in en karta fr??n en CreatedMap
    public void loadMap(CreatedMap map) {
        if (null == map || null == map.getMap()) {
            throw new IllegalArgumentException("Invalid map");
        }
        world = map.getWorld();
        worldComboBox.setValue(world);
        spinner.getValueFactory().setValue(map.getSeconds());
        name = map.getName();
        switch (map.getHeartCrystals()) {
            case 1 -> firstHeartClicked();
            case 2 -> secondHeartClicked();
            case 3 -> thirdHeartClicked();
        }
        Sprite[][] mapArray = map.getMap();
        for (int i = 0; i < dimension * dimension; i++) {
            switch (mapArray[i % dimension][i / dimension]) {
                case PATH -> labels.get(i).setGraphic(new ImageView(pathImage));
                case WALL -> labels.get(i).setGraphic(new ImageView(wallImage));
                case BREAKABLE_WALL -> labels.get(i).setGraphic(new ImageView(breakableWallImage));
                case AXE -> labels.get(i).setGraphic(new ImageView(axeImage));
                case COLLECTIBLE -> labels.get(i).setGraphic(new ImageView(collectibleImage));
                case START -> labels.get(i).setGraphic(new ImageView(startImage));
                case GOAL -> labels.get(i).setGraphic(new ImageView(goalImage));
                case HEART -> labels.get(i).setGraphic(new ImageView(heartImage));
            }
        }
    }

    //uppdaterar antalet hj??rtan som banan ska ha, och tillh??rande grafiska element
    private void firstHeartClicked() {
        hearts = 1;
        firstHeart.setImage(redHeart);
        secondHeart.setImage(greyHeart);
        thirdHeart.setImage(greyHeart);
    }

    //uppdaterar antalet hj??rtan som banan ska ha, och tillh??rande grafiska element
    private void secondHeartClicked() {
        hearts = 2;
        firstHeart.setImage(redHeart);
        secondHeart.setImage(redHeart);
        thirdHeart.setImage(greyHeart);
    }

    //uppdaterar antalet hj??rtan som banan ska ha, och tillh??rande grafiska element
    private void thirdHeartClicked() {
        hearts = 3;
        firstHeart.setImage(redHeart);
        secondHeart.setImage(redHeart);
        thirdHeart.setImage(redHeart);
    }

    //L??gger till listners f??r labels i h??gra menyn
    private void addListenerToLabel(Label label) {
        labels.add(label);

        label.setOnDragDetected(e -> {
            Image image;
            if (label.getId().equals("path")) {
                image = pathImage;
            } else if (label.getId().equals("wall")) {
                image = wallImage;
            } else if (label.getId().equals("breakableWall")) {
                image = breakableWallImage;
            } else if (label.getId().equals("axe")) {
                image = axeImage;
            } else if (label.getId().equals("collectible")) {
                image = collectibleImage;
            } else if (label.getId().equals("heart")) {
                image = heartImage;
            } else {
                image = pathImage;
            }
            Dragboard db = label.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(image);
            content.putString(label.getId());
            db.setContent(content);
        });
    }

    //Metoder som kallas p?? f??r att s??tta upp sj??lva kartan
    private void setUpSandboxMap() {
        setBackground();
        sandBoxMap.setGridLinesVisible(true);
        setStyle("-fx-grid-lines-color: white;");
        setupLabels();
        setupListeners();
    }

    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg",
                MainProgram.WIDTH, MainProgram.HEIGHT, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(menuBackground));
    }

    //initierar kartan med tv?? stegar som start och m??l
    private void setupLabels() {
        int id = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == dimension - 1 && 0 == j) {
                    Label label = getStart();
                    label.setId(String.valueOf(id++));
                    sandBoxMap.add(label, i, j);
                    labels.add(label);
                } else if (0 == i && j == dimension - 1) {
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

    //listeners f??r att hantera drag and drop funktionalitet
    private void setupListeners() {
        for (Label label : labels) {
            label.setOnDragDetected(e -> {
                Dragboard db = label.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putImage(((ImageView) label.getGraphic()).getImage()); //l??gger bilden i minnet
                content.putString(label.getId()); //l??gger id i minnet
                db.setContent(content); //l??gger inneh??llet i dragboard

            });


            label.setOnDragDropped(e -> {
                Dragboard db = e.getDragboard();
                if (db.hasImage() && db.hasString()) {
                    Node target = e.getPickResult().getIntersectedNode(); //h??mtar noden som vi drar labeln till
                    if (target != null && target instanceof Label) {
                        String sourceId = db.getString(); //h??mtar id fr??n dragboard
                        if (isNumeric(sourceId)) {
                            ImageView sourceImage = (ImageView) findLabelById(sourceId).getGraphic(); //h??mtar bilden fr??n labeln som vi drar
                            ImageView targetImage = (ImageView) ((Label) target).getGraphic(); //h??mtar bilden fr??n labeln som vi droppar p??
                            Image temp = sourceImage.getImage(); //byter plats p?? bilderna
                            sourceImage.setImage(targetImage.getImage());
                            targetImage.setImage(temp);
                        } else {

                            ImageView targetImage = (ImageView) ((Label) target).getGraphic();
                            targetImage.setImage(db.getImage());
                        }
                    }
                }
            });

            label.setOnDragOver(e -> {
                ;
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

    private void printLabels() {
        for (Node node : sandBoxMap.getChildren()) {
            if (node instanceof Label) {
                Label label = (Label) node;
                System.out.println("Label ID: " + label.getId());
                if (label.getGraphic() != null) {
                    System.out.println("Image: " + ((ImageView) label.getGraphic()).getImage().getUrl());
                } else {

                }
            }
        }
    }

    //Byter ut emptySprite.png bilder mot wall.png. Anv??nds n??r man trycker p?? "fill walls"
    private void fillWithWalls() {
        for (Node node : sandBoxMap.getChildren()) {
            if (node instanceof Label) {
                Label label = (Label) node;
                ImageView imageView = (ImageView) label.getGraphic();

                if (imageView != null && imageView.getImage().getUrl() != null) {
                    if (Objects.equals(imageView.getImage().getUrl(), "file:files/emptySprite.png")) {
                        imageView.setImage(wallImage);
                        label.setGraphic(imageView);
                    }
                }
            }
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
        ImageView goalView = new ImageView(goalImage);
        goalView.setFitHeight(squareSizeMap);
        goalView.setFitWidth(squareSizeMap);
        label.setGraphic(goalView);
        return label;
    }

    private Label getStart() {
        Label label = new Label();
        ImageView startView = new ImageView(startImage);
        startView.setFitHeight(squareSizeMap);
        startView.setFitWidth(squareSizeMap);
        label.setGraphic(startView);
        return label;
    }

    private Label getEmpty() {
        Label label = new Label();
        ImageView emptyView = new ImageView(deleteImage);
        emptyView.setFitHeight(squareSizeMap);
        emptyView.setFitWidth(squareSizeMap);
        label.setGraphic(emptyView);
        return label;
    }

    //j??mf??r ifall tv?? bilder ??r samma
    private boolean compareImages(Image image1, Image image2) {
        if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()) {
            return false;
        }
        PixelReader reader1 = image1.getPixelReader();
        PixelReader reader2 = image2.getPixelReader();
        for (int y = 0; y < image1.getHeight(); y++) {
            for (int x = 0; x < image1.getWidth(); x++) {
                if (reader1.getArgb(x, y) != reader2.getArgb(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

}


package view.sandbox;

import control.MainProgram;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import model.maps.CreatedMap;

import java.util.ArrayList;

public class SandboxLoader extends Pane {
    private final ScrollPane scrollPane;
    private int id = 0;
    private final VBox content;
    
    private final MainProgram mainProgram;

    public SandboxLoader() {
        this.mainProgram = MainProgram.getMainProgram();
        setBackground();
        content = new VBox();
        content.setPrefSize(600, 400);
        content.setTranslateX(0);
        content.setTranslateY(0);
        content.setBackground(Background.EMPTY);
        content.setSpacing(20.0);
        content.setStyle("-fx-background-color: transparent !important;");
        scrollPane = new ScrollPane(content);
        scrollPane.setPrefSize(600, 400);
        scrollPane.setTranslateX(100);
        scrollPane.setTranslateY(100);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-padding: 0; -fx-background-insets: 0;");
        scrollPane.setBackground(Background.EMPTY);



        getChildren().add(scrollPane);
    }
    public SandboxLoader(ArrayList<CreatedMap> maps) {
        this();
        for (CreatedMap map : maps) {
            content.getChildren().add(addMap(map));
        }

       // scrollPane.lookup(".viewport").setStyle("-fx-background-color: transparent;");
    }

    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
    }
    //lägger till funktioner för sparade kartor i en vbox.
    private VBox addMap(CreatedMap map) {
        CreatedMap finalMap = map;
        VBox template = new VBox();
        template.setSpacing(10);

        HBox buttons = new HBox();
        buttons.setSpacing(40);

        Label name = new Label("World: " + map.getName());
        name.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        Label load = new Label("Edit");
        load.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 14));
        load.setOnMouseEntered(e -> load.setTextFill(Color.ORANGERED));
        load.setOnMouseExited(e -> load.setTextFill(Color.web("#FFFFFF")));
        load.setOnMouseClicked(e -> {
            mainProgram.loadMap(finalMap);
        });
        Label play = new Label("Play");
        play.setOnMouseEntered(e -> play.setTextFill(Color.ORANGERED));
        play.setOnMouseExited(e -> play.setTextFill(Color.web("#FFFFFF")));
        play.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 14));
        play.setOnMouseClicked(e -> {
            mainProgram.playMap(finalMap);
        });

        Label delete = new Label("Delete");
        delete.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 14));
        delete.setOnMouseEntered(e -> delete.setTextFill(Color.ORANGERED));
        delete.setOnMouseExited(e -> delete.setTextFill(Color.web("#FFFFFF")));
        delete.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this map?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    mainProgram.deleteMap(finalMap);
                    content.getChildren().remove(template);
                }
            });
        });
        buttons.getChildren().addAll(load, play, delete);
        template.getChildren().addAll(name, buttons);
        return template;
    }
}

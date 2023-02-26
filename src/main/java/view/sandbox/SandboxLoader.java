package view.sandbox;

import control.MainProgram;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
        content.setTranslateX(100);
        content.setTranslateY(100);
        scrollPane = new ScrollPane(content);
        scrollPane.setPrefSize(600, 400);
        scrollPane.setTranslateX(100);
        scrollPane.setTranslateY(100);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        getChildren().add(scrollPane);

    }
    public SandboxLoader(ArrayList<CreatedMap> maps) {
        this();
        for (CreatedMap map : maps) {
            content.getChildren().add(addMap(map));
        }
    }

    private void setBackground() {
        BackgroundImage menuBackground = new BackgroundImage(new Image("file:files/MenuBackground.jpg", 800, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(menuBackground));
    }

    private VBox addMap(CreatedMap map) {
        CreatedMap finalMap = map;
        VBox template = new VBox();
        template.setSpacing(10);
        Label name = new Label("World: " + map.getName());
        name.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 18));
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        Button load = new Button("Load");
        load.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 14));
        load.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), null, null)));
        load.setOnMouseClicked(e -> {
            mainProgram.loadMap(finalMap);
        });
        Button play = new Button("Play");
        play.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 14));
        play.setOnMouseClicked(e -> {
            mainProgram.playMap(finalMap);
        });
        Button delete = new Button("Delete");
        delete.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 14));
        delete.setOnMouseClicked(e -> {
            mainProgram.deleteMap(finalMap);
            content.getChildren().remove(template);
        });
        buttons.getChildren().addAll(load, play, delete);
        template.getChildren().addAll(name, buttons);
        return template;
    }
}

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
        content.setTranslateX(100);
        content.setTranslateY(100);
        content.setBackground(Background.EMPTY);
        content.setStyle("-fx-background-color: transparent !important;");
        scrollPane = new ScrollPane(content);
        scrollPane.setPrefSize(600, 400);
        scrollPane.setTranslateX(100);
        scrollPane.setTranslateY(100);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-padding: 0; -fx-background-insets: 0;");
        scrollPane.setBackground(Background.EMPTY);
        getChildren().add(scrollPane);

        Label createdMazes = new Label("CREATED MAZES");
        createdMazes.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 27));
        createdMazes.setTextFill(Color.web("#0000D6"));
        createdMazes.setTranslateX(220);
        createdMazes.setTranslateY(50);
        getChildren().add(createdMazes);



        Label back = new Label("Return");
        back.setFont(Font.loadFont("file:files/fonts/PressStart2P.ttf", 27));
        back.setTextFill(Color.web("#0000D6"));
        back.setTranslateX(320);
        back.setTranslateY(530);

        getChildren().add(back);
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

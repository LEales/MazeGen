package view.Campaign;


import control.MainProgram;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import model.Maps.World2Maps;
import model.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class World2TemplateTest {
    World2Maps w1m;
    World2Template w2;

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void init() {
        w1m = new World2Maps(3, 25, 1, World.UNDERGROUND);
        try {
            w2 = new World2Template(w1m, new RightPanel("21"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void createImageViewPos() {
        Image image = new Image("file:files/items/heart.png");
        int i = 13;
        int i1 = 12;
        ImageView imageView = new ImageView(image);
        assertEquals(imageView.getImage(), w2.createImageView(image, i, i1).getImage());

    }

    @Test
    void createImageViewNeg() {
        Image image = new Image("file:files/items/heart.png");
        int i = 13;
        int i1 = 12;
        Image wrongImage = new Image("file:files/items/axe.png");
        ImageView imageView = new ImageView(image);
        assertNotEquals(imageView.getImage(), w2.createImageView(wrongImage, i, i1).getImage());
    }

    @Test
    void createImageViewNull() {
        Image image = new Image("file:files/items/heart.png");
        int i = 13;
        int i1 = 12;
        try {
            w2.createImageView(null, i, i1).getImage();
        } catch (IllegalArgumentException e) {
            assertEquals("Image invalid", e.getMessage());
        }
    }

    @Test
    void createImageViewIoverBorder() {
        Image image = new Image("file:files/items/heart.png");
        int i = 2;
        int i1 = 12;
        boolean ok = true;
        try {
            w2.createImageView(image, i, i1);
        } catch (IllegalArgumentException e) {
            ok = false;
        }
        assertTrue(ok);
    }

    @Test
    void createImageViewIonBorder() {
        Image image = new Image("file:files/items/heart.png");
        int i = 1;
        int i1 = 12;
        boolean ok = true;
        try {
            w2.createImageView(image, i, i1);
        } catch (IllegalArgumentException e) {
            ok = false;
        }
        assertTrue(ok);
    }

    @Test
    void createImageViewIunderBorder() {
        Image image = new Image("file:files/items/heart.png");
        int i = 0;
        int i1 = 12;
        try {
            w2.createImageView(image, i, i1);
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed", e.getMessage());
        }
    }

    @Test
    void createImageViewI1overBorder() {
        Image image = new Image("file:files/items/heart.png");
        int i = 13;
        int i1 = 2;
        boolean ok = true;
        try {
            w2.createImageView(image, i, i1);
        } catch (IllegalArgumentException e) {
            ok = false;
        }
        assertTrue(ok);
    }

    @Test
    void createImageViewI1onBorder() {
        Image image = new Image("file:files/items/heart.png");
        int i = 13;
        int i1 = 1;
        boolean ok = true;
        try {
            w2.createImageView(image, i, i1);
        } catch (IllegalArgumentException e) {
            ok = false;
        }
        assertTrue(ok);
    }

    @Test
    void createImageViewI1underBorder() {
        Image image = new Image("file:files/items/heart.png");
        int i = 1;
        int i1 = 12;
        try {
            w2.createImageView(image, i, i1);
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers not allowed", e.getMessage());
        }
    }

    @Test
    void createRectanglePos() {
        double v1 = 2.0;
        double v2 = 2.0;
        double y = 2.0;
        double x = 2.0;
        Rectangle actRec = w2.createRectangle(v1, v2, y, x);

        assertAll(
                () -> assertEquals(v1, actRec.getWidth()),
                () -> assertEquals(v2, actRec.getHeight()),
                () -> assertEquals(y, actRec.getY()),
                () -> assertEquals(x, actRec.getX())
        );
    }

    @Test
    void createRectangleNeg() {
        double v1 = 2.0;
        double v2 = 2.0;
        double y = 2.0;
        double x = 2.0;

        double v1false = 3.0;
        double v2false = 3.0;
        double yFalse = 3.0;
        double xFalse = 3.0;

        Rectangle actRec = w2.createRectangle(v1, v2, y, x);

        assertAll(
                () -> assertNotEquals(v1false, actRec.getWidth()),
                () -> assertNotEquals(v2false, actRec.getHeight()),
                () -> assertNotEquals(yFalse, actRec.getY()),
                () -> assertNotEquals(xFalse, actRec.getX())
        );
    }

    @Test
    void getWallPos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/forest/wall.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getWall");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);  //TODO här är du
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getWallNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/forest/goal.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getWall");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getImage(), actView.getImage()),
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getPathPos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/forest/path.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getPath");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getPathNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/forest/goal.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getPath");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getBordersPos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/forest/border.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getBorders");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getBordersNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/forest/path.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getBorders");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getBreakableWallPos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/breakablewall.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getBreakableWall");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getBreakableWallNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/forest/path.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getBreakableWall");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getGoalPos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/forest/goal.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getGoal");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getGoalNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/forest/path.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getGoal");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getStartPos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/forest/start.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getStart");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void getStartNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/forest/path.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("getStart");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void addCollectiblePos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/forest/collectible.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("addCollectible");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void addCollectibleNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/forest/path.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("addCollectible");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void addHeartCrystalPos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/items/heart.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("addHeartCrystal");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void addHeartCrystalNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/items/pickaxe.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("addHeartCrystal");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getImage(), actView.getImage()),
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void addPickAxePos() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2);
        Image image = new Image("file:files/items/pickaxe.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("addPickAxe");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }

    @Test
    void addPickaxeNeg() {
        int squaresize = (int) MainProgram.HEIGHT / (w1m.getMap().length + 2) - 1;
        Image image = new Image("file:files/items/heart.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(squaresize);
        imageView.setFitWidth(squaresize);

        Method metod;

        try {
            metod = World1Template.class.getDeclaredMethod("addPickAxe");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        metod.setAccessible(true);
        Label actLabel;
        try {
            actLabel = (Label) metod.invoke(w2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ImageView actView = (ImageView) actLabel.getGraphic();
        assertAll(
                () -> assertNotEquals(imageView.getFitHeight(), actView.getFitHeight()),
                () -> assertNotEquals(imageView.getFitWidth(), actView.getFitWidth())
        );
    }


}
package view.menu;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChooseDimensionTest {
    ChooseDimension chooseDimension = new ChooseDimension();

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void createImageViewEquals() {
        double X = 5.0;
        double Y = 4.0;
        Image image = new Image("file:/files/items/heart.png");
        ImageView imageView = getFreshImageView(image, X, Y);

        Method methodView;
        try {
            methodView = ChooseDimension.class.getDeclaredMethod("createImageView", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        methodView.setAccessible(true);

        ImageView actualView;
        try {
            actualView = (ImageView) methodView.invoke(chooseDimension, (Object) image, (Object) X, (Object) Y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        assertAll(
                () -> assertEquals(imageView.getImage(), actualView.getImage()),
                () -> assertEquals(imageView.getTranslateX(), actualView.getTranslateX(), 1e-8),
                () -> assertEquals(imageView.getTranslateY(), actualView.getTranslateY(), 1e-8),
                () -> assertEquals(imageView.getStyle(), actualView.getStyle())
        );
    }

    @Test
    void createImageViewNotEqual() {
        double x = 6.0;
        double y = 7.0;
        double z = 5.0;
        double r = 9.0;

        Image image = new Image("file:/files/items/heart.png");
        Image wrongImage = new Image("file:/files/items/pickaxe.png");
        ImageView imageView = getFreshImageView(image, x, y);
        imageView.setStyle("fx-background-color: #000000;");


        Method methodView;
        try {
            methodView = ChooseDimension.class.getDeclaredMethod("createImageView", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        methodView.setAccessible(true);
        ImageView actualView;
        try {
            actualView = (ImageView) methodView.invoke(chooseDimension, wrongImage, z, r);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertAll(
                () -> assertNotEquals(imageView.getImage(), actualView.getImage()),
                () -> assertNotEquals(imageView.getTranslateX(), actualView.getTranslateX(), 1e-8),
                () -> assertNotEquals(imageView.getTranslateY(), actualView.getTranslateY(), 1e-8),
                () -> assertNotEquals(imageView.getStyle(), actualView.getStyle())
        );
    }

    @Test
    void validateXunderUpperBorder() {
        double x = MainProgram.WIDTH - 0.1;
        double y = MainProgram.HEIGHT / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateXonUpperBorder() {
        double y = MainProgram.HEIGHT / 2;
        double x = MainProgram.WIDTH;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateXoverUpperBorder() {
        double y = MainProgram.HEIGHT / 2;
        double x = MainProgram.WIDTH + 0.1;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);

        try {
            validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException b) {
            assertEquals("Invalid translateX", b.getMessage());
        } catch (IllegalAccessException e) {

        }
    }

    @Test
    void validateXoverLowerBorder() {
        double x = 0.1;
        double y = MainProgram.HEIGHT / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateXonLowerBorder() {
        double x = 0.1;
        double y = MainProgram.HEIGHT / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateXunderLowerBorder() {
        double x = 0.0;
        double y = MainProgram.HEIGHT / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);

        try {
            validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException b) {
            assertEquals("Invalid translateX", b.getMessage());
        } catch (IllegalAccessException e) {

        }
    }

    @Test
    void validateYunderUpperBorder() {
        double y = MainProgram.HEIGHT - 0.1;
        double x = MainProgram.WIDTH / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateYonUpperBorder() {
        double y = MainProgram.HEIGHT;
        double x = MainProgram.WIDTH / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateYoverUpperBorder() {
        double y = MainProgram.HEIGHT + 0.1;
        double x = MainProgram.WIDTH / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);

        try {
            validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException b) {
            assertEquals("Invalid translateY", b.getMessage());
        } catch (IllegalAccessException e) {

        }
    }

    @Test
    void validateYoverLowerBorder() {
        double y = 0.2;
        double x = MainProgram.WIDTH / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateYonLowerBorder() {
        double y = 0.1;
        double x = MainProgram.WIDTH / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);
        boolean validated;
        try {
            validated = (boolean) validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(validated);
    }

    @Test
    void validateYunderLowerBorder() {
        double y = 0;
        double x = MainProgram.WIDTH / 2;
        Image image = new Image("file:/files/items/heart.png");

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);

        try {
            validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException b) {
            assertEquals("Invalid translateY", b.getMessage());
        } catch (IllegalAccessException e) {

        }
    }


    @Test
    void validateImageNull() {
        double y = MainProgram.HEIGHT;
        double x = MainProgram.WIDTH / 2;
        Image image = null;

        Method validate;

        try {
            validate = ChooseDimension.class.getDeclaredMethod("validate", Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        validate.setAccessible(true);

        try {
            validate.invoke(chooseDimension, (Image) image, (double) x,(double) y);
        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException b) {
            assertEquals("Invalid image", b.getMessage());
        } catch (IllegalAccessException e) {

        }
    }

    @Test
    void onEnterAndExitNullImage() {
        //skicka in null imageview
        Image image = new Image("file:/files/items/heart.png");
        double x = 7.0;
        double y = 8.0;
        ImageView imageView = null;

        Method onEnterAndExit;

        try {
            onEnterAndExit = ChooseDimension.class.getDeclaredMethod("onEnterAndExit", ImageView.class, Image.class, double.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        onEnterAndExit.setAccessible(true);

        try {
            onEnterAndExit.invoke(chooseDimension, imageView, image, x, y);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Imageview", e.getMessage());
        }
    }

    @Test
    void onClickNullView() {
        int dim = 3;

        Method onClick;
        try {
            onClick = ChooseDimension.class.getDeclaredMethod("onClick", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        onClick.setAccessible(true);

        try {
            onClick.invoke(chooseDimension, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Image", e.getMessage());
        }

    }

    @Test
    void onClickdimForbidden10() {
        int dim = 10;


        Method onClick;
        try {
            onClick = ChooseDimension.class.getDeclaredMethod("onClick", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        onClick.setAccessible(true);

        try {
            onClick.invoke(chooseDimension, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException e) {
            assertEquals("Invalid dimension", e.getMessage());
        }
    }

    @Test
    void onClickForbidden14() {
        int dim = 14;

        Method onClick;
        try {
            onClick = ChooseDimension.class.getDeclaredMethod("onClick", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        onClick.setAccessible(true);

        try {
            onClick.invoke(chooseDimension, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException e) {
            assertEquals("Invalid dimension", e.getMessage());
        }
    }

    @Test
    void onClickForbidden18() {
        int dim = 18;

        Method onClick;
        try {
            onClick = ChooseDimension.class.getDeclaredMethod("onClick", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        onClick.setAccessible(true);

        try {
            onClick.invoke(chooseDimension, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException e) {
            assertEquals("Invalid dimension", e.getMessage());
        }
    }

    @Test
    void onClickForbidden28() {
        int dim = 28;

        Method onClick;
        try {
            onClick = ChooseDimension.class.getDeclaredMethod("onClick", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        onClick.setAccessible(true);

        try {
            onClick.invoke(chooseDimension, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalArgumentException e) {
            assertEquals("Invalid dimension", e.getMessage());
        }
    }



    ImageView getFreshImageView(Image image, double x, double y) {
        ImageView imageView = new ImageView(image);
        imageView.setStyle("fx-background-color: transparent;");
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
        imageView.toFront();
        return imageView;
    }
}

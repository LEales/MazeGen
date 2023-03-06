package view.sandbox;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SandboxDimensionTest {
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
    void checkMaxDimension() throws NoSuchMethodException {
        SandboxDimension sandboxDimension = new SandboxDimension();
        int expectedMax = 25;

        Method methodGetSlider = SandboxDimension.class.getDeclaredMethod("getSlider");
        methodGetSlider.setAccessible(true);
        Slider slider = null;
        try {
            slider = (Slider) methodGetSlider.invoke(sandboxDimension);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int actualMax = (int) slider.getMax();
        assertEquals(expectedMax, actualMax);
    }

    @Test
    void checkSmallDimension() throws NoSuchMethodException {
        SandboxDimension sandboxDimension = new SandboxDimension();
        int expectedMin = 5;

        Method methodGetSlider = SandboxDimension.class.getDeclaredMethod("getSlider");
        methodGetSlider.setAccessible(true);
        Slider slider = null;
        try {
            slider = (Slider) methodGetSlider.invoke(sandboxDimension);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int actualMin = (int) slider.getMin();
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void checkAnyDimension() throws NoSuchMethodException {
        SandboxDimension sandboxDimension = new SandboxDimension();
        int expected = 13;

        Method methodGetSlider = SandboxDimension.class.getDeclaredMethod("getSlider");
        methodGetSlider.setAccessible(true);
        Slider slider = null;
        try {
            slider = (Slider) methodGetSlider.invoke(sandboxDimension);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        slider.setValue(expected);
        int actual = (int) slider.getValue();

        assertEquals(expected, actual);
    }

    @Test
    void checkNegativeDimension() throws NoSuchMethodException {
        SandboxDimension sandboxDimension = new SandboxDimension();

        Method methodGetSlider = SandboxDimension.class.getDeclaredMethod("getSlider");
        methodGetSlider.setAccessible(true);
        Slider slider = null;
        try {
            slider = (Slider) methodGetSlider.invoke(sandboxDimension);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        slider.setValue(-1);
        int actual = (int) slider.getValue();

        assertEquals(5, actual);
    }
}

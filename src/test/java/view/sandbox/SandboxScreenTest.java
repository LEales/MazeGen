package view.sandbox;

import control.MainProgram;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.menu.ChooseDimension;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class SandboxScreenTest {
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
    void stopExistsCheck(){
        SandboxScreen sandboxScreen = new SandboxScreen(10);

        Method methodView;
        try {
            methodView = SandboxScreen.class.getDeclaredMethod("findLabelById", String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        methodView.setAccessible(true);

        Label actualView;
        try {
            actualView = (javafx.scene.control.Label) methodView.invoke(sandboxScreen,"1");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    void startExistsCheck(){
        SandboxScreen sandboxScreen = new SandboxScreen(10);

        Method methodView;
        try {
            methodView = SandboxScreen.class.getDeclaredMethod("findLabelById", String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        methodView.setAccessible(true);

        Label actualView;
        try {
            actualView = (javafx.scene.control.Label) methodView.invoke(sandboxScreen,"0");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

}
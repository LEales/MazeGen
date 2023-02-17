package view.Campaign;

import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import model.Maps.*;
import model.World;
import org.junit.jupiter.api.Test;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;

public class WorldTemplateTest {
    Sprite[][] sprite;
    World world = World.FOREST;
    int currentLevel;
    int heartCrystals;
    RightPanel rightPanel;
    int seconds;
    World1Template worldTemplate;


    @Test
    void createPathTrasistionPos() {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(new Node() {
        });

    }

    @Test
    void createImageView() {

    }
/*
    World1Template setWorldTemplate(int currentLevel) throws FileNotFoundException {
        this.currentLevel = currentLevel;
        rightPanel = new RightPanel(String.valueOf(currentLevel));
        seconds = 25;
        heartCrystals = 3;

        switch(currentLevel) {
            case 11:
                World1Maps world1Map = new World1Maps();
                sprite = world1Map.getLevel11();
                world = World.FOREST;
                break;
            case 21:
                World2Maps world2Map = new World2Maps();
                sprite = world2Map.getLevel21();
                break;
            case 31:
                World3Maps world3Map = new World3Maps();
                sprite = world3Map.getLevel31();
                break;
            case 41:
                World4Maps world4Map = new World4Maps();
                sprite = world4Map.getLevel41();
                break;
            case 51:
                World5Maps world5Map = new World5Maps();
                sprite = world5Map.getLevel51();
                break;
            case 61:
                World6Maps world6Map = new World6Maps();
                sprite = world6Map.getLevel61();
                break;
        }
    }

 */
}

package view.menu;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.enums.GameMode;
import model.enums.World;
import org.junit.jupiter.api.Test;
import view.sandbox.SandboxScreen;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RightPanelTest {

    @Test
    public void testRemovePickaxe() throws FileNotFoundException, NoSuchFieldException, IllegalAccessException {
        new JFXPanel();

        Platform.runLater(() -> {
            try {
                RightPanel rightPanel = new RightPanel(GameMode.CAMPAIGN);
                Image emptyView = new Image("file:files/empty.png", 50, 50, false, false);
                ImageView pickaxeLabel = new ImageView(new Image("file:files/pickaxe.png", 50, 50, false, false));
                Field pickaxeLabelField = RightPanel.class.getDeclaredField("pickaxeLabel");
                pickaxeLabelField.setAccessible(true);
                pickaxeLabelField.set(rightPanel, pickaxeLabel);
                rightPanel.removePickaxe();
                assertEquals(emptyView, pickaxeLabel.getImage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

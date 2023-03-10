package view;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

public class VictoryScreenTest {
    private AnimationTimer timer;
    private Label label;
    private Label currCharLabel;

    @Test
    public void testCreateCharAnimation() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        VictoryScreen vs = new VictoryScreen();
        Method createCharAnimation = VictoryScreen.class.getDeclaredMethod("createCharAnimation", Label.class);
        createCharAnimation.setAccessible(true);

        label = new Label("A");
        createCharAnimation.invoke(vs, label);

        Field timerField = VictoryScreen.class.getDeclaredField("timer");
        timerField.setAccessible(true);
        timer = (AnimationTimer) timerField.get(vs);

        assertNotNull(timer);
        assertNull(currCharLabel);

        boolean isLabelVisible = label.isVisible();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(550);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isLabelVisible == label.isVisible()) {
                fail("Label's visibility was not updated");
            }
            isLabelVisible = label.isVisible();
        }

        timer.stop();
        assertNull(currCharLabel);
    }
}

    /*
    @After
    public void deleteTheFile() throws Exception {
        File scoreListFile = new File("files/testHighScore.dat");
        if (scoreListFile.exists()) {
            scoreListFile.delete();
        }
    }

    @Test
    public void testSetTime() {
        VictoryScreen victoryScreen = new VictoryScreen();
        int time = 100;
        int result = victoryScreen.setTime(time);
        assertEquals(time, result);
    }

    //Ska inte g?? att s??tta sm?? bokst??ver
    @Test
    public void SetSmallCharactersTextCurrent() {
        VictoryScreen victoryScreen = new VictoryScreen();
        Label firstLabel = (Label) victoryScreen.getChildren().get(0);
        Label secondLabel = (Label) victoryScreen.getChildren().get(1);
        Label thirdLabel = (Label) victoryScreen.getChildren().get(2);


        victoryScreen.setTextCurrent("a");
        Label error = (Label) victoryScreen.getChildren().get(3);
        assertTrue(error.getText().equals("Not A Valid Input"));
    }
    //Ska inte g?? att s??tta ogiltiga tecken
    @Test
    public void SetInvalidCharacterTextCurrent() {
        VictoryScreen victoryScreen = new VictoryScreen();
        Label firstLabel = (Label) victoryScreen.getChildren().get(0);
        Label secondLabel = (Label) victoryScreen.getChildren().get(1);
        Label thirdLabel = (Label) victoryScreen.getChildren().get(2);

        Label error = (Label) victoryScreen.getChildren().get(3);
        victoryScreen.setTextCurrent("!");
        assertTrue(error.getText().equals("Not A Valid Input"));

        error = (Label) victoryScreen.getChildren().get(3);
        victoryScreen.setTextCurrent("?");
        assertTrue(error.getText().equals("Not A Valid Input"));

        error = (Label) victoryScreen.getChildren().get(3);
        victoryScreen.setTextCurrent("/");
        assertTrue(error.getText().equals("Not A Valid Input"));

    }

    @Test
    public void SetValidTextCurrent() {
        VictoryScreen victoryScreen = new VictoryScreen();
        Label firstLabel = (Label) victoryScreen.getChildren().get(0);
        Label secondLabel = (Label) victoryScreen.getChildren().get(1);
        Label thirdLabel = (Label) victoryScreen.getChildren().get(2);

        victoryScreen.setTextCurrent("A");
        assertEquals("A", firstLabel.getText());
        assertEquals("_", secondLabel.getText());
        assertEquals("_", thirdLabel.getText());

        victoryScreen.setTextCurrent("B");
        assertEquals("A", firstLabel.getText());
        assertEquals("B", secondLabel.getText());
        assertEquals("_", thirdLabel.getText());

        victoryScreen.setTextCurrent("C");
        assertEquals("A", firstLabel.getText());
        assertEquals("B", secondLabel.getText());
        assertEquals("C", thirdLabel.getText());

        victoryScreen.setTextCurrent("BACK_SPACE");
        assertEquals("A", firstLabel.getText());
        assertEquals("B", secondLabel.getText());
        assertEquals("_", thirdLabel.getText());

        victoryScreen.setTextCurrent("BACK_SPACE");
        assertEquals("A", firstLabel.getText());
        assertEquals("_", secondLabel.getText());
        assertEquals("_", thirdLabel.getText());

        victoryScreen.setTextCurrent("BACK_SPACE");
        assertEquals("_", firstLabel.getText());
        assertEquals("_", secondLabel.getText());
        assertEquals("_", thirdLabel.getText());
    }

    @Test
    public void Background() {
        VictoryScreen victoryScreen = new VictoryScreen();
        BackgroundImage backgroundImage = victoryScreen.setBackground();
        assertTrue(backgroundImage.getImage().getUrl().endsWith("files/MenuBackground.jpg"));
        assertEquals(MainProgram.WIDTH, backgroundImage.getImage().getWidth(), 0.0);
        assertEquals(MainProgram.HEIGHT, backgroundImage.getImage().getHeight(), 0.0);
    }

    @Test
    public void SetupTextArea() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        VictoryScreen victoryScreen = new VictoryScreen();
        Method setupTextArea = victoryScreen.getClass().getDeclaredMethod("setupTextArea", double.class, double.class);
        setupTextArea.setAccessible(true);
        Label label = (Label) setupTextArea.invoke(victoryScreen, 100.0, 200.0);

        assertEquals(100.0, label.getTranslateX(), 0.0);
        assertEquals(200.0, label.getTranslateY(), 0.0);
        assertEquals(Font.loadFont("file:files/fonts/PressStart2P.ttf", 50), label.getFont());
        assertEquals("0xffffffff", label.getTextFill().toString());
    }

    @Test
    public void addValidNameToScoreList() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        VictoryScreen victoryScreen = new VictoryScreen();
        String name = "ABC";
        victoryScreen.setTextCurrent(name);
        Label firstScoreLabel = (Label) victoryScreen.getChildren().get(0);

        System.out.println(name + " and " + firstScoreLabel.getText());
        assertEquals(name , firstScoreLabel.getText());
    }



    //Testa s?? att filen som sparas och l??ses med samma v??rden
    @Test
    public void addToScoreList() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String name = "AAA";
        int time = 20;
        int level = 1;
        Player player = new Player(name, time, level);
        VictoryScreen victoryScreen = new VictoryScreen();

        ArrayList<Player> scoreList = new ArrayList<>();
        scoreList.add(player);
        addPlayerToScoreList(player,victoryScreen,scoreList);
        ArrayList<Player> readList = getScoreList();
        for (int i = 0; i<readList.size(); i++) {
            assertEquals(scoreList.get(i).getLvl(), readList.get(i).getLvl());
            assertEquals(scoreList.get(i).getPlayer(), readList.get(i).getPlayer());
            assertEquals(scoreList.get(i).getSeconds(), readList.get(i).getSeconds());
        }

    }

    //Hj??lp klass
    ArrayList<Player> getScoreList(){
        ArrayList<Player> playerList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/testHighScore.dat"))) {
            while (true) {
                Player player = null;
                try {
                    player = (Player) ois.readObject();
                } catch (EOFException e) {
                    break;
                }
                playerList.add(player);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return playerList;
    }

    //Kolla s?? att v??rldarna sparas och laddas in r??tt
    @Test
    public void testWorld() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        VictoryScreen victoryScreen = new VictoryScreen();
        Method addToScoreList = victoryScreen.getClass().getDeclaredMethod("addToScoreList", ArrayList.class, Player.class, String.class);
        addToScoreList.setAccessible(true);
        ArrayList<Player> localList = new ArrayList<>();

        Player player = new Player("AAA", 100, 111);
        Player player1 = new Player("BBB", 200, 211);
        Player player2 = new Player("CCC", 300, 311);
        Player player3 = new Player("DDD", 400, 411);
        Player player4 = new Player("EEE", 500, 511);
        Player player5 = new Player("FFF", 600, 611);

        localList.add(player);
        localList.add(player1);
        localList.add(player2);
        localList.add(player3);
        localList.add(player4);
        localList.add(player5);

        localList.add(player);
        localList.add(player2);

        localList.add(player3);
        localList.add(player4);

        localList.add(player5);

        Collections.sort(localList);

        addPlayerToScoreList(player,victoryScreen,localList);
        addPlayerToScoreList(player1,victoryScreen,localList);
        addPlayerToScoreList(player2,victoryScreen,localList);
        addPlayerToScoreList(player3,victoryScreen,localList);
        addPlayerToScoreList(player4,victoryScreen,localList);
        addPlayerToScoreList(player5,victoryScreen,localList);


        ArrayList<Player> readList = getScoreList();
        Collections.sort(readList);
        for (int i = 0; i<readList.size(); i++){
            assertEquals(localList.get(i).getLvl(),readList.get(i).getLvl());
        }
    }

    //Kolla s?? att v??rldarna sparas och laddas in r??tt
    @Test
    public void testlvl() throws Exception {
        VictoryScreen victoryScreen = new VictoryScreen();
        deleteTheFile();
        Method addToScoreList = victoryScreen.getClass().getDeclaredMethod("addToScoreList", ArrayList.class, Player.class, String.class);
        addToScoreList.setAccessible(true);

        Player player = new Player("AAA", 100, 0);
        Player player1 = new Player("BBB", 200, 11);
        Player player2 = new Player("CCC", 200, 15);

        Player player3 = new Player("DDD", 200, 21);
        Player player4 = new Player("EEE", 200,25);

        Player player5 = new Player("FFF", 300, 31);
        Player player6 = new Player("GGG", 300, 35);

        Player player7 = new Player("HHH", 400, 41);
        Player player8 = new Player("III", 500, 61);
        Player player9 = new Player("JJJ", 600, 65);
        ArrayList<Player> localList = new ArrayList<>();

        //L??gg till player i lokalLista
        localList.add(player);
        localList.add(player2);

        localList.add(player3);
        localList.add(player4);

        localList.add(player5);
        localList.add(player6);

        localList.add(player7);
        localList.add(player8);
        localList.add(player9);
        Collections.sort(localList);

        addPlayerToScoreList(player,victoryScreen,localList);
        addPlayerToScoreList(player1,victoryScreen,localList);
        addPlayerToScoreList(player2,victoryScreen,localList);
        addPlayerToScoreList(player3,victoryScreen,localList);
        addPlayerToScoreList(player4,victoryScreen,localList);
        addPlayerToScoreList(player5,victoryScreen,localList);
        addPlayerToScoreList(player6,victoryScreen,localList);
        addPlayerToScoreList(player7,victoryScreen,localList);
        addPlayerToScoreList(player8,victoryScreen,localList);
        addPlayerToScoreList(player9,victoryScreen,localList);

        ArrayList<Player> readList = getScoreList();
        Collections.sort(readList);
        for (int i = 0; i<readList.size(); i++){
            assertEquals(localList.get(i).getLvl(),readList.get(i).getLvl());
        }

    }
    public void addPlayerToScoreList(Player player, VictoryScreen victory, ArrayList<Player> scoreList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method addToScoreList = victory.getClass().getDeclaredMethod("addToScoreList", ArrayList.class, Player.class, String.class);
        addToScoreList.setAccessible(true);
        addToScoreList.invoke(victory, scoreList,player, "files/testHighScore.dat");;
    }

}
*/
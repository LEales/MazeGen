package control;

import javafx.scene.layout.BorderPane;
import model.Maps.Sprite;
import view.Randomize.MapTemplate;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * @author André Eklund
 * @edit Viktor Näslund
 */

public class GenerateNextLevel {

    private MazeGenerator mazeGenerator;
    private final BorderPane mainPane;
    private final int dimension;

    /**
     * Initializes the objects.
     *
     * @param mainPane      En BorderPane.
     * @param mazeGenerator Klassen som genererar labyrinter.
     * @param dimension     Storleken på labyrinten som ska genereras.
     */

    public GenerateNextLevel(BorderPane mainPane, MazeGenerator mazeGenerator, int dimension) {
        this.dimension = dimension;
        this.mazeGenerator = mazeGenerator;
        this.mainPane = mainPane;
    }

    /**
     * Genererar en ny labyrint och skickar det till GUIt.
     *
     * @throws FileNotFoundException
     */
    public void generateNewMaze() throws FileNotFoundException {
        Sprite[][] currentMaze = mazeGenerator.getMaze();
        MazeGenerator newMazegenerator = new MazeGenerator(dimension, false);
        Sprite[][] nextMaze = newMazegenerator.getMaze();
        int col = 0;

        for (int i = 0; i < currentMaze.length; i++) {
            for (int j = 0; j < currentMaze[i].length; j++) {
                if (currentMaze[i][j] == Sprite.GOAL) {
                    nextMaze[i][j] = Sprite.START;
                } else if (currentMaze[i][j] == Sprite.START) {
                    col = j;
                }
            }
        }
        nextMaze[new Random().nextBoolean() ? 0 : nextMaze.length - 1][col] = Sprite.GOAL;
        mainPane.setCenter(new MapTemplate(checkStartAndGoalNeighbors(nextMaze), this));
        mazeGenerator = newMazegenerator;
    }

    /**
     * En metod som kollar arrayens siffror för att säkerställa att
     * start och mål inte är instängda mellan siffror som representerar väggar.
     *
     * @param maze Arrayen som ska granskas.
     * @return returnerar den modifierade arrayen.
     */
    private Sprite[][] checkStartAndGoalNeighbors(Sprite[][] maze) {

        int wallCounterStart = 0;
        int wallCounterGoal = 0;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {

                if (Sprite.START == maze[i][j]) {
                    for (int offsetRow = i - 1; offsetRow <= i + 1; offsetRow++) {
                        for (int offsetCol = j - 1; offsetCol <= j + 1; offsetCol++) {

                            if ((offsetRow >= 0) && (offsetRow < maze.length)) {

                                if ((offsetCol >= 0) && (offsetCol < maze[0].length)) {
                                    if (Sprite.WALL == maze[offsetRow][offsetCol]) {
                                        if ((i == 0) && (j == 0)) {
                                            if (validate(1, offsetRow, offsetRow, offsetCol, maze)) {
                                                wallCounterStart++;
                                            }
                                        }
                                    } else if (wallCounterStart >= 2) {
                                        for (int offsetRow2 = offsetRow - 1; offsetRow2 <= offsetRow + 1; offsetRow2++) {
                                            for (int offsetCol2 = offsetCol - 1; offsetCol2 <= offsetCol + 1; offsetCol2++) {
                                                if ((offsetRow2 >= 0) && (offsetRow2 < maze.length)) {
                                                    if ((offsetCol2 >= 0) && (offsetCol2 < maze[0].length)) {
                                                        if (Sprite.WALL == maze[offsetRow2][offsetCol2]) {
                                                            maze[offsetRow2][offsetCol2] = Sprite.PATH;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (maze[i][j] == Sprite.GOAL) {
                    for (int offsetRow = i - 1; offsetRow <= i + 1; offsetRow++) {
                        for (int offsetCol = j - 1; offsetCol <= j + 1; offsetCol++) {

                            if ((offsetRow >= 0) && (offsetRow < maze.length)) {
                                if ((offsetCol >= 0) && (offsetCol < maze[0].length)) {
                                    if (maze[offsetRow][offsetCol] == Sprite.WALL) {
                                        if (validate(offsetRow, 1, offsetRow, offsetCol, maze)) {
                                            wallCounterGoal++;
                                        }
                                    } else if (wallCounterGoal >= 2) {
                                        for (int offsetRow2 = offsetRow - 1; offsetRow2 <= offsetRow + 1; offsetRow2++) {
                                            for (int offsetCol2 = offsetCol - 1; offsetCol2 <= offsetCol + 1; offsetCol2++) {
                                                if ((offsetRow2 >= 0) && (offsetRow2 < maze.length)) {
                                                    if ((offsetCol2 >= 0) && (offsetCol2 < maze[0].length)) {
                                                        if (maze[offsetRow2][offsetCol2] == Sprite.WALL) {
                                                            maze[offsetRow2][offsetCol2] = Sprite.PATH;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return maze;
    }

    private boolean validate(int x, int offsetRow, int offsetRow1, int offsetCol, Sprite[][] maze) {
        return (x != offsetRow && 1 != offsetCol) || (1 != offsetRow1 && offsetCol != maze.length - 1) ||
                (offsetRow1 != maze.length - 1 && 1 != offsetCol) || (offsetRow1 != maze.length - 1 &&
                offsetCol != maze.length - 1);
    }

    public MazeGenerator getMazeGenerator() {
        return mazeGenerator;
    }
}

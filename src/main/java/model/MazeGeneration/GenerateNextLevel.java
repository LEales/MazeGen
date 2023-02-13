package model.MazeGeneration;

import control.MainProgram;
import javafx.scene.layout.BorderPane;
import model.Maps.Sprite;
import view.Randomize.MapTemplate;
import view.Menu.RightPanel;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * @author André Eklund
 * @edit Viktor Näslund
 */

public class GenerateNextLevel {

    private MazeGenerator mazeGenerator;
    private BorderPane mainPane;
    private MainProgram mainProgram;
    private RightPanel rightPanel;
    private int dimension;

    /**
     * Initializes the objects.
     *
     * @param mainProgram   Huvudprogrammet.
     * @param mainPane      En BorderPane.
     * @param mazeGenerator Klassen som genererar labyrinter.
     * @param rightPanel    Panelen som visar information så som liv, tid, nivå osv.
     * @param dimension     Storleken på labyrinten som ska genereras.
     */

    public GenerateNextLevel(MainProgram mainProgram, BorderPane mainPane, MazeGenerator mazeGenerator, RightPanel rightPanel, int dimension) {
        this.dimension = dimension;
        this.mazeGenerator = mazeGenerator;
        this.mainProgram = mainProgram;
        this.mainPane = mainPane;
        this.rightPanel = rightPanel;
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
                if (currentMaze[i][j] == Sprite.Goal) {
                    nextMaze[i][j] = Sprite.Start;
                } else if (currentMaze[i][j] == Sprite.Start) {
                    col = j;
                }
            }
        }
        nextMaze[new Random().nextBoolean() ? 0 : nextMaze.length - 1][col] = Sprite.Goal;
        mainPane.setCenter(new MapTemplate(checkStartAndGoalNeighbors(nextMaze), mainProgram, this));
        this.mazeGenerator = newMazegenerator;
    }

    /**
     * En metod som kollar arrayens siffror för att säkerställa att
     * start och mål inte är instängda mellan siffror som representerar väggar.
     *
     * @param maze Arrayen som ska granskas.
     * @return returnerar den modifierade arrayen.
     */
    public Sprite[][] checkStartAndGoalNeighbors(Sprite[][] maze) {

        int wallCounterStart = 0;
        int wallCounterGoal = 0;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {

                if (maze[i][j] == Sprite.Start) {
                    for (int offsetRow = i - 1; offsetRow <= i + 1; offsetRow++) {
                        for (int offsetCol = j - 1; offsetCol <= j + 1; offsetCol++) {

                            if ((offsetRow >= 0) && (offsetRow < maze.length)) {

                                if ((offsetCol >= 0) && (offsetCol < maze[0].length)) {
                                    if (maze[offsetRow][offsetCol] == Sprite.Wall) {
                                        if ((i == 0) && (j == 0)) {
                                            if ((offsetRow != 1 && offsetCol != 1) || (offsetRow != 1 && offsetCol != maze.length - 1) || (offsetRow != maze.length - 1 && offsetCol != 1) || (offsetRow != maze.length - 1 && offsetCol != maze.length - 1)) {
                                                wallCounterStart++;
                                            }
                                        }
                                    } else if (wallCounterStart >= 2) {
                                        for (int offsetRow2 = offsetRow - 1; offsetRow2 <= offsetRow + 1; offsetRow2++) {
                                            for (int offsetCol2 = offsetCol - 1; offsetCol2 <= offsetCol + 1; offsetCol2++) {
                                                if ((offsetRow2 >= 0) && (offsetRow2 < maze.length)) {
                                                    if ((offsetCol2 >= 0) && (offsetCol2 < maze[0].length)) {
                                                        if (maze[offsetRow2][offsetCol2] == Sprite.Wall) {
                                                            maze[offsetRow2][offsetCol2] = Sprite.Path;
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
                } else if (maze[i][j] == Sprite.Goal) {
                    for (int offsetRow = i - 1; offsetRow <= i + 1; offsetRow++) {
                        for (int offsetCol = j - 1; offsetCol <= j + 1; offsetCol++) {

                            if ((offsetRow >= 0) && (offsetRow < maze.length)) {
                                if ((offsetCol >= 0) && (offsetCol < maze[0].length)) {
                                    if (maze[offsetRow][offsetCol] == Sprite.Wall) {
                                        if ((offsetRow != 1 && offsetCol != 1) || (offsetRow != 1 && offsetCol != maze.length - 1) || (offsetRow != maze.length - 1 && offsetCol != 1) || (offsetRow != maze.length - 1 && offsetCol != maze.length - 1)) {
                                            wallCounterGoal++;
                                        }
                                    } else if (wallCounterGoal >= 2) {
                                        for (int offsetRow2 = offsetRow - 1; offsetRow2 <= offsetRow + 1; offsetRow2++) {
                                            for (int offsetCol2 = offsetCol - 1; offsetCol2 <= offsetCol + 1; offsetCol2++) {
                                                if ((offsetRow2 >= 0) && (offsetRow2 < maze.length)) {
                                                    if ((offsetCol2 >= 0) && (offsetCol2 < maze[0].length)) {
                                                        if (maze[offsetRow2][offsetCol2] == Sprite.Wall) {
                                                            maze[offsetRow2][offsetCol2] = Sprite.Path;
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

    public MazeGenerator getMazeGenerator() {
        return mazeGenerator;
    }
}

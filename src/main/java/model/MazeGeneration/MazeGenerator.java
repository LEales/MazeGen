package model.MazeGeneration;

import model.Maps.Sprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {

    /**
     * @Author https://github.com/oppenheimj/maze-generator/blob/master/MazeGenerator.java
     * Edit Sebastian Helin, André Eklund
     */

    private final Stack<Node> stack = new Stack<>();
    private final Random rand = new Random();
    private Sprite[][] maze;
    private final int dimension;
    private final boolean generateGoalAndStart;

    /**
     * @param dim             Tar in en dimension för hur stor labyrinten ska vara
     * @param setGoalAndStart Sätter start & mål
     */
    public MazeGenerator(int dim, boolean setGoalAndStart) {
        this.generateGoalAndStart = setGoalAndStart;
        maze = new Sprite[dim][dim];
        maze = fillArray(maze);
        dimension = dim;
        generateMaze();
        createStartAndGoal();
    }

    private Sprite[][] fillArray(Sprite[][] maze) {
        for (Sprite[] sprites : maze) {
            Arrays.fill(sprites, Sprite.WALL);
        }
        return maze;
    }

    private void generateMaze() {
        stack.push(new Node(0, 0));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                maze[next.y][next.x] = Sprite.PATH;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
            }
        }
    }

    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.y - 1; y < node.y + 2; y++) {
            for (int x = node.x - 1; x < node.x + 2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && Sprite.PATH == maze[y][x]) {
                    numNeighboringOnes++;
                }
            }
        }
        return (3 > numNeighboringOnes) && Sprite.PATH != maze[node.y][node.x];
    }

    private void randomlyAddNodesToStack(ArrayList<Node> nodes) {
        int targetIndex;
        while (!nodes.isEmpty()) {
            targetIndex = rand.nextInt(nodes.size());
            stack.push(nodes.remove(targetIndex));
        }
    }

    private ArrayList<Node> findNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for (int y = node.y - 1; y < node.y + 2; y++) {
            for (int x = node.x - 1; x < node.x + 2; x++) {
                if (pointOnGrid(x, y) && pointNotCorner(node, x, y)
                        && pointNotNode(node, x, y)) {
                    neighbors.add(new Node(x, y));
                }
            }
        }
        return neighbors;
    }

    /**
     * Edit av Sebastian Helin & Andre Eklund
     */
    private void createStartAndGoal() {
        if (generateGoalAndStart) {
            maze[randomIndex()][0] = Sprite.START;
            maze[randomIndex()][maze.length - 1] = Sprite.GOAL;
        }
    }

    private int randomIndex() {
        return new Random().nextBoolean() ? 0 : maze.length - 1;
    }

    public Sprite[][] getMaze() {
        return maze;
    }

    private Boolean pointOnGrid(int x, int y) {
        return 0 <= x && y >= 0 && x < dimension && y < dimension;
    }

    private Boolean pointNotCorner(Node node, int x, int y) {
        return (x == node.x || y == node.y);
    }

    private Boolean pointNotNode(Node node, int x, int y) {
        return !(x == node.x && y == node.y);
    }
}
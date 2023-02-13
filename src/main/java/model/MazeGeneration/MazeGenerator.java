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

    private Stack<Node> stack = new Stack<>();
    private Random rand = new Random();
    private Sprite[][] maze;
    private int dimension;
    private boolean generateGoalAndStart;

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
        System.out.println(getRawMaze());
    }

    private Sprite[][] fillArray(Sprite[][] maze) {
        for (Sprite[] sprites : maze) {
            Arrays.fill(sprites, Sprite.Wall);
        }
        return maze;
    }

    public void generateMaze() {
        stack.push(new Node(0, 0));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next)) {
                maze[next.y][next.x] = Sprite.Path;
                ArrayList<Node> neighbors = findNeighbors(next);
                randomlyAddNodesToStack(neighbors);
            }
        }
    }

    public String getRawMaze() {
        StringBuilder sb = new StringBuilder();
        for (Sprite[] row : maze) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }

    /**
     * @return
     * @edit av Andre Eklund & Sebastian Helin
     */
    public String getSymbolicMaze() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(maze[i][j] == Sprite.Path ? "*" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean validNextNode(Node node) {
        int numNeighboringOnes = 0;
        for (int y = node.y - 1; y < node.y + 2; y++) {
            for (int x = node.x - 1; x < node.x + 2; x++) {
                if (pointOnGrid(x, y) && pointNotNode(node, x, y) && maze[y][x] == Sprite.Path) {
                    numNeighboringOnes++;
                }
            }
        }
        return (numNeighboringOnes < 3) && maze[node.y][node.x] != Sprite.Path;
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
    public void createStartAndGoal() {
        if (generateGoalAndStart) {
            maze[randomIndex()][0] = Sprite.Start;
            maze[randomIndex()][maze.length - 1] = Sprite.Goal;
        }
    }

    public int randomIndex() {
        return new Random().nextBoolean() ? 0 : maze.length - 1;
    }

    public Sprite[][] getMaze() {
        return maze;
    }

    private Boolean pointOnGrid(int x, int y) {
        return x >= 0 && y >= 0 && x < dimension && y < dimension;
    }

    private Boolean pointNotCorner(Node node, int x, int y) {
        return (x == node.x || y == node.y);
    }

    private Boolean pointNotNode(Node node, int x, int y) {
        return !(x == node.x && y == node.y);
    }
}
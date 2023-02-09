package model.MazeGeneration;

import control.MainProgram;
import javafx.application.Application;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class GenerateNextLevelTest {
    HashMap<Node, ArrayList<Node>> G = new HashMap<>();
    MazeGenerator mg;

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
    }

    @Test
    void generateNewMaze10() {
        generateNewMaze(10);
    }
    @Test
    void generateNewMaze14() {
        generateNewMaze(14);
    }
    @Test
    void generateNewMaze18() {
        generateNewMaze(18);
    }
    @Test
    void generateNewMaze28() {
        generateNewMaze(28);
    }
    void generateNewMaze(int dim) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 100; i++) {
            Platform.runLater(() -> {
                MainProgram mp = MainProgram.getMainProgram();
                try {
                    mp.changeToRandomize(dim);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                GenerateNextLevel gnl = mp.getGenerateNextLevel();
                mg = gnl.getMazeGenerator();
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int[][] maze = mg.getMaze();
            Node start = start(maze);
            if (start.equals(new Node(-1, -1))) {
                fail("No start Node");
            }
            Node end = end(maze);
            if (end.equals(new Node(-1, -1))) {
                fail("No end Node");
            }
            buildGraph(maze);
            assertTrue(dfs(start, end));
        }
    }

    private boolean dfs(Node start, Node end) {
        System.out.println("here");
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visited = new HashSet<>();
        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.equals(end)) {
                return true;
            }
            for (Node x : G.get(curr)) {
                if (!visited.contains(x)) {
                    visited.add(x);
                    stack.push(x);
                }
            }
        }
        return false;
    }

    private void buildGraph(int[][] maze) {
        G.clear();
        for (int j = 0; j < maze.length; j++) {
            for (int k = 0; k < maze[j].length; k++) {
                if (road(j, k, maze)) {
                    if (validate(j - 1, maze.length) && road(j - 1, k, maze)) {
                        addEdge(new Node(j - 1, k), new Node(j, k));
                    }
                    if (validate(j + 1, maze.length) && road(j + 1, k, maze)) {
                        addEdge(new Node(j + 1, k), new Node(j, k));
                    }
                    if (validate(k + 1, maze.length) && road(j, k + 1, maze)) {
                        addEdge(new Node(j, k + 1), new Node(j, k));
                    }
                    if (validate(k - 1, maze.length) && road(j, k - 1, maze)) {
                        addEdge(new Node(j, k - 1), new Node(j, k));
                    }
                }
            }
        }
    }


    private boolean road(int i, int j, int[][] maze) {
        return maze[i][j] == 1 || maze[i][j] == 2 || maze[i][j] == 3;
    }

    private boolean validate(int i, int dim) {
        return i >= 0 && i < dim;
    }

    private void addEdge(Node a, Node b) {
        G.putIfAbsent(a, new ArrayList<>());
        G.putIfAbsent(b, new ArrayList<>());
        G.get(a).add(b);
        G.get(b).add(a);
    }

    private Node end(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 3) {
                    return new Node(i, j);
                }
            }
        }
        return new Node(-1, -1);
    }

    private Node start(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 2) {
                    return new Node(i, j);
                }
            }
        }
        return new Node(-1, -1);
    }

}
package model.MazeGeneration;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class MazeGeneratorTest {

    HashMap<Node, ArrayList<Node>> G = new HashMap<>();


    void checkStartAndGoal(int dim) {
        for (int i = 0; i < 1000; i++) {
            G.clear();
            MazeGenerator mg = new MazeGenerator(dim, true);
            int[][] maze = mg.getMaze();
            Node start = start(maze);
            G.put(start, new ArrayList<>());
            if (start.equals(new Node(-1, -1))) {
                fail("No start Node");
            }
            Node end = end(maze);
            G.put(end, new ArrayList<>());
            if (end.equals(new Node(-1, -1))) {
                fail("No end Node");
            }
            buildGraph(maze);
            System.out.println(i);
            assertTrue(dfs(start, end));
        }
    }

    @Test
    void checkStartAndGoalPain() {
        checkStartAndGoal(28);
    }

    @Test
    void checkStartAndGoal18x18() {
        checkStartAndGoal(18);
    }

    @Test
    void checkStartAndGoal14x14() {
        checkStartAndGoal(14);
    }

    @Test
    void checkStartAndGoal10x10() {
        checkStartAndGoal(10);
    }

    private boolean dfs(Node start, Node end) {
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
        if (!G.get(a).contains(b)) {
            G.get(a).add(b);
        }
        if (!G.get(b).contains(a)) {
            G.get(b).add(a);
        }
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
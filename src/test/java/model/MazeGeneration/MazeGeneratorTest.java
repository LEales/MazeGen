package model.MazeGeneration;

import model.Maps.Sprite;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

//Test that randomized mazes are completable

class MazeGeneratorTest {

    HashMap<Node, ArrayList<Node>> G = new HashMap<>();

    void checkStartAndGoal(int dim) {
        for (int i = 0; i < 1000; i++) {
            G.clear();
            MazeGenerator mg = new MazeGenerator(dim, true);
            Sprite[][] maze = mg.getMaze();
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

    /**
     * A depth first search between two nodes.
     * @param start start ladder/node to start searching from
     * @param end goal ladder/node to search for a path to
     * @return true if a path exists and false if one doesn't.
     */
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

    /**
     * Builds a graph structure out of a 2-D maze.
     * @param maze the maze that is converted to a graph.
     */
    private void buildGraph(Sprite[][] maze) {
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

    /**
     * A help method for checking valid blocks in the maze.
     * @param i The y coordinate to check
     * @param j The x cooridnate to check
     * @param maze The maze to check in
     * @return True if the position is a valid connection between two nodes, otherwise false
     */
    private boolean road(int i, int j, Sprite[][] maze) {
        return maze[i][j] == Sprite.Path || maze[i][j] == Sprite.Start || maze[i][j] == Sprite.Goal;
    }

    /**
     *
     * @param i Represents a x och y coordinate.
     * @param dim The length/width of the maze
     * @return tru if the index is within the maze, and false if it isn't.
     */
    private boolean validate(int i, int dim) {
        return i >= 0 && i < dim;
    }

    /**
     * Adds Nodes to adj lists.
     * @param a Node that has a connection to b.
     * @param b Node that has connection to a.
     */
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

    /**
     * Finds the finish node in the maze
     * @param maze 2-D Maze to search in
     * @return The end node if one exists otherwise a Node with -1,-1 as coordinates
     */
    private Node end(Sprite[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == Sprite.Goal) {
                    return new Node(i, j);
                }
            }
        }
        return new Node(-1, -1);
    }

    /**
     * Finds the start node in the maze
     * @param maze 2-D Maze to search in
     * @return The start node if one exists otherwise a Node with -1,-1 as coordinates
     */
    private Node start(Sprite[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == Sprite.Start) {
                    return new Node(i, j);
                }
            }
        }
        return new Node(-1, -1);
    }
}
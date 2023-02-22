package model.MazeGeneration;

import control.MainProgram;
import control.MazeGenerator;
import javafx.application.Application;
import model.enums.Sprite;
import model.Node;
import model.maps.RandomizeMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

//Test that randomized mazes are completable

class MazeGeneratorTest {

    HashMap<Node, ArrayList<Node>> G = new HashMap<>();

    @BeforeAll
    static void initJFXRuntime() {
        new Thread(() -> Application.launch(MainProgram.class)).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void checkStartAndGoal(int dim) {
        for (int i = 0; i < 1000; i++) {
            G.clear();
            MazeGenerator mg = new MazeGenerator();
            mg.generateNewMaze(dim);
            mg.generateNextMaze();


            RandomizeMap rm = mg.getMap();

            Sprite[][] maze = rm.getMap();

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
        return maze[i][j] == Sprite.PATH || maze[i][j] == Sprite.START || maze[i][j] == Sprite.GOAL;
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
                if (maze[i][j] == Sprite.GOAL) {
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
                if (maze[i][j] == Sprite.START) {
                    return new Node(i, j);
                }
            }
        }
        return new Node(-1, -1);
    }

    @Test
    void validateDimension10onBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 10);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(result);
    }

    @Test
    void validateDimension10overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 11);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void validateDimension10underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 9);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void validateDimension14onBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 14);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(result);
    }

    @Test
    void validateDimension14overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 15);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void validateDimension14underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 13);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void validateDimension18onBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 18);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(result);
    }

    @Test
    void validateDimension18overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 19);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void validateDimension18underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 17);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void validateDimension28onBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 28);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertTrue(result);
    }

    @Test
    void validateDimension28overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 29);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void validateDimension28underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();

        try {
            method = MazeGenerator.class.getDeclaredMethod("validateDimension", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        boolean result;
        try {
            result = (boolean) method.invoke(mg, 27);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertFalse(result);
    }

    @Test
    void getSeconds10() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 10;
        int expected = 25;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        int result;
        try {
            result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, result);
    }

    @Test
    void getSeconds14() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 14;
        int expected = 60;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        int result;
        try {
            result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, result);
    }

    @Test
    void getSeconds18() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 18;
        int expected = 80;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        int result;
        try {
            result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, result);
    }

    @Test
    void getSeconds28() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 28;
        int expected = 99;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);
        int result;
        try {
            result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, result);
    }

    @Test
    void getSeconds10underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 9;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSeconds10overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 11;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSeconds14overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 15;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSeconds14underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 13;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSeconds18overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 19;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSeconds18underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 17;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSeconds28overBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 29;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSeconds28underBorder() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 29;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSecondsZero() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = 0;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void getSecondsIntMaxValue() {
        Method method;
        MazeGenerator mg = new MazeGenerator();
        int dim = Integer.MAX_VALUE;
        String expected = "Unexpected value: " + dim;

        try {
            method = MazeGenerator.class.getDeclaredMethod("getSeconds", int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        method.setAccessible(true);

        try {
            int result = (int) method.invoke(mg, dim);
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalStateException e) {
            assertEquals(expected, e.getMessage());
        }
    }


}
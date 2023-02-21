package control;

import model.Direction;
import model.Maps.RandomizeMap;
import model.Maps.Sprite;
import model.Node;
import model.World;
import view.Randomize.MapTemplate;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {

    /**
     * @Author https://github.com/oppenheimj/maze-generator/blob/master/MazeGenerator.java
     * Edit Sebastian Helin, André Eklund
     * @edit Teodor Wegestål, Luke Eales
     */
    private RandomizeMap map;
    private final Stack<Node> stack = new Stack<>();

    /**
     * Randomizes a new maze and places start and goal nodes based on the previous maze.
     */
    public void generateNextMaze() {
        RandomizeMap nextMap = generateMaze(map.dimension);
        int col = 0;

        Node start = null;
        Node end;

        for (int i = 0; i < map.dimension; i++) {
            for (int j = 0; j < map.dimension; j++) {
                if (map.spriteEquals(i, j, Sprite.GOAL)) {
                    nextMap.setSprite(i, j, Sprite.START);
                    start = new Node(i, j);
                } else if (map.spriteEquals(i, j, Sprite.START)) {
                    col = j;
                }
            }
        }
        int x = new Random().nextBoolean() ? 0 : nextMap.dimension - 1;
        nextMap.setSprite(x, col, Sprite.GOAL);
        end = new Node(x, col);
        nextMap = checkStartAndGoalNeighbors(nextMap, start);
        nextMap = checkStartAndGoalNeighbors(nextMap, end);
        map = nextMap;

        MainProgram.getMainProgram().changeRandomMapPane(this);
    }

    /**
     * Generates a new maze.
     *
     * @param dimension dimension for the maze
     */
    public void generateNewMaze(int dimension) {
        if (!validateDimension(dimension)) {
            throw new RuntimeException("Invalid dimension");
        }
        map = generateMaze(dimension);
        map = createStartAndGoal(map);
    }

    private boolean validateDimension(int dimension) {
        return dimension == 10 || dimension == 14 || dimension == 18 || dimension == 28;
    }

    /**
     * Returns the appropriate time for a each dimension.
     *
     * @param dimension dimension of the maze
     * @return the time in seconds
     */
    private int getSeconds(int dimension) {
        return switch (dimension) {
            case 10 -> 25;
            case 14 -> 60;
            case 18 -> 80;
            case 28 -> 99;
            default -> throw new IllegalStateException("Unexpected value: " + dimension);
        };
    }

    /**
     * Randomizes a new maze
     *
     * @param dimension the dimension for the map
     * @return the randomized map
     */
    private RandomizeMap generateMaze(int dimension) {
        if (!validateDimension(dimension)) {
            throw new RuntimeException("Invalid dimension");
        }
        RandomizeMap map = new RandomizeMap(3, getSeconds(dimension), dimension);
        stack.clear();
        map.fillArray();
        stack.push(new Node(0, 0));
        while (!stack.empty()) {
            Node next = stack.pop();
            if (validNextNode(next, map)) {
                map.setSprite(next.y, next.x, Sprite.PATH);
                ArrayList<Node> neighbors = findNeighbors(next, map);
                randomlyAddNodesToStack(neighbors);
            }
        }
        return map;
    }

    private boolean validNextNode(Node node, RandomizeMap map) {
        if (null == node || null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        int numNeighboringOnes = 0;
        for (int y = node.y - 1; y < node.y + 2; y++) {
            for (int x = node.x - 1; x < node.x + 2; x++) {
                if (pointOnGrid(x, y, map) && pointNotNode(node, x, y) && map.spriteEquals(y, x, Sprite.PATH)) {
                    numNeighboringOnes++;
                }
            }
        }
        return (3 > numNeighboringOnes) && !map.spriteEquals(node.y, node.x, Sprite.PATH);
    }

    private void randomlyAddNodesToStack(ArrayList<Node> nodes) {
        if (null == nodes) {
            throw new RuntimeException("Invalid ArrayList");
        }
        Random rand = new Random();
        int targetIndex;
        while (!nodes.isEmpty()) {
            targetIndex = rand.nextInt(nodes.size());
            stack.push(nodes.remove(targetIndex));
        }
    }

    private ArrayList<Node> findNeighbors(Node node, RandomizeMap map) {
        if (null == node || null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        ArrayList<Node> neighbors = new ArrayList<>();
        for (int y = node.y - 1; y < node.y + 2; y++) {
            for (int x = node.x - 1; x < node.x + 2; x++) {
                if (pointOnGrid(x, y, map) && pointNotCorner(node, x, y)
                        && pointNotNode(node, x, y)) {
                    neighbors.add(new Node(x, y));
                }
            }
        }
        return neighbors;
    }

    /**
     * Adds start and goal sprites to the map
     *
     * @param map the map to add start and goal to
     */
    private RandomizeMap createStartAndGoal(RandomizeMap map) {
        if (null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        int y = randomIndex(map);
        int x = 0;
        map.setSprite(y, x, Sprite.START);
        map = checkStartAndGoalNeighbors(map, new Node(y, x));
        y = randomIndex(map);
        x = map.dimension - 1;
        map.setSprite(y, x, Sprite.GOAL);
        map = checkStartAndGoalNeighbors(map, new Node(y, x));
        return map;
    }

    /**
     * Verifies that a node is not isolated by walls.
     * If the node is isolated, adds a path to the closest other path in a randomized direction
     *
     * @param map  the current map
     * @param node the node to be checked
     * @return updated map
     */
    private RandomizeMap checkStartAndGoalNeighbors(RandomizeMap map, Node node) {
        if (null == node || null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        if (validateIsPath(node.x - 1, node.y, map) ||
                validateIsPath(node.x + 1, node.y, map) ||
                validateIsPath(node.x, node.y - 1, map) ||
                validateIsPath(node.x, node.y + 1, map)) {
            return map;
        }
        Direction direction;
        int x = 0, y = 0;
        do {
            direction = randomizeDirection();
            switch (direction) {
                case NORTH -> {
                    x = node.x - 1;
                    y = node.y;
                }
                case WEST -> {
                    x = node.x;
                    y = node.y - 1;
                }
                case EAST -> {
                    x = node.x;
                    y = node.y + 1;
                }
                case SOUTH -> {
                    x = node.x + 1;
                    y = node.y;
                }
                default -> throw new RuntimeException("No direction");
            }
        } while (!pointOnGrid(x, y, map));

        return createPath(direction, x, y, map);
    }

    /**
     * Creates a path in a direction until it reaches another path
     *
     * @param direction the direction
     * @param x         to node x-coordinate
     * @param y         the node-y coordinate
     * @param map       the current map
     * @return the updated map
     */
    private RandomizeMap createPath(Direction direction, int x, int y, RandomizeMap map) {
        if (null == direction || null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        map.setSprite(x, y, Sprite.PATH);
        switch (direction) {
            case NORTH -> {
                if (map.spriteEquals(x - 1, y, Sprite.WALL)) createPath(Direction.NORTH, x - 1, y, map);
            }
            case WEST -> {
                if (map.spriteEquals(x, y - 1, Sprite.WALL)) createPath(Direction.WEST, x, y - 1, map);
            }
            case EAST -> {
                if (map.spriteEquals(x, y + 1, Sprite.WALL)) createPath(Direction.EAST, x, y + 1, map);
            }
            case SOUTH -> {
                if (map.spriteEquals(x + 1, y, Sprite.WALL)) createPath(Direction.SOUTH, x + 1, y, map);
            }
        }
        return map;
    }

    /**
     * Randomizes a direction
     *
     * @return the randomized direction
     */
    private Direction randomizeDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];

    }

    private boolean validateIsPath(int x, int y, RandomizeMap map) {
        if (null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        return pointOnGrid(x, y, map) && map.spriteEquals(x, y, Sprite.PATH);
    }

    private int randomIndex(RandomizeMap map) {
        if (null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        return new Random().nextBoolean() ? 0 : map.dimension - 1;
    }

    public RandomizeMap getMap() {
        return map;
    }

    private boolean pointOnGrid(int x, int y, RandomizeMap map) {
        if (null == map) {
            throw new RuntimeException("Invalid parameters");
        }
        return 0 <= x && y >= 0 && x < map.dimension && y < map.dimension;
    }

    private boolean pointNotCorner(Node node, int x, int y) {
        if (null == node) {
            throw new RuntimeException("Invalid parameters");
        }
        return (x == node.x || y == node.y);
    }

    private boolean pointNotNode(Node node, int x, int y) {
        if (null == node) {
            throw new RuntimeException("Invalid parameters");
        }
        return !(x == node.x && y == node.y);
    }

    public void setWorld(World world) {
        if (null == world) {
            throw new RuntimeException("Invalid parameters");
        }
        map.setWorld(world);
    }

    public Sprite getSprite(int x, int y) {
        return map.getSprite(x, y);
    }
}
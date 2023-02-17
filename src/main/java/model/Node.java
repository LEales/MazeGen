package model;

import java.util.Objects;

/**
 * @Author Sebastian Helin, Andre Eklund
 * Skapar en nod med en x & y position
 */
public class Node {
    public final int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
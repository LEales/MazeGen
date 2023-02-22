package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void createNode() {
        Node n = new Node(1, 2);
        assertFalse(n.equals(null));
    }
    @Test
    public void minValue() {
        Node n = new Node(Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1);
        assertEquals(Integer.MIN_VALUE + 1, n.x);
        assertEquals(Integer.MIN_VALUE + 1, n.y);
    }

    @Test
    public void maxValue() {
        Node n = new Node(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1);
        assertEquals(Integer.MAX_VALUE - 1, n.x);
        assertEquals(Integer.MAX_VALUE - 1, n.y);

    }
    @Test
    public void Equals() {
        Node n1 = new Node(1, 2);
        Node n2 = new Node(1, 2);
        Node n3 = new Node(2, 3);

        assertEquals(n1, n2);
        assertNotEquals(n1, n3);
    }

    @Test
    public void HashCode() {
        Node n1 = new Node(1, 2);
        Node n2 = new Node(1, 2);
        Node n3 = new Node(2, 3);

        assertEquals(n1.hashCode(), n2.hashCode());
        assertNotEquals(n1.hashCode(), n3.hashCode());
    }



}

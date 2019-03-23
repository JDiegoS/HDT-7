package sample;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree tree = new BinaryTree();

    @org.junit.Test
    public void add() {
        tree.add(new Association("test", "prueba"));
        String verificacion = tree.getSpanish("test");
        assertEquals("prueba", tree.getSpanish("test"));
    }

    @org.junit.Test
    public void containsNode() {
        tree.add(new Association("test", "prueba"));
        assertEquals(true, tree.containsNode("test"));
    }
}
package sample;


/**
 * @author Juan Diego Solorzano
 * @Carne 18151
 * @name BinaryTree.java
 * Implementacion de Binary Tree extraido de https://www.baeldung.com/java-binary-tree
 * */

public class BinaryTree {

    Node root;

    private Node Recursiveadd(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = Recursiveadd(current.left, value);
        } else if (value > current.value) {
            current.right = Recursiveadd(current.right, value);
        } else {
            // Ya existe el nodo
            return current;
        }

        return current;
    }

    public void add(int value){
        root = Recursiveadd(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // No hay hijos
            if (current.left == null && current.right == null) {
                return null;
            }

            //Tiene un hijo
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            } else{
                //Hay dos hijos
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

}



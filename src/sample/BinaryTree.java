/**
 * @author Juan Diego Solorzano y Luis Perez Aju
 * @Carne 18151 y 18212
 * @name BinaryTree.java
 * Implementacion de Binary Tree extraido de https://www.baeldung.com/java-binary-tree
 * */

public class BinaryTree {

    Node<Association> root;

    // Agrega el nodo
    private Node Recursiveadd(Node<Association> current, Association value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.value) < 0)   {
            current.left = Recursiveadd(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = Recursiveadd(current.right, value);
        } else {
            // Ya existe el valor
            return current;
        }

        return current;
    }

    public void add(Association value){
        root = Recursiveadd(root, value);
    }

    // Verifica si contiene el nodo
    private boolean containsNodeRecursive(Node current, String value) {
        // no lo contiene
        if (current == null) {
            return false;
        }

        //si lo contiene
        if (value.equals(current.value)) {
            return true;
        }
        return value.compareTo(current.value.key.toString())<0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    //Verifica si contiene el nodo comenzando desde el root
    public boolean containsNode(String value) {
        return containsNodeRecursive(root, value);
    }

    public String getSpanish(String english) {
        Node node = root;
        while (node != null) {
            if (node.value.key.equals(english)) {
                String key = node.value.value.toString();
                return key;
            }
            node = english.compareTo(node.value.key.toString()) < 0
                    ? node.left
                    : node.right;
        }
        return null;
    }

    String text = "";
    //Muestra el arbol en orden (in-order)
    public String traverseInOrder(Node node) {

        if (node != null) {
            traverseInOrder(node.left);
            text = text + (" " + node.value.key.toString() + " : " + node.value.value.toString());
            traverseInOrder(node.right);
            return text;
        } else{
            String txt = "No hay nodo";
            return  txt;
        }
    }


}



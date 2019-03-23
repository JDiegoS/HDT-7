
/**
 * @author Juan Diego Solorzano y  Luis Perez Aju
 * @Carne 18151 y 18212
 * @name Node.java
 * Extraido de https://www.baeldung.com/java-binary-tree
 * */

public class Node<E> {

    //Se modifica el codigo del original para obtener values que no sean int
    Association value;
    Node<E> left;
    Node<E> right;

    public Node(Association value){
        this.value = value;
        right = null;
        left = null;
    }

}

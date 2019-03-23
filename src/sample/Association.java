package sample;

/**
 * @author Juan Diego Solorzano
 * @Carne 18151
 * @name Association.java
 * Implementacion de Association extraido de http://www.cs.pomona.edu/classes/cs062/structure5/Association.java
 * */

public class Association<K,V> {

    protected K key;
    protected V value;

    public Association(K key, V value){
        if (key != null){
            this.key = key;
            this.value = value;
        }
        else {
            System.out.println("Llave no puede ser null");
        }
    }


    public V getValue(){
        return value;
    }

    public K getKey(){
        return key;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }

    public int compareTo(Association value) {
        int a = key.toString().compareTo(value.key.toString());
        return a;
    }
}

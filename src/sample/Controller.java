package sample;


/**
 * @author Juan Diego Solorzano y Luis Perez Aju
 * @Carne 18151 y 18212
 * @name Controller.java
 * Clase que contiene los metodos al usar la interfaz
 * * */
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.IOException;
import java.io.*;

public class Controller {


    //Variables
    public Button mostrar;
    public Button cargar;
    public TextArea text;

    BinaryTree arbol = new BinaryTree();

    //Demuestra el diccionario en la interfaz
    public void show(ActionEvent event) throws IOException {

        arbol = readDictionary("diccionario.txt", arbol);
        text.setText(text.getText() + "\nDiccionario: \n" + arbol.traverseInOrder(arbol.root));

    }

    //Lee el archivo texto.txt y lo traduce
    String resultado = "";
    String[] res = null;
    public void read(ActionEvent event) throws IOException {
        res = readFile("texto.txt");
        for (String node:res){
            if (arbol.containsNode(node)){
                resultado += arbol.getSpanish(node) + " ";
            }else {
                resultado += "*" + node + "* ";
            }
        }
        text.setText(text.getText() + "\n" + resultado);


    }

    //Lee el archivo diccionario.txt y lo organiza
    public static BinaryTree readDictionary(String archivo, BinaryTree tree) throws IOException {
        File file = new File(archivo);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String text;
        while((text = br.readLine()) != null){
            text = text.replace("(", "");
            text = text.replace(")", "\n");
            String[] parte = text.split(", ");
            String clave = parte[0];
            String valor = parte[1];
            tree.add(new Association(clave,valor));
        }
        return tree;
    }

    private static String[] readFile(String nombre) throws IOException {
        File file = new File(nombre);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] translated = null;
        int i= 0;
        while((line = br.readLine()) != null){
            translated = line.split(" ");
            for (String node:translated) {
                node = node.toLowerCase();
                translated[i] = node;
                i++;
            }
        }
        return translated;
    }

}

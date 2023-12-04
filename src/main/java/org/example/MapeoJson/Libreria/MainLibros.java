package org.example.MapeoJson.Libreria;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.MapeoJson.Libros;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.MapeoJson.Constant.JSON_MAPPER;


public class MainLibros {
    public static void main(String[] args) {
        int optmenu, isbn,anyo_p;
        String autor,titulo;
        Scanner entrada = new Scanner(System.in);
        ArrayList<org.example.MapeoJson.Libros> libros = new ArrayList<org.example.MapeoJson.Libros>();
        org.example.MapeoJson.Libros l1=new org.example.MapeoJson.Libros(0001,"Metro2033","Vladimir",2004);
        org.example.MapeoJson.Libros l2=new org.example.MapeoJson.Libros(0002,"Codice","Leonardo",1646);
        org.example.MapeoJson.Libros l3=new org.example.MapeoJson.Libros(0003,"Openheimer","Robert",1950);
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        try {
            JSON_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            JSON_MAPPER.writeValue(new File("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/Libros.json"), libros);
        }catch (Exception e){
            System.out.println("Algo ha salido mal");
        }
        do {
            System.out.println("Menu:");
            System.out.println("1. Introducir nuevo libro");
            System.out.println("2. Buscar libros");
            System.out.println("3. Listado libros");
            System.out.println("0. Salir");

            optmenu = entrada.nextInt();
            switch (optmenu) {
                case 1 -> {
                    System.out.println("ISBN:");
                    isbn= entrada.nextInt();
                    System.out.println("Titulo:");
                    titulo= entrada.nextLine();
                    System.out.println("Autor:");
                    autor= entrada.nextLine();
                    System.out.println("Anyo de publicacion:");
                    anyo_p= entrada.nextInt();
                    almacenar(isbn,titulo,autor,anyo_p);
                }
                case 2 -> {
                    buscar(entrada);
                }
                case 3 -> {

                }
                default -> {
                    System.err.println("Opcion no valida");
                }
            }
        }while(optmenu!=0);
    }

    public static void almacenar(int isbn, String titulo, String autor, int anyo_p){

        ArrayList<org.example.MapeoJson.Libros> libros = new ArrayList<org.example.MapeoJson.Libros>();
        org.example.MapeoJson.Libros l1=new org.example.MapeoJson.Libros(isbn,titulo,autor,anyo_p);
        libros.add(l1);
    }

    public static void buscar(Scanner entrada){
        String busca = entrada.nextLine().toLowerCase();

        boolean found = false;

        //for (Libros libros){

        //}
    }

    public static ArrayList jsonToArrayList(){
        ArrayList<org.example.MapeoJson.Libros> libros = null;
        try {
            libros = JSON_MAPPER.readValue(new File("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/Libros.json"),
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Libros.class));
        }catch (Exception e){

        }
        return libros;
    }
}
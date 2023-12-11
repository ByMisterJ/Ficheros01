package org.example.MapeoJson.Libreria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static org.example.MapeoJson.Constant.JSON_MAPPER;


public class MainLibros {
    public static void main(String[] args) throws Exception {
        int optmenu, isbn,anyo_p;
        String autor,titulo;
        Scanner entrada = new Scanner(System.in);
        ArrayList<Libros> libros = new ArrayList<Libros>();
        Libros l1=new Libros(0001,"Metro2033","Vladimir",2004);
        Libros l2=new Libros(0002,"Codice","Leonardo",1646);
        Libros l3=new Libros(0003,"Openheimer","Robert",1950);
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
            System.out.println("3. Guardar en json");
            System.out.println("4. Listar todos los libros almacenados");
            System.out.println("0. Salir");

            optmenu = entrada.nextInt();
            switch (optmenu) {
                case 1 -> {
                    System.out.println("ISBN:");
                    isbn= entrada.nextInt();
                    System.out.println("Titulo:");
                    titulo= entrada.nextLine();
                    titulo= entrada.nextLine();
                    System.out.println("Autor:");
                    autor= entrada.nextLine();
                    System.out.println("Anyo de publicacion:");
                    anyo_p= entrada.nextInt();
                    almacenar(isbn,titulo,autor,anyo_p,libros);
                }
                case 2 -> {
                    System.out.println("Introduce el titulo del libro que deseas buscar");
                    buscar(entrada,libros);
                }
                case 3 -> {
                    ArrayToJSON(libros);
                }
                case 4 -> {
                    libros = jsonToArrayList();
                    libros.forEach(System.out::println);
                }
                default -> {
                    System.err.println("Opcion no valida");
                }
            }
        }while(optmenu!=0);
    }

    public static void almacenar(int isbn, String titulo, String autor, int anyo_p, ArrayList<Libros> libros) throws Exception {


        Libros l1=new Libros(isbn,titulo,autor,anyo_p);
        libros.add(l1);

        ArrayToJSON(libros);
    }

    public static boolean buscar(Scanner entrada, ArrayList<Libros> libros){
        String busca = entrada.nextLine().toLowerCase();
        busca = entrada.nextLine().toLowerCase();
        Iterator<Libros> iter = libros.iterator();

        while(iter.hasNext()){
            Libros l=iter.next();
            if (l.getTitulo().equalsIgnoreCase(busca)){
                System.out.println("El libro: "+busca+" esta");
                return true;
            }
        }
        System.out.println("El libro: "+busca+" no esta");
        return false;
    }
    public static ArrayList<Libros> jsonToArrayList() throws Exception {
        ArrayList<Libros> libros;
        Path librosjson = Path.of("./Libros.json");
        try {
            libros = JSON_MAPPER.readValue(librosjson.toFile(), new TypeReference<ArrayList<Libros>>() {});
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return libros;
    }

    public static void ArrayToJSON(ArrayList<Libros> libros) throws Exception{
        try{
            JSON_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            JSON_MAPPER.writeValue(new File("./Libros.json"),libros);
        }catch (IOException e){}
    }
}
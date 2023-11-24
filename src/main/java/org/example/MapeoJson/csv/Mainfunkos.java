package org.example.MapeoJson.csv;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Mainfunkos {
    public static void main(String[] args) throws Exception {

        Scanner scanner=new Scanner(System.in);
        int menu=0;
        String basura;
        String modelao;
        Path funkoscsv = Path.of("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/csv/funkos.csv");
        ArrayList<funkos> funk = new ArrayList<>();
        try {
            String contenido = new String(Files.readAllBytes(funkoscsv));
            System.out.println(contenido);
            String[] separados=contenido.split(",|\n");

            String COD;
            String NOMBRE;
            String MODELO;
            double PRECIO;
            LocalDate FECHA_LANZAMIENTO;
            for (int cont=0;cont<=separados.length;cont++){
                if (cont%5==0 && cont!=0 && cont!=5){
                    COD=separados[(cont-5)];
                    NOMBRE=separados[(cont-4)];
                    MODELO=separados[(cont-3)];
                    PRECIO=Double.parseDouble(separados[(cont-2)]);
                    FECHA_LANZAMIENTO= LocalDate.parse(separados[cont-1]);
                    funkos f1=new funkos(COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO);
                    funk.add(f1);
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        //MENU//
        System.out.println("MENU");
        System.out.println("1. Funko mas caro");
        System.out.println("2. Media de los precios");
        System.out.println("3. Funkos por modelos");
        System.out.println("3. Funkos por modelos");
        System.out.println("4. Numero de funkos por modelo");
        System.out.println("5. Funkos lanzados en 2023");

        menu = scanner.nextInt();
        basura = scanner.nextLine();
        switch (menu){
            case 1:
                //Mas caro//
                Double funk_caro=funk.stream()
                        .map(funkos::getPrecio)
                        .max(Double::compare).get();
                System.out.println(funk_caro);
                break;

            case 2:
                //Media//
                Double mediaPrecio=funk.stream()
                        .mapToDouble(funkos::getPrecio).average().getAsDouble();
                System.out.println(mediaPrecio);
                break;

            case 3:
                //FUNKOS X MODELOS//
                System.out.println("introduce el modelo");
                modelao = scanner.nextLine();
                switch (modelao) {
                    case "MARVEL":
                    List<funkos> gmarvel = funk.stream()
                            .filter(p -> p.getModelo().equals("MARVEL")).toList();
                        gmarvel.forEach(System.out::println);
                    break;
                    case "DISNEY":
                    List<funkos> gdisney = funk.stream()
                            .filter(p -> p.getModelo().equals("DISNEY")).toList();
                        gdisney.forEach(System.out::println);
                    break;
                    case "ANIME":
                    List<funkos> ganime = funk.stream()
                            .filter(p -> p.getModelo().equals("ANIME")).toList();
                        ganime.forEach(System.out::println);
                    break;
                    case "OTROS":
                    List<funkos> gotros = funk.stream()
                            .filter(p -> p.getModelo().equals("OTROS")).toList();
                        gotros.forEach(System.out::println);
                    break;
                    default:
                        System.err.println("Modelo no valido");
                        break;
                }
                break;
            case 4:

                List<funkos> gmarvel = funk.stream()
                        .filter(p -> p.getModelo().equals("MARVEL")).toList();
                List<funkos> gdisney = funk.stream()
                        .filter(p -> p.getModelo().equals("DISNEY")).toList();
                List<funkos> ganime = funk.stream()
                        .filter(p -> p.getModelo().equals("ANIME")).toList();
                List<funkos> gotros = funk.stream()
                        .filter(p -> p.getModelo().equals("OTROS")).toList();

                Double num_marvel= (double) gmarvel.stream().count();
                System.out.println(num_marvel);
                Double num_disney= (double) gdisney.stream().count();
                System.out.println(num_disney);
                Double num_anime= (double) ganime.stream().count();
                System.out.println(num_anime);
                Double num_otros= (double) gotros.stream().count();
                System.out.println(num_otros);
                break;
            case 5:

                List<funkos> date2023=funk.stream()
                        .filter(p->p.getFecha_lanzamiento().getYear()==2023).toList();
                date2023.forEach(System.out::println);
                break;

            default:
                System.err.println("yo que se");
                break;
        }
        backup(funk);
        //MENU//


        //funk.forEach(System.out::println);

    }

    public static void backup(ArrayList <funkos> funk)throws Exception {
        File fichero = new File ("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/csv/funkos.dat");
        try(ObjectOutputStream ficherosalida = new ObjectOutputStream(new FileOutputStream(fichero))){
            ficherosalida.writeObject(funk);
        }catch (Exception e){
        }
    }

    public static ArrayList <funkos> restore () throws Exception{
        File fichero = new File ("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/csv/funkos.dat");
        try (ObjectInputStream ajasdas = new ObjectInputStream(new FileInputStream(fichero))){
            return (ArrayList<funkos>) ajasdas.readObject();
        }
    }

}

package org.example.FicherosDeIntercambio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.FicherosDeIntercambio.Entities.Lenguaje2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OperacionesJSON {

    public static Lenguaje2 leerObjetoJson(Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(ruta.toFile(), Lenguaje2.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Lenguaje2> leerArrayObjetosJson(Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // return objectMapper.readValue(ruta.toFile(), new TypeReference<List<Lenguaje2>>() { });
            return objectMapper.readValue(ruta.toFile(), new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String escribirObjetoJson(Lenguaje2 lenguaje) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(lenguaje);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String escribirListaObjetosJson(List<Lenguaje2> lenguajes) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(lenguajes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escribirListaObjetosJson(List<Lenguaje2> lenguajes, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), lenguajes);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    public static void main(String[] args) throws IOException {
        Path ficheroObjetoJson = Path.of(".", "src", "main", "resources", "lenguaje.json");
        System.out.println("\n**** Lectura de objeto JSON desde fichero ****");
        System.out.println(leerObjetoJson(ficheroObjetoJson));

        Path ficheroArrayObjetosJson = Path.of(".", "src", "main", "resources", "lenguajes.json");
        System.out.println("\n**** Lectura de array de objetos JSON desde fichero ****");
        leerArrayObjetosJson(ficheroArrayObjetosJson).forEach(System.out::println);

        Lenguaje2 lenguaje1 = new Lenguaje2("Solidity", 180, false, List.of("María", "Sonia", "José Miguel"));
        Lenguaje2 lenguaje2 = new Lenguaje2("Vyper", 160, false, List.of("Pepe", "Julián"));

        List<Lenguaje2> lenguajes = List.of(lenguaje1, lenguaje2);

        System.out.println("\n**** Escritura de objeto JSON por consola ****");
        System.out.println(escribirObjetoJson(lenguaje1));

        System.out.println("\n**** Escritura de lista de objetos JSON por consola ****");
        System.out.println(escribirListaObjetosJson(lenguajes));

        Path ejemploEscrituraJson = Path.of(".", "src", "main", "resources", "escritura.json");

        System.out.println("\n**** Escritura de lista de objetos JSON a fichero ****");
        escribirListaObjetosJson(lenguajes, ejemploEscrituraJson);


    }

}

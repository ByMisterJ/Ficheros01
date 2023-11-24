package org.example.FicherosDeIntercambio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TratamientoCSV {

    private final static String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {

        // Lectura de ficheros CSV con Files.lines en java.nio
        try (Stream<String> contenidoFichero = Files.lines(Path.of(".", "src", "main", "resources", "funkos.csv"))) {
            List<List<String>> funkos = contenidoFichero.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).toList();
            funkos.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }


}

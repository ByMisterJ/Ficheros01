package org.example.MapeoJson.personas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class MainPersonas {
    public static void main(String[] args) {
        ObjectMapper JSON_MAPPER = new ObjectMapper();
        Path pathDrivers = Path.of("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/Personas.json");
        ArrayList<Personas> personas;
        try {
            personas = JSON_MAPPER.readValue(pathDrivers.toFile(), new TypeReference<ArrayList<Personas>>() {});
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        personas.forEach(System.out::println);
    }
}
package org.example.MapeoJson.productos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class MainProductos {
    public static void main(String[] args) {
        ObjectMapper JSON_MAPPER = new ObjectMapper();
        Path pathDrivers = Path.of("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/Producto.json");
        ArrayList<Producto> productos;
        try {
            productos = JSON_MAPPER.readValue(pathDrivers.toFile(), new TypeReference<ArrayList<Producto>>() {});
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        productos.forEach(System.out::println);
    }
}
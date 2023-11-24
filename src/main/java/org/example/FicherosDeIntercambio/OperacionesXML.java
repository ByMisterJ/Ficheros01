package org.example.FicherosDeIntercambio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.FicherosDeIntercambio.Entities.Lenguaje2;
import org.example.FicherosDeIntercambio.Entities.ListaLenguajes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Jackson es una biblioteca Java popular para trabajar con JSON,
// pero también puede ser utilizada para trabajar con XML.
public class OperacionesXML {

    public static Lenguaje2 leerObjetoXml(Path ruta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(ruta.toFile(), Lenguaje2.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Lenguaje2> leerArrayObjetosXml(Path ruta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // return xmlMapper.readValue(ruta.toFile(), new TypeReference<List<Lenguaje2>>() { });
            return xmlMapper.readValue(ruta.toFile(), new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String escribirObjetoXml(Lenguaje2 lenguaje) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el XML se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return xmlMapper.writeValueAsString(lenguaje);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String escribirListaObjetosXml(List<Lenguaje2> lenguajes) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el XML se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return xmlMapper.writeValueAsString(lenguajes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Si queremos serializar una lista de objetos, se pueden manipular las etiquetas XML creando
    // una clase auxiliar que contenga la lista de objetos y que tenga la etiqueta raíz
    public static String escribirListaObjetosXmlv2(ListaLenguajes lenguajes) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el XML se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return xmlMapper.writeValueAsString(lenguajes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escribirListaObjetosXml(ListaLenguajes lenguajes, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), lenguajes);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    public static void main(String[] args) throws IOException {
        Path ficheroObjetoXml = Path.of(".", "src", "main", "resources", "lenguaje.xml");
        System.out.println("\n**** Lectura de objeto XML desde fichero ****");
        System.out.println(leerObjetoXml(ficheroObjetoXml));

        Path ficheroArrayObjetosXml = Path.of(".", "src", "main", "resources", "lenguajes.xml");
        System.out.println("\n**** Lectura de array de objetos XML desde fichero ****");
        leerArrayObjetosXml(ficheroArrayObjetosXml).forEach(System.out::println);

        Lenguaje2 lenguaje1 = new Lenguaje2("Solidity", 180, false, List.of("María", "Sonia", "José Miguel"));
        Lenguaje2 lenguaje2 = new Lenguaje2("Vyper", 160, false, List.of("Pepe", "Julián"));

        List<Lenguaje2> lenguajes = List.of(lenguaje1, lenguaje2);

        ListaLenguajes listaLenguajes = new ListaLenguajes(lenguajes);

        System.out.println("\n**** Escritura de objeto XML por consola ****");
        System.out.println(escribirObjetoXml(lenguaje1));

        System.out.println("\n**** Escritura de lista de objetos XML por consola ****");
        System.out.println(escribirListaObjetosXml(lenguajes));

        System.out.println("\n**** Escritura de lista de objetos XML por consola v2 ****");
        System.out.println(escribirListaObjetosXmlv2(listaLenguajes));

        Path ejemploEscrituraXml = Path.of(".", "src", "main", "resources", "escritura.xml");

        System.out.println("\n**** Escritura de lista de objetos XML a fichero ****");
        escribirListaObjetosXml(listaLenguajes, ejemploEscrituraXml);


    }

}

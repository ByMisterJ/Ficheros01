package org.example.MapeoJson.Atletas_xml;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<AtletaFemenina> atletas= new ArrayList<AtletaFemenina>();
        ArrayList<String> pruebas = new ArrayList<String>();
        pruebas.add("100 metros lisos");
        pruebas.add("lanzamiento javalina");
        pruebas.add("natacion");
        pruebas.add("pertiga");
        pruebas.add("baloncesto");
        AtletaFemenina a1=new AtletaFemenina("Carolina",pruebas,24,"España");
        AtletaFemenina a2=new AtletaFemenina("Maria",pruebas,26,"Portugal");
        AtletaFemenina a3=new AtletaFemenina("Jana",pruebas,25,"EEUU");
        AtletaFemenina a4=new AtletaFemenina("Natasha",pruebas,29,"Ucrania");
        atletas.add(a1);
        atletas.add(a2);
        atletas.add(a3);
        atletas.add(a4);

        Path ruta = Path.of("src/main/java/org/example/MapeoJson/Atletas_xml/atletas_femeninas.xml");
        try {
            Files.deleteIfExists(ruta);
            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            Lista list = new Lista(atletas);
            mapper.writeValue(ruta.toFile(), list);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

package org.example.MapeoJson.deportistas;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.MapeoJson.deportistas.DeportistaFemenina;

import java.util.ArrayList;
import static org.example.MapeoJson.Constant.JSON_MAPPER;
import java.io.File;

public class MainDeportistas {
    public static void main(String[] args) {
        ArrayList<DeportistaFemenina> deportistas = new ArrayList<DeportistaFemenina>();
        DeportistaFemenina d1=new DeportistaFemenina("Carolina","badminton",30,"España");
        DeportistaFemenina d2=new DeportistaFemenina("Katie","natacion",26,"EEUU");
        DeportistaFemenina d3=new DeportistaFemenina("Queralt","snowboar",34,"España");
        deportistas.add(d1);
        deportistas.add(d2);
        deportistas.add(d3);
        try {
            JSON_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
            JSON_MAPPER.writeValue(new File("/home/daw2/Documents/Server/Ficheros/src/main/java/org/example/MapeoJson/deportistas_femeninas.json"), deportistas);
        }catch (Exception e){
            System.err.println("Algo a ido mal");
        }
    }
}

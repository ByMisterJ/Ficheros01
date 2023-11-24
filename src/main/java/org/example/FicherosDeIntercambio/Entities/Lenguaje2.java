package org.example.FicherosDeIntercambio.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
//@JacksonXmlRootElement(localName = "lenguaje")
public class Lenguaje2 {

    //@JacksonXmlProperty(isAttribute = true)
    private String nombre;
    private int sueldo;
    private boolean compilado;
    //@JacksonXmlElementWrapper(localName = "programadores")
    //@JacksonXmlProperty(localName = "programador")
    private List<String> programadores;

    /*
    public Lenguaje(String nombre, int sueldo, boolean compilado, List<String> programadores) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.compilado = compilado;
        this.programadores = programadores;
    }

    public Lenguaje() {
    }

     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setCompilado(boolean compilado) {
        this.compilado = compilado;
    }

    public void setProgramadores(List<String> programadores) {
        this.programadores = programadores;
    }

    @Override
    public String toString() {
        return "Lenguaje{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", compilado=" + compilado +
                ", programadores=" + programadores +
                '}';
    }

}

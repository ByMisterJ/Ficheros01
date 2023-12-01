package org.example.MapeoJson.Atletas_xml;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JacksonXmlRootElement(localName = "atleta")
class AtletaFemenina implements Serializable {

    @JacksonXmlProperty(localName = "nombre")
    private String nombre;
    @JacksonXmlProperty(localName = "prueba")
    @JacksonXmlElementWrapper(localName = "pruebas")
    private List<String> pruebas;
    @JacksonXmlProperty(localName = "edad")
    private int edad;
    @JacksonXmlProperty(localName = "pais")
    private String pais;
}

package org.example.MapeoJson.Atletas_xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lista {
    @JacksonXmlElementWrapper(localName = "atletas")
    private ArrayList<AtletaFemenina> atleta;
}

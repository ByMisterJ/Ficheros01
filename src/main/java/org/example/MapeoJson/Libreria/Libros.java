package org.example.MapeoJson.Libreria;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libros {
    private int isbn;
    private String titulo;
    private String autor;
    private int anyo_publicacion;
}

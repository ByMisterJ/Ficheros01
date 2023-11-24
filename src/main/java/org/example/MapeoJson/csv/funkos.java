package org.example.MapeoJson.csv;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class funkos {
    private String cod;
    private String nombre;
    private String modelo;
    private Double precio;
    private LocalDate fecha_lanzamiento;
}

package org.example.FicherosDeIntercambio.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListaLenguajes {
    private List<Lenguaje2> lenguajes;

    public void setLenguajes(List<Lenguaje2> lenguajes) {
        this.lenguajes = lenguajes;
    }

    @Override
    public String toString() {
        return "ListaLenguajes{" +
                "lenguajes=" + lenguajes +
                '}';
    }
}

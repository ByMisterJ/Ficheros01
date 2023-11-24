package org.example.MapeoJson.deportistas;

public class DeportistaFemenina {
    private String nombre;
    private String deporte;
    private int edad;
    private String pais;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public DeportistaFemenina(String nombre, String deporte, int edad, String pais) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.edad = edad;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "DeportistaFemenina{" +
                "nombre='" + nombre + '\'' +
                ", deporte='" + deporte + '\'' +
                ", edad=" + edad +
                ", pais='" + pais + '\'' +
                '}';
    }

}

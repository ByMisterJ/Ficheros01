package org.example.MapeoJson.productos;

public class Producto {
    private String Nombre;
    private String Modelo;
    private int precio;
    private float valoracion;
    public Producto() {}
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getModelo() {
        return Modelo;
    }
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public float getValoracion() {
        return valoracion;
    }
    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre='" + Nombre + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", precio=" + precio +
                ", valoracion=" + valoracion +
                '}';
    }
}
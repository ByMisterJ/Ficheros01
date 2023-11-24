package org.example.serializacion;

public class Uso {
    public static void main(String[] args) {

        Contacto contacto1 = new Contacto("patri", "123", "email", "direccion", 1, 2);
        Contacto contacto2 = new Contacto("neus", "123", "email", "direccion", 2, 1);

        //Escritura de datos
        ContactoOutput salida= new ContactoOutput();
        try {
            salida.abrir();
            salida.escribir(contacto1);
            salida.escribir(contacto2);
            salida.cerrar();
        } catch (Exception e) {

        }

        //Lectura de datos
        Contacto contacto;
        ContactoInput entrada;

        entrada = new ContactoInput();
        try {
            entrada.abrir();
            do {
                contacto = entrada.leer();
                System.out.println(contacto.getNombre());
                System.out.println(contacto.getTelefono());
            } while ((contacto != null));
            entrada.cerrar();
        } catch (Exception e) {

        }
    }
}

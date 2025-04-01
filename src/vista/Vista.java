package src.vista;

import java.util.Scanner;

/**
 * Clase abstracta base para las vistas de la aplicación.
 * Define una estructura común para las interfaces que muestran información
 * al usuario o reciben entradas de este.
 */
public abstract class Vista {

    private static Scanner entrada = new Scanner(System.in);

    /**
     * Constructor por defecto.
     */
    public Vista() {}

    /**
     * Muestra un error en la consola utilizando la traza de la excepción.
     *
     * @param e Excepción que contiene la información del error.
     */
    public void mostrarError(Exception e) {
        e.printStackTrace();
    }

    /**
     * Muestra un mensaje informativo en la consola.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Devuelve el objeto Scanner compartido para entrada de usuario.
     *
     * @return Instancia de Scanner.
     */
    public static Scanner getScanner (){
        return entrada;
    }

}

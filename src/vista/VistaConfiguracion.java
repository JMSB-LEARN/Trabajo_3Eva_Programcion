package src.vista;

/**
 * Vista encargada de mostrar mensajes y errores relacionados con la configuración de la aplicación.
 */
public class VistaConfiguracion extends Vista {

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
}

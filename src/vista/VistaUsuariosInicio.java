package src.vista;

import java.util.Scanner;

/**
 * Vista encargada de comunicarse con el usuario en el inicio de sesión.
 * Solicita datos y muestra mensajes relacionados con el acceso del usuario.
 */
public class VistaUsuariosInicio extends Vista {

    private static Scanner entrada = Vista.getScanner();

    /**
     * Constructor por defecto.
     */
    public VistaUsuariosInicio() {}

    /**
     * Solicita al usuario que introduzca su nombre.
     *
     * @return Nombre introducido por el usuario.
     */
    public String pedirNombreUsuario(){
        mostrarMensaje("Dame tu nombre de usuario");
        return entrada.nextLine();
    }

    /**
     * Solicita al usuario que introduzca su correo electrónico.
     * Si el campo se deja vacío, se considera cancelada la operación.
     *
     * @return Correo electrónico introducido por el usuario, o cadena vacía si se cancela.
     */
    public String pedirCorreoElectronico(){
        mostrarMensaje("Dame un correo electrónico para crear tu cuenta (Si se deja vacío se cancelará la creación de cuenta)");
        return entrada.nextLine();
    }
}

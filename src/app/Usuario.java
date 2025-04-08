package src.app;

import java.io.Serializable;

/**
 * Clase que representa a un usuario de la aplicación.
 * Contiene el nombre y el correo electrónico del usuario.
 */
public class Usuario implements Serializable {

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Correo electrónico del usuario.
     */
    private String correoElectronico;

    /**
     * Crea un nuevo usuario con el nombre y correo electrónico proporcionados.
     *
     * @param nombre Nombre del usuario.
     * @param correoElectronico Correo electrónico del usuario.
     */
    public Usuario(String nombre, String correoElectronico){
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return Correo electrónico del usuario.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
}
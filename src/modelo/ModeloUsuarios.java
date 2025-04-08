package src.modelo;

import src.app.Usuario;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase encargada de gestionar el almacenamiento y recuperación de usuarios.
 * Utiliza serialización para guardar y cargar objetos {@link Usuario}.
 */
public class ModeloUsuarios extends Modelo{

    private final Path carpetaUsuarios = Paths.get("Personaje");

    /**
     * Constructor por defecto.
     */
    public ModeloUsuarios() {}

    /**
     * Verifica si existe un archivo de usuario con el nombre proporcionado.
     *
     * @param nombreUsuario Nombre del usuario a verificar.
     * @return {@code true} si el usuario existe; {@code false} en caso contrario.
     */
    public boolean existeUsuario(String nombreUsuario) {
        return Files.exists(carpetaUsuarios.resolve(nombreUsuario + ".bin"));
    }

    /**
     * Lee un usuario desde un archivo binario en la carpeta correspondiente.
     *
     * @param nombreUsuario Nombre del usuario a cargar.
     * @return Objeto {@link Usuario} deserializado.
     * @throws IOException Si ocurre un error de entrada/salida.
     * @throws ClassNotFoundException Si la clase del objeto no puede ser encontrada.
     */
    public Usuario leerUsuario(String nombreUsuario) throws IOException, ClassNotFoundException {
        Path archivo = carpetaUsuarios.resolve(nombreUsuario + ".bin");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(archivo))) {
            return (Usuario) ois.readObject();
        }
    }

    /**
     * Guarda un objeto {@link Usuario} en un archivo binario en la carpeta correspondiente.
     *
     * @param usuario Usuario que se desea guardar.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardarUsuario(Usuario usuario) throws IOException {
        Path archivo = carpetaUsuarios.resolve(usuario.getNombre() + ".bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(archivo))) {
            oos.writeObject(usuario);
        }
    }
}
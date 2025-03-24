package app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase principal de la aplicación que permite la creación de archivos o directorios
 * en el sistema de archivos mediante el uso de la enumeración {@link TipoArchivo}.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("J");
    }

    /**
     * Crea un archivo o directorio en la ruta especificada con el nombre y tipo dados.
     *
     * @param nombre Nombre del archivo o directorio a crear.
     * @param path Ruta donde se debe crear el archivo o directorio.
     * @param tipo Tipo de archivo a crear (archivo regular o directorio).
     * @return {@code true} si el archivo o directorio fue creado correctamente; 
     *         {@code false} en caso de error.
     */
    private boolean crearFicheroArchivo(String nombre, Path path, TipoArchivo tipo) {
        try {
            Path pathArchivo = path.resolve(nombre);

            switch (tipo) {
                case TipoArchivo.Archivo -> { Files.createFile(pathArchivo); }
                case TipoArchivo.Directorio -> { Files.createDirectory(pathArchivo); }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return false;
    }

    /**
     * Crea un archivo o directorio en el directorio actual con el nombre y tipo dados.
     *
     * @param nombre Nombre del archivo o directorio a crear.
     * @param tipo Tipo de archivo a crear (archivo regular o directorio).
     * @return {@code true} si el archivo o directorio fue creado correctamente; 
     *         {@code false} en caso de error.
     */
    private boolean crearFicheroArchivo(String nombre, TipoArchivo tipo) {
        try {
            return crearFicheroArchivo(nombre, Paths.get(""), tipo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

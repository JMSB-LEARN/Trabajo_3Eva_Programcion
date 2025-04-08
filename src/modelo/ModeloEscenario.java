package src.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo encargado de manejar el archivo del escenario en la aplicación.
 * Se asegura de que el archivo del escenario exista y contenga una estructura básica.
 */
public class ModeloEscenario extends Modelo {

    private static final String archivo = "Escenario/escenario1.txt";
    private static final Integer columnas = 10;
    private static final Integer filas = 10;

    /**
     * Constructor por defecto.
     * Inicializa una instancia del modelo de escenario sin parámetros adicionales.
     */
    public ModeloEscenario() {}

    /**
     * Comprueba si existe el archivo escenario1.txt y, en caso negativo, lo crea.
     * Además, exista o no, después de comprobarlo escribe en el archivo.
     *
     * @throws Exception Si ocurre un error durante la verificación o creación.
     */
    public static void crearYEscribirArchivo() throws Exception{
        Path rutaArchivo = Paths.get(archivo);

        try {
            if (Files.notExists(rutaArchivo)) {
                Files.createFile(rutaArchivo);
            }

            if (Files.size(rutaArchivo) == 0) {
                List<String> contenido = generarEscenario();
                Files.write(rutaArchivo, contenido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para generar el contenido dentro del escenario. Genera un borde superior e inferior,
     * y líneas centrales representando las filas del escenario.
     *
     * @return Devuelve una lista de cadenas que representan la estructura del escenario.
     */
    private static List<String> generarEscenario() {
        List<String> escenario = new ArrayList<>();

        String bordeHorizontal = "_".repeat(columnas * 2 + 1);
        String filaMedia = "|" + " ".repeat(columnas * 2 - 1) + "|";

        escenario.add(bordeHorizontal);

        for (int i = 0; i < filas; i++) {
            escenario.add(filaMedia);
        }

        escenario.add(bordeHorizontal);

        return escenario;
    }
}

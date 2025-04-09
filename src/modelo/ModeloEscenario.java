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
    private static String[][] escenario = new String[filas][columnas];

    /**
     * Constructor por defecto.
     * Inicializa una instancia del modelo de escenario sin parámetros adicionales.
     */
    public ModeloEscenario() {}

    /**
     * Comprueba si existe el archivo escenario1.txt y, si no existe, lo crea.
     * Si el archivo está vacío, lo rellena automáticamente.
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
                String[] lineas = {
                    "1I,2O,1E,1O,1E,2O,1E,1F",
                    "3E,3O,",          
                    "4O,3E,2O",     
                    "",
                    "",
                    "2E,1O,1E,1O,1E,1O,1E,1O",
                    "1O,1E,1O,1E,1O,1E,1O,1E,1O", 
                    "1O,3E,3O", 
                    "3O,6E,1O", 
                    "7O,1E,1F,1O" 
                };

                llenarEscenario(lineas);
                List<String> contenido = generarEscenario();
                Files.write(rutaArchivo, contenido);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Llena la matriz del escenario interpretando cada línea como una secuencia de bloques.
     * Si la línea está vacía, se llena completamente de 'E'.
     * @param lineas Estas lineas es la version reducida de lo que contiene el archivo
     */

    private static void llenarEscenario(String[] lineas){
        for (int i = 0; i < filas; i++) {
            if (i >= lineas.length || lineas[i].trim().isEmpty()) {
                for (int j = 0; j < columnas; j++) {
                    escenario[i][j] = "E";
                }
            } else {
                String[] bloques = lineas[i].split(",");
                int col = 0;

                for (String bloque : bloques) {
                    bloque = bloque.trim();
                    if (bloque.length() < 2) continue;

                    int cantidad = Integer.parseInt(bloque.substring(0, bloque.length() - 1));
                    String tipo = String.valueOf(bloque.charAt(bloque.length() - 1));

                    for (int k = 0; k < cantidad && col < columnas; k++) {
                        escenario[i][col++] = tipo;
                    }
                }

                while (col < columnas) {
                    escenario[i][col++] = "E";
                }
            }
        }
    }

    /**
     * Método para generar el contenido dentro del escenario. Genera un borde superior e inferior,
     * y líneas centrales representando las filas del escenario.
     *
     * @return Devuelve una lista de cadenas que representan la estructura del escenario.
     */
    private static List<String> generarEscenario() {
        List<String> contenido = new ArrayList<>();
        String bordeHorizontal = "—".repeat(columnas * 2 + 1);
        contenido.add(columnas + "x" + filas);
        contenido.add(bordeHorizontal);

        for (int i = 0; i < filas; i++) {
            StringBuilder fila = new StringBuilder("|");
            for (int j = 0; j < columnas; j++) {
                fila.append(escenario[i][j]);
                if (j < columnas - 1) fila.append(",");
            }
            fila.append("|");
            contenido.add(fila.toString());
        }

        contenido.add(bordeHorizontal);
        return contenido;
    }
}

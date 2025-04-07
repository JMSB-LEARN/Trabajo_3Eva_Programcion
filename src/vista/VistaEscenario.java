package src.vista;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class VistaEscenario {
    private static final String archivo = "Escenario/escenario1.txt";

    public static void mostrarEscenario() {
        Path rutaArchivo = Paths.get(archivo);
        
        try {
            List<String> lineas = Files.readAllLines(rutaArchivo);

            for (String linea : lineas) {
                System.out.println(linea);
            }
        } 
        catch (IOException e){
            e.printStackTrace();
        }
    } 
}

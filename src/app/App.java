package src.app;

import src.controlador.ControladorPrincipal;

/**
 * Clase principal de la aplicación.
 * Inicia el controlador principal al ejecutarse.
 */
public class App {

	/**
 	* Constructor por defecto para que javadoc no se queje.
 	*/
	public App() {}


    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        new ControladorPrincipal().iniciar();
    }
}
package src.controlador;

import src.modelo.ModeloEscenario;
import src.vista.VistaEscenario;

/**
 * Controlador encargado de coordinar la vista y el modelo del escenario.
 */

public class ControladorEscenario extends Controlador {

    private VistaEscenario vista;

    /**
     * Constructor del controlador.
     * @param vista Vista asociada a este controlador.
     */
    public ControladorEscenario(VistaEscenario vista) {
        this.vista = vista;
    }

/**
     * Método principal de inicio. Se encarga de generar y guardar el archivo del escenario.
     * Llama a métodos del modelo y notifica a la vista si ha sido un exito o si algo a ocurrido durante el proceso.
     */
    @Override
    public void iniciar() {
        try {
            ModeloEscenario.crearYEscribirArchivo();
            //En caso de que todo haya salido bien
            vista.mostrarMensaje("Escenario creado correctamente.");
        } catch (Exception e) {
            //En caso de que haya ocurrido algun error.
            vista.mostrarMensaje("Error al crear el escenario: " + e.getMessage());
        }
    }
}

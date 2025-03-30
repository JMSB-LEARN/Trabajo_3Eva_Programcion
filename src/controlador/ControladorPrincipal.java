package src.controlador;

import src.modelo.ModeloConfiguracion;
import src.vista.VistaConfiguracion;

/**
 * Controlador principal de la aplicación.
 * Se encarga de iniciar la aplicación comprobando la configuración inicial
 * y mostrando los mensajes correspondientes mediante la vista.
 */
public class ControladorPrincipal extends Controlador {

    static ModeloConfiguracion modeloConfiguracion = new ModeloConfiguracion();
    static VistaConfiguracion vistaConfiguracion = new VistaConfiguracion();

    /**
     * Inicia la aplicación verificando la existencia de los archivos de configuración.
     * En caso de éxito, muestra un mensaje informativo; en caso de error, muestra el error correspondiente.
     */
    public void iniciar() {
        try {
            vistaConfiguracion.mostrarMensaje(modeloConfiguracion.comprobarConfig());
        } catch (Exception e) {
            vistaConfiguracion.mostrarError(e);
        }
    }
}

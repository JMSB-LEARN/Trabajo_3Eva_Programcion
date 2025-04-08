package src.controlador;

import src.modelo.ModeloConfiguracion;
import src.vista.VistaConfiguracion;
import src.vista.Vista;
import src.modelo.Modelo;

/**
 * Controlador encargado de gestionar la configuración desde la vista.
 */
public class ControladorConfiguracion extends Controlador {
	private VistaConfiguracion vistaConfiguracion ;
	private ModeloConfiguracion modeloConfiguracion;

    /**
     * Constructor por defecto.
     * Inicializa la vista de configuración y el modelo encargado de gestionar dicha configuración.
     */
    ControladorConfiguracion(){
        this.vistaConfiguracion = new VistaConfiguracion();
        this.modeloConfiguracion = new ModeloConfiguracion();
    }

    /**
     * Inicia el proceso de configuración.
     * Verifica si los archivos y directorios necesarios existen y los crea si es necesario.
     */
    @Override
    public void iniciar(){
        iniciarlizarConfiguracion();
    }

    /**
     * Inicializa la configuración de la aplicación verificando o creando
     * los archivos y directorios necesarios.
     */
    public void iniciarlizarConfiguracion() {
        try {
            vistaConfiguracion.mostrarMensaje(modeloConfiguracion.comprobarConfig());
        } catch (Exception e) {
            vistaConfiguracion.mostrarError(e);
            System.exit(1);
        }
    }


}
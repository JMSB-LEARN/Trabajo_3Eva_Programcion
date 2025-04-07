package src.controlador;

import src.modelo.ModeloConfiguracion;
import src.vista.VistaConfiguracion;

public class ControladorConfiguracion extends Controlador{
	private Vista vistaConfiguracion ;
	private Modelo modeloConfiguracion;

	ControladorConfiguracion(){
		this.vistaConfiguracion = new VistaConfiguracion();
		this.modeloConfiguracion = new ModeloConfiguracion();
	}

	@Override
	public iniciar(){
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
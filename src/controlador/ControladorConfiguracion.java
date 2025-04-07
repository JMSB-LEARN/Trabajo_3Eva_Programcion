package src.controlador;

import src.modelo.ModeloConfiguracion;
import src.vista.VistaConfiguracion;
import src.vista.Vista;
import src.modelo.Modelo;

public class ControladorConfiguracion extends Controlador{
	private VistaConfiguracion vistaConfiguracion ;
	private ModeloConfiguracion modeloConfiguracion;

	ControladorConfiguracion(){
		this.vistaConfiguracion = new VistaConfiguracion();
		this.modeloConfiguracion = new ModeloConfiguracion();
	}

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
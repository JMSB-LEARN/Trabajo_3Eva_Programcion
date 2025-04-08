package src.controlador;

import src.modelo.Modelo;
import src.controlador.ControladorConfiguracion;
import src.controlador.ControladorComprobarUsuario;

/**
 * Controlador principal de la aplicación.
 * Se encarga de iniciar la aplicación comprobando la configuración inicial
 * y mostrando los mensajes correspondientes mediante la vista.
 */
public class ControladorPrincipal extends Controlador {
    private Controlador controladorComprobarUsuario;
    private Controlador controladorConfiguracion;


    /**
     * Constructor por defecto.
     */
    public ControladorPrincipal() {
        this.controladorConfiguracion=new ControladorConfiguracion();
        this.controladorComprobarUsuario=new ControladorComprobarUsuario();

    }

    /**
     * Inicia la aplicación verificando la existencia de los archivos de configuración.
     * En caso de éxito, muestra un mensaje informativo; en caso de error, muestra el error correspondiente.
     */
    public void iniciar() {
        controladorConfiguracion.iniciar();
        controladorComprobarUsuario.iniciar();
    }


   
}
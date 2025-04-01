package src.controlador;

import src.modelo.ModeloConfiguracion;
import src.modelo.ModeloUsuarios;
import src.app.Usuario;
import src.vista.VistaConfiguracion;
import src.vista.VistaUsuariosInicio;

/**
 * Controlador principal de la aplicación.
 * Se encarga de iniciar la aplicación comprobando la configuración inicial
 * y mostrando los mensajes correspondientes mediante la vista.
 */
public class ControladorPrincipal extends Controlador {

    static ModeloConfiguracion modeloConfiguracion = new ModeloConfiguracion();
    static ModeloUsuarios modeloUsuarios = new ModeloUsuarios();
    static VistaConfiguracion vistaConfiguracion = new VistaConfiguracion();
    static VistaUsuariosInicio vistaUsuariosInicio = new VistaUsuariosInicio();
    static Usuario jugador;

    /**
     * Constructor por defecto.
     */
    public ControladorPrincipal() {}

    /**
     * Inicia la aplicación verificando la existencia de los archivos de configuración.
     * En caso de éxito, muestra un mensaje informativo; en caso de error, muestra el error correspondiente.
     */
    public void iniciar() {
        iniciarlizarConfiguracion();
        comprobarUsuario();
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

    /**
     * Comprueba si el usuario ya existe. Si no existe, crea uno nuevo.
     * También gestiona la carga o guardado del usuario.
     */
    public void comprobarUsuario() {
        String nombreUsuario = "";
        nombreUsuario = vistaUsuariosInicio.pedirNombreUsuario();
        if (modeloUsuarios.existeUsuario(nombreUsuario)) {
            try {
                jugador = modeloUsuarios.leerUsuario(nombreUsuario);
                vistaUsuariosInicio.mostrarMensaje("Usuario cargado correctamente");
            } catch (Exception e) {
                System.exit(2);
            }
        } else {
            vistaUsuariosInicio.mostrarMensaje("Usuario no reconocido, creando uno nuevo");
            String correo = obtenerCorreoElectronico();
            if (correo.isEmpty()) {
                System.exit(2);
            }
            jugador = new Usuario(nombreUsuario, correo);
            try {
                modeloUsuarios.guardarUsuario(jugador);
                vistaUsuariosInicio.mostrarMensaje("Usuario guardado correctamente");
            } catch (Exception e) {
                System.exit(2);
            }
        }
        vistaUsuariosInicio.mostrarMensaje("Comprobacion de usuario exitosa");
    }

    /**
     * Solicita y valida un correo electrónico introducido por el usuario.
     *
     * @return Correo electrónico válido o cadena vacía si se cancela.
     */
    public String obtenerCorreoElectronico() {
        String correo = "";
        boolean correoCorrecto = false;
        do {
            correo = vistaUsuariosInicio.pedirCorreoElectronico();
            if (correo.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$")) {
                correoCorrecto = true;
            } else {
                vistaUsuariosInicio.mostrarMensaje("El correo no es correcto, \nSolo puede contener letras, números, puntos, guiones y guiones bajos antes de la arroba, seguido de un dominio con una extensión como .com o .org.");
            }
        } while (!correoCorrecto && !correo.isEmpty());
        return correo;
    }
}
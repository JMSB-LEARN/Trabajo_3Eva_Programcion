package src.controlador;

import src.vista.VistaUsuariosInicio;
import src.modelo.ModeloUsuarios;
import src.app.Usuario;

public class ControladorComprobarUsuario extends Controlador{
	private VistaUsuariosInicio vistaUsuariosInicio ;
	private ModeloUsuarios modeloUsuarios;
    private Usuario jugador;

	ControladorComprobarUsuario(){
		this.vistaUsuariosInicio = new VistaUsuariosInicio();
		this.modeloUsuarios = new ModeloUsuarios();
	}


	@Override
	public void iniciar(){
		comprobarUsuario();
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
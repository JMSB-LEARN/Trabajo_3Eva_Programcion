package src.modelo;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileAlreadyExistsException;
import src.app.TipoArchivo;

/**
 * Modelo encargado de gestionar la configuración inicial de la aplicación.
 * Comprueba la existencia del archivo de configuración y crea la estructura base
 * con los directorios necesarios.
 */
public class ModeloConfiguracion extends Modelo {

    /**
     * Constructor por defecto.
     */
    public ModeloConfiguracion() {}

	/**
	 * Comprueba si existe el archivo de configuración y, en caso contrario, lo crea
	 * junto a los directorios para Personaje, Escena y Partida.
	 *
	 * @return Mensaje indicando si se creó la estructura o si ya existía.
	 * @throws Exception Si ocurre un error durante la verificación o creación.
	 */
	public String comprobarConfig() throws Exception {
		final Path rutaInicial = Paths.get("");
		final Path configFiles = rutaInicial.resolve("config.json");
		String mensajeFinalizacion="PlaceHolder";

		if (Files.notExists(configFiles)) {
			crearArbolBase(rutaInicial);
			mensajeFinalizacion="Archivos creados con exito.";
		}else{
			mensajeFinalizacion="Archivo de configuracion ya existente.";
		}
		return mensajeFinalizacion;
	}

    /**
     * Crea la estructura base de archivos y directorios necesaria para la aplicación.
     * Incluye la creación de un archivo de configuración y directorios para "Personaje",
     * "Escena" y "Partida". Si alguno de estos elementos ya existe, no se lanza error.
     *
     * @param rutaInicial Ruta base donde se deben crear los archivos y directorios.
     * @throws Exception Si ocurre un error durante la creación de los elementos.
     */
	public void crearArbolBase(Path rutaInicial) throws Exception {
		Map<String, TipoArchivo> archivosCrear = new HashMap<String, TipoArchivo>();
		archivosCrear.put("config.json", TipoArchivo.Archivo);
		archivosCrear.put("Personaje", TipoArchivo.Directorio);
		archivosCrear.put("Escena", TipoArchivo.Directorio);
		archivosCrear.put("Partida", TipoArchivo.Directorio);
		for (var entry : archivosCrear.entrySet()) {
			try {
				crearFicheroArchivo(entry.getKey(), entry.getValue(), rutaInicial);
			} catch (FileAlreadyExistsException e) {
                // evitar que muestre error;
			}
		}
	}

	/**
	 * Crea un archivo o directorio en la ruta especificada con el nombre y tipo
	 * dados.
	 *
	 * @param nombre Nombre del archivo o directorio a crear.
	 * @param tipo   Tipo de archivo a crear (archivo regular o directorio).
	 * @param path   Ruta donde se debe crear el archivo o directorio.
	 * @return {@code true} si el archivo o directorio fue creado correctamente;
	 *         {@code false} en caso de error.
	 */
	private boolean crearFicheroArchivo(String nombre, TipoArchivo tipo, Path path) throws Exception{
		Path pathArchivo = path.resolve(nombre);
		boolean resultado=false;

		switch (tipo) {
		case TipoArchivo.Archivo ->{resultado=true; Files.createFile(pathArchivo);}
		case TipoArchivo.Directorio ->{resultado=true; Files.createDirectory(pathArchivo);}
		default ->{ resultado=false; throw new Exception("Tipo No Reconocido");}
		}

		return resultado;
	}

	/**
	 * Crea un archivo o directorio en el directorio actual con el nombre y tipo
	 * dados.
	 *
	 * @param nombre Nombre del archivo o directorio a crear.
	 * @param tipo   Tipo de archivo a crear (archivo regular o directorio).
	 * @return {@code true} si el archivo o directorio fue creado correctamente;
	 *         {@code false} en caso de error.
	 */
	private boolean crearFicheroArchivo(String nombre, TipoArchivo tipo) throws Exception {
		return crearFicheroArchivo(nombre, tipo, Paths.get(""));
	}

}

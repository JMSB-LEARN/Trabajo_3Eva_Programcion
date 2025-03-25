package app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase principal de la aplicación
 */
public class App {

	public static void main(String[] args) {
		comprobarConfig();
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
	private static boolean crearFicheroArchivo(String nombre, TipoArchivo tipo, Path path) {
		try {
			Path pathArchivo = path.resolve(nombre);

			switch (tipo) {
			case TipoArchivo.Archivo -> {Files.createFile(pathArchivo);}
			case TipoArchivo.Directorio -> {Files.createDirectory(pathArchivo);}
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
	private static boolean crearFicheroArchivo(String nombre, TipoArchivo tipo) {
		try {
			return crearFicheroArchivo(nombre, tipo, Paths.get(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Comprueba si existe el archivo de configuracion y en caso contrario
	 * lo crea junto a los directorios para Personaje, Escenario y Partida
	 */
	private static void comprobarConfig(){
		Path rutaInicial = Paths.get("");
		Path configFiles = rutaInicial.resolve("config.json");

		if(Files.notExists(configFiles)){
			crearFicheroArchivo("config", TipoArchivo.Archivo, rutaInicial);
			crearFicheroArchivo("Personaje", TipoArchivo.Directorio, rutaInicial);
			crearFicheroArchivo("Escena", TipoArchivo.Directorio, rutaInicial);
			crearFicheroArchivo("Partida", TipoArchivo.Directorio, rutaInicial);
		}
	}
}

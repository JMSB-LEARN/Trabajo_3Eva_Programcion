package app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) {
		System.out.println("J");

	}

	private boolean crearFicheroArchivo(String nombre, Path path, TipoArchivo tipo) {
		try {
			Path pathArchivo = path.resolve(nombre);

			switch (tipo) {

			case TipoArchivo.Archivo -> {Files.createFile(pathArchivo);}
			case TipoArchivo.Directorio -> {Files.createDirectory(pathArchivo);}
			}

		} catch (Exception e) {

		}
		return false;
	}

	private boolean crearFicheroArchivo(String nombre, TipoArchivo tipo) {
		try {
			return crearFicheroArchivo(nombre, Paths.get(""), tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
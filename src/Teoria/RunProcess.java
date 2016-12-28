package Teoria;

import java.io.IOException;
import java.util.Arrays;

//Modelo asíncrono: Los dos trabajan al mismo tiempo y en paralelo
public class RunProcess {
	public static void main(String[] args) throws IOException {
		if (args.length <= 0) { //Es que no hay programa .EXE en ARGS
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1); //Salir
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			Process process = pb.start(); //Iniciar proceso
			int retorno = process.waitFor(); //Sirve para que el progrma se detenga
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			System.exit(-1);
		}
	}
}
package Tarea1_ProcesosEnJava;

import java.io.IOException;

public class RuntimeProcess {
	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			process.destroy();
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}
	}
}

/* A) No ha ocurrido nada, el programa se ejecuta y termina al instante por motivo
 * del process.destroy(), cuya función es finalizar el programa.
 * 
 * B) Al comentar la línea process.destroy(), el programa se ejecuta, abre notepad.exe y termina
 */
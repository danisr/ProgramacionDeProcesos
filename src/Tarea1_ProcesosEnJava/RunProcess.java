package Tarea1_ProcesosEnJava;

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {
	public static void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		ProcessBuilder pb2 = new ProcessBuilder(args);
		try {
			Process process = pb.start();			
			int retorno = process.waitFor();			
			System.out.println("La ejecuci�n de 1� calculadora" + Arrays.toString(args) + "devuelve " + retorno);
			
			Process process2 = pb2.start();
			int retorno2 = process2.waitFor();
			System.out.println("La ejecuci�n de 2� calculadora" + Arrays.toString(args) + "devuelve " + retorno2);
			
		} catch (IOException ex) {
			System.err.println("Excepci�n de E/S!!");
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finaliz� de forma incorrecta");
			System.exit(-1);
		}
	}
}
/* a) Los pasos a seguir han sido los siguientes: Run Configurations..., pesta�a de Arguments
 * y se escribe "calc.exe". A continuaci�n pulsar en Run y se abre la calculadora. Por consola
 * devuelve "La ejecuci�n de [calc.exe]devuelve 0".
 * 
 * b) Al no escribir nada en Arguments, devuelve por consola el siguiente error:
 * "Se necesita un programa a ejecutar"
 * 
 * c) Pasamos por argumentos "calc.exe" Y "notepad.exe" y se abre la calculadora pero no el notepad
 * 
 * d) Para ejecutar dos calculadores seguidas creamos otro proceso con su start() y waitor()
 */
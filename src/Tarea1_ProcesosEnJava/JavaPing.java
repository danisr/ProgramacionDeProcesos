package Tarea1_ProcesosEnJava;

import java.io.*;

public class JavaPing {
	public static void main(String[] args) {
		Runtime runTime = Runtime.getRuntime(); //Devuelve el objeto runTime
		Process process = null;
		try {
			process = runTime.exec("ping " + args[0]); //Ejecuta el proceso
			
			//Conecta a la salida normal del subproceso y se guarda en la variable (in)
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			//Con este bucle se imprimen 10 líneas con saludo, más lo que tiene la variable (in) en cada línea leída
			for (int i = 0; i < 10; i++)
				System.out.println("Saludo " + in.readLine());
		} catch (IOException e) {
			System.out.println("No pudimos correr el ping");
			System.exit(-1);
		}
		if (process != null) //Si el proceso es distinto de null se destruye
			process.destroy();
		try {
			process.waitFor(); //No tiene sentido esta línea ya que el proceso muere en el process.destroy(), por lo tanto no entra en el try/catch
		} catch (InterruptedException e) {
			System.out.println("No pudimos esperar por témino");
			System.exit(-1); //Se ejecuta después de un error
		}
		//Imprime el estatus de término, que en este ejercicio siempre es uno
		System.out.println("Estatus de término: " + process.exitValue());
		System.exit(0);
	}
}

/*
 * A)
 * Para la IP de Google (74.125.224.72 ) nos devuelve: Saludo Ping statistics
 * for 74.125.224.72: Saludo Packets: Sent = 4, Received = 0, Lost = 4 (100%
 * loss), Saludo null Estatus de témino: 1
 * 
 * PAra la IP de Youtube ( 74.125.39.136 ) nos devuelve: Saludo Ping statistics
 * for 74.125.39.136: Saludo Packets: Sent = 4, Received = 0, Lost = 4 (100%
 * loss), Saludo null Estatus de témino: 1 
 * 
 * Para una IP no válida (24.127.09.196) devuelve: Saludo Ping request could not find host 24.127.09.196. Please check the name and try again.
 * 
 * Para una IP no válida(34.125.724.0) devuelve: Saludo Ping request could not find host 34.125.724.0. Please check the name and try again.
 *
 *B) Se comenta en el código
 * 
 */
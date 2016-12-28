package Tarea1_ProcesosEnJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ComunicationBetweenProcess {
	
	public static void main(String args[]) throws IOException {
		Process process = new ProcessBuilder(args).start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		System.out.println("Salida del proceso " + Arrays.toString(args) + ":");
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
/*
 * a) Lo que se obtiene por pantalla es lo siguiente: Salida del proceso
 * [cmd.exe]: Microsoft Windows [Version 10.0.10586] (c) 2016 Microsoft
 * Corporation. All rights reserved.
 * Primero ejecuta el Syso que está antes del While, luego entra al While y muestra
 * las dos líneas que tiene por defecto el CMD al abrirse
 * 
 * b) Sale igual, pero al incluir UTF-8 los caracteres especiales salen bien representados
 * 
 * c)
 * 
 */
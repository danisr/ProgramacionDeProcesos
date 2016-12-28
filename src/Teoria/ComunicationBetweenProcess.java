package Teoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

//Modelo S�ncrono
public class ComunicationBetweenProcess {
	public static void main(String args[]) throws IOException {
		Process process = new ProcessBuilder(args).start();
		InputStream is = process.getInputStream(); //Engancha con el proceso hijo
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		System.out.println("Salida del proceso " + Arrays.toString(args) + ":");
		while ((line = br.readLine()) != null) { //Mientras haya algo que leer
			System.out.println(line);
		}
	}
}
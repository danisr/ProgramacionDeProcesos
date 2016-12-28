package Tarea2_Multiprogramacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PadreAleatorios {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String textoPadre = "";
		ProcessBuilder pb;
		Process process = null;

		try {
			//Ejecucion del jar (clase Hijo)
			pb = new ProcessBuilder("java", "-jar", "Hijo_Aleatorios.jar");
			process = pb.start();

			//stdin del proceso hijo
			OutputStream out = process.getOutputStream();
			PrintStream ps = new PrintStream(out);

			//stdout del proceso hijo
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while (!textoPadre.equals("fin")) {
				System.out.print("Escriba una palabra: ");
				textoPadre = scan.nextLine();
				ps.println(textoPadre);
				ps.flush();

				if (!textoPadre.equals("fin")) {
					//stdin del proceso padre
					String line;
					line = br.readLine();
					System.out.println("Salida del proceso hijo: " + line);
				} else {
					System.out.println("Finalizacion del proceso Hijo. Fin del programa");
					process.destroy();
				}
			}
			br.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
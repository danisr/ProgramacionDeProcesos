package Tarea2_Multiprogramacion;

import java.util.Scanner;

public class HijoAleatorios {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String entrada = "";
		while (!entrada.equals("fin")) {
			entrada = scan.nextLine();
			if (!entrada.equals("fin")) {
				int numAleatorio = (int) (Math.random() * 11);
				System.out.println(numAleatorio);
			}
		}
	}
}
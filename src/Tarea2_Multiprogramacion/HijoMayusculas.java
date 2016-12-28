package Tarea2_Multiprogramacion;

import java.util.Scanner;

public class HijoMayusculas {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String entrada = "";
		while (!entrada.equals("fin")) {
			entrada = scan.nextLine();
			if (!entrada.equals("fin")) {
				String mayus = entrada.toUpperCase();
				System.out.println(mayus);
			}
		}
	}
}
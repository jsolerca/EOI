package es.eoi.io;

import java.util.Scanner;

public class EjercicioA {

	public static void main(String[] args) {
		
		boolean running = true;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String line = "";
		String lineTotal = "";
		System.out.println("Ejercicio 1");
		System.out.println("Introduzca texto: ");
		
		do {
			line = scan.nextLine();
			
			if(line.equalsIgnoreCase("END")) {
				running = false;
			} else {
				lineTotal = lineTotal.concat(line).concat("\n");
			}
			
		} while (running);
		
		System.out.println("");
		System.out.println("Finalizada Entrada de Datos");
		System.out.println("Los datos introducidos han sido:");
		System.out.println(lineTotal);
		
	}

}

package es.eoi.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Ejercicio 3");
		
		String opcion;
		String filename = "diarioEjercicio3.txt";
		
		try {
			
			do {
				System.out.println("Seleccione una opción:");
				System.out.println("1 - Escribir diario");
				System.out.println("2 - Leer diario");
				
				opcion = scan.nextLine();
				
				switch (opcion) {
				case "1":
					escribirDiario(filename, scan);
					break;
					
				case "2":
					try {
						leerDiario(filename);
					}  catch (FileNotFoundException e) {
						System.out.println("El fichero no existe");
					}
					break;
					
				default:
					System.out.println("Opcion incorrecta");
					running = false;
					break;
				}
				
			} while (running);
		
		} catch (IOException e) {
			System.out.println("Se ha producido un error");
		}

	}

	public static void escribirDiario(String filename, Scanner scan) throws IOException {
		System.out.println("Escriba su diario:");
		//Escritura
		boolean runningWrite = true;
		String line = "";
		do {
			line = scan.nextLine();
			if(line.equalsIgnoreCase("FIN")) {
				runningWrite = false;
			} else {
				FileWriter fw = new FileWriter(filename, true);
				fw.write(line.concat("\n"));
				fw.close();
			}
		} while (runningWrite);
		
	}

	public static void leerDiario(String filename) throws IOException {
		//Lectura
		String strLine = "";
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		System.out.println("El contenido del diario es:");
		while (strLine != null) {
			strLine = br.readLine();
			if(strLine != null) {
				System.out.println(strLine);
			}
		}
		br.close();
	}

}

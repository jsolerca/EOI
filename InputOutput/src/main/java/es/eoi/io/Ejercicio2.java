package es.eoi.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		String strLine = "";
		try {
			//Escritura
			String filename = "ficheroEjercicio2.txt";
			FileWriter fw = new FileWriter(filename, false);
			fw.write("Ejercicio 2\n");
			fw.write("Ejecución del Ejercicio 1 - Calculadora\n");
			fw.write("Introduzca el primer número: \n");
			fw.write("2\n");
			fw.write("Introduzca el segundo número: \n");
			fw.write("5\n");
			fw.write("La suma de los números introducidos es: 7");
			fw.close();

			//Lectura
			FileReader fr = new FileReader("ficheroEjercicio2.txt");
			BufferedReader br = new BufferedReader(fr);
			System.out.println("El contenido del fichero ficheroEjercicio2.txt es:");
			while (strLine != null) {
				sb.append(strLine);
				sb.append(System.lineSeparator());
				strLine = br.readLine();
				if(strLine != null) {
					System.out.println(strLine);
				}
			}
			br.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

}

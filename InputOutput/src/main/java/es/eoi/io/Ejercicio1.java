package es.eoi.io;

import java.util.Scanner;

public class Ejercicio1 {
	
	public static int suma(int a, int b) {
		return a+b;
	}

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int a;
		int b;
		int total;
		
		System.out.println("Ejercicio 1 - Calculadora");
		
		System.out.println("Introduzca el primer n�mero: ");
		a = scan.nextInt();
		
		System.out.println("Introduzca el segundo n�mero: ");
		b = scan.nextInt();
		
		total = suma(a,b);
		
		System.out.println("La suma de los n�meros introducidos es: ".concat(String.valueOf(total)));
		
	}

}

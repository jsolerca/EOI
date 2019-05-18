package es.eoi.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Asignatura {

	String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

class Calificacion {

	double calificacion;
	Asignatura asignatura;

	public Calificacion(Asignatura asignatura, double nota) {
		this.calificacion = nota;
		this.asignatura = asignatura;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
}

class Alumno {

	String nombre;
	String apellidos;
	int edad;
	List<Calificacion> notas;

	public Alumno(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public List<Calificacion> getNotas() {
		return notas;
	}

	public void setNotas(List<Calificacion> notas) {
		this.notas = notas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}

public class Ejercicio4 {

	public static void main(String[] args) {

		Asignatura a1 = new Asignatura();
		a1.setNombre("Matemáticas");
		Asignatura a2 = new Asignatura();
		a2.setNombre("Inglés");
		Asignatura a3 = new Asignatura();
		a3.setNombre("Física");

		List<Calificacion> notas = new ArrayList<Calificacion>();
		Calificacion ca1 = new Calificacion(a1, 5);
		notas.add(ca1);
		Calificacion ca2 = new Calificacion(a2, 4.9);
		notas.add(ca2);
		Calificacion ca3 = new Calificacion(a3, 4);
		notas.add(ca3);

		Alumno alu1 = new Alumno("A", "X", 31);
		Alumno alu2 = new Alumno("E", "Y", 30);
		Alumno alu3 = new Alumno("I", "Z", 31);
		alu1.setNotas(notas);
		alu2.setNotas(notas);
		alu3.setNotas(notas);
		
		Alumno[] clase = {alu1, alu2, alu3};
		
		String result = "";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();		
		result = result.concat(gson.toJson(clase));
		System.out.println(result);
		
		try {
		
			
			System.out.println("Guardando...");
			guardarAlumno("jsonEjercicio4.json", result);
			System.out.println("Leyendo...");
			String json = recuperarAlumnos("jsonEjercicio4.json");
			System.out.println(json);
			Alumno[] claseRecuperada = gson.fromJson(json, Alumno[].class);
			System.out.println("alumnos recuperados ".concat(String.valueOf(claseRecuperada.length)));
		} catch (Exception e) {
			System.out.println("Se ha producido un error");
		}
	}

	private static String recuperarAlumnos(String filename) throws IOException {
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		while (strLine != null) {
			strLine = br.readLine();
			if(strLine != null) {
				sb.append(strLine);
				sb.append(System.lineSeparator());
			}
		}
		
		br.close();
		return sb.toString();
	}

	private static void guardarAlumno(String filename, String json) throws IOException {
		// Escritura
		FileWriter fw = new FileWriter(filename, false);
		fw.write(json);
		fw.close();
	}
	
	private static void prueba1(int a, int b) {
		
		switch(a) {
			case 1:
				if(b == 0) {
					System.out.println(1);
				}
			break;
			case 2:
				if(b == 1) {
					System.out.println(2);
				}
			break;
			default:
				if(b == 1) {
					System.out.println(3);
				} else {
					System.out.println(4);
				}
			break;
		}
		
	}

}

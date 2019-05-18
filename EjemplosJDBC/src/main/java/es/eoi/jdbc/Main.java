package es.eoi.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	
	public static void ejercicio1(String url, String user, String pass) {
		try {
			//Establecemos Conexión
			Connection conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado a ".concat(url));
			
			//Inicializamos Statement
			Statement st = conexion.createStatement();
			
			//Ejecutamos y Recuperamos la consulta SQL
			ResultSet rs = st.executeQuery("SELECT * FROM CLIENTES");
			System.out.println("SELECT * FROM CLIENTES");
			
			//Recorremos los datos obtenidos (si los hay)
			while (rs.next()) {
				System.out.print(rs.getString("DNI").concat(" - "));
				System.out.print(rs.getString("NOMBRE").concat(" - "));
				System.out.println(rs.getString("DIR"));
			}
			
			st.close();
			conexion.close();
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error.");
			e.printStackTrace();
		} 
	}
	
	public static void ejercicio2(String url, String user, String pass) {
		try {
			//Establecemos Conexión
			Connection conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado a ".concat(url));
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append("FROM CLIENTES ");
			sql.append("WHERE DNI = ? ");
			sql.append("OR NOMBRE LIKE ? ");
			System.out.println(sql.toString());
			
			//Inicializamos PreparedStatement
			PreparedStatement pst = conexion.prepareStatement(sql.toString());
			pst.setString(1, "1112");
			pst.setString(2, "%rio");
			
			//Ejecutamos y Recuperamos la consulta SQL
			ResultSet rs = pst.executeQuery();
			
			//Recorremos los datos obtenidos (si los hay)
			while (rs.next()) {
				System.out.print(rs.getString("DNI").concat(" - "));
				System.out.print(rs.getString("NOMBRE").concat(" - "));
				System.out.println(rs.getString("DIR"));
			}
			
			pst.close();
			conexion.close();
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error.");
			e.printStackTrace();
		} 
	}
	
	public static void ejercicio3(String url, String user, String pass) {
		try {
			//Establecemos Conexión
			Connection conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conectado a ".concat(url));
			
			//Inicializamos CallableStatement
			CallableStatement cst = conexion.prepareCall("CALL SP_CLIENTES");
			
			//Ejecutamos y Recuperamos la consulta SQL
			ResultSet rs = cst.executeQuery();
			
			//Recorremos los datos obtenidos (si los hay)
			while (rs.next()) {
				System.out.print(rs.getString("DNI").concat(" - "));
				System.out.print(rs.getString("NOMBRE").concat(" - "));
				System.out.println(rs.getString("DIR"));
			}
			
			cst.close();
			conexion.close();
			
		} catch (Exception e) {
			System.out.println("Se ha producido un error.");
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ej_eoi?serverTimezone=UTC";
		String user = "root";
		String pass = "1234";
		
		//Statement
		ejercicio1(url, user, pass);
		
		//PreparedStatement
		ejercicio2(url, user, pass);
		
		//CallableStatement
		ejercicio3(url, user, pass);

		
	}
}

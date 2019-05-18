package es.eoi.novedades;

public class Ejercicio1 implements Interfaz1,Interfaz2 {
	

	public static void main(String[] args) {
		new Ejercicio1().saluda();
	}

	@Override
	public void saluda() {
		// TODO Auto-generated method stub
		Interfaz1.super.saluda();
	}

}

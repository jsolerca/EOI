package es.eoi.novedades;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		ICalculadoraLambda iSuma 			= (x,y) -> x + y;
		ICalculadoraLambda iResta			= (x,y) -> x - y;

		System.out.println(iSuma.operacion(2, 5));
		System.out.println(iSuma.operacion(1, 0));
		System.out.println(iSuma.operacion(0, 4));
		
		System.out.println(iResta.operacion(1, 0));
		System.out.println(iResta.operacion(6, 1));
		System.out.println(iResta.operacion(2, 12));

		
	}

}

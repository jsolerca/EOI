package es.eoi.novedades;

public class Ejercicio3 {
	
	public interface IText {
		public String transform (String x);
	}

	public static void main(String[] args) {
		
		IText IUpper = (x) -> {
			String retorno = x;
			retorno = retorno.toUpperCase();
			return retorno;
		};
		
		IText ILower = (x) -> {
			String retorno = x;
			retorno = retorno.toLowerCase();
			return retorno;
		};
		
		System.out.println(IUpper.transform("Hola Soy Javier"));
		System.out.println(ILower.transform("Hola Soy Javier"));
		
	}

}

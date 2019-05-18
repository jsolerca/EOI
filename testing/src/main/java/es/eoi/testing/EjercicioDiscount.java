package es.eoi.testing;

public class EjercicioDiscount {

	public static void discount(int x) {
		if (x <= 14) {
			System.out.println("no discount");
		} else if (x >= 15 && x < 50) {
			System.out.println("discount 1%");
		} else if (x >= 50 && x < 120) {
			System.out.println("discount 5%");
		} else if (x >= 120) {
			System.out.println("discount 10%");
		}
	}

}

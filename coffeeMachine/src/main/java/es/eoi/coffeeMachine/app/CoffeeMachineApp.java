package es.eoi.coffeeMachine.app;

import es.eoi.coffeeMachine.entities.Coffee;
import es.eoi.coffeeMachine.entities.Milk;
import es.eoi.coffeeMachine.entities.Sugar;
import es.eoi.coffeeMachine.exceptions.CoffeeException;
import es.eoi.coffeeMachine.services.BebidaCaliente;
import es.eoi.coffeeMachine.services.BebidaCalienteImpl;

public class CoffeeMachineApp {

	
	public static void main(String[] args) {
		
		BebidaCaliente service = new BebidaCalienteImpl();
		
		try {
			System.out.println(service.orderCoffee(new Milk(), new Coffee(), new Sugar()));
			System.out.println(service.orderCoffee(null, new Coffee(), null));
			System.out.println(service.orderCoffee(new Milk(), null, new Sugar()));
		} catch (CoffeeException e) {
			System.out.println("Lo siento, no me queda café :(");
		} catch (Exception e) {
			System.out.println("Lo siento, se ha producido un error");
		}
	}
}

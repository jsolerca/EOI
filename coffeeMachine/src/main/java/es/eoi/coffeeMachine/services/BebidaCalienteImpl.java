package es.eoi.coffeeMachine.services;

import es.eoi.coffeeMachine.entities.Coffee;
import es.eoi.coffeeMachine.entities.CoffeeCup;
import es.eoi.coffeeMachine.entities.Milk;
import es.eoi.coffeeMachine.entities.Sugar;
import es.eoi.coffeeMachine.exceptions.CoffeeException;

public class BebidaCalienteImpl implements BebidaCaliente {

	public CoffeeCup orderCoffee(Milk milk, Coffee coffee, Sugar sugar) throws CoffeeException {
		
		CoffeeCup cup = null;
		
		if (coffee == null) {
			throw new CoffeeException();
		} else {
			cup = new CoffeeCup(coffee, milk, sugar);
		}
		
		return cup;
	}

}

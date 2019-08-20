package es.eoi.coffeeMachine.services;

import es.eoi.coffeeMachine.entities.*;
import es.eoi.coffeeMachine.exceptions.CoffeeException;

public interface BebidaCaliente {
	
	public CoffeeCup orderCoffee(Milk milk, Coffee coffee, Sugar sugar) throws CoffeeException;

}

package es.eoi.coffeeMachine.entities;

public class CoffeeCup {
	
	private Coffee myCoffee;
	
	private Milk myMilk;
	
	private Sugar mySugar;

	public CoffeeCup(Coffee myCoffee, Milk myMilk, Sugar mySugar) {
		this.myCoffee = myCoffee;
		this.myMilk = myMilk;
		this.mySugar = mySugar;
	}

	public Coffee getMyCoffee() {
		return myCoffee;
	}

	public void setMyCoffee(Coffee myCoffee) {
		this.myCoffee = myCoffee;
	}

	public Milk getMyMilk() {
		return myMilk;
	}

	public void setMyMilk(Milk myMilk) {
		this.myMilk = myMilk;
	}

	public Sugar getMySugar() {
		return mySugar;
	}

	public void setMySugar(Sugar mySugar) {
		this.mySugar = mySugar;
	}

	@Override
	public String toString() {
		return String.format("CoffeeCup [myCoffee=%s, myMilk=%s, mySugar=%s]", myCoffee, myMilk, mySugar);
	}
	
	

	
	
	
}

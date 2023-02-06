package vending_machine;


public class Drink extends Item {
	
	private float ounces;
	private String type;	// soda, water, other - want enum here?
	
	// constructor
	public Drink(String name, float calories, String itemType, float ounces, String type) {
		super(name, calories, itemType);
		this.ounces = ounces;
		this.type = type;
	}
	
	// getters
	public float getOunces() {return ounces;}
	public String getType() {return type;}

	// setters
	public void setOunces(float ounces) {this.ounces = ounces;}
	public void setType(String type) {this.type = type;}

	@Override
	public String toString() {
		return "NAME: " + this.getName() + " | " + 
				"CALORIES: " + this.getCalories() + " | " + 
				"ITEMTYPE: " + this.getItemType() + " | " + 
				"OUNCES: " + this.getOunces() + " | " + 
				"TYPE: " + this.getType() ;
	}
	
	
	
	
}

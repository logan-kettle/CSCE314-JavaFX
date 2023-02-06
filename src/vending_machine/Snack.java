package vending_machine;


public class Snack extends Item {
	
	private float weight;
	private boolean containsNuts;
	
	// constructor with Item super constructor
	public Snack(String name, float calories, String itemType, float weight, boolean containsNuts) {
		super(name, calories, itemType);
		this.weight = weight;
		this.containsNuts = containsNuts;
	}

	// getters
	public float getWeight() {return weight;}
	public boolean isContainsNuts() {return containsNuts;}
	
	// setters
	public void setWeight(float weight) {this.weight = weight;}
	public void setContainsNuts(boolean containsNuts) {this.containsNuts = containsNuts;}

	@Override
	public String toString() {
		return "NAME: " + this.getName() + " | " + 
				"CALORIES: " + this.getCalories() + " | " + 
				"ITEMTYPE: " + this.getItemType() + " | " + 
				"WEIGHT: " + this.getWeight() + " | " + 
				"CONTAINSNUTS: " + this.isContainsNuts() ;
	}
	
	
	
	
}

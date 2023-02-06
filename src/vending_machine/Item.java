package vending_machine;


public class Item {
	
	private String name;
	private float calories;
	private String itemType;
	
	// constructor
	public Item(String name, float calories, String itemType) {
		this.name = name;
		this.calories = calories;
		this.itemType = itemType;
	}
	
	// getters
	public String getName() {return name;}
	public float getCalories() {return calories;}
	public String getItemType() {return itemType;}
	
	// setters
	public void setName(String name) {this.name = name;}
	public void setCalories(float calories) {this.calories = calories;}
	public void setItemType(String itemType) {this.itemType = itemType;}
	
}

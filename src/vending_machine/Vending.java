package vending_machine;

import java.io.*;
import java.util.*;

public class Vending {
	
	public ArrayList<String> directory;	// array of product names parallel with slots
	public ArrayList< ArrayList<Item> > slots;		// array of queues of items
	
	public Vending(ArrayList<String> dir) {
		slots = new ArrayList< ArrayList<Item> >();		// creates empty slots directory
		this.loadItems(dir);
		this.directory = new ArrayList<String>();
		for (ArrayList<Item> al : slots) {
			directory.add(al.get(0).getName());		// fill up directory with just the string names
		}
	}
	
	// return/parameters open to your interpretation
	public void loadItems(ArrayList<String> lines) {
		// parse data passed in to sort into respective slots
		// basically fill up slots attribute
		
		// Item constructor: String name, float calories, String itemType
		// based on first item on line, declare Drink or Snack
		String name;
		float calories;
		String itemType;	// using same name as attribute but just the first parsed element
		int amt;
		
		// specific to Snack
		float weight = 0;
		boolean containsNuts = false;
		
		// specific to Drink
		float ounces = 0;
		String type = "";
		
		// parses line, adds whatever item to the slots list the correct number of times 
		// 
		for (String s : lines) {
			StringTokenizer tokenizer = new StringTokenizer(s, ", ");
			
			// both have
			itemType = tokenizer.nextToken();
			name = tokenizer.nextToken();
			calories = Float.parseFloat(tokenizer.nextToken());
			
			if (itemType.equals("Snack")) {
				weight = Float.parseFloat(tokenizer.nextToken());
				containsNuts = Boolean.parseBoolean(tokenizer.nextToken());
			}
			else if (itemType.equals("Drink")) {
				ounces = Float.parseFloat(tokenizer.nextToken());
				type = tokenizer.nextToken();
			}
			else {
				System.out.println("ERROR: neither Drink nor Snack");
			}
			
			// both have the amount in their queue
			amt = Integer.parseInt(tokenizer.nextToken());
			
			/*
			System.out.println("itemType: " + itemType + " | " + 
					"name: " + name + " |\n " + 
					"calories: " + calories + " | " + 
					"weight: " + weight + " |\n " + 
					"containsNuts: " + containsNuts + " | " + 
					"ounces: " + ounces + " |\n " + 
					"type: " + type + " | " +
					"amt: " + amt + "\n");
			*/
			
			if (itemType.equals("Snack")) {
				Snack snack = new Snack(name, calories, itemType, weight, containsNuts);
				// create new queue to add in each item according to amount in slot
				ArrayList to_add = new ArrayList();
				
				// adds the number of snacks to the queue
				for (int i=0; i<amt; i++) {
					to_add.add(snack);
					
				}
				this.slots.add(to_add);
			}
			else if (itemType.equals("Drink")) {
				Drink drink = new Drink(name, calories, itemType, ounces, type);
				// create new queue to add in each item according to amount in slot
				ArrayList to_add = new ArrayList();
				for (int i=0; i<amt; i++) {
					to_add.add(drink);
					
				}
				this.slots.add(to_add);
			}
			else {
				System.out.println("this should not happen");
			}
		}
		
	}
	
	public void unloadItem(Integer index) {
		// logic check to avoid empty slots of item - spoken about at beginning of rubric
		String itemName = this.directory.get(index);		// gets product name
		
		// itemSlots and itemAvailability are parallel so when we find which slot has
		// the maximum number of the needed item, with itemAvailability, we can get
		// which slot it actually is from itemSlots
		ArrayList<Integer> itemSlots = this.findProduct(itemName);		// returns list of slots with needed item
		
		
		int max_index_val = 0;
		// if there is only one slot with the product, we can only pull from that slot
		if (itemSlots.size() >= 1) {
			max_index_val = itemSlots.get(0);
			ArrayList<Integer> itemAvailability = new ArrayList<Integer>();
			for (Integer ind : itemSlots) {
				itemAvailability.add(this.slots.get(ind).size());		// adds size of queue at each index in parallel to slots with needed item
			}
			
			int max_index = 0;
			for(int i=0; i<itemAvailability.size();i++) {
				if (itemAvailability.get(i) > itemAvailability.get(max_index)) {
					// the parallel index
					max_index = i;		// finding which slot of itemSlots holds the most number of product
				}
			}
			
			// the actual slot index
			max_index_val = itemSlots.get(max_index);		// gives value (index) at the slot that holds the most of products	
		}
		else { // if there are no slots with the product
			System.out.println("No more " + itemName + " available");
			return;
		}
		
		this.slots.get(max_index_val).remove(0);	// removes first index of slot with most availability
		
	}
	
	public void unloadItem(ArrayList<Integer> choices) {
		// receive user choices from DataFile
		// call on original unloadItem -- only used to process file
		for(Integer c : choices) {
			this.unloadItem(c);
		}
		
	}
	
	public ArrayList<Integer> findProduct(String productName) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		// returns the index numbers that match the product
		for (int i=0;i<this.slots.size();i++) {
			if (productName.equals(this.directory.get(i)) & (this.slots.get(i).size() > 0)) {	// checking parameter with first element name of each queue
				indices.add(i);
			}
		}
		return indices;
	}
	
	// MUST HAVE DECONSTRUCTOR BUT I DON'T REALLY KNOW HOW TO DO THAT YET
	// JVM HANDLES IT
	
//	public void finalize() {
//		displayItems();
//	}
	
	public void displayItems() {
		System.out.print(this.toString());
	}
	
	@Override
	public String toString() {
		/*
		String to_return = "DIRECTORY: \n";
		to_return = to_return.concat(directory.toString() + "\n");
				
		to_return = to_return.concat("SLOTS: \n");

		int inc = 0;
		
		for (ArrayList<Item> al : slots) {
			to_return = to_return.concat("SLOT " + inc + ": ");
			for (Item i : al) {
				to_return = to_return.concat(i.getName() + " ");
			}
			to_return = to_return.concat("\n");
			inc++;
		}
		return to_return;
		*/
		
		String to_return = new String("");
		for (int i=0;i<directory.size();i++) {
			to_return = to_return.concat(directory.get(i) + ": (");
			if (slots.get(i).size() > 0) {
				if (slots.get(i).get(0).getItemType().equals("Drink")) {
					Drink item = (Drink) slots.get(i).get(0);
					to_return = to_return.concat(item.getType() + "): " + 
					slots.get(i).size() + "\n");
				}
				else {
				to_return = to_return.concat(slots.get(i).get(0).getItemType() + "): " + 
						slots.get(i).size() + "\n");
				}
			}
			else {
				to_return = to_return.concat("N/A" + "): 0\n");
			}
					
		}
		return to_return;
		
	}

}

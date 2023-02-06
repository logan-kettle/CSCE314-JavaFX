package vending_machine;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //load data from file
	    
	    DataFile myData = new DataFile("directory.txt", "input.txt");

	    //initialize Vending machine with loaded data
	    ArrayList <String> myVending = myData.loadDirectory();
	    ArrayList <Integer> mySelections = myData.loadSampleInput();

	    Vending myMachine = new Vending(myVending);
	    System.out.println(myMachine.toString());
	    System.out.println();
	    
	    // Test line to show items before removing initially
	    System.out.println("Items originally there:");
	    System.out.print(myMachine.toString()); //debug helper function, REALLY NEEDS toString()
	    System.out.println("______________________________\n");
	    
	    //remove items
	    myMachine.unloadItem(mySelections);
	    System.out.println("Items removed final count: ");

	    //Final output to display after removing
	    System.out.println(myMachine.toString()); //debug helper function, REALLY NEEDS toString()
	    System.out.println("done.");
	    
//	    System.out.println("collecting garbage...");
//	    
//	    myMachine = null;
//	    
//	    System.gc();
	    
	    /*****************/
	    // Above DisplayItems() call is fine, but the Vending machine's deconstructor 
	    // should call that function since it's the LAST operation. Notice it could be
	    // done with a helper function that USES the toString()
	    // We will NOT call DisplayItems() in testing 
	    /*****************/
	    
	    
	}

}
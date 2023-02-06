package vending_machine;


import java.io.*;
import java.util.*;

public class DataFile {
	
	private String directoryFileName;
	private String inputFileName;
	
	public DataFile(String dfn, String ifn) {
		this.directoryFileName = dfn;
		this.inputFileName = ifn;
	}
	
	
	// produces array list of strings - each string is a line from 
	// the directory file - represents vending machine contents
	public ArrayList<String> loadDirectory() {
		// access directoryFileName and start loading
		
		// are we debugging
		boolean debug = false;
		
		// testing for file existence
		Scanner infile = null;
		try {
			infile = new Scanner(new FileReader(this.directoryFileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}
		
		String line = "";
		ArrayList<String> to_return = new ArrayList<String>();
		
		while(infile.hasNextLine()) {
			line = infile.nextLine();
			to_return.add(line);
		}
		
		if (debug) {
			System.out.println("checking stuff for loadDirectory...");
			// System.out.println(to_return.toString());
			int i=0;
			for (String s : to_return) {
				System.out.print(i++);
				System.out.print(": ");
				System.out.println(s);
			}
			System.out.println("done.");
		}
		
		// the returned value is an array of strings, each string being the slot in the vending machine and its descriptors
		return to_return;
	}
	
	
	// returns array list of integers, splitting input.txt by line
	// represents user selections
	public ArrayList<Integer> loadSampleInput() {
		// access inputFileName and start loading
		
		// are we debugging
			boolean debug = false;
			
			// testing for file existence
			Scanner infile = null;
			try {
				infile = new Scanner(new FileReader(this.inputFileName));
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found");
				e.printStackTrace();
				System.exit(0);
			}
			
			int num = 0;
			ArrayList<Integer> to_return = new ArrayList<Integer>();
			
			while(infile.hasNextLine()) {
				num = infile.nextInt();
				to_return.add(num);
			}
			
			if (debug) {
				System.out.println("checking stuff for loadSampleInput...");
				// System.out.println(to_return.toString());
				int i=0;
				for (int n : to_return) {
					System.out.print(i++);
					System.out.print(": ");
					System.out.println(n);
				}
				System.out.println("done.");
			}
		
		
		// returns array of integers that represent the user's choices
		return to_return;
	}
}

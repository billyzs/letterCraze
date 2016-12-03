package common.model;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

/** Defines a dictionary for a letterCraze level, which contains all strings a Word object can 
 * form on from the tiles on the board.
 * 
 * @author Adam Camilli (aocamilli@wpi.edu)
 * @author Grant Espe
 *
 */
public class Dictionary {
	
	// The look up table for the dictionary
	Hashtable<String,Boolean> table;
	
	// Scanner for reading files
	Scanner sc;
	
	// The default file (located in letterCraze)
	public static final String defaultTable = "WordTable.sort";

	// Default constructor, which populates table from defaultTable
	public Dictionary() throws IOException {
		table = new Hashtable<String,Boolean>();
		sc = new Scanner(new File(defaultTable));
		
		// Populate table
		String s;
		while (sc.hasNextLine()) {
			s = sc.nextLine().trim();
			table.put(s, Boolean.TRUE);
		} sc.close();
	}
	
	// Constructor to form dictionary using an alternate Hashtable
	public Dictionary(Hashtable<String,Boolean> alternate){
		table = alternate;
	}
	
	public boolean isWord(String s) {
		return table.containsKey(s.toLowerCase());
	}

}

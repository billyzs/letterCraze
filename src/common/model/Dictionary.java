package common.model;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
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

	/** The look up table for the dictionary. */
	HashSet<String> table;
	
	/** Scanner for reading files. */
	Scanner sc;
	
	/** The default file (located in letterCraze). */
	public static final String defaultTable = "./WordTable.sort";

	/**
	 *  Default constructor, which populates table from defaultTable file.
	 * @throws IOException
	 */
	public Dictionary() throws IOException {
		table = new HashSet<String>();
		sc = new Scanner(new File(defaultTable));
		
		// Populate table
		String s;
		while (sc.hasNextLine()) {
			s = sc.nextLine().trim();
			table.add(s);
		} sc.close();
	}
	
	/**
	 * Constructor to form <code>Dictionary</code> using an alternate <code>HashSet</code>.
	 * @param alternate
	 */
	public Dictionary(HashSet<String> alternate){
		table = alternate;
	}
	
	/**
	 * Constructor to form <code>Dictionary</code> from an array of strings.
	 * @param words
	 */
	public Dictionary(String[] words){
		table = new HashSet<String>();
		for(String word : words){
			this.table.add(word.toLowerCase());
		}
	}
	
	/**
	 * Returns whether a string in is contained in the <code>Dictionary</code> object. 
	 * @param s A string
	 * @return Whether or not s is in this object.
	 */
	public boolean isWord(String s) {
		return table.contains(s.toLowerCase());
	}

	public HashSet<String> getTable() {
		return table;
	}
}

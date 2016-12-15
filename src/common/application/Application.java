package common.application;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.controller.StartLevelController;
import common.view.LevelView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

import common.model.*;
import common.view.*;

/**
 * Parent class for all applications having to do with letterCraze as well as the top-level <code>JFrame</code> for all boundary objects.
 * @author Team Technetium
 */
public class Application extends JFrame {

	protected Model model; 
	protected WelcomeView welcome;
	protected MenuView menu;
	
	//To be removed on the merge to dev
	public Application(){}
	
	/**
	 * Usable constructor to host code used by most extensions of <code>Application</code> to take in entity objects and open their frame.
	 * @param m The <code>Model</code> object containing entity objects for letterCraze.
	 */
	public Application(Model m) {
		this.model = m;

		//initialize window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 645);
		ContentPane.setContentPanel(new JPanel());
		ContentPane.get().setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContentPane.get());
		ContentPane.get().setLayout(null);
		ContentPane.get().setLayout(new GridLayout(0, 1, 0, 0));

	}

	public MenuView getMenu(){ return this.menu; }
	
	/**
	 * Load the 15 level files available by default to all letterCraze <code>Applications</code>.
	 * @return An <code>ArrayList</code> of <code>Level</code> objects.
	 */
	public static ArrayList<Level> loadDefaultLevels(){
		ArrayList<Level> result = new ArrayList<Level>();
		try{
            for(int k = 1; k <= 5; k++){
                result.add(loadLevel("Puzzle_Level_"+k+".lvl"));
                result.add(loadLevel("Lightning_Level_"+k+".lvl"));
                result.add(loadLevel("Theme_Level_"+k+".lvl"));
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Loads levels besides the default levels in folder /levels.
	 * @return returns an arraylist of levels, besides default levels.
	 */
	public static ArrayList<Level> loadOtherLevels(){
		File folder = new File("./levels");
		ArrayList<String> filenames = new ArrayList<String>();
        for (File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                filenames.add(fileEntry.getName());
            }
		}
        
        ArrayList<Level> result = new ArrayList<Level>();

        //cycle through filenames
        for(String s : filenames){
        	boolean isDefault = false;

        	//shitty way of checking if its a default level
            for(int k = 1; k <= 5; k++){
                if(s.equals("Puzzle_Level_"+k+".lvl")
                    || (s.equals("Lightning_Level_"+k+".lvl"))
                    || (s.equals("Theme_Level_"+k+".lvl"))){
                	isDefault = true;
                }
            }

            //if it isnt default, add to result
            if(!isDefault){
                try {
                	System.out.println("Loading " + s);
                    result.add(loadLevel(s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
	}

	/** Either this or another controller is used to create a <code>Level</code> object from a specifically formatted 
	 * text file.
	 * @param filename Name of the file.
	 * @return A Level object.
	 * @throws IOException
	 */
	public static Level loadLevel(String filename) throws IOException{

		//read a file
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./levels/" + filename));
            
            //get first three args
            String type = br.readLine();
            String name = br.readLine();
            int highscore = Integer.parseInt(br.readLine());

            //read next three ints as starvals
            int targetScore= Integer.parseInt(br.readLine());

            //read in whether it is unlocked
            boolean isUnlocked = false;
            if(br.readLine().equals("true"))
            	isUnlocked = true;

            ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
            
            
            //read in board as 6 lines
            String row;
            for(int r = 0; r < 6 && (row = br.readLine()) != null; r++){

            	//add new row
            	tiles.add(new ArrayList<Tile>());

            	//cycle through the string, adding tiles to the array
            	char[] chars = row.toCharArray();
            	for(int c = 0; c < chars.length; c++){
            		if(chars[c] == '1'){
            			Tile newTile = new Tile(r,c);

            			tiles.get(r).add(newTile);
            			
            			//assign it a random letter
            		}
            		else{
            			tiles.get(r).add(new NullTile(r, c));
            		}
            	}
            }
            
            int ligthningSeconds = 0;
            //System.out.println("NOT YET"+ ligthningSeconds + type);
            if (type.equals("Lightning")) {
            	ligthningSeconds = Integer.parseInt(br.readLine());
            	//System.out.println("WE DID SET IT" + ligthningSeconds);
            }
            //System.out.println("YOU MISSED IT"+ ligthningSeconds);

            int maxWords = 0;
            if (type.equals("Puzzle")){
            	maxWords = Integer.parseInt(br.readLine());
            }
            
            
            //create the resulting level
            Level result = null;
            switch(type){
            	case "Puzzle":
            		//TODO fix placeholder values
            		result = new PuzzleLevel(new Board(tiles), name, new Dictionary(),
                    		highscore, targetScore, isUnlocked, maxWords);
            		return result;
            	case "Lightning":
            		result = new LightningLevel(new Board(tiles), name, new Dictionary(),
                    		highscore, targetScore, isUnlocked, ligthningSeconds);
            		return result;
            	case "Theme":

					HashSet<String> table = new HashSet<String>();
             		// not at EOF yet, read into dict.
					String prevWord = "";
					String word;
					while((word=br.readLine()) != null && !word.equals("")){
						prevWord = word.toLowerCase();
						table.add(prevWord);
					}

					//remove last, its the theme type.
					table.remove(prevWord);
					
					Dictionary dict = new Dictionary(table);
            		result = new ThemeLevel(new Board(tiles), name, dict, highscore, targetScore, isUnlocked, prevWord);
            		return result;
            }


            br.close();
        }//Cleanup 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
        //failed read
		return null;
	}

	public Model getModel() {
		return this.model;
	}

	public WelcomeView getWelcome() {
		return this.welcome;
	}
}

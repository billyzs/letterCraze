package common.application;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.controller.StartLevelController;
import common.view.LevelView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import common.model.*;
import common.view.*;

public class Application extends JFrame{

	protected Model model; 
	protected WelcomeView welcome;
	protected MenuView menu;
	
	//To be removed on the merge to dev


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


	//This will eventually be in a common.controller
	public static Level loadLevel(String filename){

		//read a file
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./" + filename));
            
            //get first three args
            String type = br.readLine();
            String name = br.readLine();
            int highscore = Integer.parseInt(br.readLine());

            //read next three ints as starvals
            int[] starVals = new int[3];
            for(int k = 0; k < starVals.length; k++)
                starVals[k] = Integer.parseInt(br.readLine());
            
            //read in whether it is unlocked
            boolean isUnlocked = false;
            if(br.readLine().equals("true"))
            	isUnlocked = true;

            ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
            
            //read in board as 6 lines until EOF
            String row;
            for(int r = 0; (row = br.readLine()) != null; r++){

            	//add new row
            	tiles.add(new ArrayList<Tile>());


            	//cycle through the string, adding tiles to the array
            	char[] chars = row.toCharArray();
            	for(int c = 0; c < chars.length; c++){
            		if(chars[c] == '1'){
            			//TODO, placeholder values
            			tiles.get(r).add(new Tile("Z", r, c));
            		}
            		else{
            			tiles.get(r).add(new Tile("", r, c));
            		}
            	}
            }
            
            for(int k = 0; k < 6; k++){
            	System.out.println(tiles.get(0).get(k).getLetters());
            }
            
            //create the resulting level
            Level result = null;
            switch(type){
            	case "Puzzle":
            		//TODO fix placeholder values
            		result = new PuzzleLevel(new Board(tiles), name, new Dictionary(),
                    		highscore, starVals, 100, isUnlocked);
            		return result;
            	case "Lightning":
            		return result;
            	case "Theme":
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

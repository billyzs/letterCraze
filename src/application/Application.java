package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.*;
import view.*;

//santiago and spencer
public class Application {
	Model model; 
	WelcomeView welcome;
	MenuView menu;
	LevelView currentLevel;

	public Application(Model m){
		this.model = m;
	}

	//This will eventually be in a controller
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
            
            //create the resulting level
            Level result = null;
            switch(type){
            	case "Puzzle":
            		//TODO fix placeholder values
            		result = new PuzzleLevel(new Board(tiles), name, new Dictionary(),
                    		highscore, starVals, 100);
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
}

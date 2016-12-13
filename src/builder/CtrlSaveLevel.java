package builder;

import common.model.Dictionary;
import common.model.Level;
import common.model.ThemeLevel;
import common.model.Tile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Saves a level to ASCII file format as specified by Grant Espe.
 * <p>
 * Fields are (separated by new line):
 * <p>
 * Type
 * <p>
 * Name
 * <p>
 * highScore
 * <p>
 * starVal[0]
 * <p>
 * starVal[1]
 * <p>
 * starVal[2]
 * <p>
 * unlocked
 * <p>
 * 6*6 Board Layout
 * <p>
 * (Theme only) Dict words.
 * @author Created by billyzs on 12/3/16.
 */

public class CtrlSaveLevel implements ActionListener {
    Level currentLevel;
    public CtrlSaveLevel(Level lvl){
        currentLevel = lvl;
    }

    protected void saveLevelToFile(Level lvl, String filename) throws IOException {
        BufferedWriter writer = null;
        try{
        	//check if the file exists (Always unlock new levels/files)
        	File f = new File("./levels/" + filename);
        	boolean isDefault = f.exists();

            writer = new BufferedWriter(new FileWriter("./levels/" + filename));
            writer.write(lvl.getType()); writer.newLine();
            writer.write(lvl.getName()); writer.newLine();
            writer.write(Integer.toString(lvl.getHighscore())); writer.newLine();
            int starVals = lvl.getTargetScore();

            writer.write(Integer.toString(starVals)); writer.newLine();

            //Custom levels should be unlocked automatically 
            if(isDefault){
                writer.write(String.valueOf(lvl.isUnlocked())); writer.newLine();
            }
            else{
                writer.write("true"); writer.newLine();
            }

            // write board layout to buffer
            String sysLineBreak = System.getProperty("line.separator");
            for (ArrayList<Tile> row : lvl.getBoard().getTiles()){
                // write each row to buffer
                String buffer = "";
                for(Tile t: row){
                    buffer += (t.isSelectable())? "1" : "0";
                }
                writer.write(buffer); writer.newLine();
            }
            if (lvl.getType().equals("Theme")) {
                // write the dict to end of file
                Iterator<String> itr = lvl.getDict().getTable().iterator();

                while(itr.hasNext()){
                    String s = itr.next();
                    writer.write(s); writer.newLine();
                }
                // writer.write(itr.next()); writer.newLine();
            }
            else if(lvl.getType().equals("Puzzle")){
            	writer.write("" + lvl.getMaxWords()); writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            // pwd
            System.err.println(System.getProperty("user.dir"));
            System.err.format("IOException: %s%n", e);
            throw e;
        }
        finally {
            if(writer!=null) writer.close();
        }
    }
    
    /**
     * Save a level as an ASCII text file in the format specified in the class description.
     * @param lvl
     * @throws IOException
     */
    public void saveLevelToFile(Level lvl) throws IOException{
        saveLevelToFile(lvl, lvl.getName()+".lvl");
    }
    @Override
    /**
     * File name should be
     */
    public void actionPerformed(ActionEvent actionEvent){
        System.out.println("preparing to save");
        try{
			saveLevelToFile(currentLevel);
			System.out.println("saved");
		} catch (Exception e){
        	e.printStackTrace();
		}
    }
}

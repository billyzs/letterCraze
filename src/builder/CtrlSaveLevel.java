package builder;

import common.model.Level;
import common.model.Tile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Saves a level to ASCII file as specified by Grant
 * Created by billyzs on 12/3/16.
 */

public class CtrlSaveLevel implements ActionListener {
    Level currentLevel;
    public CtrlSaveLevel(Level lvl){
        currentLevel = lvl;
    }

    protected void saveLevelToFile(Level lvl, String filename) throws IOException {
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write(lvl.getType()); writer.newLine();
            writer.write(lvl.getName()); writer.newLine();
            writer.write(Integer.toString(lvl.getHighscore())); writer.newLine();
            int[] starVals = lvl.getStarVals();
            for (int val : starVals){
                writer.write(Integer.toString(val)); writer.newLine();
            }
            writer.write(String.valueOf(lvl.getUnlocked())); writer.newLine();
            // write board layout and letter layout to buffer
            // for anything other than themed, wordLayoutBuffer should just be empty string
            // TODO make sure tiles's words are "" for puzzle and lightening.
            String wordLayoutBuffer = "";
            String sysLineBreak = System.getProperty("line.separator");
            for (ArrayList<Tile> row : lvl.getBoard().getTiles()){
                // write each row to buffer
                String buffer = "";
                for(Tile t: row){
                    if(t.isSelectable()){
                        buffer += "1";
                        wordLayoutBuffer += t.getLetters();
                    }
                    else{
                        buffer += "0";
                        wordLayoutBuffer += "*"; //disabled tile
                    }

                }
                writer.write(buffer); writer.newLine();
                wordLayoutBuffer += sysLineBreak;
            }
            if (lvl.getType() == "Theme") {
                // remove the last unnecessary line break
                wordLayoutBuffer = wordLayoutBuffer.substring(0,wordLayoutBuffer.length()-1);
                writer.write(wordLayoutBuffer);
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
    protected void saveLevelToFile(Level lvl) throws IOException{
        saveLevelToFile(lvl, lvl.getName()+".lvl");
    }
    @Override
    /**
     * File name should be
     */
    public void actionPerformed(ActionEvent actionEvent){

    }
}

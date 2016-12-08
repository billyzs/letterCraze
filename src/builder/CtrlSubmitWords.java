package builder;

import com.sun.xml.internal.ws.util.StringUtils;
import common.model.Dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Controller for saving user's submitted words to ThemeLevel's Dict
 * Created by billyzs on 12/7/16.
 */
public class CtrlSubmitWords implements ActionListener{
	String prompt; // message to display to user
	ViewBuildLevel vbl;
	JTextPane jtp;
	AppBuilder builder;
	public CtrlSubmitWords(){}
	public CtrlSubmitWords(ViewBuildLevel vbl, JTextPane j, AppBuilder b){
		this.vbl = vbl;
		this.jtp = j;
		this.builder = b;
	}

	/**
	 * Count the number of letters in word, counting qu as 1 letter
	 * @param w word
	 * @return number of letters
	 */
	int countLetters(String w){
		w = w.toLowerCase();
		return w.replace("qu", "q").length();
	}

	/**
	 * return true if w only contains a-z
	 * @param w
	 * @return
	 */
	boolean isAlpha(String w){
		return w.chars().allMatch(Character::isLetter);
	}

	/**
	 * Parse comma delimited string as list
	 * @param userInput
	 * @return
	 */


	/**
	 * Validate user input.
	 * User input is valid if
	 * 1. total number of letters < number of squares enabled (Qu count as 1)
	 * 2. each word is longer than 3 letters
	 * @param userInput
	 */

	boolean isValid(String userInput, int numActiveTiles) throws Exception {
		if(numActiveTiles > 36){
			throw new IllegalArgumentException("Too many tiles: " + Integer.toString(numActiveTiles));
		}
		userInput = userInput.toLowerCase();
		String[] words = userInput.split(",");
		int totalLength= 0;
		for(String w : words){
			if(!isAlpha(w)){
				throw new IllegalArgumentException(w + " contains illeagle characters.");
			}
			else if (countLetters(w) < 3){
				throw new IllegalArgumentException(w + " is too short.");
			}
			else{
				totalLength += countLetters(w);
			}
		}
		if (totalLength > numActiveTiles){
			throw new IllegalArgumentException("Too many words: " + Integer.toString(totalLength) + "vs Tiles: " + Integer.toString(numActiveTiles));
		}
		else{
			return true;
		}

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// get the words
		String userInput = jtp.getText();

		// get numActiveTile
		int numActiveTile = builder.getModel().getCurrentLevel().getBoard().countActiveTiles();
		try{
			if(isValid(userInput, numActiveTile)){
				// save dict to level
				String[] words = userInput.split(",");
				Dictionary dict = new Dictionary(words);
				vbl.getLevel().setDict(dict);
			}
		} catch (Exception e) {
			// display exception message in the prompt field of ViewBuildLevel
			vbl.prompt.setText(e.getMessage());
		}
	}


}

package common.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import common.model.Level;
import common.model.Word;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * <code>JPanel</code> object to show submitted <code>Word</code> objects.
 * @author Grant Espe
 * @author Santiago Sade de la Paz
 */
public class SubmittedWordsView extends JPanel implements IView {
	private JTextField textField;
	private JLabel currentWordLabel;
	private ArrayList<JLabel> wordLabels;
	private JLabel wordsLeft;
	private int wordsLeftNumber;
	private Level l;

	JButton submitWord;

	ArrayList<String> words;

	Word currentWord;
	
	/**
	 * Default constructor.
	 * @param sw An ArrayList of Strings
	 * @param cw
	 */
	public SubmittedWordsView(ArrayList<String> sw, Word cw, Level l){
		this.words = sw;
		this.currentWord = cw;
		this.l = l;

		this.initialize();
		this.wordLabels = new ArrayList<JLabel>();
		this.submitWord.setEnabled(false);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Create the <code>JPanel</code>.
	 */
	public void initialize() {
		
		setLayout(null);
		JLabel lblSubmittedWords = new JLabel("Submitted Words");
		
		lblSubmittedWords.setBounds(61, 44, 148, 22);
		lblSubmittedWords.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSubmittedWords.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(197, 6, 76, 29);
		add(btnSubmit);
		add(lblSubmittedWords);
		this.submitWord = btnSubmit;
		
		this.currentWordLabel= new JLabel("");
		this.currentWordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.currentWordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		this.currentWordLabel.setBounds(98, 8, 100, 22);
		//currentWordLabel.setBounds(98, 8, 80, 50);

		//srsly santiago
		add(this.currentWordLabel);
		
		wordsLeft = new JLabel("");
		wordsLeft.setBounds(65, 70, 140, 16);
		wordsLeft.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(wordsLeft);
		wordsLeft.setVisible(true);
	
		if (l.getType().equals("Puzzle")) {
			wordsLeftNumber = l.getMaxWords() - words.size();
			wordsLeft.setText(wordsLeftNumber + " words left");
		}
		
	}
	
	public void refresh(){
		System.out.println(this.currentWord.toString());
		
		//remove all labels from the view
		if(wordLabels != null){
            for(JLabel jl : wordLabels){
                this.remove(jl);
            }
		}

		//add all labels in the words array to the view, and to the array
		for(int k = 0; k < words.size(); k++){
            JLabel word = new JLabel(this.words.get(k));
            int size = this.wordLabels.size();
            int offset = k*20;
            word.setBounds(85, 100 + offset, 100, 16);
            word.setHorizontalAlignment(SwingConstants.CENTER);

            this.wordLabels.add(word);
            this.add(word);
            word.setVisible(true);
		}
		
		//Now refresh current word
		this.currentWordLabel.setText(currentWord.toString());

		//refresh submitted words
		System.out.println(words);

		//Disable button if current words isnt a word, or short enough, or exceeds max words
		boolean isTheme = ContentPane.getCurrentLevelView().getLevel().getType().equals("Theme");
		boolean longEnough = this.currentWord.toString().length() >= 3;
		boolean underMaxWords = words.size() < ContentPane.getCurrentLevelView().getLevel().getMaxWords();
		if(ContentPane.getCurrentLevelView().getLevel().getDict().isWord(this.currentWord.toString()) && (isTheme || longEnough) && underMaxWords)
			this.submitWord.setEnabled(true);
		else
			this.submitWord.setEnabled(false);
		
		if (ContentPane.getCurrentLevelView().getLevel().getType().equals("Puzzle")) {
			wordsLeftNumber = ContentPane.getCurrentLevelView().getLevel().getMaxWords() - words.size();
			wordsLeft.setText(wordsLeftNumber + " words left");
		}
		
		this.repaint();
		
		
	}
	
	
	/**
	 * Converts the arraylist of words into <code>JLabel</code>s, refreshes for adding/removing a word.
	 */
	
	
	public JButton getSubmitButton(){return this.submitWord;}
	
	
}

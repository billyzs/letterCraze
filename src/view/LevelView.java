package view;

import javax.swing.JButton;
import javax.swing.JLabel;

public class LevelView implements IView {
	BoardView board;
	StarsView stars;
	SubmittedWordsView submittedWords;
	JButton exit;
	JButton reset;
	JButton finish;
	JButton submitWord;
	JLabel currentWord;
	JLabel name;
	JLabel timer;

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}
}

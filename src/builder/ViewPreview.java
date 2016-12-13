package builder;

import common.model.Level;
import common.view.BoardView;
import common.view.LevelView;

import javax.swing.*;

/**
 * View of a preview of what a level currently being built will look like when saved.
 * @author Created by billyzs on 12/8/16.
 */
public class ViewPreview extends JFrame {
	BoardView boardView;
	LevelView levelView;
	public ViewPreview(ViewBuildLevel vbl){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200, 200, 900, 645);
		boardView = vbl.getBoardView();
		// add(boardView);
		// boardView.setVisible(true);

		//Setup board
		vbl.getLevel().initialize();

		//Stop timer
		vbl.getLevel().terminate();

		levelView = new LevelView(vbl.getLevel());

		add(levelView);
	}
}

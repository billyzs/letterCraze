package builder;

import common.model.Level;
import common.view.BoardView;

import javax.swing.*;

/**
 * Created by billyzs on 12/8/16.
 */
public class ViewPreview extends JFrame {
	BoardView boardView;
	public ViewPreview(ViewBuildLevel vbl){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(200, 200, 800, 645);
		boardView = vbl.getBoardView();
		add(boardView);
		boardView.setVisible(true);
	}
}

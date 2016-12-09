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
		boardView = vbl.getBoardView();
		add(boardView);
	}

	@Override
	public void show() {
		//super.show();
		this.setVisible(true);
	}

	@Override
	public void hide() {
		//super.hide();
		this.setVisible(false);
	}
}

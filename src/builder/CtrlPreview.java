package builder;

import common.model.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by billyzs on 12/8/16.
 */
public class CtrlPreview implements ActionListener {
	ViewBuildLevel vbl;
	public CtrlPreview(ViewBuildLevel vbl){
		this.vbl = vbl;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		ViewPreview vpv = new ViewPreview(this.vbl);
		vpv.setVisible(true);
	}
}

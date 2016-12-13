package builder;

import common.model.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <code>ActionListener</code> controller which handles bringing up the preview of a level currently being built.
 * @author Created by billyzs on 12/8/16.
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

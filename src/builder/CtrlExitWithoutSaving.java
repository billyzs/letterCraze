package builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <code>ActionListener</code> controller for exiting the builder without saving one's progres on a new level.
 * @author Created by billyzs on 12/8/16.
 */
public class CtrlExitWithoutSaving implements ActionListener{
	CtrlModifyLevel cml;
	ViewBuildLevel viewBuildLevel;
	public CtrlExitWithoutSaving(CtrlModifyLevel cml){
		this.cml = cml;
	}

	/**
	 * Basically hides this view and bring up ViewMenu. Discards all current changes to this level.
	 * @param actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		int seq = cml.seq;
		// reset the corresponding level in model to the original state
		System.out.println("Restoring the original level");
		cml.getBuilder().getModel().getLevels().set(seq, cml.getBackup());
		cml.getViewBuildLevel().hide();
		cml.getBuilder().getMenu().show();
	}
}

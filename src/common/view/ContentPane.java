package common.view;

import javax.swing.JPanel;

/**
 * Content pane to be retrieved from anywhere.
 * @author Grant Espe
 */
public final class ContentPane {
    private static LevelView currentLevelView;
	private static JPanel contentPane;

	private ContentPane(){
	}

	public static JPanel get(){
		return contentPane;
	}
	
	public static void setContentPanel(JPanel jp){
		contentPane = jp;
	}

	public static void setCurrentLevelView(LevelView lv){currentLevelView = lv;}
	public static LevelView getCurrentLevelView(){ return currentLevelView;}

}

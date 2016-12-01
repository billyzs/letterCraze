package view;

import javax.swing.JPanel;

/*
 * ContentPane.get() to get the content pane from anywhere
 */
public final class ContentPane {
	private static JPanel contentPane;

	private ContentPane(){
	}

	public static JPanel get(){
		return contentPane;
	}
	
	public static void setContentPanel(JPanel jp){
		contentPane = jp;
	}

}

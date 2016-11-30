package view;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class BoardView extends JPanel implements IView{

	ArrayList<ArrayList<TileView>> TileViews;
	String label;
	
	public BoardView(String label){
		this.initialize();
		this.label = label;
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
	 * Create the panel.
	 */
	public void initialize() {
		
		TileView panel = new TileView();
		panel.setBounds(0, 0, 96, 96);
		panel.setLabel(label);
		
		TileView TileView_ = new TileView();
		TileView_.setBounds(192, 0, 96, 96);
		TileView_.setLabel(label);
		
		TileView TileView__1 = new TileView();
		TileView__1.setBounds(96, 0, 96, 96);
		TileView__1.setLabel(label);
		
		TileView TileView__2 = new TileView();
		TileView__2.setLabel(label);
		TileView__2.setBounds(96, 96, 96, 96);
		
		TileView TileView__3 = new TileView();
		TileView__3.setBounds(0, 96, 96, 96);
		TileView__3.setLabel(label);
		setLayout(null);
		add(TileView_);
		add(TileView__1);
		add(TileView__2);
		add(TileView__3);
		add(panel);
		
		TileView TileView__4 = new TileView();
		TileView__4.setBounds(0, 191, 96, 96);
		TileView__4.setLabel(label);
		add(TileView__4);
		
		TileView TileView__5 = new TileView();
		TileView__5.setBounds(96, 191, 96, 96);
		TileView__5.setLabel(label);
		add(TileView__5);
		
		TileView TileView__6 = new TileView();
		TileView__6.setBounds(192, 96, 96, 96);
		TileView__6.setLabel(label);
		add(TileView__6);
		
		TileView TileView__7 = new TileView();
		TileView__7.setBounds(192, 191, 96, 96);
		TileView__7.setLabel(label);
		add(TileView__7);
		
		TileView TileView__8 = new TileView();
		TileView__8.setBounds(0, 286, 96, 96);
		TileView__8.setLabel(label);
		add(TileView__8);
		
		TileView TileView__9 = new TileView();
		TileView__9.setBounds(96, 286, 96, 96);
		TileView__9.setLabel(label);
		add(TileView__9);
		
		TileView TileView__10 = new TileView();
		TileView__10.setBounds(192, 286, 96, 96);
		TileView__10.setLabel(label);
		add(TileView__10);
		
		TileView TileView__11 = new TileView();
		TileView__11.setBounds(288, 0, 96, 96);
		TileView__11.setLabel(label);
		add(TileView__11);
		
		TileView TileView__12 = new TileView();
		TileView__12.setBounds(288, 191, 96, 96);
		TileView__12.setLabel(label);
		add(TileView__12);
		
		TileView TileView__13 = new TileView();
		TileView__13.setBounds(288, 96, 96, 96);
		TileView__13.setLabel(label);
		add(TileView__13);
		
		TileView TileView__14 = new TileView();
		TileView__14.setBounds(288, 286, 96, 96);
		TileView__14.setLabel(label);
		add(TileView__14);
		
		TileView TileView__15 = new TileView();
		TileView__15.setBounds(384, 0, 96, 96);
		TileView__15.setLabel(label);
		add(TileView__15);
		
		TileView TileView__16 = new TileView();
		TileView__16.setBounds(384, 96, 96, 96);
		TileView__16.setLabel(label);
		add(TileView__16);
		
		TileView TileView__17 = new TileView();
		TileView__17.setBounds(384, 191, 96, 96);
		TileView__17.setLabel(label);
		add(TileView__17);
		
		TileView TileView__18 = new TileView();
		TileView__18.setBounds(480, 0, 96, 96);
		TileView__18.setLabel(label);
		add(TileView__18);
		
		TileView TileView__19 = new TileView();
		TileView__19.setBounds(480, 191, 96, 96);
		TileView__19.setLabel(label);
		add(TileView__19);
		
		TileView TileView__20 = new TileView();
		TileView__20.setBounds(480, 96, 96, 96);
		TileView__20.setLabel(label);
		add(TileView__20);
		
		TileView TileView__21 = new TileView();
		TileView__21.setBounds(384, 286, 96, 96);
		TileView__21.setLabel(label);
		add(TileView__21);
		
		TileView TileView__22 = new TileView();
		TileView__22.setBounds(480, 286, 96, 96);
		TileView__22.setLabel(label);
		add(TileView__22);
		
		TileView TileView__23 = new TileView();
		TileView__23.setBounds(0, 381, 96, 96);
		TileView__23.setLabel(label);
		add(TileView__23);
		
		TileView TileView__24 = new TileView();
		TileView__24.setBounds(96, 381, 96, 96);
		TileView__24.setLabel(label);
		add(TileView__24);
		
		TileView TileView__25 = new TileView();
		TileView__25.setBounds(192, 381, 96, 96);
		TileView__25.setLabel(label);
		add(TileView__25);
		
		TileView TileView__26 = new TileView();
		TileView__26.setBounds(288, 381, 96, 96);
		TileView__26.setLabel(label);
		add(TileView__26);
		
		TileView TileView__27 = new TileView();
		TileView__27.setBounds(384, 381, 96, 96);
		TileView__27.setLabel(label);
		add(TileView__27);
		
		TileView TileView__28 = new TileView();
		TileView__28.setBounds(480, 381, 96, 96);
		TileView__28.setLabel(label);
		add(TileView__28);
		
		TileView TileView__29 = new TileView();
		TileView__29.setBounds(0, 477, 96, 96);
		TileView__29.setLabel(label);
		add(TileView__29);
		
		TileView TileView__30 = new TileView();
		TileView__30.setBounds(96, 477, 96, 96);
		TileView__30.setLabel(label);
		add(TileView__30);
		
		TileView TileView__31 = new TileView();
		TileView__31.setBounds(192, 477, 96, 96);
		TileView__31.setLabel(label);
		add(TileView__31);
		
		TileView TileView__32 = new TileView();
		TileView__32.setBounds(288, 477, 96, 96);
		TileView__32.setLabel(label);
		add(TileView__32);
		
		TileView TileView__33 = new TileView();
		TileView__33.setBounds(384, 477, 96, 96);
		TileView__33.setLabel(label);
		add(TileView__33);
		
		TileView TileView__34 = new TileView();
		TileView__34.setBounds(480, 477, 96, 96);
		TileView__34.setLabel(label);
		add(TileView__34);

	}
}

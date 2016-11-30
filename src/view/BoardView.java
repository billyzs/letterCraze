package view;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BoardView extends JPanel implements IView{

	ArrayList<ArrayList<TileView>> tileViews;
	
	public BoardView(){
		this.initialize();
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
		
		TileView tileView_ = new TileView();
		tileView_.setBounds(192, 0, 96, 96);
		
		TileView tileView__1 = new TileView();
		tileView__1.setBounds(96, 0, 96, 96);
		
		TileView tileView__2 = new TileView();
		tileView__2.setBounds(96, 96, 96, 96);
		
		TileView tileView__3 = new TileView();
		tileView__3.setBounds(0, 96, 96, 96);
		setLayout(null);
		add(tileView_);
		add(tileView__1);
		add(tileView__2);
		add(tileView__3);
		add(panel);
		
		TileView tileView__4 = new TileView();
		tileView__4.setBounds(0, 191, 96, 96);
		add(tileView__4);
		
		TileView tileView__5 = new TileView();
		tileView__5.setBounds(96, 191, 96, 96);
		add(tileView__5);
		
		TileView tileView__6 = new TileView();
		tileView__6.setBounds(192, 96, 96, 96);
		add(tileView__6);
		
		TileView tileView__7 = new TileView();
		tileView__7.setBounds(192, 191, 96, 96);
		add(tileView__7);
		
		TileView tileView__8 = new TileView();
		tileView__8.setBounds(0, 286, 96, 96);
		add(tileView__8);
		
		TileView tileView__9 = new TileView();
		tileView__9.setBounds(96, 286, 96, 96);
		add(tileView__9);
		
		TileView tileView__10 = new TileView();
		tileView__10.setBounds(192, 286, 96, 96);
		add(tileView__10);
		
		TileView tileView__11 = new TileView();
		tileView__11.setBounds(288, 0, 96, 96);
		add(tileView__11);
		
		TileView tileView__12 = new TileView();
		tileView__12.setBounds(288, 191, 96, 96);
		add(tileView__12);
		
		TileView tileView__13 = new TileView();
		tileView__13.setBounds(288, 96, 96, 96);
		add(tileView__13);
		
		TileView tileView__14 = new TileView();
		tileView__14.setBounds(288, 286, 96, 96);
		add(tileView__14);
		
		TileView tileView__15 = new TileView();
		tileView__15.setBounds(384, 0, 96, 96);
		add(tileView__15);
		
		TileView tileView__16 = new TileView();
		tileView__16.setBounds(384, 96, 96, 96);
		add(tileView__16);
		
		TileView tileView__17 = new TileView();
		tileView__17.setBounds(384, 191, 96, 96);
		add(tileView__17);
		
		TileView tileView__18 = new TileView();
		tileView__18.setBounds(480, 0, 96, 96);
		add(tileView__18);
		
		TileView tileView__19 = new TileView();
		tileView__19.setBounds(480, 191, 96, 96);
		add(tileView__19);
		
		TileView tileView__20 = new TileView();
		tileView__20.setBounds(480, 96, 96, 96);
		add(tileView__20);
		
		TileView tileView__21 = new TileView();
		tileView__21.setBounds(384, 286, 96, 96);
		add(tileView__21);
		
		TileView tileView__22 = new TileView();
		tileView__22.setBounds(480, 286, 96, 96);
		add(tileView__22);
		
		TileView tileView__23 = new TileView();
		tileView__23.setBounds(0, 381, 96, 96);
		add(tileView__23);
		
		TileView tileView__24 = new TileView();
		tileView__24.setBounds(96, 381, 96, 96);
		add(tileView__24);
		
		TileView tileView__25 = new TileView();
		tileView__25.setBounds(192, 381, 96, 96);
		add(tileView__25);
		
		TileView tileView__26 = new TileView();
		tileView__26.setBounds(288, 381, 96, 96);
		add(tileView__26);
		
		TileView tileView__27 = new TileView();
		tileView__27.setBounds(384, 381, 96, 96);
		add(tileView__27);
		
		TileView tileView__28 = new TileView();
		tileView__28.setBounds(480, 381, 96, 96);
		add(tileView__28);
		
		TileView tileView__29 = new TileView();
		tileView__29.setBounds(0, 477, 96, 96);
		add(tileView__29);
		
		TileView tileView__30 = new TileView();
		tileView__30.setBounds(96, 477, 96, 96);
		add(tileView__30);
		
		TileView tileView__31 = new TileView();
		tileView__31.setBounds(192, 477, 96, 96);
		add(tileView__31);
		
		TileView tileView__32 = new TileView();
		tileView__32.setBounds(288, 477, 96, 96);
		add(tileView__32);
		
		TileView tileView__33 = new TileView();
		tileView__33.setBounds(384, 477, 96, 96);
		add(tileView__33);
		
		TileView tileView__34 = new TileView();
		tileView__34.setBounds(480, 477, 96, 96);
		add(tileView__34);

	}
}

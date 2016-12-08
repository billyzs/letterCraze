package common.view;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import common.model.Board;
import common.model.Tile;


public class BoardView extends JPanel implements IView{

	ArrayList<ArrayList<TileView>> TileViews;

	public Board getBoard() {
		return board;
	}

	Board board;
	
	public BoardView(Board b){
		this.board = b;
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

		setLayout(null);
		
		//init tileViews
		this.TileViews = new ArrayList<ArrayList<TileView>>();

		//attempt to put santiagos mess in a loop
		for(int r = 0; r < 6; r++){
			this.TileViews.add(new ArrayList<TileView>());

			for(int c = 0; c < 6; c++){
				Tile theTile = this.board.getTiles().get(r).get(c);
                TileView atv = new TileView(theTile);

                atv.setBounds(c*95, r*95, 96, 96);

                //Add it to the array
				this.TileViews.get(r).add(atv);

                add(atv);
			}
		}
	}
	
	public ArrayList<ArrayList<TileView>> getTileViews(){return this.TileViews; }
	
}

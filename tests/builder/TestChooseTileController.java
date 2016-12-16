package builder;

import static org.junit.Assert.*;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.Test;

import builder.ChooseTileController;
import common.application.Application;
import common.model.Board;
import common.model.Model;
import common.model.NullTile;
import common.model.Tile;
import common.view.ContentPane;
import common.view.TileView;


public class TestChooseTileController {
	AppBuilder app = new AppBuilder(new Model(Application.loadDefaultLevels()));

	@Test
	public void testIsBoardValid(){
		//TODO test more board configuration
		NullTile nt = new NullTile(1,1);
		TileView tv = new TileView(nt);
		ChooseTileController c = new ChooseTileController(app, tv);
		ArrayList<ArrayList<Tile>> l = new ArrayList<>();
		for (int i = 0; i < 6; i++){
			ArrayList<Tile> row = new ArrayList<Tile>(6);
			for(int j =0; j < 6; j++){
				row.add(new Tile(i, j));
			}
			l.add(row);
		}
		Board b = new Board(l);
		assertTrue(c.isBoardValid(b));
		int k = 0;
		for(ArrayList<Tile> row : b.getTiles()){
			row.set(0, new NullTile(k,0));
			k++;
		}
		assertTrue(c.isBoardValid(b));

		k = 0;
		for(ArrayList<Tile> row : b.getTiles()){
			row.set(5, new NullTile(k,5));
			k++;
		}
		assertTrue(c.isBoardValid(b));

		k = 0;
		for(ArrayList<Tile> row : b.getTiles()){
			row.set(3, new NullTile(k,3));
			k++;
		}
		assertFalse(c.isBoardValid(b));
	}
	
	@Test
	public void testActionPerformed(){
		Tile t = new Tile(0,0);
		TileView tv = new TileView(t);
		ChooseTileController ctc = new ChooseTileController(app, tv);
		tv.addMouseListener(ctc);
		app.getModel().setLevel(app.getModel().getLevels().get(0));

		ctc.doClick();
		
		//tile should now be null, as it is deselected
		assertTrue(tv.getTile().isNull());
	}
}

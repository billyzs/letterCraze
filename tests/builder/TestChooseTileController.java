package builder;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import builder.ChooseTileController;
import common.application.Application;
import common.model.Board;
import common.model.NullTile;
import common.model.Tile;
import common.view.TileView;


public class TestChooseTileController {
	
	@Test
	public void testIsBoardValid(){
		//TODO test more board configuration
		Application app = new Application();
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
}

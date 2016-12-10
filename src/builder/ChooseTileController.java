package builder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import common.model.Model;
import common.model.NullTile;
import game.move.*;
import common.model.Tile;
import common.view.ContentPane;
import common.view.TileView;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChooseTileController implements MouseListener{
	Application app;
	Model model;
	TileView tileView;
	
	public ChooseTileController(Application a, TileView t){
		this.app = a;
		this.model = a.getModel();
		this.tileView = t;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Tile tile = tileView.getTile();

		if(tile == null)
			return;

		
		int row = tile.getRow();
		int col = tile.getCol();

		//select/deselect the tile
		Tile newTile;
		if(tile.isNull())
			newTile = new Tile(row,col);
		else
			newTile = new NullTile(row,col);
		//newTile.setSelected(true);
		this.model.getCurrentLevel().getBoard().getTiles().get(row).set(col, newTile);

        tileView.updateTile(newTile);
        tileView.updateColor();

        ContentPane.getCurrentLevelView().refresh();
		
		ContentPane.get().invalidate();
		ContentPane.get().validate();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
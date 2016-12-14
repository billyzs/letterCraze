package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import common.model.Model;
import game.move.*;
import common.model.Tile;
import common.view.ContentPane;
import common.view.TileView;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
* <code>MouseListener</code> controller for selecting a tile, and handling the changes its state and appearance.
* @author Team Technetium
*/
public class SelectTileController implements MouseListener{
	Application app;
	Model model;
	TileView tileView;
	
	/**
	 * @param a A letterCraze application/
	 * @param t TileView of tile selected.
	 */
	public SelectTileController(Application a, TileView t){
		this.app = a;
		this.model = a.getModel();
		this.tileView = t;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Tile tile = tileView.getTile();

		if(tile == null)
			return;

		SelectTileMove move = new SelectTileMove(this.model, tile);
		if(move.isValid()){
			move.doMove();
			tileView.updateColor();
			//refresh current word
            ContentPane.getCurrentLevelView().getSubmittedWordsView().refresh();
            ContentPane.getCurrentLevelView().refresh();
            model.addMove(move);
		}
		
		ContentPane.get().invalidate();
		ContentPane.get().validate();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

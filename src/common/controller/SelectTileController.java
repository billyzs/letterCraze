package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import common.model.Model;
import common.view.TileView;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectTileController implements MouseListener{
	Application app;
	Model model;
	TileView tileView;
	
	public SelectTileController(Application a, TileView t){
		this.app = a;
		this.model = a.getModel();
		this.tileView = t;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		tileView.setBackground(Color.WHITE);
		tileView.getTile().setSelected(true);		
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

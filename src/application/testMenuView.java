package application;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.Board;
import model.Dictionary;
import model.Level;
import model.LightningLevel;
import model.Model;
import view.MenuView;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class testMenuView extends JFrame{
	MenuView mv;
	Model m;
	public testMenuView() {
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		//getContentPane().add(menuView);
		Board B = new Board();
		Dictionary dict = new Dictionary();
		String lvlname = "Test Level";
		int highScore = 1;
		int[] sv = {1,2,3};
		Level testLevel = new LightningLevel(B, lvlname, dict, highScore, sv);
		ArrayList<Level> lList = new ArrayList<Level>();
		lList.add(testLevel);
		lList.add(testLevel);
		lList.add(testLevel);
		lList.add(testLevel);
		m = new Model(lList);
		mv = new MenuView(m);
		getContentPane().add(mv);
		this.add(mv);
		mv.setVisible(true);
		
	}
	
	public static void main(String[] args){
		try{
			testMenuView t = new testMenuView();
			t.pack();
			t.setSize(900, 700);
			t.setVisible(true);
			System.out.println("Hello");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
}

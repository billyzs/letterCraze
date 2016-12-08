package common.view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import common.model.Tile;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TileView extends JPanel {
	
	JLabel lblX;
	Tile tile;
	
	public TileView(Tile t) {
		this.tile = t;
		this.initialize();
		this.updateLabel();
	}
	
	//moved logic for color to this function
	public void updateColor(){
		if (tile.isNull()) {
			setBackground(new Color(238, 238, 238));
		} else {
			if(tile.isSelected()){
                setBackground(Color.LIGHT_GRAY);
			}
            else{
                setBackground(Color.WHITE);
            }

			setBorder(new LineBorder((new Color(238, 238, 238)),2));
		}

	}
	
	//Tiles now set their own label
	public void updateLabel(){
        if(this.tile.isNull() || this.tile.getLetters().equals(""))
            this.setLabel(" ");
        else{
            //now it will display the real letters
            this.setLabel(this.tile.getLetters());
        }
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
		
		this.updateColor();
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblX)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblX)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	
	}
	
	//set the label of a tile...
	public void setLabel(String label) {
		lblX.setText(label);
	}
	
	public Tile getTile(){return tile;}

	public void updateTile(Tile newTile) {
		this.tile = newTile;
	}
	
}

package common.view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import model.Tile;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TileView extends JPanel {
	
	JLabel lblX;
	Tile tile;
	
	public TileView(Tile t) {
		this.tile = t;
		this.initialize();
		this.updateLabel();
	}
	
	//Tiles now set their own label
	public void updateLabel(){
        if(this.tile.getLetters().equals(""))
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
		setBackground(Color.LIGHT_GRAY);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
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
	
	public void setLabel(String label) {
		lblX.setText(label);
	}
}
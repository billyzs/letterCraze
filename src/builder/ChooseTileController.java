package builder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.org.apache.xpath.internal.operations.Mod;
import common.application.Application;
import common.model.Board;
import common.model.Model;
import common.model.NullTile;
import game.move.*;
import common.model.Tile;
import common.view.ContentPane;
import common.view.TileView;
import jdk.internal.util.xml.impl.Pair;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * <code>MouseListener</code> controller that handles the selecting of tiles to hold be playable when building a level.
 * @author Grant Espe
 *
 */
public class ChooseTileController implements MouseListener{
	Application app;
	Model model;
	TileView tileView;
	
	public ChooseTileController(Application a, TileView t){
		this.app = a;
		this.model = a.getModel();
		this.tileView = t;
	}

	/**
	 * One-pass connected component analysis to determine if board contains no islands.
	 * Also checks if number of active tiles is greater than minNumTiles.
	 * minNumTiles = characters in dict for Theme, 8 for others
	 * If Tile.isSelected() == True it is actually not enabled for playing.
	 * @param b board
	 * @return true if board has no islands
	 * @author billyzs
	 */
	boolean isBoardValid(Board b, int minNumTiles){

		HashSet<Point> checked = new HashSet<Point>();
		LinkedList<Tile> q = new LinkedList<Tile>();
		int currLabel = 0;
		int enabledTileCount = 0;
		for(int j=0; j < 6; j++){
			for(int i=0; i < 6; i++){
				if (currLabel > 1){
					return false;
				}
				if(!b.at(i,j).isNull() && !checked.contains(new Point(i,j))){ // if tile is enabled and not checked
					q.add(b.at(i,j));
					enabledTileCount++;
					// if(!checked.contains(new Point(i, j))){ // if tile has not been checked
					currLabel++;
					checked.add(new Point(i, j));
					// }
					while(!q.isEmpty()){
						// pop an elem from q, label all of its foreground 8-neighbors
						Tile t = q.pop();
						for(int row = max(0, t.getRow()-1); row < min(6, t.getRow()+2); row++){
							for(int col = max(0, t.getCol()-1); col < min(6, t.getCol()+2); col++){
								if(!b.at(row, col).isNull() && !checked.contains(new Point(row, col))){
									enabledTileCount++;
									q.add(b.at(row, col));
									checked.add(new Point(row, col));
								}
							}
						}
					}
				}
			}
		}
		System.out.println("active tiles:" + Integer.toString(enabledTileCount));
		return (currLabel==1 && enabledTileCount >= minNumTiles);
	}
	boolean isBoardValid(Board b){
		return isBoardValid(b, 9);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//for testing
		this.doClick();
	}
	
	public void doClick(){
		Tile tile = tileView.getTile();

		if(tile == null)
			return;

		
		int row = tile.getRow();
		int col = tile.getCol();

		//select/deselect the tile by swapping in/out a null tile
		Tile newTile;
		if(tile.isNull())
			newTile = new Tile(row,col);
		else
			newTile = new NullTile(row,col);

		this.model.getCurrentLevel().getBoard().getTiles().get(row).set(col, newTile);
        tileView.updateTile(newTile);
		
        //move the tile back if the board is invalid
		int minNumTiles = (this.model.getCurrentLevel().getType() == Model.Theme)?
				this.model.getCurrentLevel().getDict().getCharCount() : 9;
		if(!isBoardValid(this.model.getCurrentLevel().getBoard(), minNumTiles)){
            this.model.getCurrentLevel().getBoard().getTiles().get(row).set(col, tile);
            tileView.updateTile(tile);
		}

		//newTile.setSelected(true);

        tileView.updateColor();
        
        if(ContentPane.getCurrentLevelView() != null){
            ContentPane.getCurrentLevelView().refresh();
		
            ContentPane.get().invalidate();
            ContentPane.get().validate();
        }
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
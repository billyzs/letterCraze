package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import common.application.Application;
import common.model.Level;
import common.model.LightningLevel;
import common.model.Model;
import common.view.ContentPane;
import common.view.LevelView;

/**
* <code>ActionListener</code> controller to proved a timer for <code>LightningLevel</code>s using the swing <code>Timer</code> class.
* @author Team Technetium
*/
public class TimerController implements ActionListener{
    int targetSeconds;
    JLabel timerLabel;
	Level level;
	LevelView levelView;
	Timer timer;
	
	/**
	 * @param l A Level.
	 */
	public TimerController(Level l){
		this.level= l;
		this.timer = ((LightningLevel) l).getTimer();
		System.out.println("BEFORE" + targetSeconds);
		targetSeconds = ((LightningLevel)level).getTimerSeconds();
		System.out.println("AFTER" + targetSeconds);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.levelView = ContentPane.getCurrentLevelView();

		
		timerLabel = levelView.getTimerLabel();
		targetSeconds--;

		if(levelView.getTimerLabel() == null)
			return;


        timerLabel.setText("" + targetSeconds);
        if(targetSeconds <= 0){
            //timer.stop();
        	((LightningLevel)level).setTimeOver(true);
            timerLabel.setText("Out of Time!");
            levelView.getResetButton().setEnabled(false);
            levelView.getUndoButton().setEnabled(false);
            levelView.getSubmittedWordsView().getSubmitButton().setEnabled(false);
        }
        System.out.println(((LightningLevel)level).isTimeOver());
		
	}

}

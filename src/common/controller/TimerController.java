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

public class TimerController implements ActionListener{
    int elapsedSeconds = 30;
    JLabel timerLabel;
	Level level;
	LevelView levelView;
	Timer timer;
	
	public TimerController(Level l){
		this.level= l;
		this.timer = ((LightningLevel) l).getTimer();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.levelView = ContentPane.getCurrentLevelView();
		timerLabel = levelView.getTimerLabel();
		elapsedSeconds--;
        timerLabel.setText("" + elapsedSeconds);
        if(elapsedSeconds <= 0){
            timer.stop();
            System.out.println("Timer Over");
        }
		
	}

}

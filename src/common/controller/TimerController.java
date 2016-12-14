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
    int targetSeconds;
    JLabel timerLabel;
	Level level;
	LevelView levelView;
	Timer timer;
	
	public TimerController(Level l){
		this.level= l;
		this.timer = ((LightningLevel) l).getTimer();
		targetSeconds = ((LightningLevel)level).getTimerSeconds();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.levelView = ContentPane.getCurrentLevelView();
		timerLabel = levelView.getTimerLabel();
		targetSeconds--;
        timerLabel.setText("" + targetSeconds);
        if(targetSeconds <= 0){
            timer.stop();
            System.out.println("Timer Over");
        }
		
	}

}

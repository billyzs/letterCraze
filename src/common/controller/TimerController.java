package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import common.application.Application;
import common.model.Level;
import common.model.LightningLevel;
import common.model.Model;
import common.view.LevelView;

class TimerController implements ActionListener{
    int elapsedSeconds = 30;
    JLabel timerLabel;
	Level level;
	LevelView levelView;
	Timer timer;
	
	public TimerController(Level l, LevelView lv){
		this.levelView = lv;
		this.level= l;
		this.timer = ((LightningLevel) l).getTimer();
		timerLabel = levelView.getTimerLabel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		elapsedSeconds--;
        timerLabel.setText("" + elapsedSeconds);
        if(elapsedSeconds <= 0){
            timer.stop();
            System.out.println("Timer Over");
        }
		
	}

}

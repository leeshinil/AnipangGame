package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.makers.showmethemoney.model.game.BackgroundMusicSound;
import com.makers.showmethemoney.view.layout.GamePlayPanel;
import com.makers.showmethemoney.view.layout.GameScorePanel;
import com.makers.showmethemoney.view.layout.GameTimePanel;
import com.makers.showmethemoney.view.layout.LayoutPanel;

import test____.BackgroundMusic;

public class GameView {
	
	public GameView(JFrame frame) {
	
		// Sound
		BackgroundMusicSound.stop();
		BackgroundMusicSound.text.setText("C:\\Users\\User\\workspace\\test2\\고전게임스러운음악.wav");
		BackgroundMusicSound.loop();
//		BackgroundMusic music = new BackgroundMusic();
//		music.BackgroundMusicStop(music.file);
//		music.BackgroundMusicReStart("C:\\Users\\User\\workspace\\test2\\고전게임스러운음악.wav");
		
		// Set Container
		Container contentPane = frame.getContentPane();
		
		// Layout 담당 Panel
		LayoutPanel layPanel = new LayoutPanel("gameBackground1.png");
		layPanel.setLayout(null);
		layPanel.setPreferredSize(new Dimension(1200, 950));
		
		// make and set GamePlayPanel
		GamePlayPanel imagePanel = new GamePlayPanel();
		imagePanel.setLayout(null);
		imagePanel.setBounds(150, 200, 605, 605); // 위치 크기조절
		imagePanel.addMouseListener(imagePanel); // imagePanel에 대한 add Listener
		layPanel.add(imagePanel); // LayoutPanel에 add imagePanel
		
		// make and set GameTimePanel
		GameTimePanel timePanel = new GameTimePanel();
		layPanel.add(timePanel); // LayoutPanel에 add timePanel
		
		// make and set GameScorePanel
		GameScorePanel scorePanel = new GameScorePanel();
		layPanel.add(scorePanel);// LayoutPanel에 add scorePanel
		
		contentPane.add(layPanel);	// contentPane에 add LayoutPanel
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

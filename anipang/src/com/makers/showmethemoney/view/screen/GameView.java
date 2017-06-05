package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.makers.showmethemoney.model.game.BackgroundMusicSound;
import com.makers.showmethemoney.view.layout.GamePlayPanel;
import com.makers.showmethemoney.view.layout.GameScorePanel;
import com.makers.showmethemoney.view.layout.GameTimePanel;
import com.makers.showmethemoney.view.layout.StartPanel;

import test____.BackgroundMusic;

public class GameView {
//	public GameView(JFrame frame) {
	public static void main(String[] args) {
	
		JFrame frame = new JFrame("reset");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));
		
		// Sound
//		BackgroundMusicSound.stop();
//		BackgroundMusicSound.name.setText("C:\\Users\\User\\Desktop\\Anipang\\anipang\\고전게임스러운음악.wav");
//		BackgroundMusicSound.loop();
		
//		BackgroundMusic music = new BackgroundMusic();
//		music.BackgroundMusicStop(music.file);
//		music.BackgroundMusicReStart("C:\\Users\\User\\workspace\\test2\\고전게임스러운음악.wav");
		
		// Set Container
		Container contentPane = frame.getContentPane(); 
		contentPane.setLayout(null);
		
		// make and set GamePlayPanel
		GamePlayPanel playPanel = new GamePlayPanel();
		playPanel.setBounds(0, 0, 1200, 950); // 위치 크기조절
		playPanel.addMouseListener(playPanel); // imagePanel에 대한 add Listener
		
		contentPane.add(playPanel); // contentPanel에 add playPanel
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

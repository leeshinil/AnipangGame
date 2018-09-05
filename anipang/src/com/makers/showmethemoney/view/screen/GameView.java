package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.makers.showmethemoney.model.game.BackgroundMusicSound;
import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.view.layout.GamePlayPanel;

public class GameView {
	
	/********** 생성자 **********/
	public GameView() {
	
		JFrame frame = new JFrame("reset");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));
		
		// Sound
		BackgroundMusicSound.stop();
		BackgroundMusicSound.name.setText("C:\\Users\\User\\Desktop\\Anipang\\anipang\\고전게임스러운음악.wav");
		BackgroundMusicSound.loop();
		
		// Set Container
		Container contentPane = frame.getContentPane(); 
		contentPane.setLayout(null);
		
		// make and set GamePlayPanel
		GamePlayPanel playPanel = new GamePlayPanel(frame);
		playPanel.setBounds(0, 0, 1200, 950); // 위치 크기조절
		playPanel.addMouseListener(playPanel); // imagePanel에 대한 add Listener
		contentPane.add(playPanel); // contentPanel에 add playPanel
		
		GameData data = new GameData();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

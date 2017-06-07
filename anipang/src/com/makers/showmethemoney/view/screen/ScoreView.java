package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.makers.showmethemoney.model.game.BackgroundMusicSound;
import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.model.game.GameRankingData;
import com.makers.showmethemoney.model.game.RankingLogic;
import com.makers.showmethemoney.view.layout.Buttons;
import com.makers.showmethemoney.view.layout.GamePlayPanel;
import com.makers.showmethemoney.view.layout.GameScorePanel;

public class ScoreView {
	
	/********** ������ **********/
	public ScoreView() {
		
		// Sound
		BackgroundMusicSound.stop();
		
		JFrame frame = new JFrame("reset");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));

		// Set Container
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);

		// Nickname TextField
		JTextField nickname = new JTextField(10);

		// Game Score Panel
		GameScorePanel score = new GameScorePanel(nickname);
		score.setBounds(0, 0, 1200, 950); // ��ġ ũ������
		contentPane.add(score);
		
		// RANK Button actionlistener inner Class Overriding
		Buttons rankButton = new Buttons(650, 550) {
			public void actionPerformed(ActionEvent e) {
				new RankingView();

				GameRankingData rankData = new GameRankingData();
				RankingLogic rank = new RankingLogic();
				BackgroundMusicSound.name.setText("C:\\Users\\User\\Desktop\\Anipang\\anipang\\�����ϰ�Ȱ��������.wav");
				BackgroundMusicSound.loop();
				
				frame.dispose();
				rankData.setTotal_score();
				rankData.setNickname(nickname.getText()); // �г��� ����
				rank.writeScoreToFile(rankData.getNickname(), rankData.getTotal_score());
			}
		};
		contentPane.add(rankButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

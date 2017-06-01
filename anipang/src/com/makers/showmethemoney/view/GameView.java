package com.makers.showmethemoney.view;

import java.awt.*;
import javax.swing.*;

public class GameView {
	public GameView() {
		
		// 프레임 생성 및 설정
		JFrame frame = new JFrame ("Show Me The Money");
		frame.setLocation(600, 30);
		frame.setPreferredSize(new Dimension(1200,950));
		
		Container contentPane = frame.getContentPane();
		
		// 패널의 레이아웃을 담당할 패널
		JPanel layPanel = new JPanel();
		layPanel.setLayout(null);
		layPanel.setPreferredSize(new Dimension(825, 715));
		
		// 게임 진행 이미지 패널 생성 및 설정
		GamePlayPanel imagePanel = new GamePlayPanel();
		imagePanel.setLayout(null);
		imagePanel.setBounds(10, 110, 605, 605); // 위치 및 크기조절
		imagePanel.addMouseListener(imagePanel); // 이벤트 처리 위한 MouseListener를 add
		layPanel.add(imagePanel); // 레이아웃 패널에 이미지 패널을 add
		
		// 시간 패널 생성 및 설정
		GameTimePanel timePanel = new GameTimePanel();
		layPanel.add(timePanel); // 레이아웃 패널에 시간 패널을 add
		
		// 점수 패널 생성 및 설정
		GameScorePanel scorePanel = new GameScorePanel();
		layPanel.add(scorePanel);// 레이아웃 패널에 점수 패널을 add
		
		contentPane.add(layPanel);	// contentPane에 레이아웃 패널을 add
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

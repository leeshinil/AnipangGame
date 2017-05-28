package com.makers.showmethemoney.view;

import java.awt.*;
import javax.swing.*;

public class StartView {
	public StartView() {
		
		// ������ ���� �� ����
		JFrame frame = new JFrame ("Show Me The Money");
		frame.setLocation(600, 30);
		frame.setPreferredSize(new Dimension(1200,950));
		Container contentPane = frame.getContentPane();
		
		// �гε��� ���̾ƿ��� ����� �г�
		JPanel layPanel = new JPanel();
		layPanel.setLayout(null);
		layPanel.setPreferredSize(new Dimension(825, 715));
		
		// �̹��� �г� ���� �� ����
		GameView imagePanel = new GameView();
		imagePanel.setLayout(null);
		imagePanel.setBounds(10, 110, 605, 605);
		imagePanel.addMouseListener(imagePanel);
		layPanel.add(imagePanel);
		
		// �ð� �г� ���� �� ����
		JPanel timePanel = new JPanel();
		timePanel.setBounds(10, 10, 815, 90);
		timePanel.setBackground(Color.blue);
		layPanel.add(timePanel);
		
		// ���� �г� ���� �� ����
		JPanel scorePanel = new JPanel();
		scorePanel.setBounds(625, 110, 200, 605);
		scorePanel.setBackground(Color.CYAN);
		layPanel.add(scorePanel, BorderLayout.EAST);	
		
		contentPane.add(layPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

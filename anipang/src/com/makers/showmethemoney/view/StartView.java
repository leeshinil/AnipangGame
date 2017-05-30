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
		
		// �г��� ���̾ƿ��� ����� �г�
		JPanel layPanel = new JPanel();
		layPanel.setLayout(null);
		layPanel.setPreferredSize(new Dimension(825, 715));
		
		// ���� ���� �̹��� �г� ���� �� ����
		GameView imagePanel = new GameView();
		imagePanel.setLayout(null);
		imagePanel.setBounds(10, 110, 605, 605); // ��ġ �� ũ������
		imagePanel.addMouseListener(imagePanel); // �̺�Ʈ ó�� ���� MouseListener�� add
		layPanel.add(imagePanel); // ���̾ƿ� �гο� �̹��� �г��� add
		
		// �ð� �г� ���� �� ����
		JPanel timePanel = new JPanel();
		timePanel.setBounds(10, 10, 815, 90); // ��ġ �� ũ������
		timePanel.setBackground(Color.blue);
		layPanel.add(timePanel); // ���̾ƿ� �гο� �ð� �г��� add
		
		// ���� �г� ���� �� ����
		JPanel scorePanel = new JPanel();
		scorePanel.setBounds(625, 110, 200, 605);	// ��ġ �� ũ������
		scorePanel.setBackground(Color.CYAN);
		layPanel.add(scorePanel, BorderLayout.EAST);// ���̾ƿ� �гο� ���� �г��� add
		
		contentPane.add(layPanel);	// contentPane�� ���̾ƿ� �г��� add
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

package com.makers.showmethemoney.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuView {
	public static void main(String[] args) { //�ӽ÷�  main �����.

		// ������ ���� �� ����
		JFrame frame = new JFrame("Menu");
		frame.setLocation(600, 30);
		frame.setPreferredSize(new Dimension(1200, 950));
		Container contentPane = frame.getContentPane();

		// �гε��� ���̾ƿ��� ����� �г�
		JPanel layPanel = new JPanel();
		layPanel.setLayout(null);
		layPanel.setBounds(0, 0, 1200, 950);
		layPanel.setBackground(Color.GRAY);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBounds(600, 200, 400, 650);
		menuPanel.setBackground(Color.BLACK);
		layPanel.add(menuPanel);
		
		contentPane.add(layPanel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

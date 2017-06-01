package com.makers.showmethemoney.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuView {
	public static void main(String[] args) { //임시로  main 써놓음.

		// 프레임 생성 및 설정
		JFrame frame = new JFrame("Menu");
		frame.setLocation(600, 30);
		frame.setPreferredSize(new Dimension(1200, 950));
		Container contentPane = frame.getContentPane();

		// 패널들의 레이아웃을 담당할 패널
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

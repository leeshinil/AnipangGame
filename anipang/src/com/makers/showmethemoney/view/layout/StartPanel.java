package com.makers.showmethemoney.view.layout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class StartPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image backgroundImage = null;
	Image startButton;
	
	public StartPanel() {
		backgroundImage = toolkit.getImage("startBackground1.png");
		startButton = toolkit.getImage("startButton.png"); 

//		// ImageIcon��ü�� ����
//		ImageIcon originIcon = new ImageIcon("startButton.png");
//		// ImageIcon���� Image�� ����
//		Image originImg = originIcon.getImage();
//		// ����� Image�� ũ�⸦ �����Ͽ� ���ο� Image��ü ����
//				originImg.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
		// ���ο� Image�� ImageIcon��ü�� ����
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 1200, 950);
		g.drawImage(backgroundImage, 0, 0, 1200, 950, this);
		g.drawImage(startButton, 450, 700, 300, 100, this);
	}
}
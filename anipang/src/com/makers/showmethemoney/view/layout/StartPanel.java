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

//		// ImageIcon객체를 생성
//		ImageIcon originIcon = new ImageIcon("startButton.png");
//		// ImageIcon에서 Image를 추출
//		Image originImg = originIcon.getImage();
//		// 추출된 Image의 크기를 조절하여 새로운 Image객체 생성
//				originImg.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
		// 새로운 Image로 ImageIcon객체를 생성
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 1200, 950);
		g.drawImage(backgroundImage, 0, 0, 1200, 950, this);
		g.drawImage(startButton, 450, 700, 300, 100, this);
	}
}
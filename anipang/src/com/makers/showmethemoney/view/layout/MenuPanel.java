package com.makers.showmethemoney.view.layout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image backgroundImage = null;
	Image startButton1;
	Image startButton2;
	Image startButton3;
	
	/********** 생성자 **********/
	public MenuPanel() {
		backgroundImage = toolkit.getImage("menuPanelBackground.png");
		startButton1 = toolkit.getImage("modeButton1.png");
		startButton2 = toolkit.getImage("modeButton2.png");
		startButton3 = toolkit.getImage("modeButton3.png");
	}
	
	/********** 그려주는 메소드 **********/
	public void paint(Graphics g) {
		g.clearRect(0, 0, 1200, 950);
		g.drawImage(backgroundImage, 0, 0, 1200, 950, this);
		g.drawImage(startButton1, 700, 300, 300, 100, this);
		g.drawImage(startButton2, 700, 450, 300, 100, this);
		g.drawImage(startButton3, 700, 600, 300, 100, this);
	}
}

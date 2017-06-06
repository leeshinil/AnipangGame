package com.makers.showmethemoney.view.layout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class StartPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image backgroundImage = null;
	Image title = null;
	Image startButton;
	
	public StartPanel() {
		backgroundImage = toolkit.getImage("startBackgroundPanel.png");
		title = toolkit.getImage("title2.png");
		startButton = toolkit.getImage("startButton.png");
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 1200, 950);
		g.drawImage(backgroundImage, 0, 0, 1200, 950, this);
		g.drawImage(title, 300, 150, 640, 420, this);
		g.drawImage(startButton, 450, 700, 300, 100, this);
	}
}
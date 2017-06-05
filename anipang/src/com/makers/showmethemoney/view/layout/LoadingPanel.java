package com.makers.showmethemoney.view.layout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class LoadingPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image loadingImage = null;
	Image background;
	
	public LoadingPanel(String s) {
		loadingImage = toolkit.getImage("loading.png");
		background = toolkit.getImage(s);
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, 1200, 950, this);
		g.fillRect(340, 720, 542, 50);
		g.drawImage(loadingImage, 342, 735, 514, 20, this);
	}
	
	public void doDraw() {
		drawLoadingImage(getGraphics());
	}
	
	public void drawLoadingImage(Graphics g) {
		g.clearRect(0, 0, 1200, 950);
		g.drawImage(background, 0, 0, 1200, 950, this);
		g.fillRect(340, 720, 542, 50);
		int count = 0;
		int size = 10;
		
		while(count++ < 255) {
			try {
				Thread.sleep(10);
				g.drawImage(loadingImage, 340 + size, 735, 2, 20, this);
				size += 2;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class LoadingPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image loadingImage = toolkit.getImage("loading.png");
	Image background;
	Image clickMessage;
	boolean state = false;
	
	public LoadingPanel(String s) {
		System.out.println("LoadingPanel 생성자!");
		background = toolkit.getImage(s);
		clickMessage = toolkit.getImage("clickMessage.png");
	}
	
	public void paint(Graphics g) {
		System.out.println("paint!");
		g.drawImage(background, 0, 0, 1200, 950, this);
		g.fillRect(340, 720, 542, 50);
		new TimeThread().start();
		
		if(state)
			printClickMessage(getGraphics());
	}
	
	public void drawLoadingImage(Graphics g, int size) {
		g.setColor(Color.GREEN);
		g.fillRect(344 + size, 735, 2, 20);
//		g.drawImage(loadingImage, 344 + size, 735, 2, 20, this);
	}
	
	public void printClickMessage(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(354, 735, 510, 20);
		g.drawImage(clickMessage, 650, 820, 400, 30, this);
	}
	
	public class TimeThread extends Thread {
		public void run() {
			int count = 0;
			int size = 10;

			System.out.println("스레드");
			while (count++ < 255) {
				try {
					Thread.sleep(10);
					drawLoadingImage(getGraphics(), size);
					size += 2;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			state = true;
			printClickMessage(getGraphics());
		}
	}
}

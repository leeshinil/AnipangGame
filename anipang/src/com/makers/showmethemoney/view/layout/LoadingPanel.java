package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.makers.showmethemoney.model.game.ThreadData;

public class LoadingPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image loadingImage = toolkit.getImage("loading.png");
	Image background;
	Image clickMessage;
	boolean state = false;
	ThreadData threadData = null;
	
	/********** 생성자 **********/
	public LoadingPanel(String s) {
		threadData = ThreadData.getInstance();
		threadData.setInit();
		background = toolkit.getImage(s);
		clickMessage = toolkit.getImage("clickMessage.png");
	}
	
	/********** 그려주는 메소드 **********/
	public void paint(Graphics g) {
		if (threadData.loading_state) {
			new LoadingThread().start();
			threadData.loading_state = false;
		}
		g.drawImage(background, 0, 0, 1200, 950, this);
		g.fillRect(340, 720, 542, 50);
		if(state) {		
			printClickMessage(g);
		}
	}
	
	/********** 로딩 이미지를 그려주는 메소드 **********/
	public void drawLoadingImage(Graphics g, int size) {
		g.setColor(Color.GREEN);
		g.fillRect(344 + size, 735, 2, 20);
	}
	
	/********** 클릭하라는 메세지 출력하는 메소드 **********/
	public void printClickMessage(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(354, 735, 510, 20);
		g.drawImage(clickMessage, 650, 820, 400, 30, this);
	}
	
	/********** 로딩 이미지 스레드 **********/
	public class LoadingThread extends Thread {
		
		public void run() {
			int size = 0;
			while (threadData.getCount() < 255) {
				try {		
					Thread.sleep(10);
					if (threadData.getCount() < 255)
						drawLoadingImage(getGraphics(), size);
					size += 2;
					threadData.setCount();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			state = true;
			repaint();
		}
	}
}

package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class RankingPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image rankPanelbackground = toolkit.getImage("gamePanelBackground.png");
	Image buttonImage = toolkit.getImage("menuButton.png");
	
	public RankingPanel() {
		
	}
	
	public void drawRankingPanel(Graphics g) {
//		g.setColor(Color.LIGHT_GRAY);
//		g.fillRect(0, 0, 1200, 950);
		g.drawImage(rankPanelbackground, 0, 0, 1200, 950, this);
	}
	
	public void drawRankingBankground(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(200, 50, 800, 850);
	}
	
	public void drawRankArea(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(250, 100, 700, 640);
	}

	public void drawRank(Graphics g) {
		g.setColor(Color.orange);
		
		for(int i=1; i<=5; i++)
			g.fillRect(300, 50 + i*110, 600, 80);
	}
	
	public void drawButton(Graphics g) {
		g.drawImage(buttonImage, 450, 770, 300, 100, this);
	}

	public void paint(Graphics g) {
		drawRankingPanel(g);
		drawRankingBankground(g);
		drawRankArea(g);
		drawRank(g);
		drawButton(g);
	}
}

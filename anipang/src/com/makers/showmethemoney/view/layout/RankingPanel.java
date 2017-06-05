package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RankingPanel extends JPanel {
	
	public RankingPanel() {
		
	}
	
	public void drawRankingPanel(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 1200, 950);
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
		g.setColor(Color.black);
		g.fillRect(450, 770, 300, 100);
		g.setColor(Color.WHITE);
		g.fillRect(460, 780, 280, 80);
	}
		
	public void paint(Graphics g) {
		drawRankingPanel(g);
		drawRankingBankground(g);
		drawRankArea(g);
		drawRank(g);
		drawButton(g);
	}
}

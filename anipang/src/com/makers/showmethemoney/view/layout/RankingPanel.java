package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import com.makers.showmethemoney.model.game.GameRankingData;
import com.makers.showmethemoney.model.game.RankingLogic;

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
		
		LinkedList<GameRankingData> list = null;
		list = new RankingLogic().readScoreToFile();
		int size = list.size() < 5 ? list.size() : 5;
		
		for (int i = 0; i < size; i++){
			g.setColor(Color.orange);
			g.fillRect(300, 160 + i * 110, 600, 80);
			g.setColor(Color.BLACK);
			GameRankingData data = list.get(i);
			g.drawString(data.getNickname() + " : " + data.getTotal_score(), 350, 190 + i *110);
			
		}
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

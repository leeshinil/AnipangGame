package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.JPanel;

import com.makers.showmethemoney.model.game.GameRankingData;
import com.makers.showmethemoney.model.game.RankingLogic;

public class RankingPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image rankPanelbackground = toolkit.getImage("gamePanelBackground.png");
	Image buttonImage = toolkit.getImage("menuButton.png");
	Image rankBackground = toolkit.getImage("rankBackground.png");

	/********** rankPanel�� �׷��ִ� �޼ҵ� **********/
	public void drawRankingPanel(Graphics g) {
		g.drawImage(rankPanelbackground, 0, 0, 1200, 950, this);
	}

	/********** rankBackground�� �׷��ִ� �޼ҵ� **********/
	public void drawRankingBankground(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawImage(rankBackground, 200, 0, 800, 950, this);
	}

	/********** RankArea�� �׷��ִ� �޼ҵ� **********/
	public void drawRankArea(Graphics g) {
		g.setColor(Color.darkGray);
//		g.drawRect(250, 100, 700, 640);
	}

	/********** rank�� ��� ���ִ� �޼ҵ� **********/
	public void drawRank(Graphics g) {
		LinkedList<GameRankingData> list = null;
		list = new RankingLogic().readScoreToFile();
		int size = list.size() < 5 ? list.size() : 5;
		
		for (int i = 0; i < size; i++){
			g.setColor(Color.orange);
			g.fillRect(300, 200 + i * 110, 600, 80);
			g.setColor(Color.BLACK);
			GameRankingData data = list.get(i);
			g.setFont(new Font("���� ���", Font.BOLD, 40));
			g.drawString(data.getNickname() + " : " + data.getTotal_score(), 325, 255 + i *110);
		}
	}

	/********** ��ư �̹��� �׸��� �޼ҵ� **********/
	public void drawButton(Graphics g) {
		g.drawImage(buttonImage, 450, 770, 300, 100, this);
	}

	/********** �׷��ִ� �޼ҵ� **********/
	public void paint(Graphics g) {
		drawRankingPanel(g);
		drawRankingBankground(g);
		drawRankArea(g);
		drawRank(g);
		drawButton(g);
	}
}

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

	/********** rankPanel을 그려주는 메소드 **********/
	public void drawRankingPanel(Graphics g) {
		g.drawImage(rankPanelbackground, 0, 0, 1200, 950, this);
	}

	/********** rankBackground를 그려주는 메소드 **********/
	public void drawRankingBankground(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawImage(rankBackground, 200, 0, 800, 950, this);
	}

	/********** RankArea를 그려주는 메소드 **********/
	public void drawRankArea(Graphics g) {
		g.setColor(Color.darkGray);
//		g.drawRect(250, 100, 700, 640);
	}

	/********** rank를 출력 해주는 메소드 **********/
	public void drawRank(Graphics g) {
		LinkedList<GameRankingData> list = null;
		list = new RankingLogic().readScoreToFile();
		int size = list.size() < 5 ? list.size() : 5;
		
		for (int i = 0; i < size; i++){
			g.setColor(Color.orange);
			g.fillRect(300, 200 + i * 110, 600, 80);
			g.setColor(Color.BLACK);
			GameRankingData data = list.get(i);
			g.setFont(new Font("맑은 고딕", Font.BOLD, 40));
			g.drawString(data.getNickname() + " : " + data.getTotal_score(), 325, 255 + i *110);
		}
	}

	/********** 버튼 이미지 그리는 메소드 **********/
	public void drawButton(Graphics g) {
		g.drawImage(buttonImage, 450, 770, 300, 100, this);
	}

	/********** 그려주는 메소드 **********/
	public void paint(Graphics g) {
		drawRankingPanel(g);
		drawRankingBankground(g);
		drawRankArea(g);
		drawRank(g);
		drawButton(g);
	}
}

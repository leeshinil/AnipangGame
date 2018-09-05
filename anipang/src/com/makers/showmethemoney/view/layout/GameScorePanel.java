package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.makers.showmethemoney.model.game.GameData;

public class GameScorePanel extends JPanel {
	Toolkit toolkit = getToolkit();
	JTextField text = null;
	GameData data = null;
	Image gamePanelImage = null;
	Image scoreBackgroundImage = null;
	Image scoreImage = null;
	Image button = null;
	
	/********** 생성자 **********/
	public GameScorePanel(JTextField text) {
		gamePanelImage = toolkit.getImage("gamePanelBackground.png");
		scoreBackgroundImage = toolkit.getImage("input.png");
		scoreImage = toolkit.getImage("score.png");
		button = toolkit.getImage("modeButton2.png");
		
		data = GameData.getInstance();
		
		this.text = text;
		this.add(text);
	}
	
	/********** 게임 종료시 그려주는 메소드 **********/
	public void paint(Graphics g) {
		g.setColor(Color.green); // 점수 영역 백그라운드
		g.drawImage(gamePanelImage, 0, 0, 1200, 950, this);
		
		g.drawImage(scoreBackgroundImage, 150, 150, 900, 600, this);		
		g.setColor(Color.white); // 텍스트 상자 그리기
		g.fillRect(430, 560, 150, 61);
		text.setLocation(450, 580);
		
		g.setFont(new Font("맑은 고딕", Font.BOLD, 100));
		g.drawString("" + data.getTotal(), 430, 400); // 점수
		
		g.drawImage(scoreImage, 450, 200, 300, 70, this); // score 그리기
		g.drawImage(button, 650, 550, 300, 100, this); // 버튼 그리기
	}
}

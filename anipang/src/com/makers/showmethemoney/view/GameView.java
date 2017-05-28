package com.makers.showmethemoney.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.makers.showmethemoney.controller.GameController;
import com.makers.showmethemoney.model.game.GameData;

public class GameView extends JPanel implements MouseListener {
	// ��������ȭ����ǥ�����г�
	int compare_x[] = new int[2]; // x��ǥ�� ���� ����
	int compare_y[] = new int[2]; // y��ǥ�� ���� ����
	Toolkit toolkit = getToolkit(); // �̹��� �ҷ��� ��Ŷ
	Image icons[] = new Image[7];
	Image images[] = new Image[3];
	GameData data = GameData.getInstance();
	GameController gameController = null;
	
	GameView() {
		gameController = new GameController();
		
		setIcon();
		setImage();
	}
	
	public void printMap() {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}
	
	public void setIcon() {
		for(int index=0; index<=6; index++)
			icons[index] = toolkit.getImage("money" + (index) + ".png");
	}
	
	public void setImage() {
		images[0] = toolkit.getImage("gameBackground1.png");
	}
	
	public void drawIcon(Graphics g, int i, int j) {
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 25, (i - 1) * 80 + 25, 70, 70, this);
//		g.setColor(Color.blue);
//		g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}
	
	public void drawImage(Graphics g, int i) {
		g.drawImage(images[i], 0, 0, 605, 605, this);
	}
	
	public void drawRect(Graphics g, int i, int j) {
		g.setColor(Color.blue);
		g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, 700, 700);
		drawImage(g, 0);
		
		for (int i = 1; i <= 7; i++)
			for (int j = 1; j <= 7; j++)
				drawIcon(g, i, j);
	}
		
	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	
	public void mousePressed(MouseEvent e) {
		int x = (e.getX()-20) / 80 + 1;
		int y = (e.getY()-20) / 80 + 1;
		compare_x[0] = y;
		compare_y[0] = x;
	}
	
	public void mouseReleased(MouseEvent e) {
		int x = (e.getX()-20) / 80 + 1;
		int y = (e.getY()-20) / 80 + 1;
		compare_x[1] = y;
		compare_y[1] = x;
		boolean swap_state = gameController.swapCompare(compare_x, compare_y);
		if (!swap_state) {
			// error
			System.out.println("error");
		} else {
			repaint();
		}
		// sleep(1000);
		gameController.bomb(compare_x, compare_y);
		repaint();
	}
}
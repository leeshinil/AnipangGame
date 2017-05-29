package com.makers.showmethemoney.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.makers.showmethemoney.controller.GameController;
import com.makers.showmethemoney.model.game.GameData;

public class GameView extends JPanel implements MouseListener {
	// 실제게임화면을표시할패널
	int compare_x[] = new int[2]; // x좌표를 비교할 변수
	int compare_y[] = new int[2]; // y좌표를 비교할 변수
	Toolkit toolkit = getToolkit(); // 이미지 불러올 툴킷
	Image icons[] = new Image[7];
	Image images[] = new Image[3];
	GameData data = GameData.getInstance();
	GameController gameController = null;
	int type = 0;
	int size = 1;

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
		for (int index = 0; index <= 6; index++)
			icons[index] = toolkit.getImage("money" + (index) + ".png");
	}

	public void setImage() {
		images[0] = toolkit.getImage("background.png");
	}

	public void drawIcon(Graphics g, int i, int j) {
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 25, (i - 1) * 80 + 25, 70, 70, this);
		// g.setColor(Color.blue);
		// g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}

	public void drawImage(Graphics g, int i) {
		g.drawImage(images[i], 0, 0, 605, 605, this);
	}

	public void drawRect(Graphics g, int i, int j) {
		g.setColor(Color.blue);
		g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}

	public void moveRightDraw(Graphics g, int start_x, int start_y) {
		g.setColor(Color.BLACK);
		g.fillRect(((start_y - 1) * 80 + 25 + size - 10), (start_x - 1) * 80 + 25, 70, 70);

		// move
		g.drawImage(icons[data.getMap(start_x, start_y)], ((start_y - 1) * 80 + 25 + size), (start_x - 1) * 80 + 25, 70,
				70, this);
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 700, 700);
		drawImage(g, 0);
		for (int i = 1; i <= 7; i++)
			for (int j = 1; j <= 7; j++)
				drawIcon(g, i, j);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		int x = (e.getX() - 20) / 80 + 1;
		int y = (e.getY() - 20) / 80 + 1;
		compare_x[0] = y;
		compare_y[0] = x;
	}

	public void mouseReleased(MouseEvent e) {
		int x = (e.getX() - 20) / 80 + 1;
		int y = (e.getY() - 20) / 80 + 1;
		compare_x[1] = y;
		compare_y[1] = x;

		new MoveThread().start();

		System.out.println("finish");
		repaint();
	}

	public void swap() {
		boolean swap_state = gameController.swapCompare(compare_x, compare_y);
		if (!swap_state) {
			// error
			System.out.println("error");
		} else {
			repaint();
		}
		gameController.bomb(compare_x, compare_y);
	}

	public class MoveThread extends Thread {

		public void run() {
			int count = 1;
			type = 1;
			while (count++ < 10) {
				try {
					Thread.sleep(50);
					moveRightDraw(getGraphics(), compare_x[0], compare_y[0]);
					size += 10;

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			swap();
			size = 1;
		}

	}
}

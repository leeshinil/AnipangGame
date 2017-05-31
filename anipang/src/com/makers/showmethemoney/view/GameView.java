package com.makers.showmethemoney.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.makers.showmethemoney.controller.GameController;
import com.makers.showmethemoney.model.game.GameData;

public class GameView extends JPanel implements MouseListener {
	// ��������ȭ����ǥ�����г�
	int compare_x[] = new int[2]; // ���� x��ǥ�� ���� �迭
	int compare_y[] = new int[2]; // ���� y��ǥ�� ���� �迭
	Toolkit toolkit = getToolkit(); // �̹����� �ҷ��� toolkit ��ü
	Image icons[] = new Image[7]; // ������ �̹����� ���� �迭
	Image images[] = new Image[3]; // ��� �̹����� ���� �迭
	GameData data = GameData.getInstance(); // �����͸� ���� ��ü
	GameController gameController = null;
	int type = 0; // thread
	int size = 1; // thread

	GameView() { // ������
		gameController = new GameController(); // GameController ��ü ����

		setIcon(); // ������ �̹��� �ʱ�ȭ
		setImage(); // ��� �̹��� �ʱ�ȭ
	}

	public void printMap() { // Map�� ����ִ� �� value���� �ܼ�â�� ������ִ� �޼ҵ�
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}

	public void setIcon() {	// ������ �̹��� �迭�� �̹��� �ҽ��� ������ �ʱ�ȭ ���ִ� �޼ҵ�
		for (int index = 0; index <= 6; index++)
			icons[index] = toolkit.getImage("money__" + (index) + ".png");
	}

	public void setImage() { // ��� �̹��� �迭�� �̹��� �ҽ��� ������ �ʱ�ȭ ���ִ� �޼ҵ�
		images[0] = toolkit.getImage("background1.png");
	}

	public void drawIcon(Graphics g, int i, int j) { // �� ��ǥ���� ������ �̹����� �׷��ִ� �޼ҵ�
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 25, (i - 1) * 80 + 25, 70, 70, this);
		// g.setColor(Color.blue);
		// g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}

	public void drawImage(Graphics g, int i) { // ��� �̹����� �׷��ִ� �޼ҵ�
		g.drawImage(images[i], 0, 0, 605, 605, this);
	}

	public void drawRect(Graphics g, int i, int j) { // �̹��� �ֺ��� �簢���� �׷��ִ� �޼ҵ� - ��� ���ϴ���
		g.setColor(Color.blue);
		g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}

	public void moveRightDraw(Graphics g, int start_x, int start_y) { // ���������� �̵��� �� �������� �׷��ִ� �޼ҵ� - �ִϸ��̼�, �̿ϼ�
		g.setColor(Color.BLACK);
		g.fillRect(((start_y - 1) * 80 + 25 + size - 10), (start_x - 1) * 80 + 25, 70, 70);

		// move
		g.drawImage(icons[data.getMap(start_x, start_y)], ((start_y - 1) * 80 + 25 + size), (start_x - 1) * 80 + 25, 70,
				70, this);
	}

	public void paint(Graphics g) { // �����ܵ�� ��� �̹����� �׷��ִ� �޼ҵ�
		g.clearRect(0, 0, 700, 700);
		drawImage(g, 0);
		for (int i = 1; i <= 7; i++)
			for (int j = 1; j <= 7; j++)
				drawIcon(g, i, j);
	}

	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	
	public void mousePressed(MouseEvent e) { // ���콺�� ���� �κп� ���� �̺�Ʈ ó�� �޼ҵ�
		int x = (e.getX() - 20) / 80 + 1; // x��ǥ�κ��� ���� �迭�� y�ε��� �� ( (x,y)��ǥ�� �迭 �ε����� �����ϸ� (y,x)�̹Ƿ� )
		int y = (e.getY() - 20) / 80 + 1; // y��ǥ�κ��� ���� �迭�� x�ε��� �� 
		compare_x[0] = y;
		compare_y[0] = x;
	}

	public void mouseReleased(MouseEvent e) { // ���콺�� �� �κп� ���� �̺�Ʈ ó�� �޼ҵ�
		int x = (e.getX() - 20) / 80 + 1; // x��ǥ�κ��� ���� �迭�� y�ε��� ��
		int y = (e.getY() - 20) / 80 + 1; // y��ǥ�κ��� ���� �迭�� x�ε��� �� 
		compare_x[1] = y;
		compare_y[1] = x;

//		new MoveThread().start();			// thread ȿ�� ���ֱ� ���ؼ� ��� �ּ�ó�� �Ͽ���
		swap();								// MoveThread �޼ҵ� ���� ������ ��� �����Ͽ� �ٿ��ֱ� �Ͽ���
//		System.out.println("finish");
		repaint();  // �ٽ� �׷��ִ� �޼ҵ�
	}

	public void swap() { // Pressed, Released�� value�� swap�ϴ� �޼ҵ�
		boolean swap_state = gameController.swapCompare(compare_x, compare_y);
		// gameController�� swapCompare�� �Ķ���ͷ� x,y index�� ���� ���� ���� �迭���� �Ѱ���
		
		if (!swap_state) { // swap�Ұ����� ��ġ���� swap_state�� false�̸�
			
		} else {
			repaint(); // �ٽ� �׷��ִ� �޼ҵ�
		}

		gameController.bomb(compare_x, compare_y);
	
	}

//	public class MoveThread extends Thread {									//�ӽ÷� �ּ�ó�� �Ͽ���
//
//		public void run() {
//			int count = 1;
//			type = 1;
//			while (count++ < 10) {
//				try {
//					Thread.sleep(50);
//					moveRightDraw(getGraphics(), compare_x[0], compare_y[0]);
//					size += 10;
//
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			swap();
//			size = 1;
//		}
//
//	}
}

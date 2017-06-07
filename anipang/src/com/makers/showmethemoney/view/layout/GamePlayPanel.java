package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.makers.showmethemoney.controller.GameController;
import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.view.screen.ScoreView;

public class GamePlayPanel extends JPanel implements MouseListener {
	// ��������ȭ����ǥ�����г�
	int compare_x[] = new int[2]; // ���� x��ǥ�� ���� �迭
	int compare_y[] = new int[2]; // ���� y��ǥ�� ���� �迭
	Toolkit toolkit = getToolkit(); // �̹����� �ҷ��� toolkit ��ü
	Image icons[] = new Image[9]; // ������ �̹����� ���� �迭
	Image gamePanelImage = null; // ���� �г� �̹����� ���� �迭
	Image gameBackgroundImage = null; // ���� ������ ��� ��� �̹���
	GameData data = GameData.getInstance(); // �����͸� ���� ��ü
	GameController gameController = null;

	JFrame frame = null; // ���� ���� �� GameView�� Frame�� �ݱ� ���� frame�� ������ ����

	boolean state = true; // thread
	boolean end = false; //

	/********** ������ **********/
	public GamePlayPanel(JFrame frame) {
		this.frame = frame;
		gameController = new GameController(); // GameController ��ü ����
		data.initTime();
		data.setGameStart();
		data.setInitTotal();

		setIcon(); // ������ �̹��� �ʱ�ȭ
		setGameBackgroundImage(); // ���� �г� ��� �̹��� �ʱ�ȭ
		setGamePanelImage(); // ���� ������ ��� ��� �̹��� �ʱ�ȭ
	}

	/********** ��� �̹��� �迭�� �̹��� �ҽ��� ������ �ʱ�ȭ ���ִ� �޼ҵ� **********/
	public void setGamePanelImage() {
		gamePanelImage = toolkit.getImage("gamePanelBackground.png");
	}

	/********** ��� �̹��� �迭�� �̹��� �ҽ��� ������ �ʱ�ȭ ���ִ� �޼ҵ� **********/
	public void setGameBackgroundImage() {
		gameBackgroundImage = toolkit.getImage("gameBackground.png");
	}

	/********** ������ �̹��� �迭�� �̹��� �ҽ��� ������ �ʱ�ȭ ���ִ� �޼ҵ� **********/
	public void setIcon() {
		for (int index = 0; index <= 8; index++)
			icons[index] = toolkit.getImage("money__" + (index) + ".png");
	}

	/********** ���� �г� ��� �̹����� �׷��ִ� �޼ҵ� **********/
	public void drawGamePanelImage(Graphics g) {
		g.drawImage(gamePanelImage, 0, 0, 1200, 950, this);
	}

	/********** ���� ������ ��� ��� �̹����� �׷��ִ� �޼ҵ� **********/
	public void drawGameBackgroundImage(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(190, 200, 605, 605);
	}

	/********** ������ ������ ���ھ� ���带 �׷��ִ� �޼ҵ� **********/
	public void drawScore(Graphics g) {
		g.clearRect(815, 200, 200, 605);
		g.setColor(Color.black);
		g.fillRect(815, 200, 200, 605);

		// google�� g.setFont(�۾� ũ��, �۲�)
		g.setColor(Color.WHITE);

		int score[] = data.getScore();

		data.sumTotal();
		g.drawString("SCORE :  " + data.getTotal(), 850, 235);

		for (int i = 1; i < 7; i++) {
			g.drawImage(icons[i], 850, 230 + (i * 50), 40, 40, this);
			g.drawString(" x  " + score[i], 895, 255 + (i * 50));
		}

		g.drawImage(icons[7], 850, 580, 30, 30, this); // item count
		g.drawImage(icons[8], 880, 580, 30, 30, this); // item count
		g.drawString(" x  " + score[0], 920, 594);
	}

	/********** ������ ���� �ð����带 �׷��ִ� �޼ҵ� **********/
	public void drawTime(Graphics g) {
		if (state) {
			g.setColor(Color.black);
			g.fillRect(190, 90, 825, 90);
			g.setColor(Color.GREEN);
			g.fillRect(210, 110, 785, 50);
		}
		g.clearRect(995 - (600 - data.getTime()) * 13 / 10, 110, (600 - data.getTime()) * 13 / 10, 50);
		g.setColor(Color.GREEN);
		g.fillRect(975 - (600 - data.getTime()) * 13 / 10, 110, 20, 50);
		g.setColor(Color.black);
		g.drawString(Integer.toString(data.getTime() / 10), 975 - (600 - data.getTime()) * 13 / 10, 140);
	}

	/********** �����ǿ� �������� �׷��ִ� �޼ҵ� 190, 200 **********/
	public void drawIcon(Graphics g, int i, int j) { // �� ��ǥ���� ������ �̹����� �׷��ִ� �޼ҵ�
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 215, (i - 1) * 80 + 225, 70, 70, this);
	}

	/********** ��ư �̹��� �׷��ִ� �޼ҵ� **********/
	public void drawButton(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(495, 830, 300, 100);
	}

	/********** �����ܵ�� ��� �̹����� �׷��ִ� �޼ҵ� **********/
	public void paint(Graphics g) {
		if (!data.getGameFinish()) { // ���� ���� ���°� false �̸�
			if (state) { // ó�� ���� ��
				drawGamePanelImage(g);
				drawGameBackgroundImage(g);
				drawTime(g);
				new TimeThread().start();
				state = false;
			}
			for (int i = 1; i <= 7; i++)
				for (int j = 1; j <= 7; j++)
					drawIcon(g, i, j);
			drawScore(g);
		} else { // ������ ����� ��
			new ScoreView();
			frame.dispose();
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) { // ���콺�� ���� �κп� ���� �̺�Ʈ ó�� �޼ҵ�
		int x = (e.getX() - 215) / 80 + 1; // x��ǥ�κ��� ���� �迭�� y�ε��� �� ( (x,y)��ǥ�� �迭
											// �ε����� �����ϸ� (y,x)�̹Ƿ� )
		int y = (e.getY() - 225) / 80 + 1; // y��ǥ�κ��� ���� �迭�� x�ε��� ��
		compare_x[0] = y;
		compare_y[0] = x;
	}

	public void mouseReleased(MouseEvent e) { // ���콺�� �� �κп� ���� �̺�Ʈ ó�� �޼ҵ�
		int x = (e.getX() - 215) / 80 + 1; // x��ǥ�κ��� ���� �迭�� y�ε��� ��
		int y = (e.getY() - 225) / 80 + 1; // y��ǥ�κ��� ���� �迭�� x�ε��� ��
		compare_x[1] = y;
		compare_y[1] = x;

		gameController.doAction(compare_x, compare_y);
		repaint(); // �ٽ� �׷��ִ� �޼ҵ�
	}

	/********** �ð� ������ **********/
	public class TimeThread extends Thread {
		public void run() {
			while (data.getTime() > 0) {
				try {
					System.out.println(data.getTime());
					drawTime(getGraphics());
					Thread.sleep(100);
					data.setTime(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Finish
			repaint();
			data.setGameFinish(); // ������ ���� �� ���� ���� ����
		}
	}
}
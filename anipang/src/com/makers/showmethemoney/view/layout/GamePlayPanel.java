package com.makers.showmethemoney.view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.makers.showmethemoney.controller.GameController;
import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.view.screen.LoadingView;
import com.makers.showmethemoney.view.screen.RankingView;

public class GamePlayPanel extends JPanel implements MouseListener {
	// ��������ȭ����ǥ�����г�
	int compare_x[] = new int[2]; // ���� x��ǥ�� ���� �迭
	int compare_y[] = new int[2]; // ���� y��ǥ�� ���� �迭
	Toolkit toolkit = getToolkit(); // �̹����� �ҷ��� toolkit ��ü
	Image icons[] = new Image[9]; // ������ �̹����� ���� �迭
	Image gamePanelImage; // ���� �г� �̹����� ���� �迭
	Image gameBackgroundImage; // ���� ������ ��� ��� �̹���
	GameData data = GameData.getInstance(); // �����͸� ���� ��ü
	GameController gameController = null;
	
	boolean state = true; // thread
	boolean end = false;
	
	/********** ������ **********/
	public GamePlayPanel() {
		gameController = new GameController(); // GameController ��ü ����

		setIcon(); // ������ �̹��� �ʱ�ȭ
		setGameBackgroundImage(); // ���� �г� ��� �̹��� �ʱ�ȭ
		setGamePanelImage(); // ���� ������ ��� ��� �̹��� �ʱ�ȭ
	}

	/********** Map�� ����ִ� �� value���� �ܼ�â�� ������ִ� �޼ҵ� **********/
	public void printMap() {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
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
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 1200, 950);
	}

	/********** ���� ������ ��� ��� �̹����� �׷��ִ� �޼ҵ� **********/
	public void drawGameBackgroundImage(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(190, 200, 605, 605);
	}

	/********** ������ ������ ���ھ� ���带 �׷��ִ� �޼ҵ� **********/
	public void drawScore(Graphics g) {
		g.clearRect(815, 200, 200, 605);
		g.setColor(Color.blue);
		g.fillRect(815, 200, 200, 605);

		// google�� g.setFont(�۾� ũ��, �۲�)
		g.setColor(Color.WHITE);

		int score[] = data.getScore();

		data.setInitTotal();
		g.drawImage(icons[0], 850, 220, 30, 30, this);	// total Score
		g.drawString(" :  " + data.sumTotal(), 890, 240);

		for (int i = 1; i < 7; i++) {
			g.drawImage(icons[i], 850, 220 + (i * 37), 30, 30, this);
			g.drawString(" x  " + score[i], 890, 240 + (i * 37));
		}
		
		g.drawImage(icons[7], 850, 220 + 259, 30, 30, this); // item count
		g.drawImage(icons[8], 880, 220 + 259, 30, 30, this); // item count
		g.drawString(" x  " + score[0], 920, 240 + 259);
	}

	/********** ������ ���� �ð����带 �׷��ִ� �޼ҵ� **********/
	public void drawTime(Graphics g) {
		if(state){
			g.setColor(Color.RED);
			g.fillRect(190, 90, 825, 90);
			g.setColor(Color.GREEN);
			g.fillRect(210, 110, 785, 50);
			System.out.println("�۽�ƮŸ�� ��ο�");
		}
		System.out.println("Ÿ�� ��ο�");
		g.clearRect(995-(600-data.getTime())*13/10, 110, (600-data.getTime())*13/10, 50);
	}
	
	/********** �����ǿ� �������� �׷��ִ� �޼ҵ� 190, 200 **********/
	public void drawIcon(Graphics g, int i, int j) { // �� ��ǥ���� ������ �̹����� �׷��ִ� �޼ҵ�
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 215, (i - 1) * 80 + 225, 70, 70, this);
	}

//	public void moveRightDraw(Graphics g, int start_x, int start_y) { // ���������� �̵��� �� �������� �׷��ִ� �޼ҵ� - �ִϸ��̼�, �̿ϼ�
//		g.setColor(Color.BLACK);
//		g.fillRect(((start_y - 1) * 80 + 25 + size - 10), (start_x - 1) * 80 + 25, 70, 70);
//
//		// move
//		g.drawImage(icons[data.getMap(start_x, start_y)], ((start_y - 1) * 80 + 25 + size), (start_x - 1) * 80 + 25, 70, 70, this);
//	}
	
	/********** ��ư �̹��� �׷��ִ� �޼ҵ� **********/
	public void drawButton(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(495, 830, 300, 100);
	}
	
	/********** �����ܵ�� ��� �̹����� �׷��ִ� �޼ҵ� **********/
	public void paint(Graphics g) {
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
	}

	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	
	public void mousePressed(MouseEvent e) { // ���콺�� ���� �κп� ���� �̺�Ʈ ó�� �޼ҵ�
		int x = (e.getX() - 215) / 80 + 1; // x��ǥ�κ��� ���� �迭�� y�ε��� �� ( (x,y)��ǥ�� �迭 �ε����� �����ϸ� (y,x)�̹Ƿ� )
		int y = (e.getY() - 225) / 80 + 1; // y��ǥ�κ��� ���� �迭�� x�ε��� �� 
		compare_x[0] = y;
		compare_y[0] = x;
	}

	public void mouseReleased(MouseEvent e) { // ���콺�� �� �κп� ���� �̺�Ʈ ó�� �޼ҵ�
		int x = (e.getX() - 215) / 80 + 1; // x��ǥ�κ��� ���� �迭�� y�ε��� ��
		int y = (e.getY() - 225) / 80 + 1; // y��ǥ�κ��� ���� �迭�� x�ε��� �� 
		compare_x[1] = y;
		compare_y[1] = x;

//		new MoveThread().start();		// thread ȿ�� ���ֱ� ���ؼ� ��� �ּ�ó�� �Ͽ���
		gameController.doAction(compare_x, compare_y);
		repaint();  // �ٽ� �׷��ִ� �޼ҵ�
	}

	/********** �ð� ������ **********/
	 public class TimeThread extends Thread {
	      public void run() {
	         while (data.getTime() > 0) {
	            try {
	               System.out.println(data.getTime());
	               drawTime(getGraphics());
	               Thread.sleep(10);
	               data.setTime(1);

	            } catch (InterruptedException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	         
	         }
	         
	         // Finish
	         finish();
	      }
	   }
	 
	 /********** ������ ���� �� �����ϴ� �޼ҵ� **********/ /////////////////////////// ���� �� �߰� ����
	 public void finish() {
		 Buttons button = new Buttons(495, 830) {
        	 public void actionPerformed(ActionEvent e) {
 				new RankingView();
 			}
 		};
 		this.add(button);
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
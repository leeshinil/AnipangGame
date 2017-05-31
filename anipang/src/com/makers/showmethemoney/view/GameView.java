package com.makers.showmethemoney.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.makers.showmethemoney.controller.GameController;
import com.makers.showmethemoney.model.game.GameData;

public class GameView extends JPanel implements MouseListener {
	// 실제게임화면을표시할패널
	int compare_x[] = new int[2]; // 비교할 x좌표를 담을 배열
	int compare_y[] = new int[2]; // 비교할 y좌표를 담을 배열
	Toolkit toolkit = getToolkit(); // 이미지를 불러올 toolkit 객체
	Image icons[] = new Image[7]; // 아이콘 이미지를 담을 배열
	Image images[] = new Image[3]; // 배경 이미지를 담을 배열
	GameData data = GameData.getInstance(); // 데이터를 담을 객체
	GameController gameController = null;
	int type = 0; // thread
	int size = 1; // thread

	GameView() { // 생성자
		gameController = new GameController(); // GameController 객체 생성

		setIcon(); // 아이콘 이미지 초기화
		setImage(); // 배경 이미지 초기화
	}

	public void printMap() { // Map에 들어있는 각 value값을 콘솔창에 출력해주는 메소드
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}

	public void setIcon() {	// 아이콘 이미지 배열에 이미지 소스를 가져와 초기화 해주는 메소드
		for (int index = 0; index <= 6; index++)
			icons[index] = toolkit.getImage("money__" + (index) + ".png");
	}

	public void setImage() { // 배경 이미지 배열에 이미지 소스를 가져와 초기화 해주는 메소드
		images[0] = toolkit.getImage("background1.png");
	}

	public void drawIcon(Graphics g, int i, int j) { // 각 좌표별로 아이콘 이미지를 그려주는 메소드
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 25, (i - 1) * 80 + 25, 70, 70, this);
		// g.setColor(Color.blue);
		// g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}

	public void drawImage(Graphics g, int i) { // 배경 이미지를 그려주는 메소드
		g.drawImage(images[i], 0, 0, 605, 605, this);
	}

	public void drawRect(Graphics g, int i, int j) { // 이미지 주변에 사각형을 그려주는 메소드 - 사용 안하는중
		g.setColor(Color.blue);
		g.drawRect((j - 1) * 80 + 20, (i - 1) * 80 + 20, 80, 80);
	}

	public void moveRightDraw(Graphics g, int start_x, int start_y) { // 오른쪽으로 이동할 때 아이콘을 그려주는 메소드 - 애니메이션, 미완성
		g.setColor(Color.BLACK);
		g.fillRect(((start_y - 1) * 80 + 25 + size - 10), (start_x - 1) * 80 + 25, 70, 70);

		// move
		g.drawImage(icons[data.getMap(start_x, start_y)], ((start_y - 1) * 80 + 25 + size), (start_x - 1) * 80 + 25, 70,
				70, this);
	}

	public void paint(Graphics g) { // 아이콘들과 배경 이미지를 그려주는 메소드
		g.clearRect(0, 0, 700, 700);
		drawImage(g, 0);
		for (int i = 1; i <= 7; i++)
			for (int j = 1; j <= 7; j++)
				drawIcon(g, i, j);
	}

	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	
	public void mousePressed(MouseEvent e) { // 마우스를 누른 부분에 대한 이벤트 처리 메소드
		int x = (e.getX() - 20) / 80 + 1; // x좌표로부터 얻은 배열의 y인덱스 값 ( (x,y)좌표를 배열 인덱스로 생각하면 (y,x)이므로 )
		int y = (e.getY() - 20) / 80 + 1; // y좌표로부터 얻은 배열의 x인덱스 값 
		compare_x[0] = y;
		compare_y[0] = x;
	}

	public void mouseReleased(MouseEvent e) { // 마우스를 뗀 부분에 대한 이벤트 처리 메소드
		int x = (e.getX() - 20) / 80 + 1; // x좌표로부터 얻은 배열의 y인덱스 값
		int y = (e.getY() - 20) / 80 + 1; // y좌표로부터 얻은 배열의 x인덱스 값 
		compare_x[1] = y;
		compare_y[1] = x;

//		new MoveThread().start();			// thread 효과 없애기 위해서 잠시 주석처리 하였음
		swap();								// MoveThread 메소드 안의 내용을 잠시 복사하여 붙여넣기 하였음
//		System.out.println("finish");
		repaint();  // 다시 그려주는 메소드
	}

	public void swap() { // Pressed, Released의 value를 swap하는 메소드
		boolean swap_state = gameController.swapCompare(compare_x, compare_y);
		// gameController의 swapCompare에 파라미터로 x,y index에 대한 값을 담은 배열들을 넘겨줌
		
		if (!swap_state) { // swap불가능한 위치여서 swap_state가 false이면
			
		} else {
			repaint(); // 다시 그려주는 메소드
		}

		gameController.bomb(compare_x, compare_y);
	
	}

//	public class MoveThread extends Thread {									//임시로 주석처리 하였음
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

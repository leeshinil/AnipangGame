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
	// 실제게임화면을표시할패널
	int compare_x[] = new int[2]; // 비교할 x좌표를 담을 배열
	int compare_y[] = new int[2]; // 비교할 y좌표를 담을 배열
	Toolkit toolkit = getToolkit(); // 이미지를 불러올 toolkit 객체
	Image icons[] = new Image[9]; // 아이콘 이미지를 담을 배열
	Image gamePanelImage; // 게임 패널 이미지를 담을 배열
	Image gameBackgroundImage; // 게임 아이콘 출력 배경 이미지
	GameData data = GameData.getInstance(); // 데이터를 담을 객체
	GameController gameController = null;
	
	boolean state = true; // thread
	boolean end = false;
	
	/********** 생성자 **********/
	public GamePlayPanel() {
		gameController = new GameController(); // GameController 객체 생성

		setIcon(); // 아이콘 이미지 초기화
		setGameBackgroundImage(); // 게임 패널 배경 이미지 초기화
		setGamePanelImage(); // 게임 아이콘 출력 배경 이미지 초기화
	}

	/********** Map에 들어있는 각 value값을 콘솔창에 출력해주는 메소드 **********/
	public void printMap() {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}
	
	/********** 배경 이미지 배열에 이미지 소스를 가져와 초기화 해주는 메소드 **********/
	public void setGamePanelImage() {
		gamePanelImage = toolkit.getImage("gamePanelBackground.png");
	}
	
	/********** 배경 이미지 배열에 이미지 소스를 가져와 초기화 해주는 메소드 **********/
	public void setGameBackgroundImage() {
		gameBackgroundImage = toolkit.getImage("gameBackground.png");
	}

	/********** 아이콘 이미지 배열에 이미지 소스를 가져와 초기화 해주는 메소드 **********/
	public void setIcon() {
		for (int index = 0; index <= 8; index++)
			icons[index] = toolkit.getImage("money__" + (index) + ".png");
	}
	
	/********** 게임 패널 배경 이미지를 그려주는 메소드 **********/
	public void drawGamePanelImage(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 1200, 950);
	}

	/********** 게임 아이콘 출력 배경 이미지를 그려주는 메소드 **********/
	public void drawGameBackgroundImage(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(190, 200, 605, 605);
	}

	/********** 게임판 오른쪽 스코어 보드를 그려주는 메소드 **********/
	public void drawScore(Graphics g) {
		g.clearRect(815, 200, 200, 605);
		g.setColor(Color.blue);
		g.fillRect(815, 200, 200, 605);

		// google에 g.setFont(글씨 크기, 글꼴)
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

	/********** 게임판 위쪽 시간보드를 그려주는 메소드 **********/
	public void drawTime(Graphics g) {
		if(state){
			g.setColor(Color.RED);
			g.fillRect(190, 90, 825, 90);
			g.setColor(Color.GREEN);
			g.fillRect(210, 110, 785, 50);
			System.out.println("퍼스트타임 드로우");
		}
		System.out.println("타임 드로우");
		g.clearRect(995-(600-data.getTime())*13/10, 110, (600-data.getTime())*13/10, 50);
	}
	
	/********** 게임판에 아이콘을 그려주는 메소드 190, 200 **********/
	public void drawIcon(Graphics g, int i, int j) { // 각 좌표별로 아이콘 이미지를 그려주는 메소드
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 215, (i - 1) * 80 + 225, 70, 70, this);
	}

//	public void moveRightDraw(Graphics g, int start_x, int start_y) { // 오른쪽으로 이동할 때 아이콘을 그려주는 메소드 - 애니메이션, 미완성
//		g.setColor(Color.BLACK);
//		g.fillRect(((start_y - 1) * 80 + 25 + size - 10), (start_x - 1) * 80 + 25, 70, 70);
//
//		// move
//		g.drawImage(icons[data.getMap(start_x, start_y)], ((start_y - 1) * 80 + 25 + size), (start_x - 1) * 80 + 25, 70, 70, this);
//	}
	
	/********** 버튼 이미지 그려주는 메소드 **********/
	public void drawButton(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(495, 830, 300, 100);
	}
	
	/********** 아이콘들과 배경 이미지를 그려주는 메소드 **********/
	public void paint(Graphics g) {
		if (state) { // 처음 시작 시
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
	
	public void mousePressed(MouseEvent e) { // 마우스를 누른 부분에 대한 이벤트 처리 메소드
		int x = (e.getX() - 215) / 80 + 1; // x좌표로부터 얻은 배열의 y인덱스 값 ( (x,y)좌표를 배열 인덱스로 생각하면 (y,x)이므로 )
		int y = (e.getY() - 225) / 80 + 1; // y좌표로부터 얻은 배열의 x인덱스 값 
		compare_x[0] = y;
		compare_y[0] = x;
	}

	public void mouseReleased(MouseEvent e) { // 마우스를 뗀 부분에 대한 이벤트 처리 메소드
		int x = (e.getX() - 215) / 80 + 1; // x좌표로부터 얻은 배열의 y인덱스 값
		int y = (e.getY() - 225) / 80 + 1; // y좌표로부터 얻은 배열의 x인덱스 값 
		compare_x[1] = y;
		compare_y[1] = x;

//		new MoveThread().start();		// thread 효과 없애기 위해서 잠시 주석처리 하였음
		gameController.doAction(compare_x, compare_y);
		repaint();  // 다시 그려주는 메소드
	}

	/********** 시간 스레드 **********/
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
	 
	 /********** 스레드 종료 후 실행하는 메소드 **********/ /////////////////////////// 수정 및 추가 요함
	 public void finish() {
		 Buttons button = new Buttons(495, 830) {
        	 public void actionPerformed(ActionEvent e) {
 				new RankingView();
 			}
 		};
 		this.add(button);
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
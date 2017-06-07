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
	// 실제게임화면을표시할패널
	int compare_x[] = new int[2]; // 비교할 x좌표를 담을 배열
	int compare_y[] = new int[2]; // 비교할 y좌표를 담을 배열
	Toolkit toolkit = getToolkit(); // 이미지를 불러올 toolkit 객체
	Image icons[] = new Image[9]; // 아이콘 이미지를 담을 배열
	Image gamePanelImage = null; // 게임 패널 이미지를 담을 배열
	Image gameBackgroundImage = null; // 게임 아이콘 출력 배경 이미지
	GameData data = GameData.getInstance(); // 데이터를 담을 객체
	GameController gameController = null;

	JFrame frame = null; // 게임 종료 시 GameView의 Frame을 닫기 위해 frame을 저장할 변수

	boolean state = true; // thread
	boolean end = false; //

	/********** 생성자 **********/
	public GamePlayPanel(JFrame frame) {
		this.frame = frame;
		gameController = new GameController(); // GameController 객체 생성
		data.initTime();
		data.setGameStart();
		data.setInitTotal();

		setIcon(); // 아이콘 이미지 초기화
		setGameBackgroundImage(); // 게임 패널 배경 이미지 초기화
		setGamePanelImage(); // 게임 아이콘 출력 배경 이미지 초기화
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
		g.drawImage(gamePanelImage, 0, 0, 1200, 950, this);
	}

	/********** 게임 아이콘 출력 배경 이미지를 그려주는 메소드 **********/
	public void drawGameBackgroundImage(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(190, 200, 605, 605);
	}

	/********** 게임판 오른쪽 스코어 보드를 그려주는 메소드 **********/
	public void drawScore(Graphics g) {
		g.clearRect(815, 200, 200, 605);
		g.setColor(Color.black);
		g.fillRect(815, 200, 200, 605);

		// google에 g.setFont(글씨 크기, 글꼴)
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

	/********** 게임판 위쪽 시간보드를 그려주는 메소드 **********/
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

	/********** 게임판에 아이콘을 그려주는 메소드 190, 200 **********/
	public void drawIcon(Graphics g, int i, int j) { // 각 좌표별로 아이콘 이미지를 그려주는 메소드
		g.drawImage(icons[data.getMap(i, j)], (j - 1) * 80 + 215, (i - 1) * 80 + 225, 70, 70, this);
	}

	/********** 버튼 이미지 그려주는 메소드 **********/
	public void drawButton(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(495, 830, 300, 100);
	}

	/********** 아이콘들과 배경 이미지를 그려주는 메소드 **********/
	public void paint(Graphics g) {
		if (!data.getGameFinish()) { // 게임 종료 상태가 false 이면
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
		} else { // 게임이 종료된 후
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

	public void mousePressed(MouseEvent e) { // 마우스를 누른 부분에 대한 이벤트 처리 메소드
		int x = (e.getX() - 215) / 80 + 1; // x좌표로부터 얻은 배열의 y인덱스 값 ( (x,y)좌표를 배열
											// 인덱스로 생각하면 (y,x)이므로 )
		int y = (e.getY() - 225) / 80 + 1; // y좌표로부터 얻은 배열의 x인덱스 값
		compare_x[0] = y;
		compare_y[0] = x;
	}

	public void mouseReleased(MouseEvent e) { // 마우스를 뗀 부분에 대한 이벤트 처리 메소드
		int x = (e.getX() - 215) / 80 + 1; // x좌표로부터 얻은 배열의 y인덱스 값
		int y = (e.getY() - 225) / 80 + 1; // y좌표로부터 얻은 배열의 x인덱스 값
		compare_x[1] = y;
		compare_y[1] = x;

		gameController.doAction(compare_x, compare_y);
		repaint(); // 다시 그려주는 메소드
	}

	/********** 시간 스레드 **********/
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
			data.setGameFinish(); // 스레드 종료 후 게임 종료 세팅
		}
	}
}
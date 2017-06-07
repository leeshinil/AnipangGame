package com.makers.showmethemoney.model.game;

import java.util.Random;

public class GameData {
	// singleton pattern
	public static GameData data = null;
	
	private int arr[][] = new int[8][8]; // map�� �������� �ʱ�ȭ �� �迭
	private int score[] = new int[9]; // �� icon�� ������ ���� ���� �迭
	private int totalScore = 0;
	private int time = 600;

	public boolean gameFinish = false; // ���� ���� ���� �Ǵ�

	/********** ������ **********/
	public GameData() {
		setInitArray();
		setRandomArray();
		setInitMap(arr);
	}
	
	/********** array �ʱ�ȭ �޼ҵ� **********/
	public void setInitArray() {
		for (int i = 1; i <= 7; i++)
			for (int j = 1; j <= 7; j++)
				arr[i][j] = 0;
	}
	
	/********** array ������ �ʱ�ȭ �޼ҵ� **********/
	public void setRandomArray() {
		Random random = new Random(); // ���� ��ü ����
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				arr[i][j] = random.nextInt(6) + 1; // 1~6������ ���� ���� ����
				
				int a = i, b = j;
				// ���̳� ���� 3 �̻��� �� 2��° �� ��(��)�� 1��° �� ��(��), ���� ��(��)�� ������ j�� ���ҽ���
				// �ٽ� random���� ����
				if ((b >= 3 && arr[a][b - 2] == arr[a][b - 1] && arr[a][b - 1] == arr[a][b])
						|| (a >= 3 && arr[a - 2][b] == arr[a - 1][b] && arr[a - 1][b] == arr[a][b]))
					j--;
			}
		}
	}

	/********** GameData �������� ������ ��� ��ü�� �����ϴ� �޼ҵ� **********/
	public static GameData getInstance() {
		if (data == null) {
			data = new GameData();
		}
		return data;
	}

	/**------------------ about Map ------------------**/
	int map[][] = { // Game map�� �� value�� ���� �迭
			{ -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 },
			{ -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, 0, 0, 0, 0, 0, 0, 0, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1 } };

	/********** map�� arr�� value������ �ʱ�ȭ �ϴ� �޼ҵ� **********/
	public void setInitMap(int arr[][]) {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				this.map[i][j] = arr[i][j];
			}
		}
	}

	/********** (x,y)��ġ�� ����ִ� value���� ��ȯ�ϴ� �޼ҵ� **********/
	public int getMap(int x, int y) {
		return map[x][y];
	}

	/********** (x,y)��ġ�� ���� value�� �ٲٴ� �޼ҵ� **********/
	public void setMap(int x, int y, int value) {
		this.map[x][y] = value;
	}
	
	/**------------------ about score ------------------**/
	/********** score�� �ʱ�ȭ �ϴ� �޼ҵ� **********/
	public void setInitScore() {
		for (int i = 0; i < 7; i++)
			score[i] = 0;
	}
	
	/********** score�� �����ϴ� �޼ҵ� **********/
	public void setScore(int value, int cnt) {
		score[value] += cnt;
	}

	/********** score�� ��ȯ�ϴ� �޼ҵ� **********/
	public int[] getScore() {
		return score;
	}
	
	/********** totalscore�� �ʱ�ȭ �ϴ� �޼ҵ� **********/
	public void setInitTotal(){
	      totalScore = 0;
	}

	/********** score�� �����ִ� �޼ҵ�  **********/
	public void sumTotal() {
		double j = 2.0;
		
		for (int i = 1; i < 7; i++, j-=0.2) {
			totalScore += score[i] * j * 100;
		}
		totalScore += score[0] * 500;
	}
	
	/********** totalScore�� ��ȯ�ϴ� �޼ҵ� **********/
	public int getTotal() {
		return totalScore;
	}
	
	/**------------------ about time ------------------**/
	/********** time�� ��ȯ�ϴ� �޼ҵ� **********/
	public void initTime() {
		time = 600;
	}
	
	/********** time�� ��ȯ�ϴ� �޼ҵ� **********/
	public int getTime() {
		return time;
	}

	/********** time�� ���ҽ�Ű�� �޼ҵ� **********/
	public void setTime(int time) {
		this.time -= time;
	}
	
	/********** ������ ����Ǿ����� �����ϴ� �޼ҵ� **********/
	public void setGameFinish() {
		gameFinish = true;
	}
	
	/********** GameFinish�� �ʱ���·� �ǵ����ִ� �޼ҵ� **********/
	public void setGameStart() {
		gameFinish = false;
	}
	
	/********** ���� ���� ���θ� ��ȯ�ϴ� �޼ҵ� **********/
	public boolean getGameFinish() {
		return gameFinish;
	}
}
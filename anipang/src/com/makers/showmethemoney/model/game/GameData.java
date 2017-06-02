package com.makers.showmethemoney.model.game;

import java.util.Random;

public class GameData {
	//singleton pattern
	public static GameData data = null;
	
	public GameData(){ // ������
		Random random = new Random(); // ���� ��ü ����
		int arr[][] = new int[8][8]; // map�� �������� �ʱ�ȭ �� arr�迭�� ����
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				arr[i][j] = random.nextInt(6) + 1; // 1~6������ ���� ���� ����

				int a = i, b = j; 
				// ���̳� ���� 3 �̻��� �� 2��° �� ��(��)�� 1��° �� ��(��), ���� ��(��)�� ������ j�� ���ҽ��� �ٽ� random���� ���� 
				if ((b >= 3 && arr[a][b - 2] == arr[a][b - 1] && arr[a][b - 1] == arr[a][b])
						|| (a >= 3 && arr[a - 2][b] == arr[a - 1][b] && arr[a - 1][b] == arr[a][b]))
					j--;
			}
		}
		this.setInitMap(arr); // arr�� ���� map�迭�� �ʱ�ȭ
	}
	
	public static GameData getInstance(){ // GameData �������� ������ ��� ��ü�� �����ϴ� �޼ҵ�
		if(data == null){
			data = new GameData();
		}
		return data;
	}
	
	int map[][] = { // Game map�� �� value�� ���� �迭
			{-1,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1}
	};
	
	public void setInitMap(int arr[][]){ // map�� arr�� value������ �ʱ�ȭ �ϴ� �޼ҵ�
		for(int i = 1; i <= 7;i++){
			for(int j = 1; j<=7;j++){
				this.map[i][j] = arr[i][j];
			}
		}
	}
	
	public int getMap(int x, int y){ // (x,y)��ġ�� ����ִ� value���� ��ȯ�ϴ� �޼ҵ�
		return map[x][y];
	}
	
	public void setMap(int x, int y,int value){ // (x,y)��ġ�� ���� value�� �ٲٴ� �޼ҵ�
		this.map[x][y] = value;
	}
}

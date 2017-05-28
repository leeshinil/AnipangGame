package com.makers.showmethemoney.model;

import java.util.Random;

public class GameData{ // singleton pattern
	private static GameData data = null;
	Random random = new Random();
	
	GameData() { // defalut 생성자
		int arr[][] = new int[8][8]; // 각 이미지의 값을 가질 배열
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				arr[i][j] = random.nextInt(6) + 1;
				int a = i, b = j;
				if ((b >= 3 && arr[a][b - 2] == arr[a][b - 1] && arr[a][b - 1] == arr[a][b]) || (a >= 3 && arr[a - 2][b] == arr[a - 1][b] && arr[a - 1][b] == arr[a][b])) // 가로 또는 세로검사
					j--;
			}
		}
		this.setInitMap(arr);
	}
	public static GameData getInstance() { // Data를 반환하는 함수
		if (data == null ) {
			data = new GameData();
		} 
		return data;
	}

	// -1->wall 0->Empty 1->Dollar 2->Euro 3->Peso 4->Pound 5->Won 6->Yen
	int map[][] = {
			{-1,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1, 0, 0, 0, 0, 0, 0, 0,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1},
	};
	public void setInitMap(int arr[][]) { // 배열 초기값 초기화 함수
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				this.map[i][j] = arr[i][j];
			}
		}
	}	
	public int getMap(int x, int y) { // x,y번째 배열값을 반환하는 함수
		return map[x][y];
	}
		public void setMap(int x, int y, int value) { // x,y번째 배열값을 넣는 함수
		this.map[x][y] = value;
	}
}
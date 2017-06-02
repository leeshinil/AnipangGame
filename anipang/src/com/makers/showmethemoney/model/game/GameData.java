package com.makers.showmethemoney.model.game;

import java.util.Random;

public class GameData {
	//singleton pattern
	public static GameData data = null;
	
	public GameData(){ // 생성자
		Random random = new Random(); // 랜덤 객체 생성
		int arr[][] = new int[8][8]; // map에 랜덤으로 초기화 할 arr배열을 생성
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				arr[i][j] = random.nextInt(6) + 1; // 1~6까지의 랜덤 값을 대입

				int a = i, b = j; 
				// 행이나 열이 3 이상일 때 2번째 전 행(열)과 1번째 전 행(열), 현재 행(열)이 같으면 j를 감소시켜 다시 random값을 받음 
				if ((b >= 3 && arr[a][b - 2] == arr[a][b - 1] && arr[a][b - 1] == arr[a][b])
						|| (a >= 3 && arr[a - 2][b] == arr[a - 1][b] && arr[a - 1][b] == arr[a][b]))
					j--;
			}
		}
		this.setInitMap(arr); // arr의 값을 map배열에 초기화
	}
	
	public static GameData getInstance(){ // GameData 스스로의 정보를 담는 객체를 생성하는 메소드
		if(data == null){
			data = new GameData();
		}
		return data;
	}
	
	int map[][] = { // Game map의 각 value를 담을 배열
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
	
	public void setInitMap(int arr[][]){ // map을 arr의 value값으로 초기화 하는 메소드
		for(int i = 1; i <= 7;i++){
			for(int j = 1; j<=7;j++){
				this.map[i][j] = arr[i][j];
			}
		}
	}
	
	public int getMap(int x, int y){ // (x,y)위치에 들어있는 value값을 반환하는 메소드
		return map[x][y];
	}
	
	public void setMap(int x, int y,int value){ // (x,y)위치의 값을 value로 바꾸는 메소드
		this.map[x][y] = value;
	}
}

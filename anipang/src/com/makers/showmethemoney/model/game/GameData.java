package com.makers.showmethemoney.model.game;

import java.util.Random;

public class GameData {
	//singleton pattern
	
	
	
	public static GameData data = null;
	GameData(){
		Random random = new Random();
		int arr[][] = new int[8][8];
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				arr[i][j] = random.nextInt(6) + 1;

				int a = i, b = j;
				if ((b >= 3 && arr[a][b - 2] == arr[a][b - 1] && arr[a][b - 1] == arr[a][b])
						|| (a >= 3 && arr[a - 2][b] == arr[a - 1][b] && arr[a - 1][b] == arr[a][b]))
					j--;
			}
		}
		this.setInitMap(arr);
	}
	public static GameData getInstance(){
		if(data == null){
			data = new GameData();
		}
		return data;
	}
	
	int map[][] = {
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
	
	public void setInitMap(int arr[][]){
		for(int i = 1; i <= 7;i++){
			for(int j = 1; j<=7;j++){
				this.map[i][j] = arr[i][j];
			}
		}
	}
	
	public int getMap(int x, int y){
		return map[x][y];
	}
	
	public void setMap(int x, int y,int value){
		this.map[x][y] = value;
	}
}

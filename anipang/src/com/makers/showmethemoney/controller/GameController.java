package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.GameLogic;

// 모든 게임을 제어한다.

public class GameController {
	// Data를 사용해야 해.
	//GameData sr = null; 안쓰면 안돼나? 질문.
	GameLogic gameLogic = null;
	public GameController() {
		//sr = GameData.getInstance(); 사용하지 않는데 쓸 필요가?
		gameLogic = new GameLogic();
		
	}
	public boolean swapCompare(int compare_x[], int compare_y[]) {
		return gameLogic.swapCompare(compare_x, compare_y);
	}
	
	public void bomb(int compare_x[], int compare_y[]) {

	      boolean check_state1 = gameLogic.bombPressed(compare_x[0], compare_y[0]);
	      boolean check_state2 = gameLogic.bombReleased(compare_x[1], compare_y[1]);

	      if (!check_state1) {
	          //gameLogic.swapCompare(compare_x, compare_y);
	      }
	   }	
}

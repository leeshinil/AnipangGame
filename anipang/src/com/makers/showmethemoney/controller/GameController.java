package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.GameLogic;

// ��� ������ �����Ѵ�.

public class GameController {
	// Data�� ����ؾ� ��.
	//GameData sr = null; �Ⱦ��� �ȵų�? ����.
	GameLogic gameLogic = null;
	public GameController() {
		//sr = GameData.getInstance(); ������� �ʴµ� �� �ʿ䰡?
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

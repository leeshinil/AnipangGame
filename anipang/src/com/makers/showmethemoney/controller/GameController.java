
package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.model.game.GameLogic;

public class GameController {
	GameData data = null;
	GameLogic gameLogic = null;

	public GameController() { // 생성자
		data = GameData.getInstance(); // GameData를 담을 객체
		gameLogic = new GameLogic(); // GameLogic 객체
	}

	// Logic의 swapCompare메소드를 호출해주는 메소드
	public boolean swapCompare(int compare_x[], int compare_y[]) { 
		// swap 가능한지 여부를 boolean type으로 반환
		return gameLogic.swapCompare(compare_x, compare_y);
		
	}
	
	// Logic의 bomb메소드를 호출해주는 메소드
	public void bomb(int compare_x[], int compare_y[]) {
		System.out.println("============start==================");
		printA();
		// 터뜨릴  블록이 있는지 boolean type으로 check
		boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); 
		boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]);
		boolean checkAll = false;
		
		// 조건 불충족시 블록을 원래 자리로 swap
		if (!check_state1 && !check_state2) {
			gameLogic.swapCompare(compare_x, compare_y); 
		}
		
		do {
			checkAll = false;
			gameLogic.downIcon(); // value가 0인 위치에 y-1값을 대입하는 메소드
			// -> 제거 위치에 새로 downIcon 사용
			// -> 메소드 호출 후 3개이상 중복시 다시 bomb 호출
			// -> 반복문으로 계속 체크 
			checkAll = bombAll(); //모든 블록 체크
//			System.out.println(checkAll);
		} while (checkAll);
		System.out.println("============finish==================");
		printA();
	}

	public boolean bombAll() { // 모든 블록 bomb check
		boolean state = false;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 3; j++) {
				state = (state == true) ? true : gameLogic.bomb((2 * i) - 1, (2 * j) - 1);
				state = (state == true) ? true:  gameLogic.bomb((2 * i), (2 * j));
			}
		}
		return state;
	}

	public void printA() {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}
}
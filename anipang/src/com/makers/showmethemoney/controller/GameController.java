
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
		boolean state = gameLogic.isSwapPossible(compare_x, compare_y);
		if(state)
			gameLogic.swap(compare_x, compare_y);
		return state;
	}
	
	// Logic의 bomb메소드를 호출해주는 메소드
	public void doAction(int compare_x[], int compare_y[]/*, boolean item_state*/) {
		System.out.println("\n============start==================");
		printMap();

		boolean item_state = gameLogic.checkIsItem(compare_x[0], compare_y[0]); 
		if(item_state) { // pressed가 item이면
			
			// true->bitcoinItem, false->bombItem
			if(gameLogic.whatItem(compare_x[0], compare_y[0])) {
				gameLogic.bitcoinItem(compare_x[0], compare_y[0]);
			}
			else
				gameLogic.bombItem(compare_x[0], compare_y[0]);
		}

		else { // icon이면 swap 가능여부 검사
			
			// 가능하면 swap후 bomb 검사
			if(gameLogic.isSwapPossible(compare_x, compare_y)) {
				gameLogic.swap(compare_x, compare_y);
				boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); // Pressed
				boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]); // Released
				
				// bomb 없으면 원래 자리로 swap 후 return
				if (!check_state1 && !check_state2) {
					gameLogic.swap(compare_x, compare_y);
					return ;
				}
			}
			else // swap 불가능시 return
				return ;
		}
		
		boolean checkAll = false;
		do {
			checkAll = false;
			gameLogic.downIcon(); // value가 0인 위치에 y-1값을 대입하는 메소드
			// -> 제거 위치에 새로 downIcon 사용
			// -> 메소드 호출 후 3개이상 중복시 다시 bomb 호출
			// -> 반복문으로 계속 체크 
			checkAll = bombAll(); //모든 블록 체크
//			System.out.println(checkAll);
		} while (checkAll);
		
		System.out.println("\n============finish==================");
		printMap();
	}

	public boolean bombAll() { // 모든 블록 bomb check
		boolean state = false;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4 ; j++) {
				if(i < 4 && j < 4) 
					state = (state == true) ? true:  gameLogic.bomb((2 * i), (2 * j));
				state = (state == true) ? true : gameLogic.bomb((2 * i) - 1, (2 * j) - 1);
			}
		}
		System.out.println("\n============afterBoomCheck==================");
		printMap();
		return state;
	}

	public void printMap() { // map 출력
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}
}
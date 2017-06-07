package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.GameSound;
import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.model.game.GameLogic;

public class GameController {
	GameData data = null;
	GameLogic gameLogic = null;
	GameSound gameSound = null;

	/********** 생성자 **********/
	public GameController() {
		data = GameData.getInstance(); // GameData를 담을 객체
		gameLogic = new GameLogic(); // GameLogic 객체
		gameSound = new GameSound(); // GameSound 객체
	}

	/********** Logic의 swapCompare메소드를 호출해주는 메소드 ************/
	public boolean swapCompare(int compare_x[], int compare_y[]) {
		// swap 가능한지 여부를 boolean type으로 반환
		boolean state = gameLogic.isSwapPossible(compare_x, compare_y);
		if (state)
			gameLogic.swap(compare_x, compare_y);
		return state;
	}

	/********** Logic의 bomb메소드를 호출해주는 메소드 ************/
	public void doAction(int compare_x[], int compare_y[]) {

		boolean item_state = gameLogic.checkIsItem(compare_x[0], compare_y[0]);
		if (item_state) { // pressed가 item이면

			// true->bitcoinItem 수행, false->bombItem 수행
			if (gameLogic.whatItem(compare_x[0], compare_y[0])) {
				gameLogic.bitcoinItem(compare_x[0], compare_y[0]);
			} else
				gameLogic.bombItem(compare_x[0], compare_y[0]);
			gameSound.startSound(4); // 아이템 사용 소리
		}

		else { // icon이면 swap 가능여부 검사

			// 가능하면 swap후 bomb 검사
			if (gameLogic.isSwapPossible(compare_x, compare_y)) {
				gameLogic.swap(compare_x, compare_y);
				boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); // Pressed
				boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]); // Released

				// bomb 없으면 원래 자리로 swap 후 return
				if (!check_state1 && !check_state2) {
					gameLogic.swap(compare_x, compare_y);
					gameSound.startSound(2); // swap 불가 소리
					return;
				} else
					gameSound.startSound(1); // 터지는 소리
			}

			else { // swap 불가능시 return
				gameSound.startSound(2); // swap 불가 소리
				return;
			}
		}

		boolean checkAll = false;
		do {
			checkAll = false;
			gameLogic.downIcon(); // value가 0인 위치에 y-1값을 대입하는 메소드
			checkAll = bombAll(); // 모든 블록 체크

			if (checkAll)
				gameSound.startSound(1); // 터진게 있으면 터지는 소리
		} while (checkAll);
	}

	/********** 모든 블록 bomb check method **********/
	public boolean bombAll() {
		boolean state = false;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i < 4 && j < 4)
					state = (state == true) ? true : gameLogic.bomb((2 * i), (2 * j));
				state = (state == true) ? true : gameLogic.bomb((2 * i) - 1, (2 * j) - 1);
			}
		}
		return state;
	}
}
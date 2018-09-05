package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.GameSound;
import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.model.game.GameLogic;

public class GameController {
	GameData data = null;
	GameLogic gameLogic = null;
	GameSound gameSound = null;

	/********** ������ **********/
	public GameController() {
		data = GameData.getInstance(); // GameData�� ���� ��ü
		gameLogic = new GameLogic(); // GameLogic ��ü
		gameSound = new GameSound(); // GameSound ��ü
	}

	/********** Logic�� swapCompare�޼ҵ带 ȣ�����ִ� �޼ҵ� ************/
	public boolean swapCompare(int compare_x[], int compare_y[]) {
		// swap �������� ���θ� boolean type���� ��ȯ
		boolean state = gameLogic.isSwapPossible(compare_x, compare_y);
		if (state)
			gameLogic.swap(compare_x, compare_y);
		return state;
	}

	/********** Logic�� bomb�޼ҵ带 ȣ�����ִ� �޼ҵ� ************/
	public void doAction(int compare_x[], int compare_y[]) {

		boolean item_state = gameLogic.checkIsItem(compare_x[0], compare_y[0]);
		if (item_state) { // pressed�� item�̸�

			// true->bitcoinItem ����, false->bombItem ����
			if (gameLogic.whatItem(compare_x[0], compare_y[0])) {
				gameLogic.bitcoinItem(compare_x[0], compare_y[0]);
			} else
				gameLogic.bombItem(compare_x[0], compare_y[0]);
			gameSound.startSound(4); // ������ ��� �Ҹ�
		}

		else { // icon�̸� swap ���ɿ��� �˻�

			// �����ϸ� swap�� bomb �˻�
			if (gameLogic.isSwapPossible(compare_x, compare_y)) {
				gameLogic.swap(compare_x, compare_y);
				boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); // Pressed
				boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]); // Released

				// bomb ������ ���� �ڸ��� swap �� return
				if (!check_state1 && !check_state2) {
					gameLogic.swap(compare_x, compare_y);
					gameSound.startSound(2); // swap �Ұ� �Ҹ�
					return;
				} else
					gameSound.startSound(1); // ������ �Ҹ�
			}

			else { // swap �Ұ��ɽ� return
				gameSound.startSound(2); // swap �Ұ� �Ҹ�
				return;
			}
		}

		boolean checkAll = false;
		do {
			checkAll = false;
			gameLogic.downIcon(); // value�� 0�� ��ġ�� y-1���� �����ϴ� �޼ҵ�
			checkAll = bombAll(); // ��� ��� üũ

			if (checkAll)
				gameSound.startSound(1); // ������ ������ ������ �Ҹ�
		} while (checkAll);
	}

	/********** ��� ��� bomb check method **********/
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
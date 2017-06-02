
package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.model.game.GameLogic;

public class GameController {
	GameData data = null;
	GameLogic gameLogic = null;

	public GameController() { // ������
		data = GameData.getInstance(); // GameData�� ���� ��ü
		gameLogic = new GameLogic(); // GameLogic ��ü
	}

	// Logic�� swapCompare�޼ҵ带 ȣ�����ִ� �޼ҵ�
	public boolean swapCompare(int compare_x[], int compare_y[]) { 
		// swap �������� ���θ� boolean type���� ��ȯ
		boolean state = gameLogic.isSwapPossible(compare_x, compare_y);
		if(state)
			gameLogic.swap(compare_x, compare_y);
		return state;
	}
	
	// Logic�� bomb�޼ҵ带 ȣ�����ִ� �޼ҵ�
	public void doAction(int compare_x[], int compare_y[]/*, boolean item_state*/) {
		System.out.println("\n============start==================");
		printMap();

		boolean item_state = gameLogic.checkIsItem(compare_x[0], compare_y[0]); 
		if(item_state) { // pressed�� item�̸�
			
			// true->bitcoinItem, false->bombItem
			if(gameLogic.whatItem(compare_x[0], compare_y[0])) {
				gameLogic.bitcoinItem(compare_x[0], compare_y[0]);
			}
			else
				gameLogic.bombItem(compare_x[0], compare_y[0]);
		}

		else { // icon�̸� swap ���ɿ��� �˻�
			
			// �����ϸ� swap�� bomb �˻�
			if(gameLogic.isSwapPossible(compare_x, compare_y)) {
				gameLogic.swap(compare_x, compare_y);
				boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); // Pressed
				boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]); // Released
				
				// bomb ������ ���� �ڸ��� swap �� return
				if (!check_state1 && !check_state2) {
					gameLogic.swap(compare_x, compare_y);
					return ;
				}
			}
			else // swap �Ұ��ɽ� return
				return ;
		}
		
		boolean checkAll = false;
		do {
			checkAll = false;
			gameLogic.downIcon(); // value�� 0�� ��ġ�� y-1���� �����ϴ� �޼ҵ�
			// -> ���� ��ġ�� ���� downIcon ���
			// -> �޼ҵ� ȣ�� �� 3���̻� �ߺ��� �ٽ� bomb ȣ��
			// -> �ݺ������� ��� üũ 
			checkAll = bombAll(); //��� ��� üũ
//			System.out.println(checkAll);
		} while (checkAll);
		
		System.out.println("\n============finish==================");
		printMap();
	}

	public boolean bombAll() { // ��� ��� bomb check
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

	public void printMap() { // map ���
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}
}
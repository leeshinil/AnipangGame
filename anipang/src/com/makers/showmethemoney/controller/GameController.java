
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
		return gameLogic.swapCompare(compare_x, compare_y);
		
	}
	
	// Logic�� bomb�޼ҵ带 ȣ�����ִ� �޼ҵ�
	public void bomb(int compare_x[], int compare_y[]) {
		System.out.println("============start==================");
		printA();
		// �Ͷ߸�  ����� �ִ��� boolean type���� check
		boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); 
		boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]);
		boolean checkAll = false;
		
		// ���� �������� ����� ���� �ڸ��� swap
		if (!check_state1 && !check_state2) {
			gameLogic.swapCompare(compare_x, compare_y); 
		}
		
		do {
			checkAll = false;
			gameLogic.downIcon(); // value�� 0�� ��ġ�� y-1���� �����ϴ� �޼ҵ�
			// -> ���� ��ġ�� ���� downIcon ���
			// -> �޼ҵ� ȣ�� �� 3���̻� �ߺ��� �ٽ� bomb ȣ��
			// -> �ݺ������� ��� üũ 
			checkAll = bombAll(); //��� ��� üũ
//			System.out.println(checkAll);
		} while (checkAll);
		System.out.println("============finish==================");
		printA();
	}

	public boolean bombAll() { // ��� ��� bomb check
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
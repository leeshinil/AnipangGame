
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

	public boolean swapCompare(int compare_x[], int compare_y[]) { // Logic��
																	// swapCompare�޼ҵ带
																	// ȣ�����ִ� �޼ҵ�
		return gameLogic.swapCompare(compare_x, compare_y); // swap �������� ���θ�
															// boolean type���� ��ȯ
	}
	
	public void bomb(int compare_x[], int compare_y[]) { // Logic�� bomb�޼ҵ带
															// ȣ�����ִ� �޼ҵ�
		System.out.println("============start==================");
		printA();
		boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); // �Ͷ߸�  ����� �ִ��� boolean type���� check
		boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]); // �Ͷ߸� ����� �ִ��� boolean type���� check
		boolean checkAll = false;

		if (!check_state1 && !check_state2) { // ������ �� ��Ͽ� ���� �Ͷ߸��� ������
			gameLogic.swapCompare(compare_x, compare_y); // �ٽ� �� ����� ���� �ڸ��� swap
		}
		do {
			checkAll = false;
			gameLogic.downIcon(); // ��� ����� �˻��Ͽ� �� ������ ������ ����� ������ downIcon �޼ҵ带
									// ȣ��
			// -> ������ġ�� ���� downIcon ���
			// -> ������ �͵��� 3���̻� ���� �������Ͻ� �ٽ� bomb ���
			// -> �ٽ� �����ǹǷ� �ݺ��� ���.
			checkAll = bombAll();
			System.out.println(checkAll);
		} while (checkAll);
		System.out.println("============finish==================");
		printA();
	}

	public boolean bombAll() {//
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
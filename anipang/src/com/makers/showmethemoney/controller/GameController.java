
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

   public boolean swapCompare(int compare_x[], int compare_y[]) { // Logic�� swapCompare�޼ҵ带 ȣ�����ִ� �޼ҵ�
      return gameLogic.swapCompare(compare_x, compare_y); // swap �������� ���θ� boolean type���� ��ȯ
   }

   public void bomb(int compare_x[], int compare_y[]) { // Logic�� bomb�޼ҵ带 ȣ�����ִ� �޼ҵ�
      boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); // �Ͷ߸� ����� �ִ��� boolean type���� check
      boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]); // �Ͷ߸� ����� �ִ��� boolean type���� check
      if (!check_state1 && !check_state2) { // ������ �� ��Ͽ� ���� �Ͷ߸��� ������
          gameLogic.swapCompare(compare_x, compare_y); // �ٽ� �� ����� ���� �ڸ��� swap
      }
      gameLogic.downIcon(); // ��� ����� �˻��Ͽ� �� ������ ������ ����� ������ downIcon �޼ҵ带 ȣ��
   }
}

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

   public boolean swapCompare(int compare_x[], int compare_y[]) { // Logic의 swapCompare메소드를 호출해주는 메소드
      return gameLogic.swapCompare(compare_x, compare_y); // swap 가능한지 여부를 boolean type으로 반환
   }

   public void bomb(int compare_x[], int compare_y[]) { // Logic의 bomb메소드를 호출해주는 메소드
      boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]); // 터뜨릴 블록이 있는지 boolean type으로 check
      boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]); // 터뜨릴 블록이 있는지 boolean type으로 check
      if (!check_state1 && !check_state2) { // 움직인 두 블록에 대해 터뜨릴게 없으면
          gameLogic.swapCompare(compare_x, compare_y); // 다시 두 블록을 원래 자리로 swap
      }
      gameLogic.downIcon(); // 모든 블록을 검사하여 빈 공간이 있으면 블록을 내리는 downIcon 메소드를 호출
   }
}
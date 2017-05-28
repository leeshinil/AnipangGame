package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.GameData;
import com.makers.showmethemoney.model.game.GameLogic;

public class GameController {
   GameData data = null;
   GameLogic gameLogic = null;

   public GameController() {
      data = GameData.getInstance();
      gameLogic = new GameLogic();

   }

   public boolean swapCompare(int compare_x[], int compare_y[]) {
      return gameLogic.swapCompare(compare_x, compare_y);
   }

   public void bomb(int compare_x[], int compare_y[]) {
      boolean check_state1 = gameLogic.bomb(compare_x[0], compare_y[0]);
      boolean check_state2 = gameLogic.bomb(compare_x[1], compare_y[1]);
      if (!check_state1 && !check_state2) {
          gameLogic.swapCompare(compare_x, compare_y);
      }
   }
}
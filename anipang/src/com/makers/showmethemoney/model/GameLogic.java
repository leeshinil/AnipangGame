package com.makers.showmethemoney.model;
// game에 대한 logic을 담당.

public class GameLogic {
	GameData data = null;

	public GameLogic() {
		data = GameData.getInstance();
	}

	public boolean swapCompare(int compare_x[], int compare_y[]) {
		if (Math.abs(compare_x[0] - compare_x[1]) + Math.abs(compare_y[0] - compare_y[1]) != 1) {
			return false;
		} else {
			int temp = data.getMap(compare_x[0], compare_y[0]);
			data.setMap(compare_x[0], compare_y[0], data.getMap(compare_x[1], compare_y[1]));
			data.setMap(compare_x[1], compare_y[1], temp);
			return true;
		}
	}

	public boolean bombPressed(int compare_x, int compare_y) {
	      // TODO Auto-generated method stub

	      int dx[] = { 1, -1, 0, 0 };
	      int dy[] = { 0, 0, 1, -1 };

	      int x = compare_x;
	      int y = compare_y;
	      boolean check_state = false;
	      for (int i = 0; i < 2; i++) {
	         int move_x = x;
	         int move_y = y;

	         int value = data.getMap(x, y);
	         int count = 1;
	         boolean state = true;

	         while (state) {
	            move_x += dx[i];
	            move_y += dy[i];
	            if (move_x >= 1 && move_x <= 7 && move_y >= 1 && move_y <= 7 && data.getMap(move_x, move_y) == value) {
	               count++;
	            } else {
	               if (count >= 3) {
	                  move_x -= dx[i];
	                  move_y -= dy[i];
	                  int start_x = 0, finish_x = 0, start_y = 0, finish_y = 0;

	                  if (x <= move_x) {
	                     start_x = x;
	                     finish_x = move_x;
	                     for (int j = start_x; j <= finish_x; j++) {
	                        data.setMap(j, y, 0);
	                     }
	                  }
	                  if (x >= move_x) {
	                     start_x = x;
	                     finish_x = move_x;
	                     for (int j = finish_x; j <= start_x; j++) {
	                        data.setMap(j, y, 0);
	                     }
	                  }
	                  check_state = true;
	               }
	               state = false;
	            }
	         }
	      }

	      return check_state;
	   }

	   public boolean bombReleased(int compare_x, int compare_y) {
	      // TODO Auto-generated method stub

	      int dx[] = { 1, -1, 0, 0 };
	      int dy[] = { 0, 0, 1, -1 };

	      int x1 = compare_x;
	      int y1 = compare_y;
	      boolean check_state = false;
	      for (int i = 0; i < 2; i++) {
	         int move_x1 = x1;
	         int move_y1 = y1;

	         int value = data.getMap(x1, y1);
	         int count = 1;
	         boolean state = true;

	         while (state) {
	            move_x1 += dx[i];
	            move_y1 += dy[i];
	            if (move_x1 >= 1 && move_x1 <= 7 && move_y1 >= 1 && move_y1 <= 7
	                  && data.getMap(move_x1, move_y1) == value) {
	               count++;
	            } else {
	               if (count >= 3) {
	                  move_x1 -= dx[i];
	                  move_y1 -= dy[i];
	                  int start_x = 0, finish_x = 0, start_y = 0, finish_y = 0;

	                  if (x1 <= move_x1) {
	                     start_x = x1;
	                     finish_x = move_x1;
	                     for (int j = start_x; j <= finish_x; j++) {
	                        data.setMap(j, y1, 0);
	                     }
	                  }
	                  if (x1 >= move_x1) {
	                     start_x = x1;
	                     finish_x = move_x1;
	                     for (int j = finish_x; j <= start_x; j++) {
	                        data.setMap(j, y1, 0);
	                     }
	                  }
	                  check_state = true;
	               }
	               state = false;
	            }
	         }
	      }

	      return check_state;
	   }

	public void fillMap() {

	}

	public void printMap() {
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.print(data.getMap(i, j) + " ");
			}
			System.out.println();
		}
	}
}

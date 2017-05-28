package com.makers.showmethemoney.model.game;

import java.util.Stack;

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
	
	//방향에 따라 같은 value가 연속적으로 있는지 검사.
	public int directionCompare(int dir, int cur_x, int cur_y, int value, Stack<Point> stack) {
		int count = 0; // 방향에 따라 연속적으로 같은 값의 갯수
		
		// 0->south 1 -> north 2-> east 3->west
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		
		int move_x = cur_x;
		int move_y = cur_y;
		while (true) {
			move_x += dx[dir];
			move_y += dy[dir];
			if (move_x >= 1 && move_x <= 7 && move_y >= 1 && move_y <= 7 && data.getMap(move_x, move_y) == value) {
				stack.push(new Point(move_x, move_y));
				count ++;
			} else {
				return count;
			}
		}
	}
	
	
	public boolean bomb(int compare_x, int compare_y) {
		int value = data.getMap(compare_x, compare_y);
		Stack<Point> stack = new Stack<Point>();
		int dir[] = {0,2};
		boolean cur_state = false;
		for (int i = 0 ; i < 2; i++) {			
			int total_count = directionCompare(dir[i], compare_x, compare_y, value, stack) + directionCompare(dir[i]+1, compare_x, compare_y, value, stack);
			if (total_count >= 2) {
				while(!stack.isEmpty()) {
					Point p = stack.pop();
					int x = p.x;
					int y = p.y;
					data.setMap(x, y, 0);
				}
				cur_state = true;
			}
			stack.clear();
		}
		if (cur_state) {			
			data.setMap(compare_x, compare_y, 0);
			return true;
		} else return false;
		
		
		// 1-> new stack
		
		// 2-> north + south compare
		//  ---> int total_count = dircectionCompare(0) + directionCompare(1);
		// 3-> if total_count >= 3 stack pop bomb
		// 이하 동
		// 4-> east + west compare 
		// 5- > stack pop bomb

		
	}

	public void fillMap() {

	}
}
package com.makers.showmethemoney.model.game;

import java.util.Random;
import java.util.Stack;

public class GameLogic {
	GameData data = null;

	/********** 생성자 **********/
	public GameLogic() { // 생성자
		data = GameData.getInstance();
		data.setInitScore();
	}

	/********** swap 가능 여부 boolean type 반환 메소드 **********/
	public boolean isSwapPossible(int compare_x[], int compare_y[]) {
		// x,y 각 차를 더한 절대 값 != 1
		if (Math.abs(compare_x[0] - compare_x[1]) + Math.abs(compare_y[0] - compare_y[1]) != 1)
			return false; // swap 불가
		return true; // swap 가능
	}
	
	/********** swap 해주는 메소드 **********/
	public void swap(int compare_x[], int compare_y[]) {
		int temp = data.getMap(compare_x[0], compare_y[0]); // temp에 map의 value 저장
		data.setMap(compare_x[0], compare_y[0], data.getMap(compare_x[1], compare_y[1]));
		data.setMap(compare_x[1], compare_y[1], temp); // 두 value를 바꿔줌
	}

	/********** 방향에 따라 연속 value 중복 체크 **********/
	public int directionCompare(int dir, int cur_x, int cur_y, int value, Stack<Point> stack) {
		int count = 0; // 연속 중복 개수
		// 0->south, 1->north, 2->east, 3->west
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		int move_x = cur_x;
		int move_y = cur_y;
		
		while (true) {
			move_x += dx[dir];
			move_y += dy[dir];
			if (move_x >= 1 && move_x <= 7 && move_y >= 1 && move_y <= 7 && data.getMap(move_x, move_y) == value && data.getMap(move_x, move_y) != 0) {
				stack.push(new Point(move_x, move_y));
				count++;
			} else {
				return count;
			}
		}
	}

	/********** bomb method **********/
	public boolean bomb(int compare_x, int compare_y) {
        int value = data.getMap(compare_x, compare_y);
        Stack<Point> stack = new Stack<Point>();
        int dir[] = { 0, 2 };
        boolean cur_state = false;
        boolean bitCoinItem_state = false;
        boolean bombItem_state = false;
        
        for (int i = 0; i < 2; i++) {
           int total_count = directionCompare(dir[i], compare_x, compare_y, value, stack)
                 + directionCompare(dir[i] + 1, compare_x, compare_y, value, stack);

           if (total_count >= 2) {
              while (!stack.isEmpty()) {
                 Point p = stack.pop();
                 int x = p.x;
                 int y = p.y;
                 data.setMap(x, y, 0);
                
              }
            
              if(total_count >= 2) // increase scores
            	  data.setScore(data.getMap(compare_x, compare_y), total_count+1);
            
              if(total_count >=4)
                 bombItem_state = true;
              else if(total_count >= 3)
                 bitCoinItem_state = true;
              cur_state = true;
           }
           stack.clear();
        }
        
        if (cur_state) {
           if(bitCoinItem_state) {
        	   data.setMap(compare_x, compare_y, 7);
        	   new GameSound().startSound(3); // 아이템 생길때
           }
           else if(bombItem_state) {
        	   data.setMap(compare_x, compare_y, 8);
        	   new GameSound().startSound(3); // 아이템 생길때
           }
           else {               
              data.setMap(compare_x, compare_y, 0);
           }
           return true;
        } else
           return false;

     // 1-> new stack
     // 2-> north + south compare
     // ---> int total_count = dircectionCompare(0) + directionCompare(1);
     // 3-> if total_count >= 3 stack pop bomb
     // 이하 동문
     // 4-> east + west compare
     // 5- > stack pop bomb
  }

	/********** 아이콘 빈칸에 채우기 **********/
	public void downIcon() {
		Random random = new Random();

		for (int i = 7; i > 1; i--)
			for (int j = 1; j <= 7; j++)
				if (data.getMap(i, j) == 0)
					for (int b = i - 1; b >= 1; b--)
						if (data.getMap(b, j) != 0) {
							data.setMap(i, j, data.getMap(b, j));
							data.setMap(b, j, 0);
							break;
						}
		for (int x = 1; x <= 7; x++)
			for (int y = 1; y <= 7; y++)
				if (data.getMap(x, y) == 0)
					data.setMap(x, y, random.nextInt(6) + 1);
	}
	
	/********** item인지 체크하는 메소드 **********/
	public boolean checkIsItem(int x, int y) {
		if(data.getMap(x, y) == 7 || data.getMap(x, y) == 8)
			return true;
		return false;
	}
	
	/********** 어떤 메소드인지 확인하는 메소드 **********/
	public boolean whatItem(int x, int y) {
		if(data.getMap(x, y) == 7)
			return true; // bitcoin
		return false; // bomb
	}	
	
	/********** bitcointItem 수행하는 메소드 **********/
	public void bitcoinItem(int x, int y) {
	      int value = new Random().nextInt(6)+1;
	      int count = 0;
	      
	      for(int i = 1; i <= 7; i++)
	         for(int j = 1; j <= 7; j++)
	            if(data.getMap(i, j) == value) {
	               data.setMap(i,j,0);
	               count++;
	            }
	      
	      data.setMap(x, y, 0);
	      data.setScore(value, count+1);
	      data.setScore(0, 1);
	   }
	   
	/********** bombItem 수행하는 메소드 **********/
	public void bombItem(int x, int y) {
		for (int i = 1; i <= 7; i++) {
			if (data.getMap(x, i) != 7 && data.getMap(x, i) != 8 && data.getMap(i, y) != 7 && data.getMap(i, y) != 8) {
				data.setScore(data.getMap(x, i), 1);
				data.setMap(x, i, 0);
				data.setScore(data.getMap(i, y), 1);
				data.setMap(i, y, 0);
			}
		}
		data.setMap(x, y, 0);
		data.setScore(0, 1);
	}
}
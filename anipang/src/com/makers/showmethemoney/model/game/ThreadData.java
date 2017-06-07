package com.makers.showmethemoney.model.game;

public class ThreadData {
	
	private static ThreadData threadData = null;
	public static ThreadData getInstance() {
		if (threadData == null) {
			threadData = new ThreadData();
		}
		return threadData;
	}
	public boolean loading_state = true;
	
	/********* loadingpanel thread data ***********/
	int count = 0;
	public synchronized int getCount() { return count; }
	public void setCount() { this.count += 1; }
	public void setCount(int count) { this.count = count; }
	/**********************************************/
	
	/********** init ¸Þ¼Òµå **********/
	public void setInit() {
		this.count = 0;
		this.loading_state = true;
	}
}

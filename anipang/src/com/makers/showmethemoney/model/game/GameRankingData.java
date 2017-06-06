package com.makers.showmethemoney.model.game;

import java.util.LinkedList;

public class GameRankingData {
	
	private LinkedList<GameRankingData> list = new LinkedList<GameRankingData>();
	
	public LinkedList<GameRankingData> getList() {
		return list;
	}
	private int total_score;
	private String nickname;
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public GameRankingData(String nickname, int total_score) {
		this.nickname = nickname;
		this.total_score = total_score;
	}
	public GameRankingData() {
		
	}
	
	//getter setter (접근자, 제어자) -> Alt + Shift + S
	
}

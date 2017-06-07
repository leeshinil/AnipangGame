package com.makers.showmethemoney.model.game;

import java.util.LinkedList;

public class GameRankingData {
	
	//GameRanking�� ������ LinkedList
	private LinkedList<GameRankingData> list = new LinkedList<GameRankingData>();
	GameData data = null;
	private int total_score;
	private String nickname;

	/********** ������ **********/
	public GameRankingData() {
		data = GameData.getInstance();
	}
	
	/********** ������ **********/
	public GameRankingData(String nickname, int total_score) {
		this.nickname = nickname;
		this.total_score = total_score;
	}
	
	/********** LinkedList�� ��ȯ �޼ҵ� **********/
	public LinkedList<GameRankingData> getList() {
		return list;
	}
	
	/********** totalScore ��ȯ �޼ҵ� **********/
	public int getTotal_score() {
		return total_score;
	}

	/********** totalScore ���� �޼ҵ� **********/
	public void setTotal_score() {
		total_score = data.getTotal();
	}

	/********** nickName ���� �޼ҵ� **********/
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/********** nickName ��ȯ �޼ҵ� **********/
	public String getNickname() {
		return nickname;
	}
}

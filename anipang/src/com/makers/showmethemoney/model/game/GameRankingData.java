package com.makers.showmethemoney.model.game;

import java.util.LinkedList;

public class GameRankingData {
	
	//GameRanking을 저장할 LinkedList
	private LinkedList<GameRankingData> list = new LinkedList<GameRankingData>();
	GameData data = null;
	private int total_score;
	private String nickname;

	/********** 생성자 **********/
	public GameRankingData() {
		data = GameData.getInstance();
	}
	
	/********** 생성자 **********/
	public GameRankingData(String nickname, int total_score) {
		this.nickname = nickname;
		this.total_score = total_score;
	}
	
	/********** LinkedList값 반환 메소드 **********/
	public LinkedList<GameRankingData> getList() {
		return list;
	}
	
	/********** totalScore 반환 메소드 **********/
	public int getTotal_score() {
		return total_score;
	}

	/********** totalScore 대입 메소드 **********/
	public void setTotal_score() {
		total_score = data.getTotal();
	}

	/********** nickName 대입 메소드 **********/
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/********** nickName 반환 메소드 **********/
	public String getNickname() {
		return nickname;
	}
}

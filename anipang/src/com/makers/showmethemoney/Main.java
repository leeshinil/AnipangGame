package com.makers.showmethemoney;

import com.makers.showmethemoney.controller.StartController;
import com.makers.showmethemoney.model.game.BackgroundMusicSound;

/********** �ݵ�� ���� ���� ���� ����, ���忡 ���� ��θ� Ȯ���ؾ� ��!!! **********/
public class Main {
	public static void main(String[] args) {
		new StartController().gameStart();
		new BackgroundMusicSound();
		/****/
	}
}
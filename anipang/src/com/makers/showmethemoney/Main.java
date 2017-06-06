package com.makers.showmethemoney;

import com.makers.showmethemoney.controller.StartController;
import com.makers.showmethemoney.model.game.BackgroundMusicSound;

/********** 반드시 실행 전에 넣은 음악, 사운드에 대한 경로를 확인해야 함!!! **********/
public class Main {
	public static void main(String[] args) {
		new StartController().gameStart();
		new BackgroundMusicSound();
		/****/
	}
}
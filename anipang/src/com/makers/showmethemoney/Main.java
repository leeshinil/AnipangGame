package com.makers.showmethemoney;

import com.makers.showmethemoney.controller.StartController;
import com.makers.showmethemoney.model.game.BackgroundMusicSound;

public class Main {
	public static void main(String[] args) {
		// Game Start!!
		new StartController().gameStart();
		new BackgroundMusicSound();
	}			
}
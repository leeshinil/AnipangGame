package com.makers.showmethemoney;

import com.makers.showmethemoney.controller.StartController;

import test____.BackgroundMusic;

public class Main {
	public static void main(String[] args) {
		// Game Start!!
		new StartController().gameStart();
		new BackgroundMusic();
	}			
}
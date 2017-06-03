package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.BackgroundMusicSound;
import com.makers.showmethemoney.view.screen.StartView;

import test____.BackgroundMusic;

public class StartController {

	public void gameStart() {
		// Start View!!
		new StartView();
		new BackgroundMusicSound().loop();
//		new BackgroundMusic().BackgroundMusicStart();
	}
}
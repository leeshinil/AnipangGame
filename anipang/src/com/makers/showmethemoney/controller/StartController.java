package com.makers.showmethemoney.controller;

import com.makers.showmethemoney.model.game.BackgroundMusicSound;
import com.makers.showmethemoney.view.screen.StartView;

public class StartController {
	
	/********** »ý¼ºÀÚ **********/
	public void gameStart() {
		// Start View!!
		new StartView();
		new BackgroundMusicSound().loop();
	}
}
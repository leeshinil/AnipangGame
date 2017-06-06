package com.makers.showmethemoney.model.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GameSound {
	JTextField name[] = { // sound의 경로를 저장하는 TextField
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\enteredButton.wav"), // Button - entered시 소리
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\터지는소리2.wav"), // Game - 코인 터질때 소리
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\터지는소리2.wav"), // Game - 아이템 생길때 소리
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\터지는소리2.wav") // Game - 아이템 사용시 소리
			};
	File file[] = { 	// sound를 변환하여 담아둘 File
			new File(name[0].getText()),
			new File(name[1].getText()),
			new File(name[2].getText()),
			new File(name[3].getText())
			};

	public void startSound(int i) { // i번째에 저장된 소리를 출력하는 메소드
		try {
			AudioClip audioClip = Applet.newAudioClip(file[i].toURL());
			audioClip.play();
			System.out.println("Game Sound!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(name[i], "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}

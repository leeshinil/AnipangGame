package com.makers.showmethemoney.model.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GameSound {
	JTextField name[] = { // sound�� ��θ� �����ϴ� TextField
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\enteredButton.wav"), // Button - entered�� �Ҹ�
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\�����¼Ҹ�2.wav"), // Game - ���� ������ �Ҹ�
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\�����¼Ҹ�2.wav"), // Game - ������ ���涧 �Ҹ�
			new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\�����¼Ҹ�2.wav") // Game - ������ ���� �Ҹ�
			};
	File file[] = { 	// sound�� ��ȯ�Ͽ� ��Ƶ� File
			new File(name[0].getText()),
			new File(name[1].getText()),
			new File(name[2].getText()),
			new File(name[3].getText())
			};

	public void startSound(int i) { // i��°�� ����� �Ҹ��� ����ϴ� �޼ҵ�
		try {
			AudioClip audioClip = Applet.newAudioClip(file[i].toURL());
			audioClip.play();
			System.out.println("Game Sound!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(name[i], "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}

package com.makers.showmethemoney.model.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BackgroundMusicSound{
	// ��� : C:\\Users\\User\\Desktop\\Anipang\\anipang\\
	public static JTextField name = new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\�����ϰ�Ȱ��������.wav");
	public static File file = null;
	static AudioClip audioClip = null;

	/********** ������ ���ѹݺ� ��� **********/
	public static void loop() {
		try {
			file = new File(name.getText());
			audioClip = Applet.newAudioClip(file.toURL());
			audioClip.loop();
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(name, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	/********** ���� ���� **********/
	public static void stop() {
		audioClip.stop();
	}
}

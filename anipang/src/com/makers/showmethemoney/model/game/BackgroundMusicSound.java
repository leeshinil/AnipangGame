package com.makers.showmethemoney.model.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BackgroundMusicSound{

	public static JTextField text = new JTextField("C:\\Users\\User\\workspace\\test2\\경쾌하고활기찬음악.wav");
	public static File file = null;
	static AudioClip audioClip = null;

	public static void loop() {
		try {
			file = new File(text.getText());
			audioClip = Applet.newAudioClip(file.toURL());
			audioClip.loop();
			System.out.println("무한 재생!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(text, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void play() {
		try {
			file = new File(text.getText());
			audioClip = Applet.newAudioClip(file.toURL());
			audioClip.loop();
			System.out.println("무한 재생!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(text, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void stop() {
		audioClip.stop();
	}
}

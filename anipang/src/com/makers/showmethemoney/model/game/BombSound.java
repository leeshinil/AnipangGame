package com.makers.showmethemoney.model.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BombSound {
	JTextField name = new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\터지는소리2.wav");
	File file = new File(name.getText());

	public void Start() {
		try {
			AudioClip audioClip = Applet.newAudioClip(file.toURL());
			audioClip.play();
			System.out.println("Button Sound!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(name, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
}

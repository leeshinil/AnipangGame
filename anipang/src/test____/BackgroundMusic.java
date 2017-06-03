package test____;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BackgroundMusic {
	public static JTextField text = new JTextField("C:\\Users\\User\\workspace\\test2\\경쾌하고활기찬음악.wav");
	public static File file = new File(text.getText());
	static AudioClip audioClip = null;
	
	public void BackgroundMusicStart() {
		try {
			audioClip = Applet.newAudioClip(file.toURL());
			audioClip.loop();
			System.out.println("무한 재생!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(text, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void BackgroundMusicReStart(String url) {
		try {
			file = new File(url);
			audioClip = Applet.newAudioClip(file.toURL());
			audioClip.loop();
			System.out.println("무한 재생!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(text, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void BackgroundMusicStop(File file) {
		try {
			audioClip = Applet.newAudioClip(file.toURL());
			audioClip.stop();
			System.out.println("무한 재생!");
		} catch (MalformedURLException mue) {
			JOptionPane.showMessageDialog(text, "Wrong file name.", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
}

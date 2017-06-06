package com.makers.showmethemoney.view.layout;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.makers.showmethemoney.model.game.GameSound;

public class Buttons extends JButton implements ActionListener, MouseListener {
	JLabel label = null;
	JTextField name = new JTextField("C:\\Users\\User\\Desktop\\Anipang\\anipang\\enteredButton.wav");
	File file = null;
	AudioClip audioClip = null;
	
	public Buttons(int x, int y) {
		this.setBounds(x, y, 300, 100);
		this.setContentAreaFilled(false);
		
		this.addActionListener(this);
		this.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) { }
	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) {
		new GameSound().startSound(0);
	}
	public void mouseExited(MouseEvent e) {	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
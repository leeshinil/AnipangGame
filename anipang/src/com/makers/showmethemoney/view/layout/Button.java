package com.makers.showmethemoney.view.layout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Button extends JButton implements ActionListener, MouseListener{
	JLabel label = null;
	
	public Button(JLabel s, int x, int y, int width, int height) {
		this.setLayout(null);
		this.setBounds(x, y, width, height);

		label = s;
		label.setBounds(0, 0, 300, 100);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 50));

		this.add(label);
		this.addActionListener(this);
		this.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) {	}
	
	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) {	}
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
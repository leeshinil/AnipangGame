package com.makers.showmethemoney.view.screen;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.makers.showmethemoney.view.layout.Button;
import com.makers.showmethemoney.view.layout.LayoutPanel;

public class StartView {

	public StartView() {
	
		// Make Frame
		JFrame frame = new JFrame ("Show Me The Money");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));
		Container contentPane = frame.getContentPane();
		
		// Layout ´ã´ç Panel
		LayoutPanel layPanel = new LayoutPanel("startBackground1.png");
		layPanel.setLayout(null);
		layPanel.setBounds(0, 0, 1200, 950);

		JLabel label = new JLabel("START");
		
		// START Button inner Class Overriding
		Button startButton = new Button(label, 450, 700, 300, 100) {
			public void actionPerformed(ActionEvent e) {
				layPanel.remove(this);
				contentPane.remove(layPanel);
				new MenuView(frame);
			}
			
			public void mouseEntered(MouseEvent e) {
				label.setText("START!!");
			}

			public void mouseExited(MouseEvent e) {
				label.setText("START");
			}
		};
		
		layPanel.add(startButton);
		contentPane.add(layPanel);		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

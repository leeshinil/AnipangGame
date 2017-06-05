package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import com.makers.showmethemoney.view.layout.Buttons;
import com.makers.showmethemoney.view.layout.StartPanel;

public class StartView {

	public StartView() {

		// Make Frame
		JFrame frame = new JFrame ("Show Me The Money");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);

		// draw ´ã´ç Panel
		StartPanel drawPanel = new StartPanel();
		drawPanel.setLayout(null);
		drawPanel.setBounds(0, 0, 1200, 950);

		// START Button actionlistener inner Class Overriding
		Buttons startButton = new Buttons(450, 700) {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(drawPanel);
				contentPane.remove(this);
				new LoadingView(frame, 0, "startBackground2.png");
			}
		};

		contentPane.add(drawPanel);
		contentPane.add(startButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
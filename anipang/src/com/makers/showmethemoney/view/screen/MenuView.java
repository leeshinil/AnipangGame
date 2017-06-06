package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.makers.showmethemoney.view.layout.Buttons;
import com.makers.showmethemoney.view.layout.MenuPanel;

public class MenuView {
	
	public MenuView() {

		// Make Frame
		JFrame frame = new JFrame("Show Me The Money");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));
		
		// Set Container
		Container contentPane = frame.getContentPane();
		
		// draw 담당 Panel
		MenuPanel layPanel = new MenuPanel();
		layPanel.setLayout(null);
		layPanel.setBounds(0, 0, 1200, 950);	
		
		// Button MouseEvent에 대한 inner Class Overriding
		Buttons ModeButton1 = new Buttons(700, 300);
		Buttons ModeButton2 = new Buttons(700, 450);
		Buttons ModeButton3 = new Buttons(700, 600);
		
		// Button Action에 대한 inner Class Overriding
		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(layPanel);
				new LoadingView(1, "gamePanelBackground.png");
			}
		};
		ActionListener action2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(layPanel);
				new LoadingView(2, "gamePanelBackground.png");
			}
		};
		ActionListener action3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(layPanel);
				new LoadingView(3, "gamePanelBackground.png");
			}
		};
		
		// Button에 대한 add listener
		ModeButton1.addActionListener(action1);
		ModeButton2.addActionListener(action2);
		ModeButton3.addActionListener(action3);
				
		// Layout Panel에 add buttons
		layPanel.add(ModeButton1);
		layPanel.add(ModeButton2);
		layPanel.add(ModeButton3);
		
		contentPane.add(layPanel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

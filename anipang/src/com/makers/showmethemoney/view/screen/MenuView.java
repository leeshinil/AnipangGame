package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.makers.showmethemoney.view.layout.Buttons;
import com.makers.showmethemoney.view.layout.MenuPanel;
import com.makers.showmethemoney.view.layout.StartPanel;

public class MenuView {
	JLabel mode1 = null;
	JLabel mode2 = null;
	JLabel mode3 = null;
	
	public MenuView(JFrame frame) {

		// Set Container
		Container contentPane = frame.getContentPane();
		
		// draw 담당 Panel
		MenuPanel layPanel = new MenuPanel();
		layPanel.setLayout(null);
		layPanel.setBounds(0, 0, 1200, 950);	
		
		// Button에 print될 Label
//		mode1 = new JLabel("Mode 1");
//		mode2 = new JLabel("Mode 2");
//		mode3 = new JLabel("Mode 3");

		// Button MouseEvent에 대한 inner Class Overriding
		Buttons ModeButton1 = new Buttons(700, 300);
//		{
//			public void mouseEntered(MouseEvent e) {
//				mode1.setText("Mode 1!!");	
//			}
//			public void mouseExited(MouseEvent e) {
//				mode1.setText("Mode 1");
//			}
//		};
		Buttons ModeButton2 = new Buttons(700, 450);
//		{
//			public void mouseEntered(MouseEvent e) {
//				mode2.setText("Mode 2!!");
//			}
//			public void mouseExited(MouseEvent e) {
//				mode2.setText("Mode 2");
//			}
//		};
		Buttons ModeButton3 = new Buttons(700, 600);
//		{
//			public void mouseEntered(MouseEvent e) {
//				mode3.setText("Mode 3!!");
//			}
//			public void mouseExited(MouseEvent e) {
//				mode3.setText("Mode 3");
//			}
//		};
		
		// Button Action에 대한 inner Class Overriding
		ActionListener action1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(layPanel);
				new LoadingView(frame, 1, "gameBackground1.png");
			}
		};
		ActionListener action2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(layPanel);
				new LoadingView(frame, 2, "gameBackground1.png");
			}
		};
		ActionListener action3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(layPanel);
				new LoadingView(frame, 3, "gameBackground1.png");
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

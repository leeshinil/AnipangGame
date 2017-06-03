package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.makers.showmethemoney.view.layout.Button;
import com.makers.showmethemoney.view.layout.LayoutPanel;

public class MenuView {
	JLabel mode1 = null;
	JLabel mode2 = null;
	JLabel mode3 = null;
	
	public MenuView(JFrame frame) {

		// Set Container
		Container contentPane = frame.getContentPane();
		
		// Layout 담당 Panel
		LayoutPanel layPanel = new LayoutPanel("startBackground2.png");
		layPanel.setLayout(null);
		layPanel.setBounds(0, 0, 1200, 950);	
		
		// Button에 print될 Label
		mode1 = new JLabel("Mode 1");
		mode2 = new JLabel("Mode 2");
		mode3 = new JLabel("Mode 3");

		// Button MouseEvent에 대한 inner Class Overriding
		Button ModeButton1 = new Button(mode1, 700, 300, 300, 100) {
			public void mouseEntered(MouseEvent e) {
				mode1.setText("Mode 1!!");	
			}
			public void mouseExited(MouseEvent e) {
				mode1.setText("Mode 1");
			}
		};
		Button ModeButton2 = new Button(mode2, 700, 450, 300, 100) {
			public void mouseEntered(MouseEvent e) {
				mode2.setText("Mode 2!!");
			}
			public void mouseExited(MouseEvent e) {
				mode2.setText("Mode 2");
			}
		};
		Button ModeButton3 = new Button(mode3, 700, 600, 300, 100) {
			public void mouseEntered(MouseEvent e) {
				mode3.setText("Mode 3!!");
			}
			public void mouseExited(MouseEvent e) {
				mode3.setText("Mode 3");
			}
		};
		
		// Button Action에 대한 inner Class Overriding
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layPanel.remove(ModeButton1);
				layPanel.remove(ModeButton2);
				layPanel.remove(ModeButton3);
				contentPane.remove(layPanel);
				new GameView(frame);
			}
		};
		
		// Button에 대한 add listener
		ModeButton1.addActionListener(action);
		ModeButton2.addActionListener(action);
		ModeButton3.addActionListener(action);
				
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

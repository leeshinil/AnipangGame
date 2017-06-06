package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.makers.showmethemoney.view.layout.Buttons;
import com.makers.showmethemoney.view.layout.RankingPanel;

public class RankingView {

	/********** ������ **********/
	public RankingView() {

		// Make Frame
		JFrame frame = new JFrame("RANK");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));
		Container contentPane = frame.getContentPane();

		contentPane.setLayout(null);

		// draw ��� Panel
		RankingPanel drawPanel = new RankingPanel();
		drawPanel.setLayout(null);
		drawPanel.setBounds(0, 0, 1200, 950);
		contentPane.add(drawPanel);
		
		Buttons menuButton = new Buttons(450, 770);
		
		// Button Action�� ���� inner Class Overriding
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoadingView(0, "menuPanelBackground.png");
				frame.dispose();
			}
		};
		
		// Button�� ���� add listener
		menuButton.addActionListener(action);
		
		contentPane.add(menuButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

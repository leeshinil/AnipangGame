package com.makers.showmethemoney.view.screen;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.makers.showmethemoney.view.layout.RankingPanel;

public class RankingView {
	public static void main(String[] args) {

		// Make Frame
		JFrame frame = new JFrame("RANK");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));
		Container contentPane = frame.getContentPane();

		contentPane.setLayout(null);

		// draw ´ã´ç Panel
		RankingPanel drawPanel = new RankingPanel();
		drawPanel.setLayout(null);
		drawPanel.setBounds(0, 0, 1200, 950);
		contentPane.add(drawPanel);

//		g.fillRect(450, 770, 300, 100);
//		g.fillRect(460, 780, 280, 80);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

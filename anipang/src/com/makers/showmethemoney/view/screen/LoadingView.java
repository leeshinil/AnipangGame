package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.makers.showmethemoney.model.game.ThreadData;
import com.makers.showmethemoney.view.layout.LoadingPanel;

public class LoadingView {
	ThreadData threadData = null;
	
	/********** »ý¼ºÀÚ **********/
	public LoadingView(int checkView, String s) {
		int _checkView = checkView;
		threadData = ThreadData.getInstance();
		// Make Frame
		JFrame frame = new JFrame("Show Me The Money");
		frame.setLocation(500, 20);
		frame.setPreferredSize(new Dimension(1215, 995));

		// Set Container
		Container contentPane = frame.getContentPane();
		
		// make and set LoadingPanel
		LoadingPanel loadingPanel = new LoadingPanel(s);
		loadingPanel.setLayout(null);
		loadingPanel.setBounds(0, 0, 1200, 950);

		MouseListener listener = new MouseListener() {
			public void mouseReleased(MouseEvent e) { }

			public void mousePressed(MouseEvent e) {
				switch (_checkView) {
				case 0: {
					new MenuView();
					threadData.setCount(270);
					break;
				}
				case 1: {
					new GameView();
					threadData.setCount(270);
					break;
				}
				case 2: {
					new RankingView();
					threadData.setCount(270);
					break;
				}
				case 3:
					break;
				}
				frame.dispose();
			}
			
			public void mouseExited(MouseEvent e) { }
			public void mouseEntered(MouseEvent e) { }
			public void mouseClicked(MouseEvent e) { }
		};
		
		loadingPanel.addMouseListener(listener);
		contentPane.add(loadingPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

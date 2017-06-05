package com.makers.showmethemoney.view.screen;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.makers.showmethemoney.view.layout.StartPanel;
import com.makers.showmethemoney.view.layout.LoadingPanel;

public class LoadingView {

	public LoadingView(JFrame frame, int checkView, String s) {
		int _checkView = checkView;
		
		// Set Container
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		// make and set LoadingPanel
		LoadingPanel loadingPanel = new LoadingPanel("startBackground2.png");
		loadingPanel.setBounds(0, 0, 1200, 950);

		MouseListener listener = new MouseListener() {
			public void mouseReleased(MouseEvent e) { }
			public void mousePressed(MouseEvent e) {
				loadingPanel.doDraw();
				contentPane.remove(loadingPanel);
				
				switch(_checkView) {
				case 0 : new MenuView(frame); break;
//				case 1 : new GameView(frame); break; // mode 1
//				case 2 : new GameView(frame); break; // mode 2
//				case 3 : new GameView(frame); break; // mode 3
				}
			}
			public void mouseExited(MouseEvent e) { }
			public void mouseEntered(MouseEvent e) { }
			public void mouseClicked(MouseEvent e) { }
		};
		
		loadingPanel.addMouseListener(listener);
		contentPane.add(loadingPanel);
		
	}
}

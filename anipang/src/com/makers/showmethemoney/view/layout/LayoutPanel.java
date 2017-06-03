package com.makers.showmethemoney.view.layout;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class LayoutPanel extends JPanel {
	Toolkit toolkit = getToolkit();
	Image backgroundImage = null;
	
	public LayoutPanel(String s) {
		backgroundImage = toolkit.getImage(s);
	}
				
	public void paint(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, 1200, 950, this);
	}
}
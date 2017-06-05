package test____;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImageLoding extends JPanel {
	Toolkit toolkit = getToolkit();
	Image image = null;
	
	ImageLoding() {
		this.setVisible(true);
		image = toolkit.getImage("loding.png");
	}
	
	public void doDraw() {
		drawLoding(getGraphics());
	}
	
	public void drawLoding(Graphics g) {
		int count = 1;
		int size = 0;
		while (count++ < 100) {
			try {
				System.out.println("스레드 돌린다~");
				Thread.sleep(100);
				g.clearRect(310-size, 50, size, 20);
//				g.drawImage(image, 10, 50, 300-size, 20, this);
				size += 2;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(image, 10, 50, 300, 20, this);
	}
}

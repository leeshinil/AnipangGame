package test____;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public interface Main {
	public static void main(String[] args) {

		JFrame frame = new JFrame("로딩창 테스트");
		frame.setLocation(500, 100);
		frame.setPreferredSize(new Dimension(415, 310));
		Container contentPane = frame.getContentPane();
		
		ImageLoding imagePanel = new ImageLoding();
		imagePanel.setLayout(null);
		imagePanel.setPreferredSize(new Dimension(400, 300));
		
		JButton button = new JButton();
		button.setBounds(150, 230, 80, 30);
		
		ActionListener action = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				imagePanel.doDraw();
			}
		};
		
		button.addActionListener(action);
		imagePanel.add(button);
		contentPane.add(imagePanel);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

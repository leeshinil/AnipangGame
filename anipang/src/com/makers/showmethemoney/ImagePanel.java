package com.makers.showmethemoney;

import java.awt.*;        
import javax.swing.*;   

class ImagePanel extends JPanel {
    Image[] images = new Image[10];
    Toolkit toolkit = getToolkit();
    int[][] board = {
    	{ 0, 1, 2},
    	{ 2, 3, 0},
    	{ 3, 0, 1}
    };
    public ImagePanel()
    {
    	for(int i = 0 ; i < 10 ; ++i)
    		images[i] = toolkit.getImage("f"+(i+1)+".jpg");
    }
    public int getX(int col) { return col*getWidth()/3; }
    public int getY(int row) { return row*getHeight()/3; }
    public void drawCell(Graphics g, int col, int row)
    {
    	g.drawImage(images[ board[row][col] ], 
			getX(col), getY(row), getWidth()/3, getHeight()/3,
			this);
    }
    public void paint(Graphics g)  {
        g.clearRect(0, 0, getWidth(), getHeight());
        for(int row=0 ; row < 3; ++row)
        	for(int col=0; col < 3; ++col)
        		drawCell(g, row,col);        
    }
}

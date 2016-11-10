package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class BallPanel extends JPanel {

	//Pong Panel
	
	
	//Var
	Color ballColor = Color.RED;
	
	public void paint(Graphics g){
		super.paint(g);
		int x0 = 320, y0 = 50, r0 = 50;
		g.setColor(ballColor);
		g.fillOval(x0, y0, r0, r0);
		
	}
	
	public void setBallColor(Color newColor){
		this.ballColor = newColor;
	}

	public Color getBallColor(){
		return ballColor;
	}
	
	
}

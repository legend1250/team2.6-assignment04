package vn.vanlanguni.ponggame;

import java.awt.Color;

public class Ball {
	
	private Color color = Color.RED;
	
	public Ball(Color c){
		c = getColor();
	}
	
	public void setColor(Color newColor){
		this.color = newColor;
	}
	
	public Color getColor(){
		return color;
	}
}

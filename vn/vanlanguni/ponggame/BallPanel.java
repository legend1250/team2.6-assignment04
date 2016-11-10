package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
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
	
	JButton btnChangeBallColor = new JButton("Change color");
	
	public BallPanel(){
		//add component
		setLayout(null);
		add(btnChangeBallColor);
		Insets isMargin = new Insets(1, 1, 1, 1);
		
		btnChangeBallColor.setBounds(20, 20, 95, 35);
		btnChangeBallColor.setMargin(isMargin);
		//ActionListener
		ActionListener actionButton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource() == btnChangeBallColor){
					changeBallColor();
				}
			}
		};
		//add ActionListener to button
		btnChangeBallColor.addActionListener(actionButton);
	}
	
	
	private void changeBallColor(){
		Color newColor = JColorChooser.showDialog(this, "Choose Ball Color",getBallColor());
		setBallColor(newColor);
		
		repaint();
	
	}
	
	public String getData(){
		return "5";
	}
	
	public void setBallColor(Color newColor){
		this.ballColor = newColor;
	}

	public Color getBallColor(){
		return ballColor;
	}
	
	
}

package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;

public class BallPanel extends JPanel implements MouseListener{

	//Var
	Color ballColor = Color.RED;
	
	//
	private boolean IsColorBall = true,
					IsImageBall = false;
	int x0 = 320, y0 = 50, r0 = 50;
	
	//Image Ball
	Rectangle[] rectImageBall = new Rectangle[3];
	int[] x = {45,145,245}, y = {105};
	int nImageIndex = 0;
	//Image resources
	BufferedImage imgSoccerBall, imgKABall, imgMasterBall;
	String[] imgURL = {
			"images/SoccerBall.png",
			"images/KA_Ball.png",
			"images/MasterBall.png"
	};
	public void paint(Graphics g){
		super.paint(g);
	
		if(IsColorBall){
			g.setColor(ballColor);
			g.fillOval(x0, y0, r0, r0);
		}
		else if(IsImageBall){
			if(nImageIndex == 0){
				g.drawImage(imgSoccerBall, x0, y0, x0 + r0, y0 + r0, 0, 0, 256, 256, null);
			}
			else if (nImageIndex == 1){
				g.drawImage(imgKABall, x0, y0, x0 + r0, y0 + r0, 0, 0, 333, 328, null);
			}
			else if (nImageIndex == 2){
				g.drawImage(imgMasterBall, x0, y0, x0 + r0, y0 + r0, 0, 0, 400, 400, null);
			}
		}
		g.drawImage(imgSoccerBall, x[0], y[0], x[0] + r0, y[0] + r0, 0, 0, 256, 256, null);
		g.drawImage(imgKABall, x[1], y[0], x[1] + r0, y[0] + r0, 0, 0, 333, 328, null);
		g.drawImage(imgMasterBall, x[2], y[0], x[2] + r0, y[0] + r0, 0, 0, 400, 400, null);
		
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
		
		//ImageBall
		addMouseListener(this);
		rectImageBall[0] = new Rectangle(x[0], y[0], r0, r0);
		rectImageBall[1] = new Rectangle(x[1], y[0], r0, r0);
		rectImageBall[2] = new Rectangle(x[2], y[0], r0, r0);
		
		try {
			imgSoccerBall = ImageIO.read(new File(imgURL[0]));
			imgKABall = ImageIO.read(new File(imgURL[1]));
			imgMasterBall = ImageIO.read(new File(imgURL[2]));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	private void changeBallColor(){
		Color newColor = JColorChooser.showDialog(this, "Choose Ball Color",getColor());
		setColor(newColor);
		setIsImageBall(false);
		setIsColorBall(true);
		repaint();
	}
	
	
	public void setColor(Color newColor){
		this.ballColor = newColor;
	}

	public Color getColor(){
		return ballColor;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0 ; i < 3 ; i++){
			if(rectImageBall[i].contains(e.getX(),e.getY())){
				setIsImageBall(true);
				setIsColorBall(false);
				setnImageIndex(i);
			}
		}
		repaint();
	}


	public boolean isIsColorBall() {
		return IsColorBall;
	}


	public void setIsColorBall(boolean isColorBall) {
		IsColorBall = isColorBall;
	}


	public boolean isIsImageBall() {
		return IsImageBall;
	}


	public void setIsImageBall(boolean isImageBall) {
		IsImageBall = isImageBall;
	}


	public int getnImageIndex() {
		return nImageIndex;
	}


	public void setnImageIndex(int nImageIndex) {
		this.nImageIndex = nImageIndex;
	}


	public void mouseEntered(MouseEvent e) {}


	public void mouseExited(MouseEvent e) {}


	public void mousePressed(MouseEvent e) {}


	public void mouseReleased(MouseEvent e) {}

}

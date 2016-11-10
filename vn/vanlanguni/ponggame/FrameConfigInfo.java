package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameConfigInfo extends JFrame{

	
	final static int WIDTH = 400, HEIGHT = 400;
	
	BallPanel ballPanel = new BallPanel();
	PongPanel pongPanel = new PongPanel();
	
	public FrameConfigInfo(){
		setTitle("Config infomation");
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setLocation(380,150);
		setLayout(null);
		pack();
		
		initMenuComponent();
		//add Panel
		this.add(ballPanel);
		ballPanel.setBounds(0,0,WIDTH,HEIGHT);
		
		ActionListener actionBall = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== mniSetColorOfBall){
					Color newColor = JColorChooser.showDialog(ballPanel, "Choose Ball Color",ballPanel.getBallColor());
					ballPanel.setBallColor(newColor);
					repaint();
					pongPanel.setBallColor(newColor);
				}
			}
		};
		
		//add ActionListener to JMenuItem
		mniSetColorOfBall.addActionListener(actionBall);
		
	}
	
	JMenuBar mnbMenuBar;
	JMenu mnuUser, mnuBall, mnuBackground;
	JMenuItem mniSetNameOfUser, mniSetColorOfBall;
	
	private void initMenuComponent(){
		//init menuComponent
		mnbMenuBar = new JMenuBar();
		mnuUser = new JMenu("User");
		mnuBall = new JMenu("Ball");
		mnuBackground = new JMenu("Background");
		mniSetNameOfUser = new JMenuItem("Set name");
		mniSetColorOfBall = new JMenuItem("Set color");
		//add
		setJMenuBar(mnbMenuBar);
		//add to menubar
		mnbMenuBar.add(mnuUser);
		mnbMenuBar.add(mnuBall);
		mnbMenuBar.add(mnuBackground);
		//add to Menu
		mnuUser.add(mniSetNameOfUser);
		
		mnuBall.add(mniSetColorOfBall);
		
		
	}
}

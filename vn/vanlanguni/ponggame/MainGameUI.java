/*
 * 
 * 
 * 
 * 
 */
package vn.vanlanguni.ponggame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Invisible Man
 *
 */
public class MainGameUI extends JFrame{
	private static final int _HEIGHT = 500;
	private static final int _WIDTH = 500;
	
	private PongPanel pongPanel;
	private BallPanel ballPanel;
	
	public MainGameUI(){
		setPreferredSize(new Dimension(_WIDTH, _HEIGHT));
		setTitle("Pong Game - K21T Ltd.");
		setLocation(800,150);
		pongPanel = new PongPanel();
		ballPanel = new BallPanel();
		pack();
		getContentPane().add(pongPanel, BorderLayout.CENTER);
	}
	
	public void repaintPongPanel(){
		pongPanel.setBallColor(ballPanel.getBallColor());
	}

    public static void main(String[] args) {
       MainGameUI mainFrame = new MainGameUI();
       mainFrame.setVisible(true);
       mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
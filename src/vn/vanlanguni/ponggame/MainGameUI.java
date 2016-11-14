/*
 * 
 * 
 * 
 * 
 */
package vn.vanlanguni.ponggame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * 
 * @author Invisible Man
 *
 */
public class MainGameUI extends JFrame {
	private static final int _HEIGHT = 500;
	private static final int _WIDTH = 500;
	
	private PongPanel pongPanel;
	
	JDialog d;
	DialogConfig d2;
	
	public MainGameUI(){
		setPreferredSize(new Dimension(_WIDTH, _HEIGHT));
		setTitle("Pong Game - K21T Ltd.");
		setLocation(800,150);
		pongPanel = new PongPanel();
		pack();
		getContentPane().add(pongPanel, BorderLayout.CENTER);
		
		d2 = new DialogConfig();
		d2.setModal(true);
		d2.setVisible(true);

		pongPanel.setBallColor(d2.getBallColor());
	}	

    public static void main(String[] args) {
       MainGameUI mainFrame = new MainGameUI();
       mainFrame.setVisible(true);
       mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
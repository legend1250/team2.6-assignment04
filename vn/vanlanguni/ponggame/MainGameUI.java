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
	
	private PongPanel pongPanel = new PongPanel();;
	private FrameConfigInfo configFrame = new FrameConfigInfo();
	
	JButton btnPlayGame = new JButton("Play Game"),
			btnConfig = new JButton("Config");
	
	
	public MainGameUI(){
		setPreferredSize(new Dimension(_WIDTH, _HEIGHT));
		setTitle("Pong Game - K21T Ltd.");
		setLayout(null);
		setLocation(800,150);
		pack();
		
		initComponent();
	}
	
	private void initComponent(){
		this.add(btnPlayGame);
		this.add(btnConfig);
		
		btnPlayGame.setBounds(185, 40, 120, 80);
		btnConfig.setBounds(185, 180, 120, 80);
		
		btnPlayGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getContentPane().add(pongPanel, BorderLayout.CENTER);
				pongPanel.setVisible(true);
			}
		});
		
		
	}

    public static void main(String[] args) {
       MainGameUI mainFrame = new MainGameUI();
       mainFrame.setVisible(true);
       mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
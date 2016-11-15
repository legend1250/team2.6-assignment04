package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

public class JDialogSettings extends JDialog{
	final static int WIDTH = 400, HEIGHT = 600;
	
	private Color BallColor;
	private String namePlayer01, namePlayer02;
	private Color BackgroundColor;
	
	

	BallPanel ballPanel = new BallPanel();
	
	public JDialogSettings(){
		setTitle("Config infomation");
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setLocation(380,150);
		setLayout(null);
		pack();
		
		initMenuComponent();
		//add Panel
		this.add(ballPanel);
		int h_ballPanel = 450;
		ballPanel.setBounds(0,0,WIDTH,h_ballPanel);
		ballPanel.setVisible(false);
		ballPanel.setBorder(new EtchedBorder());
		
		initComponents();		
		
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
		
		ActionListener actionBall = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== mniSetColorOfBall){
					setBallColor(ballPanel.getColor());
					ballPanel.setVisible(true);
				}
			}
		};
		
		//add ActionListener to JMenuItem
		mniSetColorOfBall.addActionListener(actionBall);
	}
	
	JButton btnSaveInfo = new JButton("Save"), btnExit = new JButton("Exit");
	private void initComponents(){
		Insets isMargin = new Insets(1, 1, 1, 1);
		add(btnSaveInfo);
		btnSaveInfo.setFocusable(false);
		btnSaveInfo.setMargin(isMargin);
		btnSaveInfo.setBounds(240, 500, 65, 30);
		add(btnExit);
		btnExit.setFocusable(false);
		btnExit.setMargin(isMargin);
		btnExit.setBounds(315, 500, 60, 30);
		
		ActionListener actionButton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btnT = (JButton) e.getSource();
				if(btnT.equals(btnSaveInfo)){
					setBallColor(ballPanel.getColor());
				}
				else if(btnT.equals(btnExit)){
					if(BallColor != ballPanel.getColor()){
						int result = JOptionPane.showConfirmDialog(null, "You haven't save yet! Do you want to save then Exit?");
						if(result == JOptionPane.YES_OPTION){
							setBallColor(ballPanel.getColor());
							dispose();
						}
						else if(result == JOptionPane.NO_OPTION){
							dispose();
						}
					}
					else{
						dispose();
					}
				}
			}
		};
		btnSaveInfo.addActionListener(actionButton);
		btnExit.addActionListener(actionButton);
		
	}
	
	
	
	public Color getBallColor() {
		return BallColor;
	}


	public void setBallColor(Color ballColor) {
		BallColor = ballColor;
	}


	public String getNamePlayer01() {
		return namePlayer01;
	}


	public void setNamePlayer01(String namePlayer01) {
		this.namePlayer01 = namePlayer01;
	}


	public String getNamePlayer02() {
		return namePlayer02;
	}


	public void setNamePlayer02(String namePlayer02) {
		this.namePlayer02 = namePlayer02;
	}
}

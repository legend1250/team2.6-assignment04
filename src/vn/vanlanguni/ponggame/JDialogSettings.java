package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

public class JDialogSettings extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6319977207462766493L;

	final static int WIDTH = 450, HEIGHT = 500;
	
	BallPanel ballPanel;
	
	public JDialogSettings(){
		setTitle("Config infomation");
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setLocation(380,150);
		setLayout(null);
		pack();
		
		initMenuComponent();
		//add Panel
		ballPanel = new BallPanel();
		this.add(ballPanel);
		int h_ballPanel = 350;
		ballPanel.setBounds(0,0,WIDTH,h_ballPanel);
		ballPanel.setVisible(false);
		ballPanel.setBorder(new EtchedBorder());
		
		initComponents();		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				AskingCloseJDialog();
			}

			
		});
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
		btnSaveInfo.setBounds(280, 400, 65, 30);
		add(btnExit);
		btnExit.setFocusable(false);
		btnExit.setMargin(isMargin);
		btnExit.setBounds(365, 400, 60, 30);
		
		ActionListener actionButton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btnT = (JButton) e.getSource();
				if(btnT.equals(btnSaveInfo)){
					saveInfobBallPanel();
				}
				else if(btnT.equals(btnExit)){
					AskingCloseJDialog();
					dispose();
				}
			}
		};
		btnSaveInfo.addActionListener(actionButton);
		btnExit.addActionListener(actionButton);
		
	}
	
	private int nIndexImageBall = 0;
	private Color BallColor = Color.RED;
	
	JDialogSettings settingsBall;
	
	public JDialogSettings(int nIndex, Color newColor){
		this.nIndexImageBall = nIndex;
		this.BallColor = newColor;
	}
	
	
	private void saveInfobBallPanel(){
		int nIndex = ballPanel.getnImageIndex();
		Color newColor = ballPanel.getColor();
		setnIndexImageBall(nIndex);
		setBallColor(newColor);
		settingsBall = new JDialogSettings(nIndex,newColor);
	}

	public JDialogSettings getSettingsBall(){
		return settingsBall;
	}
	
	private void AskingCloseJDialog(){
		if(getBallColor() != ballPanel.getColor() || getnIndexImageBall() != ballPanel.getnImageIndex()){
			int result = JOptionPane.showConfirmDialog(null, "You haven't save yet! Do you want to save then Exit?","WARNING",
			        JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				saveInfobBallPanel();
			}
			else if(result == JOptionPane.NO_OPTION){
				settingsBall = new JDialogSettings(getnIndexImageBall(),getBallColor());
				dispose();
			}
		}
		else{
			settingsBall = new JDialogSettings(getnIndexImageBall(),getBallColor());
			dispose();
		}
	}
	
	public void setnIndexImageBall(int nIndexImageBall) {
		this.nIndexImageBall = nIndexImageBall;
	}
	
	public int getnIndexImageBall() {
		return nIndexImageBall;
	}

	public void setBallColor(Color ballColor) {
		BallColor = ballColor;
	}


	public Color getBallColor() {
		return BallColor;
	}
}

package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class JDialogSettings extends JDialog {
	final static int WIDTH = 400, HEIGHT = 600;

	private Color BallColor;
	private String namePlayer01="", namePlayer02="";
	private Color BackgroundColor;

	NamePanel namePanel = new NamePanel();

	BallPanel ballPanel = new BallPanel();

	public JDialogSettings() {
		setTitle("Config infomation");
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLocation(380, 150);
		setLayout(null);

		pack();

		initMenuComponent();
		// add Panel
		this.add(ballPanel);
		int h_ballPanel = 450;
		ballPanel.setBounds(0, 0, WIDTH, h_ballPanel);
		ballPanel.setVisible(false);
		ballPanel.setBorder(new EtchedBorder());

		this.add(namePanel);
		namePanel.setLayout(null);
		namePanel.setBounds(0, 0, 380, 150);
		namePanel.setVisible(true);
		namePanel.setBorder(new EtchedBorder());
		initComponents();

	}

	JMenuBar mnbMenuBar;
	JMenu mnuUser, mnuBall, mnuBackground;
	JMenuItem mniSetNameOfUser, mniSetColorOfBall;

	private void initMenuComponent() {
		// init menuComponent
		mnbMenuBar = new JMenuBar();
		mnuUser = new JMenu("User");
		mnuBall = new JMenu("Ball");
		mnuBackground = new JMenu("Background");
		mniSetNameOfUser = new JMenuItem("Set name");
		mniSetColorOfBall = new JMenuItem("Set color");
		// add
		setJMenuBar(mnbMenuBar);
		// add to menubar
		mnbMenuBar.add(mnuUser);
		mnbMenuBar.add(mnuBall);
		mnbMenuBar.add(mnuBackground);
		// add to Menu
		mnuUser.add(mniSetNameOfUser);

		mnuBall.add(mniSetColorOfBall);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mniSetColorOfBall) {
					ballPanel.setVisible(true);
					namePanel.setVisible(false);
				} else if (e.getSource() == mniSetNameOfUser)
					ballPanel.setVisible(false);
				namePanel.setVisible(true);
			}
		};

		// add ActionListener to JMenuItem
		mniSetColorOfBall.addActionListener(action);
		mniSetNameOfUser.addActionListener(action);
	}

	JButton btnSaveInfo = new JButton("Save"), btnExit = new JButton("Exit");

	private void initComponents() {
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
				if (btnT.equals(btnSaveInfo)) {
					saveInfo();
				} else if (btnT.equals(btnExit)) {
					/*
					 * if(BallColor != Color.RED){ int result =
					 * JOptionPane.showConfirmDialog(null,
					 * "You haven't save yet! Do you want to save then Exit?");
					 * if(result == JOptionPane.YES_OPTION){
					 * //saveInfoThenExit(); } else if(result ==
					 * JOptionPane.NO_OPTION){ dispose(); } } else{ dispose(); }
					 */
					dispose();
				}
			}
		};
		btnSaveInfo.addActionListener(actionButton);
		btnExit.addActionListener(actionButton);

	}

	private void saveInfo() {
		if (namePanel.GetNamePlayer01().isEmpty()) {
			setNamePlayer01("");
		} else {
			setNamePlayer01(namePanel.GetNamePlayer01());
		}
		if (namePanel.GetNamePlayer02().isEmpty()) {
			setNamePlayer02("");
		} else {
			setNamePlayer02(namePanel.GetNamePlayer02());
		}
	}

	public BallPanel returnBallPanel() {

		if (isColorBall()) {
			ballPanel = new BallPanel(true, getBallColor());
		} else {
			ballPanel = new BallPanel(false, getImageBallIndex());
		}
		return ballPanel;

		// return ballPanel;
	}

	public boolean isColorBall() {
		if (ballPanel.isIsColorBall()) {
			return true;
		}
		return false;
	}

	public int getImageBallIndex() {
		return ballPanel.getnImageIndex();
	}

	public Color getBallColor() {
		return ballPanel.getColor();
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

package vn.vanlanguni.ponggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class PaddlesPanel extends JPanel implements MouseListener {

	// Var
	Color paddlesColor = Color.RED;

	//
	private boolean IsColorPaddles = true;

	int x0 = 320, y0 = 50, w0 = 20, h0 = 100;

	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(paddlesColor);
		g.fillRect(x0, y0, w0, h0);

	}

	JButton btnChangePaddlesColor = new JButton("Change color");

	public PaddlesPanel() {
		// add component
		setLayout(null);
		add(btnChangePaddlesColor);
		Insets isMargin = new Insets(1, 1, 1, 1);

		btnChangePaddlesColor.setBounds(20, 20, 95, 35);
		btnChangePaddlesColor.setMargin(isMargin);
		// ActionListener
		ActionListener actionButtonchange = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == btnChangePaddlesColor) {
					changePaddlesColor();
				}
			}
		};
		// add ActionListener to button
		btnChangePaddlesColor.addActionListener(actionButtonchange);
	}

	public PaddlesPanel(boolean isColorPaddles, Color paddlesColor) {
		this.IsColorPaddles = true;
		this.paddlesColor = paddlesColor;
	}

	private void changePaddlesColor() {
		Color newColor1 = JColorChooser.showDialog(this,
				"Choose Paddles Color", getColor());
		setColor(newColor1);
		setIsColorPaddles(true);
		repaint();
	}

	public void setColor(Color newColor1) {
		this.paddlesColor = newColor1;
	}

	public Color getColor() {
		return paddlesColor;
	}

	public boolean isIsColorPaddles() {
		return IsColorPaddles;
	}

	public void setIsColorPaddles(boolean isColorPaddles) {
		IsColorPaddles = isColorPaddles;
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

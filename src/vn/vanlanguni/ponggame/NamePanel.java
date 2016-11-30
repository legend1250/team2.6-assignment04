/**
 * 
 */
package vn.vanlanguni.ponggame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Hades
 *
 */
public class NamePanel extends JPanel {
	String nameP1, nameP2;
	JLabel lblnameP1 = new JLabel("PlayerOne's Name"), lblnameP2 = new JLabel("PlayerTwo's Name");
	JTextField txtnameP1 = new JTextField(10), txtnameP2 = new JTextField(10);

	public String GetNamePlayer01() {
		return txtnameP1.getText();
	}

	public String GetNamePlayer02() {
		return txtnameP2.getText();
	}

	public NamePanel() {
		add(lblnameP1);
		lblnameP1.setBounds(10, 25, 140, 25);

		add(lblnameP2);
		lblnameP2.setBounds(10, 60, 140, 25);

		add(txtnameP1);
		txtnameP1.setBounds(160, 25, 200, 25);

		add(txtnameP2);
		txtnameP2.setBounds(160, 60, 200, 25);

		txtnameP1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (txtnameP1.getText().length() > 10) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		txtnameP2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (txtnameP2.getText().length() > 10) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}

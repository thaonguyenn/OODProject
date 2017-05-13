package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help extends JFrame{
JLabel lblPlayer,lblEnemy;
JButton btBack;
	public Help(){
		setLayout(null);
		btBack = new JButton("Back");
		btBack.setBounds(320, 0, 70, 30);
		add(btBack);
		btBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(100, 0, 40, 70);
		add(lblPlayer);
		lblEnemy = new JLabel("Enemy");
		lblEnemy.setBounds(100, 50, 40, 70);
		add(lblEnemy);
		
		setSize(400,400);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(50, 50, 40, 40);
		g.setColor(Color.red);
		g.fillOval(50, 100, 30, 30);
	}
}

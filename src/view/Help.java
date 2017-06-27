package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help extends JFrame{
JLabel lblInt, lblPlayer, lblEnemy, lblArmor, lblStar, lblMove, lblLeft, lblRight, lblJump, lblGrade;
JButton btBack;
	public Help(){
		setLayout(null);
		btBack = new JButton(new ImageIcon("image/back.png"));
		btBack.setBounds(320, 0, 40, 40);
		add(btBack);
		btBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				(new TestCase()).main(null);
			}
		});
		lblInt = new JLabel("Introduction");
		lblInt.setFont(new Font("Bodoni MT Black", 1, 20));
		lblInt.setBounds(120, -15, 150, 50);
		add(lblInt);
		lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(100, 0, 100, 70);
		add(lblPlayer);
		lblEnemy = new JLabel("Enemy (score: -2)");
		lblEnemy.setBounds(100, 50, 150, 70);
		add(lblEnemy);
		lblStar = new JLabel("Star      (score: +1)");
		lblStar.setBounds(100, 100, 150, 70);
		add(lblStar);
		lblArmor = new JLabel("Armor  (protected : enemy => score: +2)");
		lblArmor.setBounds(100, 150, 300, 70);
		add(lblArmor);
		lblGrade = new JLabel("(if your score is higher than 3, you are winner!)");
		lblGrade.setFont(new Font("Arial Black", 1, 13));
		lblGrade.setBounds(0, 180, 400, 70);
		add(lblGrade);
		lblMove = new JLabel(new ImageIcon("image/muiTen.jpg"));
		lblMove.setBounds(90, 210, 200, 200);
		add(lblMove);
		lblLeft = new JLabel("Go to right");
		lblLeft.setBounds(50, 310, 60, 30);
		add(lblLeft);
		lblRight = new JLabel("Go to left");
		lblRight.setBounds(270, 310, 50,30);
		add(lblRight);
		lblJump = new JLabel("Jump on");
		lblJump.setBounds(160, 230, 50,30);
		add(lblJump);
		
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
		g.setColor(Color.yellow);
		g.fillOval(50, 150, 30, 30);
		g.setColor(Color.blue);
		g.fillRect(50, 200, 35, 35);
		g.setColor(Color.black);
		g.drawLine(100, 260,260,260);
	}
	public static void main(String[] args) {
		new Help();
	}
}

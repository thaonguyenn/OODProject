package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Level extends JFrame{
	private JButton btLevel1, btLevel2;
	private JLabel lblTitle;
	BackgroundLevel1 level1;
	BackgroundLevel2 level2;
	public Level() {
		setLayout(null);
		
		level1 = new BackgroundLevel1();
		level2 = new BackgroundLevel2();
		lblTitle = new JLabel("Level");
		lblTitle.setFont(new Font("Bodoni MT Black", 2, 50));
		lblTitle.setBounds(240, -40, 150, 150);
		add(lblTitle);
		
		btLevel1 = new JButton(new ImageIcon("image/level1.gif"));
		btLevel1.setBounds(130, 90, 150, 150);
		add(btLevel1);
		btLevel1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btLevel1.isSelected()) {
					level1.start();
					setVisible(false);
				}
			}
		});
		btLevel2 = new JButton(new ImageIcon("image/level2.jpg"));
		btLevel2.setBounds(320, 90, 150, 150);
		add(btLevel2);
		btLevel2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btLevel2.isSelected()) {
					level2.start();
					setVisible(false);
				}
			}
		});
		
		setVisible(false);
		setSize(600, 350);
		setLocationRelativeTo(null);
	}
}
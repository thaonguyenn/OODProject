package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.LevelOpen;
import model.HelpOpen;
import model.InterfaceMenu;
import model.Menu;

public class Beginer extends JFrame {
	private JButton btStart, btHelp, btExit;
	Menu menu;
	public Beginer(Menu menu) {
		setLayout(null);
		this.menu = menu;
		btStart = new JButton("Start");
		btStart.setBounds(160, 50, 70, 60);
		add(btStart);
		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btStart.isSelected()) {
					menu.getMenu()[0].execute();
					setVisible(false);
				}
			}
		});
		btHelp = new JButton("Help");
		btHelp.setBounds(160, 120, 70, 60);
		add(btHelp);
		btHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btHelp.isSelected()) {
					menu.getMenu()[1].execute();
					setVisible(false);
				}
			}
		});
		btExit = new JButton("Exit");
		btExit.setBounds(160, 190, 70, 60);
		add(btExit);
		btExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btExit.isSelected()) {
					setVisible(false);
				}
			}
		});

		setVisible(false);
		setSize(400, 400);
		setLocationRelativeTo(null);
	}
	
}

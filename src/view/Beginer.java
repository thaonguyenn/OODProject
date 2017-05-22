package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.BackgroundLevel1Open;
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
					menu.getMenu1().execute();
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
					menu.getMenu2().execute();
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

		setVisible(true);
		setSize(400, 400);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		BackgroundLevel1 level1 = new BackgroundLevel1();
		Help help = new Help();
		InterfaceMenu bOpen = new BackgroundLevel1Open(level1);
		InterfaceMenu hOpen = new HelpOpen(help);
		Menu menu = new Menu(bOpen, hOpen);
		Beginer beginer = new Beginer(menu);
	}
}

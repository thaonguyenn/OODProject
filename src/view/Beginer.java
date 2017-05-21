package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Beginer extends JFrame {
	private JButton btStart, btHelp, btExit;
	private BackgroundLevel1 background;
	private Help help;
	public Beginer() {
		setLayout(null);
		background = new BackgroundLevel1();
		help = new Help();
		btStart = new JButton("Start");
		btStart.setBounds(160, 50, 70, 60);
		add(btStart);
		btStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btStart.isSelected()) {
					background.start();
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
					help.setVisible(true);
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
		Beginer beginer = new Beginer();
	}
}

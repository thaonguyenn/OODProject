package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.TouchAddDoubleGrade;
import model.Armor;
import model.Bar;
import model.Clock;
import model.Enemy;
import model.InterfaceBar;
import model.Player;
import model.NormalPlayer;
import model.ProtectedPlayer;
import model.Score;
import model.Star;

class BackgroundLevel2 extends JFrame implements Runnable {
	private Player player;
	private Enemy enemy1, enemy2;
	private InterfaceBar bar1, bar2, bar3, bar4, bar5, bar6, bar7, bar8, bar9, bar10;
	private Star st2, st3, st4;
	private int s2, s3, s4;
	private Armor armor;
	private List<InterfaceBar> bars;
	private ViewClock txtClock;
	private ViewScore txtScore;
	private Clock clock;
	private Score grade;
	Thread t;
	int key;
	int score = 0;

	public BackgroundLevel2() {
		setLayout(null);
		s2 = 0;
		s3 = 0;
		s4 = 0;
		clock = new Clock();
		grade = new Score();
		t = new Thread(this);
		txtScore = new ViewScore(grade);
		txtScore.setEditable(false);
		txtScore.setBounds(0, 0, 140, 30);
		add(txtScore);

		txtClock = new ViewClock(clock, grade);
		txtClock.setEditable(false);
		txtClock.setBounds(400, 0, 200, 30);
		add(txtClock);

		player = new NormalPlayer(100, 240, 40);
		bar1 = new Bar(0, 240, 100);
		bar2 = new Bar(80, 200, 100);
		bar3 = new Bar(160, 200, 100);
		bar4 = new Bar(300, 200, 100);
		bar5 = new Bar(450, 230, 100);
		bar6 = new Bar(400, 150, 100);
		bar7 = new Bar(300, 110, 100);
		bar8 = new Bar(200, 110, 100);
		bar9 = new Bar(60, 70, 100);
		bar10 = new Bar(0, 300, 800);
		bars = new ArrayList<InterfaceBar>();
		bars.add(bar2);
		bars.add(bar3);
		bars.add(bar4);
		bars.add(bar5);
		bars.add(bar6);
		bars.add(bar7);
		bars.add(bar8);
		bars.add(bar9);
		bars.add(bar10);

		enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
		enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);

		st2 = new Star(350, 155, 25, player, grade, txtScore);
		st3 = new Star(280, 70, 25, player, grade, txtScore);
		st4 = new Star(300, 250, 25, player, grade, txtScore);

		armor = new Armor(450, 100, 30, player, grade);

		JLabel lbl2 = new JLabel(new ImageIcon("image/b1.png"));
		lbl2.setBounds(bar1.getX(), bar1.getY() - 90, bar1.getX() + bar1.getLen(), bar1.getY());
		add(lbl2);
		JLabel lbl2t1 = new JLabel(new ImageIcon("image/b1.png"));
		lbl2t1.setBounds(bar1.getX() + 80, bar1.getY() - 90, bar1.getX() + bar1.getLen(), bar1.getY());
		add(lbl2t1);
		JLabel lbl2t2 = new JLabel(new ImageIcon("image/b1.png"));
		lbl2t2.setBounds(bar1.getX() + 160, bar1.getY() - 90, bar1.getX() + bar1.getLen(), bar1.getY());
		add(lbl2t2);
		JLabel lbl2t3 = new JLabel(new ImageIcon("image/b1.png"));
		lbl2t3.setBounds(bar1.getX() + 240, bar1.getY() - 90, bar1.getX() + bar1.getLen(), bar1.getY());
		add(lbl2t3);
		JLabel lbl2t4 = new JLabel(new ImageIcon("image/b1.png"));
		lbl2t4.setBounds(bar1.getX() + 320, bar1.getY() - 90, bar1.getX() + bar1.getLen(), bar1.getY());
		add(lbl2t4);
		JLabel lbl2t5 = new JLabel(new ImageIcon("image/b1.png"));
		lbl2t5.setBounds(bar1.getX() + 400, bar1.getY() - 90, bar1.getX() + bar1.getLen(), bar1.getY());
		add(lbl2t5);
		JLabel lbl2t6 = new JLabel(new ImageIcon("image/b1.png"));
		lbl2t6.setBounds(bar1.getX() + 480, bar1.getY() - 90, bar1.getX() + bar1.getLen(), bar1.getY());
		add(lbl2t6);
		JLabel lbl3 = new JLabel(new ImageIcon("image/b2.png"));
		lbl3.setBounds(bar2.getX() - 50, bar2.getY() - 130, bar2.getX() + bar2.getLen(), bar2.getY());
		add(lbl3);
		JLabel lbl4 = new JLabel(new ImageIcon("image/b2.png"));
		lbl4.setBounds(bar3.getX() - 75, bar3.getY() - 130, bar3.getX() + bar3.getLen(), bar3.getY());
		add(lbl4);
		JLabel lbl5 = new JLabel(new ImageIcon("image/b2.png"));
		lbl5.setBounds(bar4.getX() - 10, bar4.getY() - 100, bar4.getX() + bar4.getLen(), bar4.getY());
		add(lbl5);
		JLabel lbl8 = new JLabel(new ImageIcon("image/b2.png"));
		lbl8.setBounds(bar7.getX() - 60, bar7.getY() - 45, bar7.getX() + bar7.getLen(), bar7.getY());
		add(lbl8);
		JLabel lbl9 = new JLabel(new ImageIcon("image/b2.png"));
		lbl9.setBounds(bar8.getX() - 10, bar8.getY() - 90, bar8.getX() + bar8.getLen(), bar8.getY());
		add(lbl9);
		JLabel lbl9t = new JLabel(new ImageIcon("image/b2.png"));
		lbl9t.setBounds(bar8.getX() - 110, bar8.getY() - 90, bar8.getX() + bar8.getLen(), bar8.getY());
		add(lbl9t);
		JLabel lbl10 = new JLabel(new ImageIcon("image/b2.png"));
		lbl10.setBounds(bar9.getX() - 40, bar9.getY() - 65, bar9.getX() + bar9.getLen(), bar9.getY());
		add(lbl10);
		JLabel lbl11 = new JLabel(new ImageIcon("image/b2.png"));
		lbl11.setBounds(bar10.getX() - 55, bar10.getY() - 280, bar10.getX() + bar10.getLen(), bar10.getY());
		add(lbl11);
		JLabel lbl1 = new JLabel(new ImageIcon("image/sea4.jpg"));
		lbl1.setBounds(0, 0, 600, 350);
		add(lbl1);

		setVisible(false);
		setSize(600, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.requestFocusInWindow();
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				key = e.getKeyCode();
				if (!e.isControlDown())
					return;
				switch (key) {
				case KeyEvent.VK_RIGHT:

					player.moveRight();
					if (enemy1.touch()) {
						if (enemy1.getTouchBehavior() instanceof TouchAddDoubleGrade) {
							enemy1.performTouch();
							enemy1.setX(1200);
							enemy1.setY(1250);
						} else
							enemy1.performTouch();
					}
					if (enemy2.touch()) {
						if (enemy2.getTouchBehavior() instanceof TouchAddDoubleGrade) {
							enemy2.performTouch();
							enemy2.setX(1100);
							enemy2.setY(1150);
						} else
							enemy2.performTouch();
					}
					if (st2.touch()) {
						s2++;
						st2.performTouch();
						st2.setX(1000);
						st2.setY(1050);
					}
					if (st3.touch()) {
						s3++;
						st3.performTouch();
						st3.setX(700);
						st3.setY(750);
					}
					if (st4.touch()) {
						s4++;
						st4.performTouch();
						st4.setX(900);
						st4.setY(950);
					}
					if (armor.touch()) {
						Player tmp = player;
						player = new ProtectedPlayer(tmp.getX(), tmp.getY(), tmp.getDuongKinh(), tmp);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						if (s2 == 0)
							st2 = new Star(350, 155, 25, player, grade, txtScore);
						if (s3 == 0)
							st3 = new Star(280, 70, 25, player, grade, txtScore);
						if (s4 == 0)
							st4 = new Star(300, 250, 25, player, grade, txtScore);
						armor.performTouch();
						armor.setX(800);
						armor.setY(850);
						enemy1.setState(false);
						enemy2.setState(false);
						enemy1.setTouchBehavior(new TouchAddDoubleGrade((Score) grade, txtScore));
						enemy2.setTouchBehavior(new TouchAddDoubleGrade((Score) grade, txtScore));
					}

					repaint();
					break;
				case KeyEvent.VK_LEFT:
					player.moveLeft();
					if (enemy1.touch()) {
						if (enemy1.getTouchBehavior() instanceof TouchAddDoubleGrade) {
							enemy1.performTouch();
							enemy1.setX(1200);
							enemy1.setY(1250);
						} else
							enemy1.performTouch();
					}
					if (enemy2.touch()) {
						if (enemy2.getTouchBehavior() instanceof TouchAddDoubleGrade) {
							enemy2.performTouch();
							enemy2.setX(1100);
							enemy2.setY(1150);
						} else
							enemy2.performTouch();
					}
					if (st2.touch()) {
						s2++;
						st2.performTouch();
						st2.setX(1000);
						st2.setY(1050);
					}
					if (st3.touch()) {
						s3++;
						st3.performTouch();
						st3.setX(700);
						st3.setY(750);
					}
					if (st4.touch()) {
						s4++;
						st4.performTouch();
						st4.setX(900);
						st4.setY(950);
					}
					if (armor.touch()) {
						Player tmp = player;
						player = new ProtectedPlayer(tmp.getX(), tmp.getY(), tmp.getDuongKinh(), tmp);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						if (s2 == 0)
							st2 = new Star(350, 155, 25, player, grade, txtScore);
						if (s3 == 0)
							st3 = new Star(280, 70, 25, player, grade, txtScore);
						if (s4 == 0)
							st4 = new Star(300, 250, 25, player, grade, txtScore);
						armor.performTouch();
						armor.setX(800);
						armor.setY(850);
						enemy1.setState(false);
						enemy2.setState(false);
						enemy1.setTouchBehavior(new TouchAddDoubleGrade((Score) grade, txtScore));
						enemy2.setTouchBehavior(new TouchAddDoubleGrade((Score) grade, txtScore));
					}
					repaint();
					break;
				case KeyEvent.VK_UP:
					player.jump();
					if (enemy1.touch()) {
						if (enemy1.getTouchBehavior() instanceof TouchAddDoubleGrade) {
							enemy1.performTouch();
							enemy1.setX(1100);
							enemy1.setY(1150);
						} else
							enemy1.performTouch();

					}
					if (enemy2.touch()) {
						if (enemy2.getTouchBehavior() instanceof TouchAddDoubleGrade) {
							enemy2.performTouch();
							enemy2.setX(1200);
							enemy2.setY(1250);
						} else
							enemy2.performTouch();
					}
					if (st2.touch()) {
						s2++;
						st2.performTouch();
						st2.setX(1000);
						st2.setY(1050);
					}
					if (st3.touch()) {
						s3++;
						st3.performTouch();
						st3.setX(700);
						st3.setY(750);
					}
					if (st4.touch()) {
						s4++;
						st4.performTouch();
						st4.setX(900);
						st4.setY(950);
					}
					if (armor.touch()) {
						Player tmp = player;
						player = new ProtectedPlayer(tmp.getX(), tmp.getY(), tmp.getDuongKinh(), tmp);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						if (s2 == 0)
							st2 = new Star(350, 155, 25, player, grade, txtScore);
						if (s3 == 0)
							st3 = new Star(280, 70, 25, player, grade, txtScore);
						if (s4 == 0)
							st4 = new Star(300, 250, 25, player, grade, txtScore);
						armor.performTouch();
						armor.setX(800);
						armor.setY(850);
						enemy1.setState(false);
						enemy2.setState(false);
						enemy1.setTouchBehavior(new TouchAddDoubleGrade((Score) grade, txtScore));
						enemy2.setTouchBehavior(new TouchAddDoubleGrade((Score) grade, txtScore));
					}
					repaint();
					break;
				}
			}
		});

		t.start();
	}

	public void start() {
		this.setVisible(true);
		// new Thread(player).start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// System.out.println(player.getX() + "-" + player.getY()+ "-"
		// +player.getDuongKinh());
		g.setColor(player.power());
		g.fillOval(player.getX(), player.getY(), player.getDuongKinh(), player.getDuongKinh());
		g.setColor(Color.red);
		g.fillOval(enemy1.getX(), enemy1.getY(), enemy1.getLen(), enemy1.getLen());
		g.fillOval(enemy2.getX(), enemy2.getY(), enemy2.getLen(), enemy2.getLen());
		g.setColor(Color.yellow);
		g.fillOval(st2.getX(), st2.getY(), st2.getLen(), st2.getLen());
		g.fillOval(st3.getX(), st3.getY(), st3.getLen(), st3.getLen());
		g.fillOval(st4.getX(), st4.getY(), st4.getLen(), st4.getLen());
		g.setColor(Color.blue);
		g.fillRect(armor.getX(), armor.getY(), armor.getLen(), armor.getLen());
	}

	@Override
	public void run() {
		while (true) {
			enemy1.runEnemy();
			enemy2.runEnemy();
			
			// win before time out
			if (enemy1.getX() > 600 && enemy2.getX() > 600 && st2.getX() > 600 && st3.getX() > 600
					&& st4.getX() > 600) {
				clock = new Clock();
				if (grade.getScore() == 3) {
					int option = JOptionPane.showConfirmDialog(null, "Well done !You are winner !", "",
							JOptionPane.YES_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						this.setVisible(false);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						st2 = new Star(350, 155, 25, player, grade, txtScore);
						st3 = new Star(280, 70, 25, player, grade, txtScore);
						st4 = new Star(300, 250, 25, player, grade, txtScore);
						new TestCase().main(null);
					}
					if (option == JOptionPane.NO_OPTION) {
						this.setVisible(false);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						st2 = new Star(350, 155, 25, player, grade, txtScore);
						st3 = new Star(280, 70, 25, player, grade, txtScore);
						st4 = new Star(300, 250, 25, player, grade, txtScore);
						new TestCase().main(null);
					}
				} else if (grade.getScore() > 3) {
					int option = JOptionPane.showConfirmDialog(null, "Great !You are winner !", "",
							JOptionPane.YES_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						this.setVisible(false);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						st2 = new Star(350, 155, 25, player, grade, txtScore);
						st3 = new Star(280, 70, 25, player, grade, txtScore);
						st4 = new Star(300, 250, 25, player, grade, txtScore);
						new TestCase().main(null);
					}
					if (option == JOptionPane.NO_OPTION) {
						this.setVisible(false);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						st2 = new Star(350, 155, 25, player, grade, txtScore);
						st3 = new Star(280, 70, 25, player, grade, txtScore);
						st4 = new Star(300, 250, 25, player, grade, txtScore);
						new TestCase().main(null);
					}

				} else {
					int option = JOptionPane.showConfirmDialog(null, "Oh oh !You lost ! Play again and try better ...",
							"", JOptionPane.YES_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						this.setVisible(false);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						st2 = new Star(350, 155, 25, player, grade, txtScore);
						st3 = new Star(280, 70, 25, player, grade, txtScore);
						st4 = new Star(300, 250, 25, player, grade, txtScore);
						new TestCase().main(null);
					}
					if (option == JOptionPane.NO_OPTION) {
						this.setVisible(false);
						enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, txtScore);
						enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, txtScore);
						st2 = new Star(350, 155, 25, player, grade, txtScore);
						st3 = new Star(280, 70, 25, player, grade, txtScore);
						st4 = new Star(300, 250, 25, player, grade, txtScore);
						new TestCase().main(null);
					}

				}
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			player.run();
			player.freeFall(bars);
			repaint();
		}

	}
}

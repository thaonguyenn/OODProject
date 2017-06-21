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

import controller.ControllerBackgrond1;
import model.Armor;
import model.Bar;
import model.Clock;
import model.Enemy;
import model.InterfaceBar;
import model.InterfaceControllerBackground;
import model.InterfaceItem;
import model.Player;
import model.PlayerNormal;
import model.Score;
import model.Star;

public class BackgroundLevel1 extends JFrame implements Runnable {
	private Player player;
	private InterfaceItem enemy1, enemy2;
	private InterfaceBar bar1, bar2, bar3, bar4, bar5, bar6, bar7, bar8, bar9, bar10;
	private InterfaceItem st2, st3, st4, armor;
	private List<InterfaceBar> bars;
	private List<InterfaceItem> listEnemies;
	private List<InterfaceItem> listStars;
	private ViewClock txtClock;
	private ViewScore txtScore;
	private Clock clock;
	private Score grade;
	private InterfaceControllerBackground controller;
	Thread t;
	int key;
	int score = 0;

	public BackgroundLevel1() {
		setLayout(null);
		listEnemies = new ArrayList<InterfaceItem>();
		listStars = new ArrayList<InterfaceItem>();
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

		player = new PlayerNormal(100, 240, 40);
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
		bars.add(bar1);
		bars.add(bar2);
		bars.add(bar3);
		bars.add(bar4);
		bars.add(bar5);
		bars.add(bar6);
		bars.add(bar7);
		bars.add(bar8);
		bars.add(bar9);
		bars.add(bar10);

		enemy1 = new Enemy(clock, 170, 245, 30, player, 3, 3, 200, 100, grade, true,txtScore);
		enemy2 = new Enemy(clock, 300, 155, 30, player, 3, 3, 350, 200, grade, true,txtScore);
		
		st2 = new Star(20, 170, 25, player, grade,txtScore);
		st3 = new Star(280, 70, 25, player, grade,txtScore);
		st4 = new Star(470, 185, 25, player, grade,txtScore);

		armor = new Armor(400, 250, 30, player, (Star) st2,grade);

		controller = new ControllerBackgrond1(player,listEnemies, listStars, armor);
		controller.addEnemy(enemy1);
		controller.addEnemy(enemy2);
		controller.addStar(st2);
		controller.addStar(st3);
		controller.addStar(st4);
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
		JLabel lbl3t = new JLabel(new ImageIcon("image/b2.png"));
		lbl3t.setBounds(bar2.getX() - 120, bar2.getY() - 90, bar2.getX() + bar2.getLen(), bar2.getY());
		add(lbl3t);
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
		JLabel lbl1 = new JLabel(new ImageIcon("image/background.png"));
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
					controller.checkAll();
					repaint();
					break;
				case KeyEvent.VK_LEFT:
					player.moveLeft();
					controller.checkAll();
					repaint();
					break;
				case KeyEvent.VK_UP:
					player.jump();
					controller.checkAll();
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

		// For Testing: vẽ các đường thẳng màu đỏ thể hiện các bar
		// g.setColor(Color.red);
		// for (Bar bar : bars) {
		// g.drawLine(bar.getX(), bar.getY(), bar.getX()+bar.getLen(),
		// bar.getY());
		// }
	}

	@Override
	public void run() {
		while (true) {// && txtClock.state
			enemy1.runEnemy();
			enemy2.runEnemy();
			System.out.println(enemy1.isState());
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

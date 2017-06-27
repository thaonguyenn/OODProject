package model;

import java.util.Observable;
import java.util.Observer;

import controller.TouchAddDoubleGrade;
import controller.TouchSubGrade;
import view.ViewScore;

public class Enemy extends Item implements Observer {
	private int dx;
	private int dy;
	private int h;
	private int w;
	private boolean state, running;
	Observable observable;
	Observable txtScore;
	ViewScore score;
	public Enemy(Observable observable, int x, int y, int len, Player player, int dx, int dy, int h, int w,Observable txtScore,ViewScore score) {
		super(x, y, len, player, txtScore);
		this.observable = observable;
		observable = new Clock();
		this.score = score;
		state= true;
		
		if(state==true)
		touchBehavior = new TouchSubGrade((Score)txtScore,score);
		else
		touchBehavior = new TouchAddDoubleGrade((Score)txtScore,score);
		
		this.txtScore = txtScore;
		this.x = x;
		this.y = y;
		this.len = len;
		this.dx = dx;
		this.dy = dy;
		this.h = h;
		this.w = w;
		running = true;
		observable.addObserver(this);
		txtScore.addObserver(this);
		((Clock)observable).demNguoc(100);
	}

	public void runEnemy() {
		if (running == true) {
			if (x + dx > h || x + dx < w) {
				dx = -dx;
			}
			if (y + dy > h || y + dy < w) {
				dy = -dy;
			}
			x = x + dx;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Clock) {
			if (arg instanceof String) {
				if ("end".equals(arg)) {
					running = false;
				}
			}
		}
	}
	// so sanh khoang cach giua 2 tam voi 2 ban kinh
	public Point getTam(){
		return new Point(this.x + this.len/2, this.y + this.len /2);
	}
	public double r1r2 (){
		return len/2 + player.getBanKinh();
	}
	public double p1p2(Point p1, Point p2){
		return Math.sqrt((p2.getX()-p1.getX())*(p2.getX()-p1.getX())+(p2.getY()-p1.getY())*(p2.getY()-p1.getY()));
	}
	@Override
	public boolean touch() {
		return p1p2(getTam(), player.getTam()) <= r1r2();
	}
}
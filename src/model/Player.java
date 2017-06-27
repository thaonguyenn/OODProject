package model;

import java.awt.Color;
import java.util.List;

public abstract class Player implements Runnable{
	protected int x;
	protected int y;
	protected int duongKinh;
	protected boolean state;
	protected int score;
	protected boolean jumping, freeFalling;
	protected int highJump, currentHigh;

	public Player(int x, int y, int duongKinh) {
		super();
		this.x = x;
		this.y = y;
		this.duongKinh = duongKinh;
		state = true;
		score = 0;
		jumping = false;
		highJump = 100;
		freeFalling = false;
	}

	public abstract Color power();

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

	public void moveLeft() {
		if (state == true)
			setX(x -= 10);
	}

	public void moveRight() {
		if (state == true)
			setX(x += 10);
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getScore() {
		return score;
	}

	public int getDuongKinh() {
		return duongKinh;
	}

	public void setDuongKinh(int duongKinh) {
		this.duongKinh = duongKinh;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public void jump() {
		if (!jumping)
			jumping = true;
	}

	public void stop() {
		jumping = false;
	}
	public Point tamPlayer(int lenC) {
		return new Point(lenC / 2 + this.x, lenC / 2 + this.y);
	}

	public int banKinhPlayer(int lenC) {
		return lenC / 2;
	}
	
	public double khoangCachTuTamToD(int lenC, int lenR, Point bar) {
		return Math.abs(lenR * tamPlayer(lenC).getY() - lenR * bar.getY()) / lenR;
	}
	
	public Point getTam(){
		return new Point(this.x + this.duongKinh/2, this.y + this.duongKinh /2);
	}
	public int getBanKinh(){
		return this.duongKinh/2;
	}
	public void freeFall(List<InterfaceBar> bars, int lenght) {
		int tmp =0;
		for (int i = 0; i < bars.size(); i++) {
			if (khoangCachTuTamToD(lenght, bars.get(i).getLen(),
					new Point(bars.get(i).getX(), bars.get(i).getY())) == banKinhPlayer(lenght)){
				freeFalling = false;
				break;
			}
			else{
				tmp++;
			}
		}
		if(tmp==bars.size()) 
		freeFalling = true;
	}
	public void freeFall(List<InterfaceBar> bars) {
		if(jumping){
			freeFalling = false;
			return;
		}
		freeFalling = true;
		Point tam = getTam();
		
		for (InterfaceBar b : bars) {
			if(b.isBelow(tam) && b.isBetween(tam)){
				if(b.distanceTo(tam) <= getBanKinh()){
					freeFalling = false;
					break;
				}
			}
				
		}
	}
	@Override
	public void run() {
			if (jumping) {
				if(currentHigh < highJump){
					currentHigh += 5;
					this.y-=5;
				}else{
					currentHigh = 0;
					jumping = false;
				}
			}
			if (freeFalling) {
				this.y += 5;
			}
}
}

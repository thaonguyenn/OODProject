package model;

import java.util.Observable;
import java.util.Observer;

public abstract class Item implements Observer{
	protected int x;
	protected int y;
	protected int len;
	protected Player player;
	protected TouchBehavior touchBehavior;
	Observable score;
	public Item(int x, int y,int len, Player player,Observable score) {
		super();
		this.score = score;
		score.addObserver(this);
		this.x = x;
		this.y = y;
		this.player = player;
	}
	public TouchBehavior getTouchBehavior() {
		return touchBehavior;
	}

	public void setTouchBehavior(TouchBehavior touchBehavior) {
		this.touchBehavior = touchBehavior;
	}

	public void performTouch (){
		touchBehavior.touched();
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
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public boolean touch(){
		return player.getX()>=this.x && player.getX()<=this.x+len
			&& player.getY()>=this.y && player.getY()<=this.y+len
			|| player.getX()+player.getDuongKinh()>=this.x && player.getX()+player.getDuongKinh()<=this.x+len
			&& player.getY()+player.getDuongKinh()>=this.y && player.getY()+player.getDuongKinh()<=this.y+len;
	}
}


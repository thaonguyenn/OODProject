package model;

import java.util.Observable;

import controller.TouchProtect;

public class Armor extends Item {
	public Armor(int x, int y, int len, Player player,Observable score) {
		super(y, y, len, player, score);
		touchBehavior= new TouchProtect((Score)score);
		score = new Score();
		score.addObserver(this);
		this.x = x;
		this.y = y;
		this.len = len;
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
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean touch() {
		return player.getX()>=this.x && player.getX()<=this.x+len
				&& player.getY()>=this.y && player.getY()<=this.y+len
				|| player.getX()+player.getDuongKinh()>=this.x && player.getX()+player.getDuongKinh()<=this.x+len
				&& player.getY()+player.getDuongKinh()>=this.y && player.getY()+player.getDuongKinh()<=this.y+len;
	}
	}

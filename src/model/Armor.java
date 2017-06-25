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
	}

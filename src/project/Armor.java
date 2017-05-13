package project;

public class Armor extends Item {
	public Armor(int x, int y, int len, Player player,Star star) {
		super(y, y, len, player);
		touchBehavior= new TouchProtect();
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
	}

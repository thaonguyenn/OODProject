package model;

public class Bar implements InterfaceBar{
	private int x;
	private int y;
	private int len;

	public Bar(int x, int y, int len) {
		super();
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

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public boolean isBelow(Point point) {
		return point.getY() < this.y;
	}

	public boolean isBetween(Point point) { // ten ham nay chua dung
		return this.x <= point.getX() && point.getX() <= this.x + len;
	}

	public int distanceTo(Point point) {
		return this.y - point.getY();
	}

//	public boolean notTouch(int a, int b) {
//		return this.y == b && (a < this.x && a > this.x + 100);
//	}

//	@Override
//	public String toString() {
//		return "Bar [x=" + x + ", y=" + y + ", len=" + len + "]";
//	}
	
}

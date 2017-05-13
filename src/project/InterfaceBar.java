package project;

public interface InterfaceBar {
	public abstract boolean isBelow(Point point);
	public abstract boolean isBetween(Point point);
	public abstract int distanceTo(Point point);
	public abstract int getX();
	public abstract int getY();
	public abstract int getLen();
}

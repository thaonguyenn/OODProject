package model;

public interface InterfaceItem {
public abstract void performTouch();
public abstract boolean touch();
public abstract void setY(int y);
public abstract void setX(int x);
public abstract int getX();
public abstract int getY();
public abstract int getLen();
public abstract void runEnemy();
public abstract void setState(boolean state);
}

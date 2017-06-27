package model;

public interface InterfaceScore{
	public abstract void setCondition(boolean condition);
	public abstract void addScore();
	public abstract void subScore();
	public abstract void addDoubleScore();
	public abstract int getScore();
}

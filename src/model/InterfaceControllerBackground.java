package model;

public interface InterfaceControllerBackground {
	public abstract void checkEnemies();
	public abstract void checkStars();
	public abstract void checkArmor();
	public abstract void checkAll();
	public abstract void addEnemy(InterfaceItem enemy);
	public abstract void addStar(InterfaceItem star);
}

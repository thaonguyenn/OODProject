package model;

import java.awt.Color;
import java.util.List;

public interface InterfacePlayer {
public abstract void moveLeft();
public abstract void moveRight();
public abstract void jump();
public abstract void freeFall(List<InterfaceBar> bar);
public abstract int getX();
public abstract int getY();
public abstract int getDuongKinh();
public abstract void run();
public abstract Color power();
}

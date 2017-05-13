package project;

import java.util.List;

public interface InterfacePlayer {
public abstract void moveLeft();
public abstract void moveRight();
public abstract void jump();
public abstract void freeFall(List<InterfaceBar> bar);
}

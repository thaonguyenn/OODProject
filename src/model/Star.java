package model;

import java.util.Observable;

import controller.TouchAddGrade;
import view.ViewScore;

public class Star extends Item{
	Observable txtScore;
	ViewScore viewScore;
public Star(int x, int y, int len, Player player,Score txtScore,ViewScore viewScore) {
	super(y, y, len, player, txtScore);
	touchBehavior= new TouchAddGrade(txtScore,viewScore);
	this.x = x;
	this.y = y;
	this.len = len;
	txtScore = new Score();
	this.txtScore = txtScore;
	txtScore.addObserver(this);
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
public void runEnemy() {
	// TODO Auto-generated method stub
	
}
@Override
public void setState(boolean state) {
	// TODO Auto-generated method stub
	
}
@Override
public boolean isState() {
	// TODO Auto-generated method stub
	return false;
}
}

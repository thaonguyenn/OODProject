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
//so sanh khoang cach giua 2 tam voi 2 ban kinh
public Point getTam(){
	return new Point(this.x + this.len/2, this.y + this.len /2);
}
public double r1r2 (){
	return len/2 + player.getBanKinh();
}
public double p1p2(Point p1, Point p2){
	return Math.sqrt((p2.getX()-p1.getX())*(p2.getX()-p1.getX())+(p2.getY()-p1.getY())*(p2.getY()-p1.getY()));
}
@Override
public boolean touch() {
	return p1p2(getTam(), player.getTam()) <= r1r2();
}

}

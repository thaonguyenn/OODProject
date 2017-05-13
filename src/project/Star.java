package project;

public class Star extends Item{
	Score txtScore;
public Star(int x, int y, int len, Player player,Score txtScore) {
	super(y, y, len, player);
	touchBehavior= new TouchAddGrade(txtScore);
	this.x = x;
	this.y = y;
	this.len = len;
	this.txtScore = txtScore;
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

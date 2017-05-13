package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JTextField;

public class Score extends JTextField{
	Font myFont = new Font("Tahoma", Font.BOLD + Font.ITALIC, 20);
	Color myColor = new Color(255, 0, 0);
	FontMetrics fm;
	int score;
	boolean condition;
	public Score(){
		score =0;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(myFont);
		fm = g.getFontMetrics();
		int hourXCoordinate = 20;
		int minuteXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 2);
		
		g.setColor(myColor);
		g.drawString("Score : ",hourXCoordinate, 20);
		g.drawString(" "+score, minuteXCoordinate, 20);
	}
	public void addScore(){
		if(condition==true){
			score++;
			repaint();
		}
	}
	public void subScore(){
		if(condition==true){
			score-=2;
			repaint();
		}
	}
}

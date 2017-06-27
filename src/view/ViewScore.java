package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Score;

public class ViewScore extends JTextField implements Observer{
	Observable observable;
	private int grade;
	Font myFont = new Font("Tahoma", Font.BOLD + Font.ITALIC, 20);
	Color myColor = new Color(255, 0, 0);
	FontMetrics fm;
	public ViewScore(Observable observable) {
		grade =0;
		this.observable = observable;
		observable.addObserver(this); 
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Score){
			Score score = (Score)o;
			this.grade=score.getScore();
			repaint();
		}
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(myFont);
		fm = g.getFontMetrics();
		int hourXCoordinate = 20;
		int minuteXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 2);
		
		g.setColor(myColor);
		g.drawString("Score : ",hourXCoordinate, 20);
		
		g.drawString(" "+grade, minuteXCoordinate, 20);
	}
}

package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Clock;
import model.InterfaceScore;

public class ViewClock extends JTextField implements Observer{
	Observable observable;
	InterfaceScore score;
	private int second;
	int tmp;
	Font myFont = new Font("Tahoma", Font.BOLD + Font.ITALIC, 20);
	Color myColor = new Color(255, 0, 0);
	FontMetrics fm;
	public ViewClock(Observable observable,InterfaceScore score ) {
		tmp = 0;
		observable = new Clock();
		this.score = score;
		observable.addObserver(this); 
		((Clock)observable).demNguoc(100);
	}
	
	public int getTmp() {
		return tmp;
	}

	public void setTmp(int tmp) {
		this.tmp = tmp;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(myFont);
		fm = g.getFontMetrics();
		int hourXCoordinate = 20;
		int minuteXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 2);
		int secondXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 4);

		g.setColor(myColor);
		g.drawString("Time :", hourXCoordinate, 20);
		g.drawString(Integer.toString(second), (secondXCoordinate + minuteXCoordinate) / 2, 20);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Clock){
			Clock digital = (Clock)o;
			this.second=digital.getSecond();
			if(arg instanceof String){
				if("update".equals(arg))
					repaint();
				if("end".equals(arg)){
					System.out.println("nnnnn");
					if(score.getScore()==3)
					JOptionPane.showMessageDialog(null, "Well done !You are winner ! ");
					if(score.getScore()>3)
					JOptionPane.showMessageDialog(null, "Great !You are winner ! ");
					else{
					JOptionPane.showMessageDialog(null, "Oh oh !You lost ! Play again and try better ...");	
				}
				}
			}
		}
	}
}

package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFieldClock extends JTextField implements Observer{
	// JFrame frame;
	Observable observable;
	//DiditalClock clock;
	Score score;
	private int second;
	Font myFont = new Font("Tahoma", Font.BOLD + Font.ITALIC, 20);
	Color myColor = new Color(255, 0, 0);
	FontMetrics fm;
	//boolean state;
	public TextFieldClock(Observable observable,Score score ) {
		//state = true;
		observable = new Clock();
		this.score = score;
		//clock = new DiditalClock(observable);
//		JFrame frame = new JFrame("Digital Clock");
//		frame.add(this);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(250, 70);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
		observable.addObserver(this); // dang ky
		((Clock)observable).demNguoc(50);// bat dau giam tu 100 -> 0
//		new Thread(){
//			public void run() {
//				try {
//					while(true){
//						Thread.sleep(50); // se hop ly hon
//						TextFieldClock.this.repaint();
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			};
//		}.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		// Date date = new Date();
		// ((Clock)
		// observable).setClock(date.getHours(),date.getMinutes(),date.getSeconds());
		g.setFont(myFont);
		fm = g.getFontMetrics();
		int hourXCoordinate = 20;
		int minuteXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 2);
		int secondXCoordinate = hourXCoordinate + (fm.getMaxAdvance() * 4);

		// Set color that will use to draw digital number
		g.setColor(myColor);

		// Draw hour, draw (:) between number, draw minute and draw second.
		g.drawString("Time :", hourXCoordinate, 20);
//		g.drawString("Time :", (hourXCoordinate + minuteXCoordinate) / 2, 20);
//		g.drawString(Integer.toString(clock.getMinute()), minuteXCoordinate, 20);
		g.drawString(Integer.toString(second), (secondXCoordinate + minuteXCoordinate) / 2, 20);
//		g.drawString(":", (secondXCoordinate + minuteXCoordinate) / 2, 20);
//		g.drawString(Integer.toString(((Clock)observable).getSecond()), secondXCoordinate, 20);
	}

//	public static void main(String[] args) {
//		new TextFieldClock();
//	}
	
	@Override
	public void update(Observable o, Object arg) {
		// ham nhan thong bao neu co chuyen hot từ em.
		// viet dai nha chứ hok sure là đúng cách, vì anh chưa dùng observer của java
		if(o instanceof Clock){
			Clock digital = (Clock)o;
			this.second=digital.getSecond();
			// neu nguoi thong bao là em chẵng hạn
			if(arg instanceof String){
				if("update".equals(arg))
					repaint();
				if("end".equals(arg)){
					//state = false;
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

//	public boolean isState() {
//		return state;
//	}
//
//	public void setState(boolean state) {
//		this.state = state;
//	}
}

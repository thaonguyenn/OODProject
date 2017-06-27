package model;

import java.util.Observable;

public class Clock extends Observable{
	private int hour;
	private int minute;
	private int second;

	public Clock() {
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public void changedClock() {
		setChanged();
		notifyObservers("update"); 
	}
	public void demNguoc( int second){
		this.second = second; 
		new Thread(){
			public void run() {
				try {
					while(Clock.this.second > 0){ 
						Thread.sleep(1000);
						Clock.this.second--;
						changedClock();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setChanged();
				notifyObservers("end");
			};
		}.start();
	}
}

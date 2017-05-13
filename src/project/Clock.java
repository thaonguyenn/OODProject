package project;

import java.util.Observable;

public class Clock extends Observable {
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
		notifyObservers("update"); // 0 sẽ là cap nhật time
	}

	public void setClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		changedClock();
	}
	public void demNguoc( int second){// cung cap ra 1 ham dem nguoc cho swing xai
		this.second = second; // giay thui cho it
		new Thread(){
			public void run() {
				try {
					while(Clock.this.second > 0){ // giảm tới 0
						Thread.sleep(1000);
						Clock.this.second--;// biet cach viet nay chưa?-1
						changedClock();//data thay doi
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setChanged();
				notifyObservers("end"); // het giờ
			};
		}.start();
	}
}

package project;

import java.awt.Color;
import java.util.List;

public abstract class Player implements Runnable,InterfacePlayer {
	protected int x;
	protected int y;
	protected int duongKinh;
	protected boolean state;
	protected int score;
	protected boolean jumping, freeFalling;
	protected int highJump, currentHigh;

	public Player(int x, int y, int duongKinh) {
		super();
		this.x = x;
		this.y = y;
		this.duongKinh = duongKinh;
		state = true;
		score = 0;
		jumping = false;
		highJump = 100;
		freeFalling = false;
//		new Thread(this).start();
	}

	public abstract Color power();

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

	public void moveLeft() {
		if (state == true)
			setX(x -= 10);
	}

	public void moveRight() {
		if (state == true)
			setX(x += 10);
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getScore() {
		return score;
	}

	public int getDuongKinh() {
		return duongKinh;
	}

	public void setDuongKinh(int duongKinh) {
		this.duongKinh = duongKinh;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public void jump() {
		if (!jumping)
			jumping = true;
	}

	public void stop() {
		jumping = false;
	}
	/**
	 * 
	 * @param lenC, nó là hình tròn mà hả? da, đường kính ak hả, da dung, ai ma viet zị chời?
	 * hừm hừm.
	 * @return
	 */
	public Point tamPlayer(int lenC) {
		return new Point(lenC / 2 + this.x, lenC / 2 + this.y);
	}

	public int banKinhPlayer(int lenC) {
		return lenC / 2;
	}
	/**
	 * mai mot comment zô nha, tháng sau là em quên ak.
	 * hàm này làm gì?
	 * Tinh khoang cach tu tam player den duong thang bar
	 * @param lenC
	 * @param lenR
	 * @param bar
	 * @return
	 */
	public double khoangCachTuTamToD(int lenC, int lenR, Point bar) {
		return Math.abs(lenR * tamPlayer(lenC).getY() - lenR * bar.getY()) / lenR;
	}
	
	public Point getTam(){
		return new Point(this.x + this.duongKinh/2, this.y + this.duongKinh /2);
	}
	public int getBanKinh(){
		return this.duongKinh/2;
	}
	public void freeFall(List<Bar> bars, int lenght) {
		int tmp =0;
		for (int i = 0; i < bars.size(); i++) {
			if (khoangCachTuTamToD(lenght, bars.get(i).getLen(),
					new Point(bars.get(i).getX(), bars.get(i).getY())) == banKinhPlayer(lenght)){
				freeFalling = false;
				break;
			}
			else{
				tmp++;
			}
		}
		if(tmp==bars.size()) // nay la gi em? da la neu ko co bar nao thoa OK
		freeFalling = true;
	}
	public void freeFall(List<InterfaceBar> bars) {
		/*
		 * neu dang nhay thi khong roi.
		 */
		if(jumping){
			freeFalling = false;
			return;
		}
		
		/*
		 * Xac định có bar nào cản đường rời không?
		 */
		freeFalling = true; // mặc định là rơi.
		Point tam = getTam();
		//System.out.println(tam);
		
		for (InterfaceBar b : bars) {
			if(b.isBelow(tam) && b.isBetween(tam)){
//				System.out.print(b);
//				System.out.print("  isBelow: " + b.isBelow(tam) + "; isBetween: " + b.isBetween(tam));
//				System.out.println(";   " + b.distanceTo(tam) + " : " + getBanKinh());
				if(b.distanceTo(tam) <= getBanKinh()){//khi += or -= khac 5 
					freeFalling = false;
					break;
				}
			}
				
		}
	}
	@Override
	public void run() {
		//System.out.println("jumping: " + jumping);
		
		/* currentHigh là độ cao hiện tại của player khi đang nhảy.
		 * thay doi thuat toan ti xíu, khi nó đáng jumping thì currentHigh tăng dần đều
		 * đến khi bằng highJump thì thôi -> bắt đầu rơi xuống
		 */
			if (jumping) {
				if(currentHigh < highJump){
					currentHigh += 5; // quản lý độ cao hiện tại đã đạt max chưa?
					this.y-=5; // tọa độ thực tế khí jump
				}else{
					currentHigh = 0;
					jumping = false;
				}
			}
			//System.out.println("freeFalling: " + freeFalling);
			
			/*
			 * khi roi thi tăng y như thường. giá trị của freeFalling đc control bới hàm
			 * freeFall(List<Bar>)
			 */
			if (freeFalling) {
				this.y += 5;
			}
}
}

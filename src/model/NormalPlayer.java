package model;

import java.awt.Color;

public class NormalPlayer extends Player{

	public NormalPlayer(int x, int y, int duongKinh) {
		super(x, y, duongKinh);
		
	}

	@Override
	public Color power() {
		return Color.black;
	}

}
